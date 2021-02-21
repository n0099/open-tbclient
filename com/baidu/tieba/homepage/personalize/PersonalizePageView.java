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
    private CustomMessageListener eJz;
    private LinearLayoutManager eqM;
    private int fHo;
    private final CustomMessageListener fsV;
    private PbListView gAw;
    private int gCX;
    private com.baidu.tbadk.l.g gJB;
    private l iRt;
    private CustomMessageListener iRv;
    private FollowUserButton.a jZd;
    private boolean jhi;
    private int jhs;
    private CustomMessageListener jik;
    private BdTypeRecyclerView kaf;
    private ScrollFragmentTabHost kal;
    ScrollFragmentTabHost.a kam;
    private BigdaySwipeRefreshLayout kan;
    private View.OnClickListener kap;
    private NEGFeedBackView.a kfy;
    f.d kga;
    f.b kgb;
    private p kgj;
    private boolean kiA;
    private FRSRefreshButton kiB;
    private ab.a kiC;
    private CustomMessageListener kiD;
    private View.OnClickListener kiE;
    private e.a kiF;
    f.c kiG;
    f.a kiH;
    private Runnable kiI;
    public CustomMessageListener kiJ;
    private View.OnClickListener kiK;
    private com.baidu.tieba.homepage.personalize.bigday.b kil;
    private com.baidu.tieba.homepage.personalize.bigday.a kim;
    private a kin;
    private ab kio;
    private com.baidu.tieba.homepage.framework.b kip;
    private e kiq;
    private com.baidu.tieba.homepage.personalize.a kir;
    private com.baidu.tieba.homepage.personalize.model.e kis;
    private long kit;
    private int kiu;
    private boolean kiv;
    private long kiw;
    private boolean kix;
    private boolean kiy;
    private int kiz;
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
        int i = personalizePageView.kiz + 1;
        personalizePageView.kiz = i;
        return i;
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kal = scrollFragmentTabHost;
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
        }
        if (this.kiq != null) {
            this.kiq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kir != null) {
            this.kir.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.kan != null) {
            this.kan.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kio != null) {
            this.kio.setPageUniqueId(bdUniqueId);
        }
        if (this.kiq != null) {
            this.kiq.o(bdUniqueId);
        }
        if (this.kis != null) {
            this.kis.i(bdUniqueId);
        }
        if (this.kim != null) {
            this.kim.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.blb().setTag(bdUniqueId);
        if (this.fsV != null) {
            this.fsV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fsV);
        }
        if (this.kir != null) {
            this.kir.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.kit = 0L;
        this.mSkinType = 3;
        this.jhi = false;
        this.kiu = 0;
        this.kiv = false;
        this.kiw = -1L;
        this.kix = false;
        this.kiy = false;
        this.kiz = 0;
        this.jhs = 0;
        this.kiA = false;
        this.fHo = 1;
        this.iRv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iRt == null) {
                            PersonalizePageView.this.iRt = new l(new j());
                        }
                        PersonalizePageView.this.iRt.a(PersonalizePageView.this.kaf, 2);
                    } else if (PersonalizePageView.this.iRt != null) {
                        PersonalizePageView.this.iRt.qJ();
                    }
                }
            }
        };
        this.kiC = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mk() {
                if (PersonalizePageView.this.kaf != null && PersonalizePageView.this.kgj != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.kaf.removeHeaderView(PersonalizePageView.this.kgj.getView());
                    } else if (PersonalizePageView.this.kgj.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kgj.ks();
                        PersonalizePageView.this.kgj.getView().setVisibility(0);
                        PersonalizePageView.this.kgj.IP("1");
                        PersonalizePageView.this.kaf.setHeaderView(PersonalizePageView.this.kgj.getView());
                    }
                }
            }
        };
        this.kiD = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kiq != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.brd().bre(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kfy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                if (avVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, avVar.bmo()));
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
                    if (PersonalizePageView.this.kio != null) {
                        PersonalizePageView.this.kio.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jZd = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof cb) {
                        TiebaStatic.log(com.baidu.tieba.s.a.f("c13696", (cb) tag));
                    }
                }
            }
        };
        this.gCX = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gCX != i && PersonalizePageView.this.kal != null) {
                    PersonalizePageView.this.gCX = i;
                    if (PersonalizePageView.this.gCX == 1) {
                        PersonalizePageView.this.kal.bRQ();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.kal.bRR();
                    } else {
                        PersonalizePageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kam = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPZ() {
                if (PersonalizePageView.this.kal != null) {
                    PersonalizePageView.this.gCX = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.kaf)) {
                        PersonalizePageView.this.kal.bRR();
                    } else {
                        PersonalizePageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kiE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kaf != null) {
                    PersonalizePageView.this.kaf.removeHeaderView(PersonalizePageView.this.kgj.getView());
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kaf != null && PersonalizePageView.this.kgj != null && PersonalizePageView.this.kgj.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kgj.ks();
                    PersonalizePageView.this.kgj.getView().setVisibility(0);
                    PersonalizePageView.this.kgj.IP("1");
                    PersonalizePageView.this.kaf.setHeaderView(PersonalizePageView.this.kgj.getView());
                }
            }
        };
        this.kiF = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean iZm = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_first_install", true);

            private void cRg() {
                if (this.iZm) {
                    this.iZm = false;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, com.baidu.tbadk.util.c cVar, int i2) {
                if (PersonalizePageView.this.kip == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqT = PersonalizePageView.this.cqT();
                PersonalizePageView.this.WZ();
                if (cqT) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kip.a(i, cVar, i2);
                q.bhU().bhV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kip != null) {
                    PersonalizePageView.this.kip.a(i, i2, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cRg();
                } else if (!this.iZm) {
                    PersonalizePageView.this.kan.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cRg();
                    PersonalizePageView.this.cPJ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cRg();
                PersonalizePageView.this.kan.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.WZ();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOK().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kiv = true;
                    PersonalizePageView.this.kiw = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRh() {
                if (PersonalizePageView.this.gAw != null) {
                    PersonalizePageView.this.gAw.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gAw.endLoadData();
                    PersonalizePageView.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kiG = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKU().Ev("page_recommend");
                PersonalizePageView.this.kiq.update();
                PersonalizePageView.this.kiq.se(false);
                PersonalizePageView.this.kiA = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kga = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kiq != null && PersonalizePageView.this.kiq.cDF() != null) {
                    PersonalizePageView.this.kiq.cDF().cQB();
                }
            }
        };
        this.kiH = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buy() {
                if (PersonalizePageView.this.kiA) {
                    PersonalizePageView.this.jhs = 0;
                    PersonalizePageView.this.fHo = 1;
                    PersonalizePageView.this.kiA = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kgb = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kiq != null) {
                    PersonalizePageView.this.kiq.se(true);
                    PersonalizePageView.this.kiq.cRm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kiI = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fsV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
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
                                PersonalizePageView.this.cOT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kap = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRj();
            }
        };
        this.jik = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jhi = true;
                    }
                }
            }
        };
        this.kiJ = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kan != null && !PersonalizePageView.this.kan.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kim == null) {
                            PersonalizePageView.this.kim = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kim.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kin = PersonalizePageView.this.kim;
                            PersonalizePageView.this.cRb();
                        } else if (PersonalizePageView.this.kin != PersonalizePageView.this.kim) {
                            PersonalizePageView.this.kin = PersonalizePageView.this.kim;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kim.setEnable(true);
                        PersonalizePageView.this.kan.setProgressView(PersonalizePageView.this.kim);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.kan.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.kil == null) {
                        PersonalizePageView.this.kil = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kin = PersonalizePageView.this.kil;
                        PersonalizePageView.this.cRb();
                    } else if (PersonalizePageView.this.kin != PersonalizePageView.this.kil || !aVar.equals(PersonalizePageView.this.kil.cRH())) {
                        PersonalizePageView.this.kin = PersonalizePageView.this.kil;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.kil.setEnable(true);
                    PersonalizePageView.this.kan.setProgressView(PersonalizePageView.this.kil);
                    PersonalizePageView.this.kil.a(aVar);
                    PersonalizePageView.this.kan.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kiK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kiB != null) {
                    PersonalizePageView.this.kiB.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kit = 0L;
        this.mSkinType = 3;
        this.jhi = false;
        this.kiu = 0;
        this.kiv = false;
        this.kiw = -1L;
        this.kix = false;
        this.kiy = false;
        this.kiz = 0;
        this.jhs = 0;
        this.kiA = false;
        this.fHo = 1;
        this.iRv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iRt == null) {
                            PersonalizePageView.this.iRt = new l(new j());
                        }
                        PersonalizePageView.this.iRt.a(PersonalizePageView.this.kaf, 2);
                    } else if (PersonalizePageView.this.iRt != null) {
                        PersonalizePageView.this.iRt.qJ();
                    }
                }
            }
        };
        this.kiC = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mk() {
                if (PersonalizePageView.this.kaf != null && PersonalizePageView.this.kgj != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.kaf.removeHeaderView(PersonalizePageView.this.kgj.getView());
                    } else if (PersonalizePageView.this.kgj.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kgj.ks();
                        PersonalizePageView.this.kgj.getView().setVisibility(0);
                        PersonalizePageView.this.kgj.IP("1");
                        PersonalizePageView.this.kaf.setHeaderView(PersonalizePageView.this.kgj.getView());
                    }
                }
            }
        };
        this.kiD = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kiq != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.brd().bre(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kfy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                if (avVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, avVar.bmo()));
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
                    if (PersonalizePageView.this.kio != null) {
                        PersonalizePageView.this.kio.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jZd = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof cb) {
                        TiebaStatic.log(com.baidu.tieba.s.a.f("c13696", (cb) tag));
                    }
                }
            }
        };
        this.gCX = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gCX != i && PersonalizePageView.this.kal != null) {
                    PersonalizePageView.this.gCX = i;
                    if (PersonalizePageView.this.gCX == 1) {
                        PersonalizePageView.this.kal.bRQ();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.kal.bRR();
                    } else {
                        PersonalizePageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kam = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPZ() {
                if (PersonalizePageView.this.kal != null) {
                    PersonalizePageView.this.gCX = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.kaf)) {
                        PersonalizePageView.this.kal.bRR();
                    } else {
                        PersonalizePageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kiE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kaf != null) {
                    PersonalizePageView.this.kaf.removeHeaderView(PersonalizePageView.this.kgj.getView());
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kaf != null && PersonalizePageView.this.kgj != null && PersonalizePageView.this.kgj.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kgj.ks();
                    PersonalizePageView.this.kgj.getView().setVisibility(0);
                    PersonalizePageView.this.kgj.IP("1");
                    PersonalizePageView.this.kaf.setHeaderView(PersonalizePageView.this.kgj.getView());
                }
            }
        };
        this.kiF = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean iZm = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_first_install", true);

            private void cRg() {
                if (this.iZm) {
                    this.iZm = false;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, com.baidu.tbadk.util.c cVar, int i2) {
                if (PersonalizePageView.this.kip == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqT = PersonalizePageView.this.cqT();
                PersonalizePageView.this.WZ();
                if (cqT) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kip.a(i, cVar, i2);
                q.bhU().bhV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kip != null) {
                    PersonalizePageView.this.kip.a(i, i2, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cRg();
                } else if (!this.iZm) {
                    PersonalizePageView.this.kan.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cRg();
                    PersonalizePageView.this.cPJ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cRg();
                PersonalizePageView.this.kan.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.WZ();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOK().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kiv = true;
                    PersonalizePageView.this.kiw = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRh() {
                if (PersonalizePageView.this.gAw != null) {
                    PersonalizePageView.this.gAw.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gAw.endLoadData();
                    PersonalizePageView.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kiG = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKU().Ev("page_recommend");
                PersonalizePageView.this.kiq.update();
                PersonalizePageView.this.kiq.se(false);
                PersonalizePageView.this.kiA = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kga = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kiq != null && PersonalizePageView.this.kiq.cDF() != null) {
                    PersonalizePageView.this.kiq.cDF().cQB();
                }
            }
        };
        this.kiH = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buy() {
                if (PersonalizePageView.this.kiA) {
                    PersonalizePageView.this.jhs = 0;
                    PersonalizePageView.this.fHo = 1;
                    PersonalizePageView.this.kiA = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kgb = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kiq != null) {
                    PersonalizePageView.this.kiq.se(true);
                    PersonalizePageView.this.kiq.cRm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kiI = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fsV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
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
                                PersonalizePageView.this.cOT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kap = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRj();
            }
        };
        this.jik = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jhi = true;
                    }
                }
            }
        };
        this.kiJ = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kan != null && !PersonalizePageView.this.kan.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kim == null) {
                            PersonalizePageView.this.kim = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kim.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kin = PersonalizePageView.this.kim;
                            PersonalizePageView.this.cRb();
                        } else if (PersonalizePageView.this.kin != PersonalizePageView.this.kim) {
                            PersonalizePageView.this.kin = PersonalizePageView.this.kim;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kim.setEnable(true);
                        PersonalizePageView.this.kan.setProgressView(PersonalizePageView.this.kim);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.kan.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.kil == null) {
                        PersonalizePageView.this.kil = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kin = PersonalizePageView.this.kil;
                        PersonalizePageView.this.cRb();
                    } else if (PersonalizePageView.this.kin != PersonalizePageView.this.kil || !aVar.equals(PersonalizePageView.this.kil.cRH())) {
                        PersonalizePageView.this.kin = PersonalizePageView.this.kil;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.kil.setEnable(true);
                    PersonalizePageView.this.kan.setProgressView(PersonalizePageView.this.kil);
                    PersonalizePageView.this.kil.a(aVar);
                    PersonalizePageView.this.kan.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kiK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kiB != null) {
                    PersonalizePageView.this.kiB.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kit = 0L;
        this.mSkinType = 3;
        this.jhi = false;
        this.kiu = 0;
        this.kiv = false;
        this.kiw = -1L;
        this.kix = false;
        this.kiy = false;
        this.kiz = 0;
        this.jhs = 0;
        this.kiA = false;
        this.fHo = 1;
        this.iRv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iRt == null) {
                            PersonalizePageView.this.iRt = new l(new j());
                        }
                        PersonalizePageView.this.iRt.a(PersonalizePageView.this.kaf, 2);
                    } else if (PersonalizePageView.this.iRt != null) {
                        PersonalizePageView.this.iRt.qJ();
                    }
                }
            }
        };
        this.kiC = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mk() {
                if (PersonalizePageView.this.kaf != null && PersonalizePageView.this.kgj != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.kaf.removeHeaderView(PersonalizePageView.this.kgj.getView());
                    } else if (PersonalizePageView.this.kgj.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kgj.ks();
                        PersonalizePageView.this.kgj.getView().setVisibility(0);
                        PersonalizePageView.this.kgj.IP("1");
                        PersonalizePageView.this.kaf.setHeaderView(PersonalizePageView.this.kgj.getView());
                    }
                }
            }
        };
        this.kiD = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kiq != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.brd().bre(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kfy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                if (avVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, avVar.bmo()));
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
                    if (PersonalizePageView.this.kio != null) {
                        PersonalizePageView.this.kio.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jZd = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof cb) {
                        TiebaStatic.log(com.baidu.tieba.s.a.f("c13696", (cb) tag));
                    }
                }
            }
        };
        this.gCX = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gCX != i2 && PersonalizePageView.this.kal != null) {
                    PersonalizePageView.this.gCX = i2;
                    if (PersonalizePageView.this.gCX == 1) {
                        PersonalizePageView.this.kal.bRQ();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.kal.bRR();
                    } else {
                        PersonalizePageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kam = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPZ() {
                if (PersonalizePageView.this.kal != null) {
                    PersonalizePageView.this.gCX = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.kaf)) {
                        PersonalizePageView.this.kal.bRR();
                    } else {
                        PersonalizePageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kiE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kaf != null) {
                    PersonalizePageView.this.kaf.removeHeaderView(PersonalizePageView.this.kgj.getView());
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kaf != null && PersonalizePageView.this.kgj != null && PersonalizePageView.this.kgj.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kgj.ks();
                    PersonalizePageView.this.kgj.getView().setVisibility(0);
                    PersonalizePageView.this.kgj.IP("1");
                    PersonalizePageView.this.kaf.setHeaderView(PersonalizePageView.this.kgj.getView());
                }
            }
        };
        this.kiF = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean iZm = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_first_install", true);

            private void cRg() {
                if (this.iZm) {
                    this.iZm = false;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i2, com.baidu.tbadk.util.c cVar, int i22) {
                if (PersonalizePageView.this.kip == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqT = PersonalizePageView.this.cqT();
                PersonalizePageView.this.WZ();
                if (cqT) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kip.a(i2, cVar, i22);
                q.bhU().bhV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i2, int i22, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kip != null) {
                    PersonalizePageView.this.kip.a(i2, i22, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cRg();
                } else if (!this.iZm) {
                    PersonalizePageView.this.kan.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cRg();
                    PersonalizePageView.this.cPJ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cRg();
                PersonalizePageView.this.kan.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.WZ();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOK().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kiv = true;
                    PersonalizePageView.this.kiw = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRh() {
                if (PersonalizePageView.this.gAw != null) {
                    PersonalizePageView.this.gAw.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gAw.endLoadData();
                    PersonalizePageView.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kiG = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKU().Ev("page_recommend");
                PersonalizePageView.this.kiq.update();
                PersonalizePageView.this.kiq.se(false);
                PersonalizePageView.this.kiA = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kga = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kiq != null && PersonalizePageView.this.kiq.cDF() != null) {
                    PersonalizePageView.this.kiq.cDF().cQB();
                }
            }
        };
        this.kiH = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buy() {
                if (PersonalizePageView.this.kiA) {
                    PersonalizePageView.this.jhs = 0;
                    PersonalizePageView.this.fHo = 1;
                    PersonalizePageView.this.kiA = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kgb = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kiq != null) {
                    PersonalizePageView.this.kiq.se(true);
                    PersonalizePageView.this.kiq.cRm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kiI = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fsV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
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
                                PersonalizePageView.this.cOT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kap = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRj();
            }
        };
        this.jik = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jhi = true;
                    }
                }
            }
        };
        this.kiJ = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kan != null && !PersonalizePageView.this.kan.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kim == null) {
                            PersonalizePageView.this.kim = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kim.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kin = PersonalizePageView.this.kim;
                            PersonalizePageView.this.cRb();
                        } else if (PersonalizePageView.this.kin != PersonalizePageView.this.kim) {
                            PersonalizePageView.this.kin = PersonalizePageView.this.kim;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kim.setEnable(true);
                        PersonalizePageView.this.kan.setProgressView(PersonalizePageView.this.kim);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.kan.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.kil == null) {
                        PersonalizePageView.this.kil = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kin = PersonalizePageView.this.kil;
                        PersonalizePageView.this.cRb();
                    } else if (PersonalizePageView.this.kin != PersonalizePageView.this.kil || !aVar.equals(PersonalizePageView.this.kil.cRH())) {
                        PersonalizePageView.this.kin = PersonalizePageView.this.kil;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.kil.setEnable(true);
                    PersonalizePageView.this.kan.setProgressView(PersonalizePageView.this.kil);
                    PersonalizePageView.this.kil.a(aVar);
                    PersonalizePageView.this.kan.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kiK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kiB != null) {
                    PersonalizePageView.this.kiB.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kaf = new BdTypeRecyclerView(context);
        this.eqM = new LinearLayoutManager(this.kaf.getContext());
        this.kaf.setLayoutManager(this.eqM);
        this.kaf.setFadingEdgeLength(0);
        this.kaf.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.kaf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kgj = new p(context);
        this.kgj.setFrom("from_personaize");
        this.kgj.csv().setVisibility(0);
        this.kgj.csv().setOnClickListener(this.kiE);
        MessageManager.getInstance().registerListener(this.eJz);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iRt = new l(new j());
            this.iRt.a(this.kaf, 2);
        }
        MessageManager.getInstance().registerListener(this.iRv);
        MessageManager.getInstance().registerListener(this.kiD);
        this.kan = new BigdaySwipeRefreshLayout(context);
        this.kan.addView(this.kaf);
        this.gAw = new PbListView(context);
        this.gAw.getView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setLineGone();
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gAw.setOnClickListener(this.kap);
        this.gAw.bud();
        this.kaf.setNextPage(this.gAw);
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        MessageManager.getInstance().registerListener(this.kiJ);
        com.baidu.tbadk.core.bigday.b.blb().jp(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.kan);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.kiB = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.kiB, layoutParams);
            this.kiB.setOnClickListener(this.kiK);
            this.kiB.setVisibility(8);
        }
        this.kis = new com.baidu.tieba.homepage.personalize.model.e();
        this.kio = new ab(context, this.kaf);
        this.kio.b(this.kis);
        this.kio.a(this.kiC);
        this.kiq = new e(this.pageContext, this.kaf, this.kio, this.kan);
        this.kir = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.jik);
        this.kiz = com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cRb() {
        if (this.kin != null) {
            this.kin.setListPullRefreshListener(this.kiG);
            this.kin.a(this.kga);
            this.kin.a(this.kiH);
            this.kin.a(this.kgb);
        }
    }

    public void bZl() {
        this.kio.b(this.kfy);
        this.kio.a(this.jZd);
        this.kiq.a(this.kiF);
        this.kir.a(this);
        cRb();
        this.kaf.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.jhs += i2;
                if (PersonalizePageView.this.kiB != null) {
                    n item = PersonalizePageView.this.kaf.getItem(PersonalizePageView.this.eqM.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.kiB.show();
                        } else {
                            PersonalizePageView.this.kiB.hide();
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eqM != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.jhs < height * 3 || PersonalizePageView.this.fHo != 1) {
                        if (PersonalizePageView.this.jhs < height * 3 && PersonalizePageView.this.fHo == 2) {
                            PersonalizePageView.this.fHo = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fHo = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fHo)));
                    }
                    if (PersonalizePageView.this.eqM.getItemCount() - PersonalizePageView.this.eqM.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bRj();
                    }
                }
            }
        });
        this.kaf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bRj();
            }
        });
        this.kaf.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.kit >= 5000) {
                    PersonalizePageView.this.kiq.cE(i, i2);
                }
            }
        }, 1L);
        this.kaf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.kiq != null && PersonalizePageView.this.kiq.cDF() != null) {
                        PersonalizePageView.this.kiq.cDF().dt(view);
                    }
                    if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                        ((HomePageCardVideoViewHolder) view.getTag()).cti().stopPlay();
                    }
                }
            }
        });
        this.kaf.removeOnScrollListener(this.mOnScrollListener);
        this.kaf.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.kip = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gAw != null) {
            this.gAw.setText(getContext().getString(R.string.pb_load_more));
            this.gAw.endLoadData();
            this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kiq.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.kiq != null) {
            this.kiq.sj(!z);
        }
        this.kiy = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.kiy;
    }

    public void h(Long l) {
        this.kiq.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.kiq != null) {
            this.kiq.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.kiq != null) {
            this.kiq.showFloatingView();
        }
    }

    public void cRc() {
        if (this.kiq != null) {
            this.kiq.cRc();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.kim != null) {
                this.kim.changeSkin(i);
            }
            if (this.gAw != null) {
                this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gAw.changeSkin(i);
            }
            this.kio.onChangeSkinType(i);
            if (this.kiq != null) {
                this.kiq.onChangeSkinType(i);
            }
            if (this.kiB != null) {
                this.kiB.onChangeSkinType(i);
            }
            if (this.kgj != null) {
                this.kgj.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void bd(String str, int i) {
        if (this.gAw != null) {
            this.gAw.setText(getContext().getString(R.string.pb_load_more));
            this.gAw.endLoadData();
            this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kiq.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.kiq != null) {
                        PersonalizePageView.this.kiq.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
            this.kaf.setNextPage(this.gAw);
            this.gAw.setText(getContext().getString(R.string.pb_load_more));
            this.gAw.endLoadData();
            this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.kan != null) {
            this.kan.setVisibility(0);
        }
        if (this.kip != null) {
            this.kip.cPv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqT() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(boolean z) {
        if (this.gJB == null) {
            this.gJB = new com.baidu.tbadk.l.g(getContext());
            this.gJB.bt(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gJB.bCS();
            this.gJB.setWrapStyle(true);
            this.gJB.onChangeSkinType();
        }
        this.gJB.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.kaf.setNextPage(null);
        if (this.kan != null) {
            this.kan.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.kiq != null) {
            this.kiq.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.kiq != null) {
            this.kiq.qJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.kiz < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.kiI, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.kiq != null) {
            this.kiq.rV(z);
        }
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
            this.kam.cPZ();
        }
    }

    public void cPJ() {
        if (this.kiq != null) {
            ir(true);
            this.kiq.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.blb().bld();
            com.baidu.tbadk.core.bigday.b.blb().blc();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.kiq != null) {
            this.kiq.update();
        } else if (this.kaf != null && this.kan != null) {
            showFloatingView();
            this.kaf.setSelection(0);
            if (!this.kan.isRefreshing()) {
                if (this.kiq != null && this.kiq.cDF() != null) {
                    this.kiq.cDF().cQB();
                    this.kiq.se(false);
                }
                this.kan.setRefreshing(true);
            }
            if (this.kam != null) {
                this.kam.cPZ();
            }
        }
    }

    public void cRd() {
        if (this.refreshView != null) {
            reload();
        } else if (this.kiq != null) {
            this.kiq.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iRv);
        MessageManager.getInstance().unRegisterListener(this.jik);
        MessageManager.getInstance().unRegisterListener(this.kiJ);
        this.kiq.onDestroy();
        this.kio.b((NEGFeedBackView.a) null);
        this.kio.onDestroy();
        this.kiq.a((e.a) null);
        if (this.kil != null) {
            this.kil.setListPullRefreshListener(null);
            this.kil.a((f.d) null);
            this.kil.a((f.a) null);
            this.kil.a((f.b) null);
            this.kil.release();
        }
        if (this.kim != null) {
            this.kim.setListPullRefreshListener(null);
            this.kim.a((f.d) null);
            this.kim.a((f.a) null);
            this.kim.a((f.b) null);
            this.kim.release();
        }
        this.kaf.setOnSrollToBottomListener(null);
        if (this.kal != null) {
            this.kal.b(this.kam);
        }
        this.kaf.removeOnScrollListener(this.mOnScrollListener);
        if (this.gJB != null) {
            this.gJB.release();
        }
        this.kaf.setRecyclerListener(null);
        if (this.kir != null) {
            this.kir.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.blb().destroy();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kiI);
    }

    public void onPause() {
        this.kiq.onPause();
        if (this.kio != null) {
            this.kio.onPause();
        }
    }

    public void onResume() {
        if (this.jhi) {
            reload();
            this.jhi = false;
        }
        if (this.kan != null) {
            this.kan.resume();
        }
        if (this.kio != null) {
            this.kio.onResume();
        }
    }

    public void cOT() {
        if (this.kio != null) {
            this.kio.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kiv) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cRe();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRe() {
        if (!this.kix) {
            long BA = com.baidu.tieba.homepage.framework.a.cPu().BA(1) + com.baidu.tieba.homepage.framework.a.cPu().getCreateTime();
            long By = com.baidu.tieba.homepage.framework.a.cPu().By(1);
            if (By > 0) {
                BA = System.currentTimeMillis() - By;
            }
            com.baidu.tbadk.n.n nVar = new com.baidu.tbadk.n.n();
            nVar.bEo();
            nVar.bEp();
            com.baidu.tbadk.n.l.bEl().eK(BA);
            if (this.kiw > 0) {
                com.baidu.tbadk.n.l.bEl().eO(System.currentTimeMillis() - this.kiw);
            }
            com.baidu.tbadk.n.l.bEl().eL(nVar.bEq());
        }
        this.kix = true;
    }

    public void cOU() {
        if (this.kiq != null) {
            this.kiq.qJ(true);
        }
        t.csB().mG(false);
        com.baidu.tieba.a.d.bKU().dK("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kiI);
    }

    public void cQX() {
        this.kiq.cRt();
    }

    public void cRf() {
        this.kiq.cRf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRj() {
        com.baidu.tieba.homepage.framework.a.cPu().E(System.currentTimeMillis(), 1);
        if (this.gAw != null && !this.gAw.isLoading()) {
            this.gAw.startLoadData();
            this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kiq.bRj();
    }
}
