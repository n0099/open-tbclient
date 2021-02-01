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
    private PbListView gAi;
    private int gCJ;
    private com.baidu.tbadk.l.g gJn;
    private l iRf;
    private CustomMessageListener iRh;
    private FollowUserButton.a jYP;
    private BdTypeRecyclerView jZR;
    private ScrollFragmentTabHost jZX;
    ScrollFragmentTabHost.a jZY;
    private BigdaySwipeRefreshLayout jZZ;
    private boolean jgU;
    private CustomMessageListener jhV;
    private int jhe;
    private View.OnClickListener kab;
    f.d kfM;
    f.b kfN;
    private p kfV;
    private NEGFeedBackView.a kfk;
    private com.baidu.tieba.homepage.personalize.bigday.b khW;
    private com.baidu.tieba.homepage.personalize.bigday.a khX;
    private a khY;
    private ab khZ;
    private com.baidu.tieba.homepage.framework.b kia;
    private e kib;
    private com.baidu.tieba.homepage.personalize.a kic;
    private com.baidu.tieba.homepage.personalize.model.e kie;
    private long kif;
    private int kig;
    private boolean kih;
    private long kii;
    private boolean kij;
    private boolean kik;
    private int kil;
    private boolean kim;
    private FRSRefreshButton kin;
    private ab.a kio;
    private CustomMessageListener kip;
    private View.OnClickListener kiq;
    private e.a kir;
    f.c kis;
    f.a kit;
    private Runnable kiu;
    public CustomMessageListener kiv;
    private View.OnClickListener kiw;
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
        int i = personalizePageView.kil + 1;
        personalizePageView.kil = i;
        return i;
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jZX = scrollFragmentTabHost;
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
        }
        if (this.kib != null) {
            this.kib.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kic != null) {
            this.kic.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jZZ != null) {
            this.jZZ.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.khZ != null) {
            this.khZ.setPageUniqueId(bdUniqueId);
        }
        if (this.kib != null) {
            this.kib.o(bdUniqueId);
        }
        if (this.kie != null) {
            this.kie.i(bdUniqueId);
        }
        if (this.khX != null) {
            this.khX.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.blb().setTag(bdUniqueId);
        if (this.fsV != null) {
            this.fsV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fsV);
        }
        if (this.kic != null) {
            this.kic.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.kif = 0L;
        this.mSkinType = 3;
        this.jgU = false;
        this.kig = 0;
        this.kih = false;
        this.kii = -1L;
        this.kij = false;
        this.kik = false;
        this.kil = 0;
        this.jhe = 0;
        this.kim = false;
        this.fHo = 1;
        this.iRh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iRf == null) {
                            PersonalizePageView.this.iRf = new l(new j());
                        }
                        PersonalizePageView.this.iRf.a(PersonalizePageView.this.jZR, 2);
                    } else if (PersonalizePageView.this.iRf != null) {
                        PersonalizePageView.this.iRf.qJ();
                    }
                }
            }
        };
        this.kio = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mk() {
                if (PersonalizePageView.this.jZR != null && PersonalizePageView.this.kfV != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.jZR.removeHeaderView(PersonalizePageView.this.kfV.getView());
                    } else if (PersonalizePageView.this.kfV.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kfV.ks();
                        PersonalizePageView.this.kfV.getView().setVisibility(0);
                        PersonalizePageView.this.kfV.IO("1");
                        PersonalizePageView.this.jZR.setHeaderView(PersonalizePageView.this.kfV.getView());
                    }
                }
            }
        };
        this.kip = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kib != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.brd().bre(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kfk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
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
                    if (PersonalizePageView.this.khZ != null) {
                        PersonalizePageView.this.khZ.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jYP = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
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
        this.gCJ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gCJ != i && PersonalizePageView.this.jZX != null) {
                    PersonalizePageView.this.gCJ = i;
                    if (PersonalizePageView.this.gCJ == 1) {
                        PersonalizePageView.this.jZX.bRJ();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jZX.bRK();
                    } else {
                        PersonalizePageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.jZY = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPS() {
                if (PersonalizePageView.this.jZX != null) {
                    PersonalizePageView.this.gCJ = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jZR)) {
                        PersonalizePageView.this.jZX.bRK();
                    } else {
                        PersonalizePageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.kiq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jZR != null) {
                    PersonalizePageView.this.jZR.removeHeaderView(PersonalizePageView.this.kfV.getView());
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZR != null && PersonalizePageView.this.kfV != null && PersonalizePageView.this.kfV.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kfV.ks();
                    PersonalizePageView.this.kfV.getView().setVisibility(0);
                    PersonalizePageView.this.kfV.IO("1");
                    PersonalizePageView.this.jZR.setHeaderView(PersonalizePageView.this.kfV.getView());
                }
            }
        };
        this.kir = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean iYY = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_first_install", true);

            private void cQZ() {
                if (this.iYY) {
                    this.iYY = false;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, com.baidu.tbadk.util.c cVar, int i2) {
                if (PersonalizePageView.this.kia == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqM = PersonalizePageView.this.cqM();
                PersonalizePageView.this.WZ();
                if (cqM) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kia.a(i, cVar, i2);
                q.bhU().bhV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kia != null) {
                    PersonalizePageView.this.kia.a(i, i2, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cQZ();
                } else if (!this.iYY) {
                    PersonalizePageView.this.jZZ.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cQZ();
                    PersonalizePageView.this.cPC();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cQZ();
                PersonalizePageView.this.jZZ.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.WZ();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOC().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kih = true;
                    PersonalizePageView.this.kii = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRa() {
                if (PersonalizePageView.this.gAi != null) {
                    PersonalizePageView.this.gAi.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gAi.endLoadData();
                    PersonalizePageView.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kis = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKP().Ex("page_recommend");
                PersonalizePageView.this.kib.update();
                PersonalizePageView.this.kib.se(false);
                PersonalizePageView.this.kim = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kfM = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kib != null && PersonalizePageView.this.kib.cDy() != null) {
                    PersonalizePageView.this.kib.cDy().cQu();
                }
            }
        };
        this.kit = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buy() {
                if (PersonalizePageView.this.kim) {
                    PersonalizePageView.this.jhe = 0;
                    PersonalizePageView.this.fHo = 1;
                    PersonalizePageView.this.kim = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kfN = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kib != null) {
                    PersonalizePageView.this.kib.se(true);
                    PersonalizePageView.this.kib.cRf();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kiu = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
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
                                PersonalizePageView.this.cOM();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRc();
            }
        };
        this.jhV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jgU = true;
                    }
                }
            }
        };
        this.kiv = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZZ != null && !PersonalizePageView.this.jZZ.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.khX == null) {
                            PersonalizePageView.this.khX = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.khX.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.khY = PersonalizePageView.this.khX;
                            PersonalizePageView.this.cQU();
                        } else if (PersonalizePageView.this.khY != PersonalizePageView.this.khX) {
                            PersonalizePageView.this.khY = PersonalizePageView.this.khX;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.khX.setEnable(true);
                        PersonalizePageView.this.jZZ.setProgressView(PersonalizePageView.this.khX);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jZZ.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.khW == null) {
                        PersonalizePageView.this.khW = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.khY = PersonalizePageView.this.khW;
                        PersonalizePageView.this.cQU();
                    } else if (PersonalizePageView.this.khY != PersonalizePageView.this.khW || !aVar.equals(PersonalizePageView.this.khW.cRA())) {
                        PersonalizePageView.this.khY = PersonalizePageView.this.khW;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.khW.setEnable(true);
                    PersonalizePageView.this.jZZ.setProgressView(PersonalizePageView.this.khW);
                    PersonalizePageView.this.khW.a(aVar);
                    PersonalizePageView.this.jZZ.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kiw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kin != null) {
                    PersonalizePageView.this.kin.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kif = 0L;
        this.mSkinType = 3;
        this.jgU = false;
        this.kig = 0;
        this.kih = false;
        this.kii = -1L;
        this.kij = false;
        this.kik = false;
        this.kil = 0;
        this.jhe = 0;
        this.kim = false;
        this.fHo = 1;
        this.iRh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iRf == null) {
                            PersonalizePageView.this.iRf = new l(new j());
                        }
                        PersonalizePageView.this.iRf.a(PersonalizePageView.this.jZR, 2);
                    } else if (PersonalizePageView.this.iRf != null) {
                        PersonalizePageView.this.iRf.qJ();
                    }
                }
            }
        };
        this.kio = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mk() {
                if (PersonalizePageView.this.jZR != null && PersonalizePageView.this.kfV != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.jZR.removeHeaderView(PersonalizePageView.this.kfV.getView());
                    } else if (PersonalizePageView.this.kfV.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kfV.ks();
                        PersonalizePageView.this.kfV.getView().setVisibility(0);
                        PersonalizePageView.this.kfV.IO("1");
                        PersonalizePageView.this.jZR.setHeaderView(PersonalizePageView.this.kfV.getView());
                    }
                }
            }
        };
        this.kip = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kib != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.brd().bre(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kfk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
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
                    if (PersonalizePageView.this.khZ != null) {
                        PersonalizePageView.this.khZ.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jYP = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
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
        this.gCJ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gCJ != i && PersonalizePageView.this.jZX != null) {
                    PersonalizePageView.this.gCJ = i;
                    if (PersonalizePageView.this.gCJ == 1) {
                        PersonalizePageView.this.jZX.bRJ();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jZX.bRK();
                    } else {
                        PersonalizePageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.jZY = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPS() {
                if (PersonalizePageView.this.jZX != null) {
                    PersonalizePageView.this.gCJ = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jZR)) {
                        PersonalizePageView.this.jZX.bRK();
                    } else {
                        PersonalizePageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.kiq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jZR != null) {
                    PersonalizePageView.this.jZR.removeHeaderView(PersonalizePageView.this.kfV.getView());
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZR != null && PersonalizePageView.this.kfV != null && PersonalizePageView.this.kfV.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kfV.ks();
                    PersonalizePageView.this.kfV.getView().setVisibility(0);
                    PersonalizePageView.this.kfV.IO("1");
                    PersonalizePageView.this.jZR.setHeaderView(PersonalizePageView.this.kfV.getView());
                }
            }
        };
        this.kir = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean iYY = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_first_install", true);

            private void cQZ() {
                if (this.iYY) {
                    this.iYY = false;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, com.baidu.tbadk.util.c cVar, int i2) {
                if (PersonalizePageView.this.kia == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqM = PersonalizePageView.this.cqM();
                PersonalizePageView.this.WZ();
                if (cqM) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kia.a(i, cVar, i2);
                q.bhU().bhV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kia != null) {
                    PersonalizePageView.this.kia.a(i, i2, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cQZ();
                } else if (!this.iYY) {
                    PersonalizePageView.this.jZZ.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cQZ();
                    PersonalizePageView.this.cPC();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cQZ();
                PersonalizePageView.this.jZZ.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.WZ();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOC().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kih = true;
                    PersonalizePageView.this.kii = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRa() {
                if (PersonalizePageView.this.gAi != null) {
                    PersonalizePageView.this.gAi.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gAi.endLoadData();
                    PersonalizePageView.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kis = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKP().Ex("page_recommend");
                PersonalizePageView.this.kib.update();
                PersonalizePageView.this.kib.se(false);
                PersonalizePageView.this.kim = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kfM = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kib != null && PersonalizePageView.this.kib.cDy() != null) {
                    PersonalizePageView.this.kib.cDy().cQu();
                }
            }
        };
        this.kit = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buy() {
                if (PersonalizePageView.this.kim) {
                    PersonalizePageView.this.jhe = 0;
                    PersonalizePageView.this.fHo = 1;
                    PersonalizePageView.this.kim = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kfN = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kib != null) {
                    PersonalizePageView.this.kib.se(true);
                    PersonalizePageView.this.kib.cRf();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kiu = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
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
                                PersonalizePageView.this.cOM();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRc();
            }
        };
        this.jhV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jgU = true;
                    }
                }
            }
        };
        this.kiv = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZZ != null && !PersonalizePageView.this.jZZ.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.khX == null) {
                            PersonalizePageView.this.khX = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.khX.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.khY = PersonalizePageView.this.khX;
                            PersonalizePageView.this.cQU();
                        } else if (PersonalizePageView.this.khY != PersonalizePageView.this.khX) {
                            PersonalizePageView.this.khY = PersonalizePageView.this.khX;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.khX.setEnable(true);
                        PersonalizePageView.this.jZZ.setProgressView(PersonalizePageView.this.khX);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jZZ.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.khW == null) {
                        PersonalizePageView.this.khW = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.khY = PersonalizePageView.this.khW;
                        PersonalizePageView.this.cQU();
                    } else if (PersonalizePageView.this.khY != PersonalizePageView.this.khW || !aVar.equals(PersonalizePageView.this.khW.cRA())) {
                        PersonalizePageView.this.khY = PersonalizePageView.this.khW;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.khW.setEnable(true);
                    PersonalizePageView.this.jZZ.setProgressView(PersonalizePageView.this.khW);
                    PersonalizePageView.this.khW.a(aVar);
                    PersonalizePageView.this.jZZ.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kiw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kin != null) {
                    PersonalizePageView.this.kin.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kif = 0L;
        this.mSkinType = 3;
        this.jgU = false;
        this.kig = 0;
        this.kih = false;
        this.kii = -1L;
        this.kij = false;
        this.kik = false;
        this.kil = 0;
        this.jhe = 0;
        this.kim = false;
        this.fHo = 1;
        this.iRh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iRf == null) {
                            PersonalizePageView.this.iRf = new l(new j());
                        }
                        PersonalizePageView.this.iRf.a(PersonalizePageView.this.jZR, 2);
                    } else if (PersonalizePageView.this.iRf != null) {
                        PersonalizePageView.this.iRf.qJ();
                    }
                }
            }
        };
        this.kio = new ab.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.homepage.personalize.adapter.ab.a
            public void Mk() {
                if (PersonalizePageView.this.jZR != null && PersonalizePageView.this.kfV != null) {
                    if (TbSingleton.getInstance().isAddBanner) {
                        PersonalizePageView.this.jZR.removeHeaderView(PersonalizePageView.this.kfV.getView());
                    } else if (PersonalizePageView.this.kfV.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
                        PersonalizePageView.this.kfV.ks();
                        PersonalizePageView.this.kfV.getView().setVisibility(0);
                        PersonalizePageView.this.kfV.IO("1");
                        PersonalizePageView.this.jZR.setHeaderView(PersonalizePageView.this.kfV.getView());
                    }
                }
            }
        };
        this.kip = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.kib != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.brd().bre(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kfk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
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
                    if (PersonalizePageView.this.khZ != null) {
                        PersonalizePageView.this.khZ.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jYP = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
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
        this.gCJ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gCJ != i2 && PersonalizePageView.this.jZX != null) {
                    PersonalizePageView.this.gCJ = i2;
                    if (PersonalizePageView.this.gCJ == 1) {
                        PersonalizePageView.this.jZX.bRJ();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jZX.bRK();
                    } else {
                        PersonalizePageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.jZY = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.24
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPS() {
                if (PersonalizePageView.this.jZX != null) {
                    PersonalizePageView.this.gCJ = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jZR)) {
                        PersonalizePageView.this.jZX.bRK();
                    } else {
                        PersonalizePageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.kiq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jZR != null) {
                    PersonalizePageView.this.jZR.removeHeaderView(PersonalizePageView.this.kfV.getView());
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZR != null && PersonalizePageView.this.kfV != null && PersonalizePageView.this.kfV.getView().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    PersonalizePageView.this.kfV.ks();
                    PersonalizePageView.this.kfV.getView().setVisibility(0);
                    PersonalizePageView.this.kfV.IO("1");
                    PersonalizePageView.this.jZR.setHeaderView(PersonalizePageView.this.kfV.getView());
                }
            }
        };
        this.kir = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            private boolean iYY = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_first_install", true);

            private void cQZ() {
                if (this.iYY) {
                    this.iYY = false;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i2, com.baidu.tbadk.util.c cVar, int i22) {
                if (PersonalizePageView.this.kia == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqM = PersonalizePageView.this.cqM();
                PersonalizePageView.this.WZ();
                if (cqM) {
                    PersonalizePageView.this.ir(true);
                }
                PersonalizePageView.this.kia.a(i2, cVar, i22);
                q.bhU().bhV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void b(int i2, int i22, com.baidu.tbadk.util.c cVar, int i3) {
                if (PersonalizePageView.this.kia != null) {
                    PersonalizePageView.this.kia.a(i2, i22, cVar, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cQZ();
                } else if (!this.iYY) {
                    PersonalizePageView.this.jZZ.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cQZ();
                    PersonalizePageView.this.cPC();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void si(boolean z) {
                cQZ();
                PersonalizePageView.this.jZZ.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.WZ();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dOC().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.kih = true;
                    PersonalizePageView.this.kii = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cRa() {
                if (PersonalizePageView.this.gAi != null) {
                    PersonalizePageView.this.gAi.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gAi.endLoadData();
                    PersonalizePageView.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kis = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKP().Ex("page_recommend");
                PersonalizePageView.this.kib.update();
                PersonalizePageView.this.kib.se(false);
                PersonalizePageView.this.kim = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kfM = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.kib != null && PersonalizePageView.this.kib.cDy() != null) {
                    PersonalizePageView.this.kib.cDy().cQu();
                }
            }
        };
        this.kit = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tbadk.core.view.f.a
            public void buy() {
                if (PersonalizePageView.this.kim) {
                    PersonalizePageView.this.jhe = 0;
                    PersonalizePageView.this.fHo = 1;
                    PersonalizePageView.this.kim = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kfN = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.kib != null) {
                    PersonalizePageView.this.kib.se(true);
                    PersonalizePageView.this.kib.cRf();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kiu = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
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
                                PersonalizePageView.this.cOM();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.kab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRc();
            }
        };
        this.jhV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jgU = true;
                    }
                }
            }
        };
        this.kiv = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZZ != null && !PersonalizePageView.this.jZZ.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.khX == null) {
                            PersonalizePageView.this.khX = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.khX.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.khY = PersonalizePageView.this.khX;
                            PersonalizePageView.this.cQU();
                        } else if (PersonalizePageView.this.khY != PersonalizePageView.this.khX) {
                            PersonalizePageView.this.khY = PersonalizePageView.this.khX;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.khX.setEnable(true);
                        PersonalizePageView.this.jZZ.setProgressView(PersonalizePageView.this.khX);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jZZ.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.khW == null) {
                        PersonalizePageView.this.khW = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.khY = PersonalizePageView.this.khW;
                        PersonalizePageView.this.cQU();
                    } else if (PersonalizePageView.this.khY != PersonalizePageView.this.khW || !aVar.equals(PersonalizePageView.this.khW.cRA())) {
                        PersonalizePageView.this.khY = PersonalizePageView.this.khW;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.khW.setEnable(true);
                    PersonalizePageView.this.jZZ.setProgressView(PersonalizePageView.this.khW);
                    PersonalizePageView.this.khW.a(aVar);
                    PersonalizePageView.this.jZZ.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kiw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kin != null) {
                    PersonalizePageView.this.kin.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jZR = new BdTypeRecyclerView(context);
        this.eqM = new LinearLayoutManager(this.jZR.getContext());
        this.jZR.setLayoutManager(this.eqM);
        this.jZR.setFadingEdgeLength(0);
        this.jZR.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jZR.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kfV = new p(context);
        this.kfV.setFrom("from_personaize");
        this.kfV.cso().setVisibility(0);
        this.kfV.cso().setOnClickListener(this.kiq);
        MessageManager.getInstance().registerListener(this.eJz);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iRf = new l(new j());
            this.iRf.a(this.jZR, 2);
        }
        MessageManager.getInstance().registerListener(this.iRh);
        MessageManager.getInstance().registerListener(this.kip);
        this.jZZ = new BigdaySwipeRefreshLayout(context);
        this.jZZ.addView(this.jZR);
        this.gAi = new PbListView(context);
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setLineGone();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gAi.setOnClickListener(this.kab);
        this.gAi.bud();
        this.jZR.setNextPage(this.gAi);
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        MessageManager.getInstance().registerListener(this.kiv);
        com.baidu.tbadk.core.bigday.b.blb().jp(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.blb().mR(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.jZZ);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.kin = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.kin, layoutParams);
            this.kin.setOnClickListener(this.kiw);
            this.kin.setVisibility(8);
        }
        this.kie = new com.baidu.tieba.homepage.personalize.model.e();
        this.khZ = new ab(context, this.jZR);
        this.khZ.b(this.kie);
        this.khZ.a(this.kio);
        this.kib = new e(this.pageContext, this.jZR, this.khZ, this.jZZ);
        this.kic = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.jhV);
        this.kil = com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cQU() {
        if (this.khY != null) {
            this.khY.setListPullRefreshListener(this.kis);
            this.khY.a(this.kfM);
            this.khY.a(this.kit);
            this.khY.a(this.kfN);
        }
    }

    public void bZe() {
        this.khZ.b(this.kfk);
        this.khZ.a(this.jYP);
        this.kib.a(this.kir);
        this.kic.a(this);
        cQU();
        this.jZR.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.jhe += i2;
                if (PersonalizePageView.this.kin != null) {
                    n item = PersonalizePageView.this.jZR.getItem(PersonalizePageView.this.eqM.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.kin.show();
                        } else {
                            PersonalizePageView.this.kin.hide();
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eqM != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.jhe < height * 3 || PersonalizePageView.this.fHo != 1) {
                        if (PersonalizePageView.this.jhe < height * 3 && PersonalizePageView.this.fHo == 2) {
                            PersonalizePageView.this.fHo = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fHo = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fHo)));
                    }
                    if (PersonalizePageView.this.eqM.getItemCount() - PersonalizePageView.this.eqM.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bRc();
                    }
                }
            }
        });
        this.jZR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bRc();
            }
        });
        this.jZR.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.kif >= 5000) {
                    PersonalizePageView.this.kib.cD(i, i2);
                }
            }
        }, 1L);
        this.jZR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.kib != null && PersonalizePageView.this.kib.cDy() != null) {
                        PersonalizePageView.this.kib.cDy().dt(view);
                    }
                    if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                        ((HomePageCardVideoViewHolder) view.getTag()).ctb().stopPlay();
                    }
                }
            }
        });
        this.jZR.removeOnScrollListener(this.mOnScrollListener);
        this.jZR.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.kia = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gAi != null) {
            this.gAi.setText(getContext().getString(R.string.pb_load_more));
            this.gAi.endLoadData();
            this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kib.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.kib != null) {
            this.kib.sj(!z);
        }
        this.kik = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.kik;
    }

    public void h(Long l) {
        this.kib.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.kib != null) {
            this.kib.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.kib != null) {
            this.kib.showFloatingView();
        }
    }

    public void cQV() {
        if (this.kib != null) {
            this.kib.cQV();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.khX != null) {
                this.khX.changeSkin(i);
            }
            if (this.gAi != null) {
                this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gAi.changeSkin(i);
            }
            this.khZ.onChangeSkinType(i);
            if (this.kib != null) {
                this.kib.onChangeSkinType(i);
            }
            if (this.kin != null) {
                this.kin.onChangeSkinType(i);
            }
            if (this.kfV != null) {
                this.kfV.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void bd(String str, int i) {
        if (this.gAi != null) {
            this.gAi.setText(getContext().getString(R.string.pb_load_more));
            this.gAi.endLoadData();
            this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kib.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.kib != null) {
                        PersonalizePageView.this.kib.update();
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
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
            this.jZR.setNextPage(this.gAi);
            this.gAi.setText(getContext().getString(R.string.pb_load_more));
            this.gAi.endLoadData();
            this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jZZ != null) {
            this.jZZ.setVisibility(0);
        }
        if (this.kia != null) {
            this.kia.cPo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(boolean z) {
        if (this.gJn == null) {
            this.gJn = new com.baidu.tbadk.l.g(getContext());
            this.gJn.bt(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gJn.bCS();
            this.gJn.setWrapStyle(true);
            this.gJn.onChangeSkinType();
        }
        this.gJn.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jZR.setNextPage(null);
        if (this.jZZ != null) {
            this.jZZ.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.kib != null) {
            this.kib.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.kib != null) {
            this.kib.qJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.kil < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.kiu, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.kib != null) {
            this.kib.rV(z);
        }
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
            this.jZY.cPS();
        }
    }

    public void cPC() {
        if (this.kib != null) {
            ir(true);
            this.kib.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.blb().bld();
            com.baidu.tbadk.core.bigday.b.blb().blc();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.kib != null) {
            this.kib.update();
        } else if (this.jZR != null && this.jZZ != null) {
            showFloatingView();
            this.jZR.setSelection(0);
            if (!this.jZZ.isRefreshing()) {
                if (this.kib != null && this.kib.cDy() != null) {
                    this.kib.cDy().cQu();
                    this.kib.se(false);
                }
                this.jZZ.setRefreshing(true);
            }
            if (this.jZY != null) {
                this.jZY.cPS();
            }
        }
    }

    public void cQW() {
        if (this.refreshView != null) {
            reload();
        } else if (this.kib != null) {
            this.kib.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iRh);
        MessageManager.getInstance().unRegisterListener(this.jhV);
        MessageManager.getInstance().unRegisterListener(this.kiv);
        this.kib.onDestroy();
        this.khZ.b((NEGFeedBackView.a) null);
        this.khZ.onDestroy();
        this.kib.a((e.a) null);
        if (this.khW != null) {
            this.khW.setListPullRefreshListener(null);
            this.khW.a((f.d) null);
            this.khW.a((f.a) null);
            this.khW.a((f.b) null);
            this.khW.release();
        }
        if (this.khX != null) {
            this.khX.setListPullRefreshListener(null);
            this.khX.a((f.d) null);
            this.khX.a((f.a) null);
            this.khX.a((f.b) null);
            this.khX.release();
        }
        this.jZR.setOnSrollToBottomListener(null);
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
        }
        this.jZR.removeOnScrollListener(this.mOnScrollListener);
        if (this.gJn != null) {
            this.gJn.release();
        }
        this.jZR.setRecyclerListener(null);
        if (this.kic != null) {
            this.kic.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.blb().destroy();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kiu);
    }

    public void onPause() {
        this.kib.onPause();
        if (this.khZ != null) {
            this.khZ.onPause();
        }
    }

    public void onResume() {
        if (this.jgU) {
            reload();
            this.jgU = false;
        }
        if (this.jZZ != null) {
            this.jZZ.resume();
        }
        if (this.khZ != null) {
            this.khZ.onResume();
        }
    }

    public void cOM() {
        if (this.khZ != null) {
            this.khZ.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kih) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cQX();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQX() {
        if (!this.kij) {
            long BA = com.baidu.tieba.homepage.framework.a.cPn().BA(1) + com.baidu.tieba.homepage.framework.a.cPn().getCreateTime();
            long By = com.baidu.tieba.homepage.framework.a.cPn().By(1);
            if (By > 0) {
                BA = System.currentTimeMillis() - By;
            }
            com.baidu.tbadk.n.n nVar = new com.baidu.tbadk.n.n();
            nVar.bEo();
            nVar.bEp();
            com.baidu.tbadk.n.l.bEl().eK(BA);
            if (this.kii > 0) {
                com.baidu.tbadk.n.l.bEl().eO(System.currentTimeMillis() - this.kii);
            }
            com.baidu.tbadk.n.l.bEl().eL(nVar.bEq());
        }
        this.kij = true;
    }

    public void cON() {
        if (this.kib != null) {
            this.kib.qJ(true);
        }
        t.csu().mG(false);
        com.baidu.tieba.a.d.bKP().dK("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kiu);
    }

    public void cQQ() {
        this.kib.cRm();
    }

    public void cQY() {
        this.kib.cQY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRc() {
        com.baidu.tieba.homepage.framework.a.cPn().E(System.currentTimeMillis(), 1);
        if (this.gAi != null && !this.gAi.isLoading()) {
            this.gAi.startLoadData();
            this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.kib.bRc();
    }
}
