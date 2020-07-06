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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
import com.baidu.tieba.card.data.k;
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
/* loaded from: classes9.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager dmG;
    private final CustomMessageListener elO;
    private int eyQ;
    private PbListView fnt;
    private int fpM;
    private g fwo;
    private int hAH;
    private boolean hAx;
    private CustomMessageListener hBr;
    private n hlg;
    private CustomMessageListener hli;
    private BdTypeRecyclerView ilZ;
    private FollowUserButton.a ilu;
    private ScrollFragmentTabHost imf;
    ScrollFragmentTabHost.a imh;
    private BigdaySwipeRefreshLayout imi;
    private View.OnClickListener imk;
    f.d iqC;
    f.b iqD;
    private NEGFeedBackView.a iqa;
    private com.baidu.tieba.homepage.personalize.bigday.b irK;
    private com.baidu.tieba.homepage.personalize.bigday.a irL;
    private a irM;
    private af irN;
    private com.baidu.tieba.homepage.framework.b irO;
    private e irP;
    private com.baidu.tieba.homepage.personalize.a irQ;
    private com.baidu.tieba.homepage.personalize.model.e irR;
    private long irS;
    private int irT;
    private boolean irU;
    private boolean irV;
    private boolean irW;
    private int irX;
    private boolean irY;
    private FRSRefreshButton irZ;
    private CustomMessageListener isa;
    private e.a isb;
    f.c isc;
    f.a isd;
    private Runnable ise;
    public CustomMessageListener isf;
    private View.OnClickListener isg;
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

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.irX + 1;
        personalizePageView.irX = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.imf = scrollFragmentTabHost;
        if (this.imf != null) {
            this.imf.b(this.imh);
            this.imf.a(this.imh);
        }
        if (this.irP != null) {
            this.irP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.irQ != null) {
            this.irQ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.imi != null) {
            this.imi.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.irN != null) {
            this.irN.setPageUniqueId(bdUniqueId);
        }
        if (this.irP != null) {
            this.irP.o(bdUniqueId);
        }
        if (this.irR != null) {
            this.irR.i(bdUniqueId);
        }
        if (this.irL != null) {
            this.irL.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aPI().setTag(bdUniqueId);
        if (this.elO != null) {
            this.elO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.elO);
        }
        if (this.irQ != null) {
            this.irQ.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.irS = 0L;
        this.mSkinType = 3;
        this.hAx = false;
        this.irT = 0;
        this.irU = true;
        this.irV = false;
        this.irW = false;
        this.irX = 0;
        this.hAH = 0;
        this.irY = false;
        this.eyQ = 1;
        this.hli = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hlg == null) {
                            PersonalizePageView.this.hlg = new n(new l());
                        }
                        PersonalizePageView.this.hlg.a(PersonalizePageView.this.ilZ, 2);
                    } else if (PersonalizePageView.this.hlg != null) {
                        PersonalizePageView.this.hlg.pC();
                    }
                }
            }
        };
        this.isa = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.irP != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aVd().aVe(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iqa = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ap apVar) {
                if (apVar != null) {
                    TiebaStatic.log(new ao("c11693").dk("obj_locate", "1").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("nid", apVar.getNid()));
                    TiebaStatic.log(new ao("c11989").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ap apVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
                int i = 0;
                if (arrayList != null && apVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (apVar.threadType == 0) {
                        i = 1;
                    } else if (apVar.threadType == 40) {
                        i = 2;
                    } else if (apVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.irN != null) {
                        PersonalizePageView.this.irN.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ao("c11693").dk("tid", apVar.getTid()).dk("nid", apVar.getNid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fid", apVar.getFid()).dk("obj_param1", apVar.weight).dk("obj_source", apVar.source).dk("obj_id", apVar.extra).dk("obj_type", sb.toString()).dk("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.ilu = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bu) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bu) tag));
                    }
                }
            }
        };
        this.fpM = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fpM != i && PersonalizePageView.this.imf != null) {
                    PersonalizePageView.this.fpM = i;
                    if (PersonalizePageView.this.fpM == 1) {
                        PersonalizePageView.this.imf.bud();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.imf.bue();
                    } else {
                        PersonalizePageView.this.imf.bud();
                    }
                }
            }
        };
        this.imh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ciD() {
                if (PersonalizePageView.this.imf != null) {
                    PersonalizePageView.this.fpM = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.ilZ)) {
                        PersonalizePageView.this.imf.bue();
                    } else {
                        PersonalizePageView.this.imf.bud();
                    }
                }
            }
        };
        this.isb = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hsC = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_first_install", true);

            private void cjz() {
                if (this.hsC) {
                    this.hsC = false;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.irO == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bSS = PersonalizePageView.this.bSS();
                PersonalizePageView.this.btO();
                if (bSS) {
                    PersonalizePageView.this.ga(true);
                }
                PersonalizePageView.this.irO.P(i, i2, i3);
                q.aMU().aMV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.irO != null) {
                    PersonalizePageView.this.irO.z(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cjz();
                } else if (!this.hsC) {
                    PersonalizePageView.this.imi.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cjz();
                    PersonalizePageView.this.cir();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cjz();
                PersonalizePageView.this.imi.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.btO();
                if (ac.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.diW().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cjA() {
                if (PersonalizePageView.this.fnt != null) {
                    PersonalizePageView.this.fnt.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fnt.endLoadData();
                    PersonalizePageView.this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.isc = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.boB().Ad("page_recommend");
                PersonalizePageView.this.irP.update();
                PersonalizePageView.this.irP.ou(false);
                PersonalizePageView.this.irY = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iqC = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.irP != null && PersonalizePageView.this.irP.bZb() != null) {
                    PersonalizePageView.this.irP.bZb().cjf();
                }
            }
        };
        this.isd = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aYs() {
                if (PersonalizePageView.this.irY) {
                    PersonalizePageView.this.hAH = 0;
                    PersonalizePageView.this.eyQ = 1;
                    PersonalizePageView.this.irY = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iqD = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.irP != null) {
                    PersonalizePageView.this.irP.ou(true);
                    PersonalizePageView.this.irP.cjF();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aPI().kn(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.ise = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.elO = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.chX();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.imk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.btv();
            }
        };
        this.hBr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hAx = true;
                    }
                }
            }
        };
        this.isf = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.imi != null && !PersonalizePageView.this.imi.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.irL == null) {
                            PersonalizePageView.this.irL = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.irL.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.irM = PersonalizePageView.this.irL;
                            PersonalizePageView.this.cjw();
                        } else if (PersonalizePageView.this.irM != PersonalizePageView.this.irL) {
                            PersonalizePageView.this.irM = PersonalizePageView.this.irL;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.irL.setEnable(true);
                        PersonalizePageView.this.imi.setProgressView(PersonalizePageView.this.irL);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.imi.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.irK == null) {
                        PersonalizePageView.this.irK = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.irM = PersonalizePageView.this.irK;
                        PersonalizePageView.this.cjw();
                    } else if (PersonalizePageView.this.irM != PersonalizePageView.this.irK || !aVar.equals(PersonalizePageView.this.irK.cjY())) {
                        PersonalizePageView.this.irM = PersonalizePageView.this.irK;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.irK.setEnable(true);
                    PersonalizePageView.this.imi.setProgressView(PersonalizePageView.this.irK);
                    PersonalizePageView.this.irK.a(aVar);
                    PersonalizePageView.this.imi.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.isg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.irZ != null) {
                    PersonalizePageView.this.irZ.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.irS = 0L;
        this.mSkinType = 3;
        this.hAx = false;
        this.irT = 0;
        this.irU = true;
        this.irV = false;
        this.irW = false;
        this.irX = 0;
        this.hAH = 0;
        this.irY = false;
        this.eyQ = 1;
        this.hli = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hlg == null) {
                            PersonalizePageView.this.hlg = new n(new l());
                        }
                        PersonalizePageView.this.hlg.a(PersonalizePageView.this.ilZ, 2);
                    } else if (PersonalizePageView.this.hlg != null) {
                        PersonalizePageView.this.hlg.pC();
                    }
                }
            }
        };
        this.isa = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.irP != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aVd().aVe(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iqa = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ap apVar) {
                if (apVar != null) {
                    TiebaStatic.log(new ao("c11693").dk("obj_locate", "1").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("nid", apVar.getNid()));
                    TiebaStatic.log(new ao("c11989").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ap apVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
                int i = 0;
                if (arrayList != null && apVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (apVar.threadType == 0) {
                        i = 1;
                    } else if (apVar.threadType == 40) {
                        i = 2;
                    } else if (apVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.irN != null) {
                        PersonalizePageView.this.irN.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ao("c11693").dk("tid", apVar.getTid()).dk("nid", apVar.getNid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fid", apVar.getFid()).dk("obj_param1", apVar.weight).dk("obj_source", apVar.source).dk("obj_id", apVar.extra).dk("obj_type", sb.toString()).dk("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.ilu = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bu) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bu) tag));
                    }
                }
            }
        };
        this.fpM = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fpM != i && PersonalizePageView.this.imf != null) {
                    PersonalizePageView.this.fpM = i;
                    if (PersonalizePageView.this.fpM == 1) {
                        PersonalizePageView.this.imf.bud();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.imf.bue();
                    } else {
                        PersonalizePageView.this.imf.bud();
                    }
                }
            }
        };
        this.imh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ciD() {
                if (PersonalizePageView.this.imf != null) {
                    PersonalizePageView.this.fpM = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.ilZ)) {
                        PersonalizePageView.this.imf.bue();
                    } else {
                        PersonalizePageView.this.imf.bud();
                    }
                }
            }
        };
        this.isb = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hsC = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_first_install", true);

            private void cjz() {
                if (this.hsC) {
                    this.hsC = false;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.irO == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bSS = PersonalizePageView.this.bSS();
                PersonalizePageView.this.btO();
                if (bSS) {
                    PersonalizePageView.this.ga(true);
                }
                PersonalizePageView.this.irO.P(i, i2, i3);
                q.aMU().aMV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.irO != null) {
                    PersonalizePageView.this.irO.z(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cjz();
                } else if (!this.hsC) {
                    PersonalizePageView.this.imi.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cjz();
                    PersonalizePageView.this.cir();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cjz();
                PersonalizePageView.this.imi.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.btO();
                if (ac.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.diW().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cjA() {
                if (PersonalizePageView.this.fnt != null) {
                    PersonalizePageView.this.fnt.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fnt.endLoadData();
                    PersonalizePageView.this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.isc = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.boB().Ad("page_recommend");
                PersonalizePageView.this.irP.update();
                PersonalizePageView.this.irP.ou(false);
                PersonalizePageView.this.irY = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iqC = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.irP != null && PersonalizePageView.this.irP.bZb() != null) {
                    PersonalizePageView.this.irP.bZb().cjf();
                }
            }
        };
        this.isd = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aYs() {
                if (PersonalizePageView.this.irY) {
                    PersonalizePageView.this.hAH = 0;
                    PersonalizePageView.this.eyQ = 1;
                    PersonalizePageView.this.irY = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iqD = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.irP != null) {
                    PersonalizePageView.this.irP.ou(true);
                    PersonalizePageView.this.irP.cjF();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aPI().kn(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.ise = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.elO = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.chX();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.imk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.btv();
            }
        };
        this.hBr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hAx = true;
                    }
                }
            }
        };
        this.isf = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.imi != null && !PersonalizePageView.this.imi.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.irL == null) {
                            PersonalizePageView.this.irL = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.irL.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.irM = PersonalizePageView.this.irL;
                            PersonalizePageView.this.cjw();
                        } else if (PersonalizePageView.this.irM != PersonalizePageView.this.irL) {
                            PersonalizePageView.this.irM = PersonalizePageView.this.irL;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.irL.setEnable(true);
                        PersonalizePageView.this.imi.setProgressView(PersonalizePageView.this.irL);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.imi.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.irK == null) {
                        PersonalizePageView.this.irK = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.irM = PersonalizePageView.this.irK;
                        PersonalizePageView.this.cjw();
                    } else if (PersonalizePageView.this.irM != PersonalizePageView.this.irK || !aVar.equals(PersonalizePageView.this.irK.cjY())) {
                        PersonalizePageView.this.irM = PersonalizePageView.this.irK;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.irK.setEnable(true);
                    PersonalizePageView.this.imi.setProgressView(PersonalizePageView.this.irK);
                    PersonalizePageView.this.irK.a(aVar);
                    PersonalizePageView.this.imi.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.isg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.irZ != null) {
                    PersonalizePageView.this.irZ.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.irS = 0L;
        this.mSkinType = 3;
        this.hAx = false;
        this.irT = 0;
        this.irU = true;
        this.irV = false;
        this.irW = false;
        this.irX = 0;
        this.hAH = 0;
        this.irY = false;
        this.eyQ = 1;
        this.hli = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hlg == null) {
                            PersonalizePageView.this.hlg = new n(new l());
                        }
                        PersonalizePageView.this.hlg.a(PersonalizePageView.this.ilZ, 2);
                    } else if (PersonalizePageView.this.hlg != null) {
                        PersonalizePageView.this.hlg.pC();
                    }
                }
            }
        };
        this.isa = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.irP != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aVd().aVe(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iqa = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ap apVar) {
                if (apVar != null) {
                    TiebaStatic.log(new ao("c11693").dk("obj_locate", "1").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("nid", apVar.getNid()));
                    TiebaStatic.log(new ao("c11989").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ap apVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
                int i2 = 0;
                if (arrayList != null && apVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (apVar.threadType == 0) {
                        i2 = 1;
                    } else if (apVar.threadType == 40) {
                        i2 = 2;
                    } else if (apVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.irN != null) {
                        PersonalizePageView.this.irN.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ao("c11693").dk("tid", apVar.getTid()).dk("nid", apVar.getNid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fid", apVar.getFid()).dk("obj_param1", apVar.weight).dk("obj_source", apVar.source).dk("obj_id", apVar.extra).dk("obj_type", sb.toString()).dk("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.ilu = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bu) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bu) tag));
                    }
                }
            }
        };
        this.fpM = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.fpM != i2 && PersonalizePageView.this.imf != null) {
                    PersonalizePageView.this.fpM = i2;
                    if (PersonalizePageView.this.fpM == 1) {
                        PersonalizePageView.this.imf.bud();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.imf.bue();
                    } else {
                        PersonalizePageView.this.imf.bud();
                    }
                }
            }
        };
        this.imh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ciD() {
                if (PersonalizePageView.this.imf != null) {
                    PersonalizePageView.this.fpM = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.ilZ)) {
                        PersonalizePageView.this.imf.bue();
                    } else {
                        PersonalizePageView.this.imf.bud();
                    }
                }
            }
        };
        this.isb = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hsC = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_first_install", true);

            private void cjz() {
                if (this.hsC) {
                    this.hsC = false;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i2, int i22, int i3) {
                if (PersonalizePageView.this.irO == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bSS = PersonalizePageView.this.bSS();
                PersonalizePageView.this.btO();
                if (bSS) {
                    PersonalizePageView.this.ga(true);
                }
                PersonalizePageView.this.irO.P(i2, i22, i3);
                q.aMU().aMV();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.irO != null) {
                    PersonalizePageView.this.irO.z(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cjz();
                } else if (!this.hsC) {
                    PersonalizePageView.this.imi.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cjz();
                    PersonalizePageView.this.cir();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cjz();
                PersonalizePageView.this.imi.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.btO();
                if (ac.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.diW().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cjA() {
                if (PersonalizePageView.this.fnt != null) {
                    PersonalizePageView.this.fnt.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fnt.endLoadData();
                    PersonalizePageView.this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.isc = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.boB().Ad("page_recommend");
                PersonalizePageView.this.irP.update();
                PersonalizePageView.this.irP.ou(false);
                PersonalizePageView.this.irY = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iqC = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.irP != null && PersonalizePageView.this.irP.bZb() != null) {
                    PersonalizePageView.this.irP.bZb().cjf();
                }
            }
        };
        this.isd = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aYs() {
                if (PersonalizePageView.this.irY) {
                    PersonalizePageView.this.hAH = 0;
                    PersonalizePageView.this.eyQ = 1;
                    PersonalizePageView.this.irY = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iqD = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.irP != null) {
                    PersonalizePageView.this.irP.ou(true);
                    PersonalizePageView.this.irP.cjF();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aPI().kn(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.ise = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.elO = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.chX();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.imk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.btv();
            }
        };
        this.hBr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hAx = true;
                    }
                }
            }
        };
        this.isf = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.imi != null && !PersonalizePageView.this.imi.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.irL == null) {
                            PersonalizePageView.this.irL = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.irL.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.irM = PersonalizePageView.this.irL;
                            PersonalizePageView.this.cjw();
                        } else if (PersonalizePageView.this.irM != PersonalizePageView.this.irL) {
                            PersonalizePageView.this.irM = PersonalizePageView.this.irL;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.irL.setEnable(true);
                        PersonalizePageView.this.imi.setProgressView(PersonalizePageView.this.irL);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.imi.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.irK == null) {
                        PersonalizePageView.this.irK = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.irM = PersonalizePageView.this.irK;
                        PersonalizePageView.this.cjw();
                    } else if (PersonalizePageView.this.irM != PersonalizePageView.this.irK || !aVar.equals(PersonalizePageView.this.irK.cjY())) {
                        PersonalizePageView.this.irM = PersonalizePageView.this.irK;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.irK.setEnable(true);
                    PersonalizePageView.this.imi.setProgressView(PersonalizePageView.this.irK);
                    PersonalizePageView.this.irK.a(aVar);
                    PersonalizePageView.this.imi.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.isg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.irZ != null) {
                    PersonalizePageView.this.irZ.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ilZ = new BdTypeRecyclerView(context);
        this.dmG = new LinearLayoutManager(this.ilZ.getContext());
        this.ilZ.setLayoutManager(this.dmG);
        this.ilZ.setFadingEdgeLength(0);
        this.ilZ.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hlg = new n(new l());
            this.hlg.a(this.ilZ, 2);
        }
        MessageManager.getInstance().registerListener(this.hli);
        MessageManager.getInstance().registerListener(this.isa);
        this.imi = new BigdaySwipeRefreshLayout(context);
        this.imi.addView(this.ilZ);
        this.fnt = new PbListView(context);
        this.fnt.getView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setLineGone();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.fnt.setOnClickListener(this.imk);
        this.fnt.aXZ();
        this.ilZ.setNextPage(this.fnt);
        com.baidu.adp.base.e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        MessageManager.getInstance().registerListener(this.isf);
        com.baidu.tbadk.core.bigday.b.aPI().gQ(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aPI().kn(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.imi);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.irZ = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.irZ, layoutParams);
            this.irZ.setOnClickListener(this.isg);
            this.irZ.setVisibility(8);
        }
        this.irR = new com.baidu.tieba.homepage.personalize.model.e();
        this.irN = new af(context, this.ilZ);
        this.irN.b(this.irR);
        this.irP = new e(this.pageContext, this.ilZ, this.irN, this.imi);
        this.irQ = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.hBr);
        this.irX = com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cjw() {
        if (this.irM != null) {
            this.irM.setListPullRefreshListener(this.isc);
            this.irM.a(this.iqC);
            this.irM.a(this.isd);
            this.irM.a(this.iqD);
        }
    }

    public void bzy() {
        this.irN.b(this.iqa);
        this.irN.a(this.ilu);
        this.irP.a(this.isb);
        this.irQ.a(this);
        cjw();
        this.ilZ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.hAH += i2;
                if (PersonalizePageView.this.irZ != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.ilZ.getItem(PersonalizePageView.this.dmG.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.irZ.show();
                        } else {
                            PersonalizePageView.this.irZ.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dmG != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.hAH < height * 3 || PersonalizePageView.this.eyQ != 1) {
                        if (PersonalizePageView.this.hAH < height * 3 && PersonalizePageView.this.eyQ == 2) {
                            PersonalizePageView.this.eyQ = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.eyQ = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.eyQ)));
                    }
                    if (PersonalizePageView.this.dmG.getItemCount() - PersonalizePageView.this.dmG.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.btv();
                    }
                }
            }
        });
        this.ilZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.btv();
            }
        });
        this.ilZ.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.irS >= 5000) {
                    PersonalizePageView.this.irP.cm(i, i2);
                }
            }
        }, 1L);
        this.ilZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.irP != null && PersonalizePageView.this.irP.bZb() != null) {
                        PersonalizePageView.this.irP.bZb().cu(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bPh().stopPlay();
                    }
                }
            }
        });
        this.ilZ.removeOnScrollListener(this.mOnScrollListener);
        this.ilZ.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.irO = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fnt != null) {
            this.fnt.setText(getContext().getString(R.string.pb_load_more));
            this.fnt.endLoadData();
            this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.irP.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.irP != null) {
            this.irP.oy(!z);
        }
        this.irW = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.irW;
    }

    public void e(Long l) {
        this.irP.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.irP != null) {
            this.irP.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.irP != null) {
            this.irP.showFloatingView();
        }
    }

    public void cjx() {
        if (this.irP != null) {
            this.irP.cjx();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.fwo != null) {
                this.fwo.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.irL != null) {
                this.irL.changeSkin(i);
            }
            if (this.fnt != null) {
                this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
                this.fnt.changeSkin(i);
            }
            this.irN.onChangeSkinType(i);
            if (this.irP != null) {
                this.irP.onChangeSkinType(i);
            }
            if (this.irZ != null) {
                this.irZ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aO(String str, int i) {
        if (this.fnt != null) {
            this.fnt.setText(getContext().getString(R.string.pb_load_more));
            this.fnt.endLoadData();
            this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.irP.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.irP != null) {
                        PersonalizePageView.this.irP.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
            this.ilZ.setNextPage(this.fnt);
            this.fnt.setText(getContext().getString(R.string.pb_load_more));
            this.fnt.endLoadData();
            this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.imi != null) {
            this.imi.setVisibility(0);
        }
        if (this.irO != null) {
            this.irO.cih();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bSS() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(boolean z) {
        if (this.fwo == null) {
            this.fwo = new g(getContext());
            this.fwo.bg(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.fwo.bgC();
            this.fwo.setWrapStyle(true);
            this.fwo.onChangeSkinType();
        }
        this.fwo.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.ilZ.setNextPage(null);
        if (this.imi != null) {
            this.imi.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.irP != null) {
            this.irP.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.irP != null) {
            this.irP.ni(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.irX < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ise, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.irP != null) {
            this.irP.oo(z);
        }
        if (this.imf != null) {
            this.imf.b(this.imh);
            this.imf.a(this.imh);
            this.imh.ciD();
        }
    }

    public void cir() {
        if (this.irP != null) {
            ga(true);
            this.irP.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.aPI().aPK();
            com.baidu.tbadk.core.bigday.b.aPI().aPJ();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.irP != null) {
            this.irP.update();
        } else if (this.ilZ != null && this.imi != null) {
            showFloatingView();
            this.ilZ.setSelection(0);
            if (!this.imi.isRefreshing()) {
                if (this.irP != null && this.irP.bZb() != null) {
                    this.irP.bZb().cjf();
                    this.irP.ou(false);
                }
                this.imi.setRefreshing(true);
            }
            if (this.imh != null) {
                this.imh.ciD();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hli);
        MessageManager.getInstance().unRegisterListener(this.hBr);
        MessageManager.getInstance().unRegisterListener(this.isf);
        this.irP.onDestroy();
        this.irN.b((NEGFeedBackView.a) null);
        this.irN.onDestroy();
        this.irP.a((e.a) null);
        if (this.irK != null) {
            this.irK.setListPullRefreshListener(null);
            this.irK.a((f.d) null);
            this.irK.a((f.a) null);
            this.irK.a((f.b) null);
            this.irK.release();
        }
        if (this.irL != null) {
            this.irL.setListPullRefreshListener(null);
            this.irL.a((f.d) null);
            this.irL.a((f.a) null);
            this.irL.a((f.b) null);
            this.irL.release();
        }
        this.ilZ.setOnSrollToBottomListener(null);
        if (this.imf != null) {
            this.imf.b(this.imh);
        }
        this.ilZ.removeOnScrollListener(this.mOnScrollListener);
        if (this.fwo != null) {
            this.fwo.release();
        }
        this.ilZ.setRecyclerListener(null);
        if (this.irQ != null) {
            this.irQ.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aPI().destroy();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ise);
    }

    public void onPause() {
        this.irP.onPause();
        if (this.irN != null) {
            this.irN.onPause();
        }
    }

    public void onResume() {
        if (this.hAx) {
            reload();
            this.hAx = false;
        }
        if (this.imi != null) {
            this.imi.resume();
        }
        if (this.irN != null) {
            this.irN.onResume();
        }
    }

    public void chX() {
        if (this.irN != null) {
            this.irN.notifyDataSetChanged();
        }
    }

    public void chY() {
        if (this.irP != null) {
            this.irP.ni(true);
        }
        s.bOB().jI(false);
        com.baidu.tieba.a.d.boB().dh("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ise);
    }

    public void cjt() {
        this.irP.cjL();
    }

    public void cjy() {
        this.irP.cjy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        com.baidu.tieba.homepage.framework.a.cig().q(System.currentTimeMillis(), 1);
        if (this.fnt != null && !this.fnt.isLoading()) {
            this.fnt.startLoadData();
            this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.irP.btv();
    }
}
