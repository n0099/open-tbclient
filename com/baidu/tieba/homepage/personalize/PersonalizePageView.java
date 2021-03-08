package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.j;
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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.adapter.ab;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class PersonalizePageView extends FrameLayout {
    private CustomMessageListener eLa;
    private LinearLayoutManager eso;
    private int fIN;
    private final CustomMessageListener fuv;
    private PbListView gCf;
    private int gEG;
    private com.baidu.tbadk.l.g gLk;
    private l iTc;
    private CustomMessageListener iTe;
    private boolean jiS;
    private CustomMessageListener jjT;
    private int jjc;
    private FollowUserButton.a kbf;
    private BdTypeRecyclerView kch;
    private ScrollFragmentTabHost kcn;
    ScrollFragmentTabHost.a kco;
    private BigdaySwipeRefreshLayout kcp;
    private View.OnClickListener kcr;
    private NEGFeedBackView.a khA;
    f.d kic;
    f.b kie;
    private p kim;
    private boolean kkA;
    private int kkB;
    private boolean kkC;
    private FRSRefreshButton kkD;
    private ab.a kkE;
    private CustomMessageListener kkF;
    private View.OnClickListener kkG;
    private e.a kkH;
    f.c kkI;
    f.a kkJ;
    private Runnable kkK;
    public CustomMessageListener kkL;
    private View.OnClickListener kkM;
    private com.baidu.tieba.homepage.personalize.bigday.b kkn;
    private com.baidu.tieba.homepage.personalize.bigday.a kko;
    private a kkp;
    private ab kkq;
    private com.baidu.tieba.homepage.framework.b kkr;
    private e kks;
    private com.baidu.tieba.homepage.personalize.a kkt;
    private com.baidu.tieba.homepage.personalize.model.e kku;
    private long kkv;
    private int kkw;
    private boolean kkx;
    private long kky;
    private boolean kkz;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void a(f.a aVar);

        void a(f.b bVar);

        void a(f.d dVar);

        void setListPullRefreshListener(f.c cVar);
    }

    static /* synthetic */ int w(PersonalizePageView personalizePageView) {
        int i = personalizePageView.kkB + 1;
        personalizePageView.kkB = i;
        return i;
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kcn = scrollFragmentTabHost;
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
        }
        if (this.kks != null) {
            this.kks.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kkt != null) {
            this.kkt.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.kcp != null) {
            this.kcp.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kkq != null) {
            this.kkq.setPageUniqueId(bdUniqueId);
        }
        if (this.kks != null) {
            this.kks.o(bdUniqueId);
        }
        if (this.kku != null) {
            this.kku.i(bdUniqueId);
        }
        if (this.kko != null) {
            this.kko.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bld().setTag(bdUniqueId);
        if (this.fuv != null) {
            this.fuv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fuv);
        }
        if (this.kkt != null) {
            this.kkt.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.kkv = 0L;
        this.mSkinType = 3;
        this.jiS = false;
        this.kkw = 0;
        this.kkx = false;
        this.kky = -1L;
        this.kkz = false;
        this.kkA = false;
        this.kkB = 0;
        this.jjc = 0;
        this.kkC = false;
        this.fIN = 1;
        this.iTe = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iTc == null) {
                            PersonalizePageView.this.iTc = new l(new j());
                        }
                        PersonalizePageView.this.iTc.a(PersonalizePageView.this.kch, 2);
                    } else if (PersonalizePageView.this.iTc != null) {
                        PersonalizePageView.this.iTc.qJ();
                    }
                }
            }
        };
        this.kkE = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mn() {
                if (PersonalizePageView.this.kch != null && PersonalizePageView.this.kim != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.kch.removeHeaderView(PersonalizePageView.this.kim.getView());
                    } else if (PersonalizePageView.this.kim.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kim.ks();
                        PersonalizePageView.this.kim.getView().setVisibility(0);
                        PersonalizePageView.this.kim.IY("1");
                        PersonalizePageView.this.kch.setHeaderView(PersonalizePageView.this.kim.getView());
                    }
                }
            }
        };
        this.kkF = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kks != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bre().brf(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.khA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                if (avVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, avVar.bmq()));
                    TiebaStatic.log(new ar("c11989").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                int i = 0;
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (avVar.threadType == 0) {
                        i = 1;
                    } else if (avVar.threadType == 40) {
                        i = 2;
                    } else if (avVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.kkq != null) {
                        PersonalizePageView.this.kkq.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmq()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aq(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.kbf = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof cb) {
                        TiebaStatic.log(com.baidu.tieba.s.a.e("c13696", (cb) tag));
                    }
                }
            }
        };
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gEG != i && PersonalizePageView.this.kcn != null) {
                    PersonalizePageView.this.gEG = i;
                    if (PersonalizePageView.this.gEG == 1) {
                        PersonalizePageView.this.kcn.bRW();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.kcn.bRX();
                    } else {
                        PersonalizePageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kco = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQg() {
                if (PersonalizePageView.this.kcn != null) {
                    PersonalizePageView.this.gEG = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.kch)) {
                        PersonalizePageView.this.kcn.bRX();
                    } else {
                        PersonalizePageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kkG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kch != null) {
                    PersonalizePageView.this.kch.removeHeaderView(PersonalizePageView.this.kim.getView());
                }
            }
        };
        this.eLa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kch != null && PersonalizePageView.this.kim != null && PersonalizePageView.this.kim.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kim.ks();
                    PersonalizePageView.this.kim.getView().setVisibility(0);
                    PersonalizePageView.this.kim.IY("1");
                    PersonalizePageView.this.kch.setHeaderView(PersonalizePageView.this.kim.getView());
                }
            }
        };
        this.kkH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean jaV = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_first_install", true);

            private void cRn() {
                if (this.jaV) {
                    this.jaV = false;
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, com.baidu.tbadk.util.c cVar, int i2) {
                if (PersonalizePageView.this.kkr == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqZ = PersonalizePageView.this.cqZ();
                PersonalizePageView.this.Xc();
                if (cqZ) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kkr.a(i, cVar, i2);
                q.bhW().bhX();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kkr != null) {
                    PersonalizePageView.this.kkr.a(i, i2, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cRn();
                } else if (!this.jaV) {
                    PersonalizePageView.this.kcp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cRn();
                    PersonalizePageView.this.cPQ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cRn();
                PersonalizePageView.this.kcp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Xc();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOT().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kkx = true;
                    PersonalizePageView.this.kky = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRo() {
                if (PersonalizePageView.this.gCf != null) {
                    PersonalizePageView.this.gCf.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gCf.endLoadData();
                    PersonalizePageView.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kkI = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKY().EC("page_recommend");
                PersonalizePageView.this.kks.update();
                PersonalizePageView.this.kks.se(false);
                PersonalizePageView.this.kkC = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kic = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kks != null && PersonalizePageView.this.kks.cDL() != null) {
                    PersonalizePageView.this.kks.cDL().cQI();
                }
            }
        };
        this.kkJ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buB() {
                if (PersonalizePageView.this.kkC) {
                    PersonalizePageView.this.jjc = 0;
                    PersonalizePageView.this.fIN = 1;
                    PersonalizePageView.this.kkC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kie = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kks != null) {
                    PersonalizePageView.this.kks.se(true);
                    PersonalizePageView.this.kks.cRt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bld().mS(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kkK = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fuv = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
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
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cPa();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRp();
            }
        };
        this.jjT = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jiS = true;
                    }
                }
            }
        };
        this.kkL = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kcp != null && !PersonalizePageView.this.kcp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kko == null) {
                            PersonalizePageView.this.kko = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kko.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kkp = PersonalizePageView.this.kko;
                            PersonalizePageView.this.cRi();
                        } else if (PersonalizePageView.this.kkp != PersonalizePageView.this.kko) {
                            PersonalizePageView.this.kkp = PersonalizePageView.this.kko;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kko.setEnable(true);
                        PersonalizePageView.this.kcp.setProgressView(PersonalizePageView.this.kko);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.kcp.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.kkn == null) {
                        PersonalizePageView.this.kkn = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kkp = PersonalizePageView.this.kkn;
                        PersonalizePageView.this.cRi();
                    } else if (PersonalizePageView.this.kkp != PersonalizePageView.this.kkn || !aVar.equals(PersonalizePageView.this.kkn.cRO())) {
                        PersonalizePageView.this.kkp = PersonalizePageView.this.kkn;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.kkn.setEnable(true);
                    PersonalizePageView.this.kcp.setProgressView(PersonalizePageView.this.kkn);
                    PersonalizePageView.this.kkn.a(aVar);
                    PersonalizePageView.this.kcp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kkM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kkD != null) {
                    PersonalizePageView.this.kkD.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kkv = 0L;
        this.mSkinType = 3;
        this.jiS = false;
        this.kkw = 0;
        this.kkx = false;
        this.kky = -1L;
        this.kkz = false;
        this.kkA = false;
        this.kkB = 0;
        this.jjc = 0;
        this.kkC = false;
        this.fIN = 1;
        this.iTe = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iTc == null) {
                            PersonalizePageView.this.iTc = new l(new j());
                        }
                        PersonalizePageView.this.iTc.a(PersonalizePageView.this.kch, 2);
                    } else if (PersonalizePageView.this.iTc != null) {
                        PersonalizePageView.this.iTc.qJ();
                    }
                }
            }
        };
        this.kkE = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mn() {
                if (PersonalizePageView.this.kch != null && PersonalizePageView.this.kim != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.kch.removeHeaderView(PersonalizePageView.this.kim.getView());
                    } else if (PersonalizePageView.this.kim.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kim.ks();
                        PersonalizePageView.this.kim.getView().setVisibility(0);
                        PersonalizePageView.this.kim.IY("1");
                        PersonalizePageView.this.kch.setHeaderView(PersonalizePageView.this.kim.getView());
                    }
                }
            }
        };
        this.kkF = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kks != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bre().brf(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.khA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                if (avVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, avVar.bmq()));
                    TiebaStatic.log(new ar("c11989").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                int i = 0;
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (avVar.threadType == 0) {
                        i = 1;
                    } else if (avVar.threadType == 40) {
                        i = 2;
                    } else if (avVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.kkq != null) {
                        PersonalizePageView.this.kkq.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmq()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aq(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.kbf = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof cb) {
                        TiebaStatic.log(com.baidu.tieba.s.a.e("c13696", (cb) tag));
                    }
                }
            }
        };
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gEG != i && PersonalizePageView.this.kcn != null) {
                    PersonalizePageView.this.gEG = i;
                    if (PersonalizePageView.this.gEG == 1) {
                        PersonalizePageView.this.kcn.bRW();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.kcn.bRX();
                    } else {
                        PersonalizePageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kco = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQg() {
                if (PersonalizePageView.this.kcn != null) {
                    PersonalizePageView.this.gEG = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.kch)) {
                        PersonalizePageView.this.kcn.bRX();
                    } else {
                        PersonalizePageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kkG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kch != null) {
                    PersonalizePageView.this.kch.removeHeaderView(PersonalizePageView.this.kim.getView());
                }
            }
        };
        this.eLa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kch != null && PersonalizePageView.this.kim != null && PersonalizePageView.this.kim.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kim.ks();
                    PersonalizePageView.this.kim.getView().setVisibility(0);
                    PersonalizePageView.this.kim.IY("1");
                    PersonalizePageView.this.kch.setHeaderView(PersonalizePageView.this.kim.getView());
                }
            }
        };
        this.kkH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean jaV = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_first_install", true);

            private void cRn() {
                if (this.jaV) {
                    this.jaV = false;
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, com.baidu.tbadk.util.c cVar, int i2) {
                if (PersonalizePageView.this.kkr == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqZ = PersonalizePageView.this.cqZ();
                PersonalizePageView.this.Xc();
                if (cqZ) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kkr.a(i, cVar, i2);
                q.bhW().bhX();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kkr != null) {
                    PersonalizePageView.this.kkr.a(i, i2, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cRn();
                } else if (!this.jaV) {
                    PersonalizePageView.this.kcp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cRn();
                    PersonalizePageView.this.cPQ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cRn();
                PersonalizePageView.this.kcp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Xc();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOT().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kkx = true;
                    PersonalizePageView.this.kky = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRo() {
                if (PersonalizePageView.this.gCf != null) {
                    PersonalizePageView.this.gCf.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gCf.endLoadData();
                    PersonalizePageView.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kkI = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKY().EC("page_recommend");
                PersonalizePageView.this.kks.update();
                PersonalizePageView.this.kks.se(false);
                PersonalizePageView.this.kkC = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kic = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kks != null && PersonalizePageView.this.kks.cDL() != null) {
                    PersonalizePageView.this.kks.cDL().cQI();
                }
            }
        };
        this.kkJ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buB() {
                if (PersonalizePageView.this.kkC) {
                    PersonalizePageView.this.jjc = 0;
                    PersonalizePageView.this.fIN = 1;
                    PersonalizePageView.this.kkC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kie = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kks != null) {
                    PersonalizePageView.this.kks.se(true);
                    PersonalizePageView.this.kks.cRt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bld().mS(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kkK = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fuv = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
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
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cPa();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRp();
            }
        };
        this.jjT = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jiS = true;
                    }
                }
            }
        };
        this.kkL = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kcp != null && !PersonalizePageView.this.kcp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kko == null) {
                            PersonalizePageView.this.kko = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kko.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kkp = PersonalizePageView.this.kko;
                            PersonalizePageView.this.cRi();
                        } else if (PersonalizePageView.this.kkp != PersonalizePageView.this.kko) {
                            PersonalizePageView.this.kkp = PersonalizePageView.this.kko;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kko.setEnable(true);
                        PersonalizePageView.this.kcp.setProgressView(PersonalizePageView.this.kko);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.kcp.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.kkn == null) {
                        PersonalizePageView.this.kkn = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kkp = PersonalizePageView.this.kkn;
                        PersonalizePageView.this.cRi();
                    } else if (PersonalizePageView.this.kkp != PersonalizePageView.this.kkn || !aVar.equals(PersonalizePageView.this.kkn.cRO())) {
                        PersonalizePageView.this.kkp = PersonalizePageView.this.kkn;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.kkn.setEnable(true);
                    PersonalizePageView.this.kcp.setProgressView(PersonalizePageView.this.kkn);
                    PersonalizePageView.this.kkn.a(aVar);
                    PersonalizePageView.this.kcp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kkM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kkD != null) {
                    PersonalizePageView.this.kkD.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kkv = 0L;
        this.mSkinType = 3;
        this.jiS = false;
        this.kkw = 0;
        this.kkx = false;
        this.kky = -1L;
        this.kkz = false;
        this.kkA = false;
        this.kkB = 0;
        this.jjc = 0;
        this.kkC = false;
        this.fIN = 1;
        this.iTe = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iTc == null) {
                            PersonalizePageView.this.iTc = new l(new j());
                        }
                        PersonalizePageView.this.iTc.a(PersonalizePageView.this.kch, 2);
                    } else if (PersonalizePageView.this.iTc != null) {
                        PersonalizePageView.this.iTc.qJ();
                    }
                }
            }
        };
        this.kkE = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mn() {
                if (PersonalizePageView.this.kch != null && PersonalizePageView.this.kim != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.kch.removeHeaderView(PersonalizePageView.this.kim.getView());
                    } else if (PersonalizePageView.this.kim.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kim.ks();
                        PersonalizePageView.this.kim.getView().setVisibility(0);
                        PersonalizePageView.this.kim.IY("1");
                        PersonalizePageView.this.kch.setHeaderView(PersonalizePageView.this.kim.getView());
                    }
                }
            }
        };
        this.kkF = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kks != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bre().brf(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.khA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                if (avVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, avVar.bmq()));
                    TiebaStatic.log(new ar("c11989").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                int i2 = 0;
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (avVar.threadType == 0) {
                        i2 = 1;
                    } else if (avVar.threadType == 40) {
                        i2 = 2;
                    } else if (avVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.kkq != null) {
                        PersonalizePageView.this.kkq.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmq()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aq(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.kbf = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof cb) {
                        TiebaStatic.log(com.baidu.tieba.s.a.e("c13696", (cb) tag));
                    }
                }
            }
        };
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gEG != i2 && PersonalizePageView.this.kcn != null) {
                    PersonalizePageView.this.gEG = i2;
                    if (PersonalizePageView.this.gEG == 1) {
                        PersonalizePageView.this.kcn.bRW();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.kcn.bRX();
                    } else {
                        PersonalizePageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kco = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQg() {
                if (PersonalizePageView.this.kcn != null) {
                    PersonalizePageView.this.gEG = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.kch)) {
                        PersonalizePageView.this.kcn.bRX();
                    } else {
                        PersonalizePageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kkG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kch != null) {
                    PersonalizePageView.this.kch.removeHeaderView(PersonalizePageView.this.kim.getView());
                }
            }
        };
        this.eLa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kch != null && PersonalizePageView.this.kim != null && PersonalizePageView.this.kim.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kim.ks();
                    PersonalizePageView.this.kim.getView().setVisibility(0);
                    PersonalizePageView.this.kim.IY("1");
                    PersonalizePageView.this.kch.setHeaderView(PersonalizePageView.this.kim.getView());
                }
            }
        };
        this.kkH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean jaV = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_first_install", true);

            private void cRn() {
                if (this.jaV) {
                    this.jaV = false;
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i2, com.baidu.tbadk.util.c cVar, int i22) {
                if (PersonalizePageView.this.kkr == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqZ = PersonalizePageView.this.cqZ();
                PersonalizePageView.this.Xc();
                if (cqZ) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kkr.a(i2, cVar, i22);
                q.bhW().bhX();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i2, int i22, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kkr != null) {
                    PersonalizePageView.this.kkr.a(i2, i22, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cRn();
                } else if (!this.jaV) {
                    PersonalizePageView.this.kcp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cRn();
                    PersonalizePageView.this.cPQ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cRn();
                PersonalizePageView.this.kcp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Xc();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOT().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kkx = true;
                    PersonalizePageView.this.kky = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRo() {
                if (PersonalizePageView.this.gCf != null) {
                    PersonalizePageView.this.gCf.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gCf.endLoadData();
                    PersonalizePageView.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kkI = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKY().EC("page_recommend");
                PersonalizePageView.this.kks.update();
                PersonalizePageView.this.kks.se(false);
                PersonalizePageView.this.kkC = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kic = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kks != null && PersonalizePageView.this.kks.cDL() != null) {
                    PersonalizePageView.this.kks.cDL().cQI();
                }
            }
        };
        this.kkJ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buB() {
                if (PersonalizePageView.this.kkC) {
                    PersonalizePageView.this.jjc = 0;
                    PersonalizePageView.this.fIN = 1;
                    PersonalizePageView.this.kkC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kie = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kks != null) {
                    PersonalizePageView.this.kks.se(true);
                    PersonalizePageView.this.kks.cRt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bld().mS(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kkK = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fuv = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
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
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cPa();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRp();
            }
        };
        this.jjT = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jiS = true;
                    }
                }
            }
        };
        this.kkL = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kcp != null && !PersonalizePageView.this.kcp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kko == null) {
                            PersonalizePageView.this.kko = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kko.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kkp = PersonalizePageView.this.kko;
                            PersonalizePageView.this.cRi();
                        } else if (PersonalizePageView.this.kkp != PersonalizePageView.this.kko) {
                            PersonalizePageView.this.kkp = PersonalizePageView.this.kko;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kko.setEnable(true);
                        PersonalizePageView.this.kcp.setProgressView(PersonalizePageView.this.kko);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.kcp.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.kkn == null) {
                        PersonalizePageView.this.kkn = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kkp = PersonalizePageView.this.kkn;
                        PersonalizePageView.this.cRi();
                    } else if (PersonalizePageView.this.kkp != PersonalizePageView.this.kkn || !aVar.equals(PersonalizePageView.this.kkn.cRO())) {
                        PersonalizePageView.this.kkp = PersonalizePageView.this.kkn;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.kkn.setEnable(true);
                    PersonalizePageView.this.kcp.setProgressView(PersonalizePageView.this.kkn);
                    PersonalizePageView.this.kkn.a(aVar);
                    PersonalizePageView.this.kcp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kkM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kkD != null) {
                    PersonalizePageView.this.kkD.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kch = new BdTypeRecyclerView(context);
        this.eso = new LinearLayoutManager(this.kch.getContext());
        this.kch.setLayoutManager(this.eso);
        this.kch.setFadingEdgeLength(0);
        this.kch.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.kch.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kim = new p(context);
        this.kim.setFrom("from_personaize");
        this.kim.csB().setVisibility(0);
        this.kim.csB().setOnClickListener(this.kkG);
        MessageManager.getInstance().registerListener(this.eLa);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iTc = new l(new j());
            this.iTc.a(this.kch, 2);
        }
        MessageManager.getInstance().registerListener(this.iTe);
        MessageManager.getInstance().registerListener(this.kkF);
        this.kcp = new BigdaySwipeRefreshLayout(context);
        this.kcp.addView(this.kch);
        this.gCf = new PbListView(context);
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gCf.setOnClickListener(this.kcr);
        this.gCf.bug();
        this.kch.setNextPage(this.gCf);
        com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        MessageManager.getInstance().registerListener(this.kkL);
        com.baidu.tbadk.core.bigday.b.bld().jp(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bld().mS(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.kcp);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.kkD = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.kkD, layoutParams);
            this.kkD.setOnClickListener(this.kkM);
            this.kkD.setVisibility(8);
        }
        this.kku = new com.baidu.tieba.homepage.personalize.model.e();
        this.kkq = new ab(context, this.kch);
        this.kkq.b(this.kku);
        this.kkq.a(this.kkE);
        this.kks = new e(this.pageContext, this.kch, this.kkq, this.kcp);
        this.kkt = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.jjT);
        this.kkB = com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cRi() {
        if (this.kkp != null) {
            this.kkp.setListPullRefreshListener(this.kkI);
            this.kkp.a(this.kic);
            this.kkp.a(this.kkJ);
            this.kkp.a(this.kie);
        }
    }

    public void bZr() {
        this.kkq.b(this.khA);
        this.kkq.a(this.kbf);
        this.kks.a(this.kkH);
        this.kkt.a(this);
        cRi();
        this.kch.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.jjc += i2;
                if (PersonalizePageView.this.kkD != null) {
                    n item = PersonalizePageView.this.kch.getItem(PersonalizePageView.this.eso.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.kkD.show();
                        } else {
                            PersonalizePageView.this.kkD.hide();
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eso != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.jjc < height * 3 || PersonalizePageView.this.fIN != 1) {
                        if (PersonalizePageView.this.jjc < height * 3 && PersonalizePageView.this.fIN == 2) {
                            PersonalizePageView.this.fIN = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fIN = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fIN)));
                    }
                    if (PersonalizePageView.this.eso.getItemCount() - PersonalizePageView.this.eso.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bRp();
                    }
                }
            }
        });
        this.kch.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bRp();
            }
        });
        this.kch.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.kkv >= 5000) {
                    PersonalizePageView.this.kks.cE(i, i2);
                }
            }
        }, 1L);
        this.kch.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.kks != null && PersonalizePageView.this.kks.cDL() != null) {
                        PersonalizePageView.this.kks.cDL().dt(view);
                    }
                    if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                        ((HomePageCardVideoViewHolder) view.getTag()).cto().stopPlay();
                    }
                }
            }
        });
        this.kch.removeOnScrollListener(this.mOnScrollListener);
        this.kch.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.kkr = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gCf != null) {
            this.gCf.setText(getContext().getString(R.string.pb_load_more));
            this.gCf.endLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kks.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.kks != null) {
            this.kks.sj(!z);
        }
        this.kkA = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.kkA;
    }

    public void h(Long l) {
        this.kks.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.kks != null) {
            this.kks.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.kks != null) {
            this.kks.showFloatingView();
        }
    }

    public void cRj() {
        if (this.kks != null) {
            this.kks.cRj();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.kko != null) {
                this.kko.changeSkin(i);
            }
            if (this.gCf != null) {
                this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gCf.changeSkin(i);
            }
            this.kkq.onChangeSkinType(i);
            if (this.kks != null) {
                this.kks.onChangeSkinType(i);
            }
            if (this.kkD != null) {
                this.kkD.onChangeSkinType(i);
            }
            if (this.kim != null) {
                this.kim.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void bd(String str, int i) {
        if (this.gCf != null) {
            this.gCf.setText(getContext().getString(R.string.pb_load_more));
            this.gCf.endLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kks.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.kks != null) {
                        PersonalizePageView.this.kks.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
            this.kch.setNextPage(this.gCf);
            this.gCf.setText(getContext().getString(R.string.pb_load_more));
            this.gCf.endLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.kcp != null) {
            this.kcp.setVisibility(0);
        }
        if (this.kkr != null) {
            this.kkr.cPC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqZ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(boolean z) {
        if (this.gLk == null) {
            this.gLk = new com.baidu.tbadk.l.g(getContext());
            this.gLk.bu(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gLk.bCV();
            this.gLk.setWrapStyle(true);
            this.gLk.onChangeSkinType();
        }
        this.gLk.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.kch.setNextPage(null);
        if (this.kcp != null) {
            this.kcp.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.kks != null) {
            this.kks.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.kks != null) {
            this.kks.qJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.kkB < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.kkK, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.kks != null) {
            this.kks.rV(z);
        }
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
            this.kco.cQg();
        }
    }

    public void cPQ() {
        if (this.kks != null) {
            ir(true);
            this.kks.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bld().blf();
            com.baidu.tbadk.core.bigday.b.bld().ble();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.kks != null) {
            this.kks.update();
        } else if (this.kch != null && this.kcp != null) {
            showFloatingView();
            this.kch.setSelection(0);
            if (!this.kcp.isRefreshing()) {
                if (this.kks != null && this.kks.cDL() != null) {
                    this.kks.cDL().cQI();
                    this.kks.se(false);
                }
                this.kcp.setRefreshing(true);
            }
            if (this.kco != null) {
                this.kco.cQg();
            }
        }
    }

    public void cRk() {
        if (this.refreshView != null) {
            reload();
        } else if (this.kks != null) {
            this.kks.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iTe);
        MessageManager.getInstance().unRegisterListener(this.jjT);
        MessageManager.getInstance().unRegisterListener(this.kkL);
        this.kks.onDestroy();
        this.kkq.b((NEGFeedBackView.a) null);
        this.kkq.onDestroy();
        this.kks.a((e.a) null);
        if (this.kkn != null) {
            this.kkn.setListPullRefreshListener(null);
            this.kkn.a((f.d) null);
            this.kkn.a((f.a) null);
            this.kkn.a((f.b) null);
            this.kkn.release();
        }
        if (this.kko != null) {
            this.kko.setListPullRefreshListener(null);
            this.kko.a((f.d) null);
            this.kko.a((f.a) null);
            this.kko.a((f.b) null);
            this.kko.release();
        }
        this.kch.setOnSrollToBottomListener(null);
        if (this.kcn != null) {
            this.kcn.b(this.kco);
        }
        this.kch.removeOnScrollListener(this.mOnScrollListener);
        if (this.gLk != null) {
            this.gLk.release();
        }
        this.kch.setRecyclerListener(null);
        if (this.kkt != null) {
            this.kkt.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bld().destroy();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kkK);
    }

    public void onPause() {
        this.kks.onPause();
        if (this.kkq != null) {
            this.kkq.onPause();
        }
    }

    public void onResume() {
        if (this.jiS) {
            reload();
            this.jiS = false;
        }
        if (this.kcp != null) {
            this.kcp.resume();
        }
        if (this.kkq != null) {
            this.kkq.onResume();
        }
    }

    public void cPa() {
        if (this.kkq != null) {
            this.kkq.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kkx) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cRl();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRl() {
        if (!this.kkz) {
            long BD = com.baidu.tieba.homepage.framework.a.cPB().BD(1) + com.baidu.tieba.homepage.framework.a.cPB().getCreateTime();
            long BB = com.baidu.tieba.homepage.framework.a.cPB().BB(1);
            if (BB > 0) {
                BD = System.currentTimeMillis() - BB;
            }
            com.baidu.tbadk.n.n nVar = new com.baidu.tbadk.n.n();
            nVar.bEs();
            nVar.bEt();
            com.baidu.tbadk.n.l.bEp().eK(BD);
            if (this.kky > 0) {
                com.baidu.tbadk.n.l.bEp().eO(System.currentTimeMillis() - this.kky);
            }
            com.baidu.tbadk.n.l.bEp().eL(nVar.bEu());
        }
        this.kkz = true;
    }

    public void cPb() {
        if (this.kks != null) {
            this.kks.qJ(true);
        }
        t.csH().mG(false);
        com.baidu.tieba.a.d.bKY().dK("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kkK);
    }

    public void cRe() {
        this.kks.cRA();
    }

    public void cRm() {
        this.kks.cRm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRp() {
        com.baidu.tieba.homepage.framework.a.cPB().E(System.currentTimeMillis(), 1);
        if (this.gCf != null && !this.gCf.isLoading()) {
            this.gCf.startLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kks.bRp();
    }
}
