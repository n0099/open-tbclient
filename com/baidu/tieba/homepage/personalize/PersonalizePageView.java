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
/* loaded from: classes22.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager dQI;
    private final CustomMessageListener eQI;
    private PbListView fTv;
    private int fVW;
    private int feM;
    private com.baidu.tbadk.k.g gcx;
    private n hZL;
    private CustomMessageListener hZN;
    private boolean ipK;
    private int ipU;
    private CustomMessageListener iqJ;
    private FollowUserButton.a jch;
    private BdTypeRecyclerView jdb;
    private ScrollFragmentTabHost jdh;
    ScrollFragmentTabHost.a jdi;
    private BigdaySwipeRefreshLayout jdj;
    private View.OnClickListener jdl;
    f.d jiH;
    f.b jiI;
    private NEGFeedBackView.a jif;
    private boolean jkA;
    private int jkB;
    private boolean jkC;
    private FRSRefreshButton jkD;
    private CustomMessageListener jkE;
    private e.a jkF;
    f.c jkG;
    f.a jkH;
    private Runnable jkI;
    public CustomMessageListener jkJ;
    private View.OnClickListener jkK;
    private com.baidu.tieba.homepage.personalize.bigday.b jko;
    private com.baidu.tieba.homepage.personalize.bigday.a jkp;
    private a jkq;
    private af jkr;
    private com.baidu.tieba.homepage.framework.b jks;
    private e jkt;
    private com.baidu.tieba.homepage.personalize.a jku;
    private com.baidu.tieba.homepage.personalize.model.e jkv;
    private long jkw;
    private int jkx;
    private boolean jky;
    private boolean jkz;
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
        int i = personalizePageView.jkB + 1;
        personalizePageView.jkB = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jdh = scrollFragmentTabHost;
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
            this.jdh.a(this.jdi);
        }
        if (this.jkt != null) {
            this.jkt.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jku != null) {
            this.jku.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jdj != null) {
            this.jdj.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jkr != null) {
            this.jkr.setPageUniqueId(bdUniqueId);
        }
        if (this.jkt != null) {
            this.jkt.o(bdUniqueId);
        }
        if (this.jkv != null) {
            this.jkv.i(bdUniqueId);
        }
        if (this.jkp != null) {
            this.jkp.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bfw().setTag(bdUniqueId);
        if (this.eQI != null) {
            this.eQI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eQI);
        }
        if (this.jku != null) {
            this.jku.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.jkw = 0L;
        this.mSkinType = 3;
        this.ipK = false;
        this.jkx = 0;
        this.jky = true;
        this.jkz = false;
        this.jkA = false;
        this.jkB = 0;
        this.ipU = 0;
        this.jkC = false;
        this.feM = 1;
        this.hZN = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hZL == null) {
                            PersonalizePageView.this.hZL = new n(new l());
                        }
                        PersonalizePageView.this.hZL.a(PersonalizePageView.this.jdb, 2);
                    } else if (PersonalizePageView.this.hZL != null) {
                        PersonalizePageView.this.hZL.rh();
                    }
                }
            }
        };
        this.jkE = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jkt != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.blb().blc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jif = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dK("obj_locate", "1").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jkr != null) {
                        PersonalizePageView.this.jkr.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dK("tid", arVar.getTid()).dK("nid", arVar.getNid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", arVar.getFid()).dK("obj_param1", arVar.weight).dK("obj_source", arVar.source).dK("obj_id", arVar.extra).dK("obj_type", sb.toString()).dK("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jch = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fVW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fVW != i && PersonalizePageView.this.jdh != null) {
                    PersonalizePageView.this.fVW = i;
                    if (PersonalizePageView.this.fVW == 1) {
                        PersonalizePageView.this.jdh.bKo();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jdh.bKp();
                    } else {
                        PersonalizePageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdi = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cEd() {
                if (PersonalizePageView.this.jdh != null) {
                    PersonalizePageView.this.fVW = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jdb)) {
                        PersonalizePageView.this.jdh.bKp();
                    } else {
                        PersonalizePageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jkF = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean ihJ = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_first_install", true);

            private void cFh() {
                if (this.ihJ) {
                    this.ihJ = false;
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.jks == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean chb = PersonalizePageView.this.chb();
                PersonalizePageView.this.SK();
                if (chb) {
                    PersonalizePageView.this.hn(true);
                }
                PersonalizePageView.this.jks.P(i, i2, i3);
                q.bct().bcu();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jks != null) {
                    PersonalizePageView.this.jks.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cFh();
                } else if (!this.ihJ) {
                    PersonalizePageView.this.jdj.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cFh();
                    PersonalizePageView.this.cDN();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cFh();
                PersonalizePageView.this.jdj.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.SK();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dFk().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cFi() {
                if (PersonalizePageView.this.fTv != null) {
                    PersonalizePageView.this.fTv.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fTv.endLoadData();
                    PersonalizePageView.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jkG = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bEz().Er("page_recommend");
                PersonalizePageView.this.jkt.update();
                PersonalizePageView.this.jkt.qu(false);
                PersonalizePageView.this.jkC = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jiH = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jkt != null && PersonalizePageView.this.jkt.ctG() != null) {
                    PersonalizePageView.this.jkt.ctG().cEF();
                }
            }
        };
        this.jkH = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bot() {
                if (PersonalizePageView.this.jkC) {
                    PersonalizePageView.this.ipU = 0;
                    PersonalizePageView.this.feM = 1;
                    PersonalizePageView.this.jkC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jiI = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jkt != null) {
                    PersonalizePageView.this.jkt.qu(true);
                    PersonalizePageView.this.jkt.cFn();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bfw().nv(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.jkI = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eQI = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cCX();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jdl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bJG();
            }
        };
        this.iqJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.ipK = true;
                    }
                }
            }
        };
        this.jkJ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jdj != null && !PersonalizePageView.this.jdj.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jkp == null) {
                            PersonalizePageView.this.jkp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jkp.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jkq = PersonalizePageView.this.jkp;
                            PersonalizePageView.this.cFd();
                        } else if (PersonalizePageView.this.jkq != PersonalizePageView.this.jkp) {
                            PersonalizePageView.this.jkq = PersonalizePageView.this.jkp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jkp.setEnable(true);
                        PersonalizePageView.this.jdj.setProgressView(PersonalizePageView.this.jkp);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jdj.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jko == null) {
                        PersonalizePageView.this.jko = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jkq = PersonalizePageView.this.jko;
                        PersonalizePageView.this.cFd();
                    } else if (PersonalizePageView.this.jkq != PersonalizePageView.this.jko || !aVar.equals(PersonalizePageView.this.jko.cFJ())) {
                        PersonalizePageView.this.jkq = PersonalizePageView.this.jko;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jko.setEnable(true);
                    PersonalizePageView.this.jdj.setProgressView(PersonalizePageView.this.jko);
                    PersonalizePageView.this.jko.a(aVar);
                    PersonalizePageView.this.jdj.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jkK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jkD != null) {
                    PersonalizePageView.this.jkD.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jkw = 0L;
        this.mSkinType = 3;
        this.ipK = false;
        this.jkx = 0;
        this.jky = true;
        this.jkz = false;
        this.jkA = false;
        this.jkB = 0;
        this.ipU = 0;
        this.jkC = false;
        this.feM = 1;
        this.hZN = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hZL == null) {
                            PersonalizePageView.this.hZL = new n(new l());
                        }
                        PersonalizePageView.this.hZL.a(PersonalizePageView.this.jdb, 2);
                    } else if (PersonalizePageView.this.hZL != null) {
                        PersonalizePageView.this.hZL.rh();
                    }
                }
            }
        };
        this.jkE = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jkt != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.blb().blc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jif = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dK("obj_locate", "1").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jkr != null) {
                        PersonalizePageView.this.jkr.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dK("tid", arVar.getTid()).dK("nid", arVar.getNid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", arVar.getFid()).dK("obj_param1", arVar.weight).dK("obj_source", arVar.source).dK("obj_id", arVar.extra).dK("obj_type", sb.toString()).dK("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jch = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fVW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fVW != i && PersonalizePageView.this.jdh != null) {
                    PersonalizePageView.this.fVW = i;
                    if (PersonalizePageView.this.fVW == 1) {
                        PersonalizePageView.this.jdh.bKo();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jdh.bKp();
                    } else {
                        PersonalizePageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdi = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cEd() {
                if (PersonalizePageView.this.jdh != null) {
                    PersonalizePageView.this.fVW = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jdb)) {
                        PersonalizePageView.this.jdh.bKp();
                    } else {
                        PersonalizePageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jkF = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean ihJ = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_first_install", true);

            private void cFh() {
                if (this.ihJ) {
                    this.ihJ = false;
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.jks == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean chb = PersonalizePageView.this.chb();
                PersonalizePageView.this.SK();
                if (chb) {
                    PersonalizePageView.this.hn(true);
                }
                PersonalizePageView.this.jks.P(i, i2, i3);
                q.bct().bcu();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jks != null) {
                    PersonalizePageView.this.jks.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cFh();
                } else if (!this.ihJ) {
                    PersonalizePageView.this.jdj.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cFh();
                    PersonalizePageView.this.cDN();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cFh();
                PersonalizePageView.this.jdj.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.SK();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dFk().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cFi() {
                if (PersonalizePageView.this.fTv != null) {
                    PersonalizePageView.this.fTv.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fTv.endLoadData();
                    PersonalizePageView.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jkG = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bEz().Er("page_recommend");
                PersonalizePageView.this.jkt.update();
                PersonalizePageView.this.jkt.qu(false);
                PersonalizePageView.this.jkC = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jiH = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jkt != null && PersonalizePageView.this.jkt.ctG() != null) {
                    PersonalizePageView.this.jkt.ctG().cEF();
                }
            }
        };
        this.jkH = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bot() {
                if (PersonalizePageView.this.jkC) {
                    PersonalizePageView.this.ipU = 0;
                    PersonalizePageView.this.feM = 1;
                    PersonalizePageView.this.jkC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jiI = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jkt != null) {
                    PersonalizePageView.this.jkt.qu(true);
                    PersonalizePageView.this.jkt.cFn();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bfw().nv(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.jkI = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eQI = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cCX();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jdl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bJG();
            }
        };
        this.iqJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.ipK = true;
                    }
                }
            }
        };
        this.jkJ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jdj != null && !PersonalizePageView.this.jdj.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jkp == null) {
                            PersonalizePageView.this.jkp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jkp.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jkq = PersonalizePageView.this.jkp;
                            PersonalizePageView.this.cFd();
                        } else if (PersonalizePageView.this.jkq != PersonalizePageView.this.jkp) {
                            PersonalizePageView.this.jkq = PersonalizePageView.this.jkp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jkp.setEnable(true);
                        PersonalizePageView.this.jdj.setProgressView(PersonalizePageView.this.jkp);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jdj.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jko == null) {
                        PersonalizePageView.this.jko = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jkq = PersonalizePageView.this.jko;
                        PersonalizePageView.this.cFd();
                    } else if (PersonalizePageView.this.jkq != PersonalizePageView.this.jko || !aVar.equals(PersonalizePageView.this.jko.cFJ())) {
                        PersonalizePageView.this.jkq = PersonalizePageView.this.jko;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jko.setEnable(true);
                    PersonalizePageView.this.jdj.setProgressView(PersonalizePageView.this.jko);
                    PersonalizePageView.this.jko.a(aVar);
                    PersonalizePageView.this.jdj.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jkK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jkD != null) {
                    PersonalizePageView.this.jkD.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jkw = 0L;
        this.mSkinType = 3;
        this.ipK = false;
        this.jkx = 0;
        this.jky = true;
        this.jkz = false;
        this.jkA = false;
        this.jkB = 0;
        this.ipU = 0;
        this.jkC = false;
        this.feM = 1;
        this.hZN = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hZL == null) {
                            PersonalizePageView.this.hZL = new n(new l());
                        }
                        PersonalizePageView.this.hZL.a(PersonalizePageView.this.jdb, 2);
                    } else if (PersonalizePageView.this.hZL != null) {
                        PersonalizePageView.this.hZL.rh();
                    }
                }
            }
        };
        this.jkE = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jkt != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.blb().blc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jif = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dK("obj_locate", "1").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jkr != null) {
                        PersonalizePageView.this.jkr.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dK("tid", arVar.getTid()).dK("nid", arVar.getNid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", arVar.getFid()).dK("obj_param1", arVar.weight).dK("obj_source", arVar.source).dK("obj_id", arVar.extra).dK("obj_type", sb.toString()).dK("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jch = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fVW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.fVW != i2 && PersonalizePageView.this.jdh != null) {
                    PersonalizePageView.this.fVW = i2;
                    if (PersonalizePageView.this.fVW == 1) {
                        PersonalizePageView.this.jdh.bKo();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jdh.bKp();
                    } else {
                        PersonalizePageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdi = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cEd() {
                if (PersonalizePageView.this.jdh != null) {
                    PersonalizePageView.this.fVW = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jdb)) {
                        PersonalizePageView.this.jdh.bKp();
                    } else {
                        PersonalizePageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jkF = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean ihJ = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_first_install", true);

            private void cFh() {
                if (this.ihJ) {
                    this.ihJ = false;
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i2, int i22, int i3) {
                if (PersonalizePageView.this.jks == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean chb = PersonalizePageView.this.chb();
                PersonalizePageView.this.SK();
                if (chb) {
                    PersonalizePageView.this.hn(true);
                }
                PersonalizePageView.this.jks.P(i2, i22, i3);
                q.bct().bcu();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.jks != null) {
                    PersonalizePageView.this.jks.A(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cFh();
                } else if (!this.ihJ) {
                    PersonalizePageView.this.jdj.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cFh();
                    PersonalizePageView.this.cDN();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cFh();
                PersonalizePageView.this.jdj.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.SK();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dFk().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cFi() {
                if (PersonalizePageView.this.fTv != null) {
                    PersonalizePageView.this.fTv.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fTv.endLoadData();
                    PersonalizePageView.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jkG = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bEz().Er("page_recommend");
                PersonalizePageView.this.jkt.update();
                PersonalizePageView.this.jkt.qu(false);
                PersonalizePageView.this.jkC = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jiH = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jkt != null && PersonalizePageView.this.jkt.ctG() != null) {
                    PersonalizePageView.this.jkt.ctG().cEF();
                }
            }
        };
        this.jkH = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bot() {
                if (PersonalizePageView.this.jkC) {
                    PersonalizePageView.this.ipU = 0;
                    PersonalizePageView.this.feM = 1;
                    PersonalizePageView.this.jkC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jiI = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jkt != null) {
                    PersonalizePageView.this.jkt.qu(true);
                    PersonalizePageView.this.jkt.cFn();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bfw().nv(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.jkI = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eQI = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cCX();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jdl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bJG();
            }
        };
        this.iqJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.ipK = true;
                    }
                }
            }
        };
        this.jkJ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jdj != null && !PersonalizePageView.this.jdj.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jkp == null) {
                            PersonalizePageView.this.jkp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jkp.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jkq = PersonalizePageView.this.jkp;
                            PersonalizePageView.this.cFd();
                        } else if (PersonalizePageView.this.jkq != PersonalizePageView.this.jkp) {
                            PersonalizePageView.this.jkq = PersonalizePageView.this.jkp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jkp.setEnable(true);
                        PersonalizePageView.this.jdj.setProgressView(PersonalizePageView.this.jkp);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jdj.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jko == null) {
                        PersonalizePageView.this.jko = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jkq = PersonalizePageView.this.jko;
                        PersonalizePageView.this.cFd();
                    } else if (PersonalizePageView.this.jkq != PersonalizePageView.this.jko || !aVar.equals(PersonalizePageView.this.jko.cFJ())) {
                        PersonalizePageView.this.jkq = PersonalizePageView.this.jko;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jko.setEnable(true);
                    PersonalizePageView.this.jdj.setProgressView(PersonalizePageView.this.jko);
                    PersonalizePageView.this.jko.a(aVar);
                    PersonalizePageView.this.jdj.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jkK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jkD != null) {
                    PersonalizePageView.this.jkD.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jdb = new BdTypeRecyclerView(context);
        this.dQI = new LinearLayoutManager(this.jdb.getContext());
        this.jdb.setLayoutManager(this.dQI);
        this.jdb.setFadingEdgeLength(0);
        this.jdb.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hZL = new n(new l());
            this.hZL.a(this.jdb, 2);
        }
        MessageManager.getInstance().registerListener(this.hZN);
        MessageManager.getInstance().registerListener(this.jkE);
        this.jdj = new BigdaySwipeRefreshLayout(context);
        this.jdj.addView(this.jdb);
        this.fTv = new PbListView(context);
        this.fTv.getView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setLineGone();
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.fTv.setOnClickListener(this.jdl);
        this.fTv.boa();
        this.jdb.setNextPage(this.fTv);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        MessageManager.getInstance().registerListener(this.jkJ);
        com.baidu.tbadk.core.bigday.b.bfw().ik(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bfw().nv(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.jdj);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.jkD = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.jkD, layoutParams);
            this.jkD.setOnClickListener(this.jkK);
            this.jkD.setVisibility(8);
        }
        this.jkv = new com.baidu.tieba.homepage.personalize.model.e();
        this.jkr = new af(context, this.jdb);
        this.jkr.b(this.jkv);
        this.jkt = new e(this.pageContext, this.jdb, this.jkr, this.jdj);
        this.jku = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.iqJ);
        this.jkB = com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cFd() {
        if (this.jkq != null) {
            this.jkq.setListPullRefreshListener(this.jkG);
            this.jkq.a(this.jiH);
            this.jkq.a(this.jkH);
            this.jkq.a(this.jiI);
        }
    }

    public void bQI() {
        this.jkr.b(this.jif);
        this.jkr.a(this.jch);
        this.jkt.a(this.jkF);
        this.jku.a(this);
        cFd();
        this.jdb.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.ipU += i2;
                if (PersonalizePageView.this.jkD != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.jdb.getItem(PersonalizePageView.this.dQI.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.l) {
                        if (((com.baidu.tieba.card.data.l) item).position >= 6) {
                            PersonalizePageView.this.jkD.show();
                        } else {
                            PersonalizePageView.this.jkD.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dQI != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.ipU < height * 3 || PersonalizePageView.this.feM != 1) {
                        if (PersonalizePageView.this.ipU < height * 3 && PersonalizePageView.this.feM == 2) {
                            PersonalizePageView.this.feM = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.feM = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.feM)));
                    }
                    if (PersonalizePageView.this.dQI.getItemCount() - PersonalizePageView.this.dQI.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bJG();
                    }
                }
            }
        });
        this.jdb.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bJG();
            }
        });
        this.jdb.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.jkw >= 5000) {
                    PersonalizePageView.this.jkt.cA(i, i2);
                }
            }
        }, 1L);
        this.jdb.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.jkt != null && PersonalizePageView.this.jkt.ctG() != null) {
                        PersonalizePageView.this.jkt.ctG().cR(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).cjq().stopPlay();
                    }
                }
            }
        });
        this.jdb.removeOnScrollListener(this.mOnScrollListener);
        this.jdb.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jks = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fTv != null) {
            this.fTv.setText(getContext().getString(R.string.pb_load_more));
            this.fTv.endLoadData();
            this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jkt.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.jkt != null) {
            this.jkt.qy(!z);
        }
        this.jkA = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.jkA;
    }

    public void f(Long l) {
        this.jkt.f(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jkt != null) {
            this.jkt.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void showFloatingView() {
        if (this.jkt != null) {
            this.jkt.showFloatingView();
        }
    }

    public void cFe() {
        if (this.jkt != null) {
            this.jkt.cFe();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jkp != null) {
                this.jkp.changeSkin(i);
            }
            if (this.fTv != null) {
                this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fTv.changeSkin(i);
            }
            this.jkr.onChangeSkinType(i);
            if (this.jkt != null) {
                this.jkt.onChangeSkinType(i);
            }
            if (this.jkD != null) {
                this.jkD.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aR(String str, int i) {
        if (this.fTv != null) {
            this.fTv.setText(getContext().getString(R.string.pb_load_more));
            this.fTv.endLoadData();
            this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jkt.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.jkt != null) {
                        PersonalizePageView.this.jkt.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
            this.jdb.setNextPage(this.fTv);
            this.fTv.setText(getContext().getString(R.string.pb_load_more));
            this.fTv.endLoadData();
            this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jdj != null) {
            this.jdj.setVisibility(0);
        }
        if (this.jks != null) {
            this.jks.cDA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chb() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(boolean z) {
        if (this.gcx == null) {
            this.gcx = new com.baidu.tbadk.k.g(getContext());
            this.gcx.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gcx.bwO();
            this.gcx.setWrapStyle(true);
            this.gcx.onChangeSkinType();
        }
        this.gcx.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jdb.setNextPage(null);
        if (this.jdj != null) {
            this.jdj.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jkt != null) {
            this.jkt.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jkt != null) {
            this.jkt.pe(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.jkB < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jkI, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jkt != null) {
            this.jkt.ql(z);
        }
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
            this.jdh.a(this.jdi);
            this.jdi.cEd();
        }
    }

    public void cDN() {
        if (this.jkt != null) {
            hn(true);
            this.jkt.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bfw().bfy();
            com.baidu.tbadk.core.bigday.b.bfw().bfx();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.jkt != null) {
            this.jkt.update();
        } else if (this.jdb != null && this.jdj != null) {
            showFloatingView();
            this.jdb.setSelection(0);
            if (!this.jdj.isRefreshing()) {
                if (this.jkt != null && this.jkt.ctG() != null) {
                    this.jkt.ctG().cEF();
                    this.jkt.qu(false);
                }
                this.jdj.setRefreshing(true);
            }
            if (this.jdi != null) {
                this.jdi.cEd();
            }
        }
    }

    public void cFf() {
        if (this.refreshView != null) {
            reload();
        } else if (this.jkt != null) {
            this.jkt.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hZN);
        MessageManager.getInstance().unRegisterListener(this.iqJ);
        MessageManager.getInstance().unRegisterListener(this.jkJ);
        this.jkt.onDestroy();
        this.jkr.b((NEGFeedBackView.a) null);
        this.jkr.onDestroy();
        this.jkt.a((e.a) null);
        if (this.jko != null) {
            this.jko.setListPullRefreshListener(null);
            this.jko.a((f.d) null);
            this.jko.a((f.a) null);
            this.jko.a((f.b) null);
            this.jko.release();
        }
        if (this.jkp != null) {
            this.jkp.setListPullRefreshListener(null);
            this.jkp.a((f.d) null);
            this.jkp.a((f.a) null);
            this.jkp.a((f.b) null);
            this.jkp.release();
        }
        this.jdb.setOnSrollToBottomListener(null);
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
        }
        this.jdb.removeOnScrollListener(this.mOnScrollListener);
        if (this.gcx != null) {
            this.gcx.release();
        }
        this.jdb.setRecyclerListener(null);
        if (this.jku != null) {
            this.jku.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bfw().destroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkI);
    }

    public void onPause() {
        this.jkt.onPause();
        if (this.jkr != null) {
            this.jkr.onPause();
        }
    }

    public void onResume() {
        if (this.ipK) {
            reload();
            this.ipK = false;
        }
        if (this.jdj != null) {
            this.jdj.resume();
        }
        if (this.jkr != null) {
            this.jkr.onResume();
        }
    }

    public void cCX() {
        if (this.jkr != null) {
            this.jkr.notifyDataSetChanged();
        }
    }

    public void cCY() {
        if (this.jkt != null) {
            this.jkt.pe(true);
        }
        s.ciJ().lm(false);
        com.baidu.tieba.a.d.bEz().dF("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkI);
    }

    public void cEZ() {
        this.jkt.cFu();
    }

    public void cFg() {
        this.jkt.cFg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        com.baidu.tieba.homepage.framework.a.cDz().y(System.currentTimeMillis(), 1);
        if (this.fTv != null && !this.fTv.isLoading()) {
            this.fTv.startLoadData();
            this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jkt.bJG();
    }
}
