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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes16.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager dsC;
    private int eFg;
    private final CustomMessageListener erZ;
    private g fBv;
    private PbListView fsC;
    private int fuW;
    private boolean hGn;
    private int hGx;
    private CustomMessageListener hHm;
    private n hqR;
    private CustomMessageListener hqT;
    private FollowUserButton.a irz;
    private BdTypeRecyclerView ise;
    private ScrollFragmentTabHost isk;
    ScrollFragmentTabHost.a isl;
    private BigdaySwipeRefreshLayout ism;
    private View.OnClickListener iso;
    f.d iwI;
    f.b iwJ;
    private NEGFeedBackView.a iwg;
    private com.baidu.tieba.homepage.personalize.bigday.b ixQ;
    private com.baidu.tieba.homepage.personalize.bigday.a ixR;
    private a ixS;
    private af ixT;
    private com.baidu.tieba.homepage.framework.b ixU;
    private e ixV;
    private com.baidu.tieba.homepage.personalize.a ixW;
    private com.baidu.tieba.homepage.personalize.model.e ixX;
    private long ixY;
    private int ixZ;
    private boolean iya;
    private boolean iyb;
    private boolean iyc;
    private int iyd;
    private boolean iye;
    private FRSRefreshButton iyf;
    private CustomMessageListener iyg;
    private e.a iyh;
    f.c iyi;
    f.a iyj;
    private Runnable iyk;
    public CustomMessageListener iyl;
    private View.OnClickListener iym;
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
        int i = personalizePageView.iyd + 1;
        personalizePageView.iyd = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.isk = scrollFragmentTabHost;
        if (this.isk != null) {
            this.isk.b(this.isl);
            this.isk.a(this.isl);
        }
        if (this.ixV != null) {
            this.ixV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ixW != null) {
            this.ixW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.ism != null) {
            this.ism.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ixT != null) {
            this.ixT.setPageUniqueId(bdUniqueId);
        }
        if (this.ixV != null) {
            this.ixV.p(bdUniqueId);
        }
        if (this.ixX != null) {
            this.ixX.i(bdUniqueId);
        }
        if (this.ixR != null) {
            this.ixR.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aTD().setTag(bdUniqueId);
        if (this.erZ != null) {
            this.erZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.erZ);
        }
        if (this.ixW != null) {
            this.ixW.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.ixY = 0L;
        this.mSkinType = 3;
        this.hGn = false;
        this.ixZ = 0;
        this.iya = true;
        this.iyb = false;
        this.iyc = false;
        this.iyd = 0;
        this.hGx = 0;
        this.iye = false;
        this.eFg = 1;
        this.hqT = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hqR == null) {
                            PersonalizePageView.this.hqR = new n(new l());
                        }
                        PersonalizePageView.this.hqR.a(PersonalizePageView.this.ise, 2);
                    } else if (PersonalizePageView.this.hqR != null) {
                        PersonalizePageView.this.hqR.pD();
                    }
                }
            }
        };
        this.iyg = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ixV != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aZd().aZe(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iwg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                if (aqVar != null) {
                    TiebaStatic.log(new ap("c11693").dn("obj_locate", "1").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("nid", aqVar.getNid()));
                    TiebaStatic.log(new ap("c11989").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                int i = 0;
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (aqVar.threadType == 0) {
                        i = 1;
                    } else if (aqVar.threadType == 40) {
                        i = 2;
                    } else if (aqVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.ixT != null) {
                        PersonalizePageView.this.ixT.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ap("c11693").dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", aqVar.getFid()).dn("obj_param1", aqVar.weight).dn("obj_source", aqVar.source).dn("obj_id", aqVar.extra).dn("obj_type", sb.toString()).dn("obj_name", str).ah(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.irz = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bv) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bv) tag));
                    }
                }
            }
        };
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fuW != i && PersonalizePageView.this.isk != null) {
                    PersonalizePageView.this.fuW = i;
                    if (PersonalizePageView.this.fuW == 1) {
                        PersonalizePageView.this.isk.bxm();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.isk.bxn();
                    } else {
                        PersonalizePageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cme() {
                if (PersonalizePageView.this.isk != null) {
                    PersonalizePageView.this.fuW = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.ise)) {
                        PersonalizePageView.this.isk.bxn();
                    } else {
                        PersonalizePageView.this.isk.bxm();
                    }
                }
            }
        };
        this.iyh = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hyo = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_first_install", true);

            private void cna() {
                if (this.hyo) {
                    this.hyo = false;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void P(int i, int i2, int i3) {
                if (PersonalizePageView.this.ixU == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bWj = PersonalizePageView.this.bWj();
                PersonalizePageView.this.bwX();
                if (bWj) {
                    PersonalizePageView.this.gw(true);
                }
                PersonalizePageView.this.ixU.O(i, i2, i3);
                q.aQI().aQJ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.ixU != null) {
                    PersonalizePageView.this.ixU.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cna();
                } else if (!this.hyo) {
                    PersonalizePageView.this.ism.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cna();
                    PersonalizePageView.this.clQ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cna();
                PersonalizePageView.this.ism.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bwX();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dmf().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cnb() {
                if (PersonalizePageView.this.fsC != null) {
                    PersonalizePageView.this.fsC.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fsC.endLoadData();
                    PersonalizePageView.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iyi = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.brD().AO("page_recommend");
                PersonalizePageView.this.ixV.update();
                PersonalizePageView.this.ixV.oZ(false);
                PersonalizePageView.this.iye = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iwI = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.ixV != null && PersonalizePageView.this.ixV.ccy() != null) {
                    PersonalizePageView.this.ixV.ccy().cmG();
                }
            }
        };
        this.iyj = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bcr() {
                if (PersonalizePageView.this.iye) {
                    PersonalizePageView.this.hGx = 0;
                    PersonalizePageView.this.eFg = 1;
                    PersonalizePageView.this.iye = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iwJ = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.ixV != null) {
                    PersonalizePageView.this.ixV.oZ(true);
                    PersonalizePageView.this.ixV.cng();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aTD().kH(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iyk = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.erZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.clw();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iso = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bwE();
            }
        };
        this.hHm = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hGn = true;
                    }
                }
            }
        };
        this.iyl = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ism != null && !PersonalizePageView.this.ism.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ixR == null) {
                            PersonalizePageView.this.ixR = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ixR.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ixS = PersonalizePageView.this.ixR;
                            PersonalizePageView.this.cmX();
                        } else if (PersonalizePageView.this.ixS != PersonalizePageView.this.ixR) {
                            PersonalizePageView.this.ixS = PersonalizePageView.this.ixR;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ixR.setEnable(true);
                        PersonalizePageView.this.ism.setProgressView(PersonalizePageView.this.ixR);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.ism.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ixQ == null) {
                        PersonalizePageView.this.ixQ = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ixS = PersonalizePageView.this.ixQ;
                        PersonalizePageView.this.cmX();
                    } else if (PersonalizePageView.this.ixS != PersonalizePageView.this.ixQ || !aVar.equals(PersonalizePageView.this.ixQ.cnz())) {
                        PersonalizePageView.this.ixS = PersonalizePageView.this.ixQ;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ixQ.setEnable(true);
                    PersonalizePageView.this.ism.setProgressView(PersonalizePageView.this.ixQ);
                    PersonalizePageView.this.ixQ.a(aVar);
                    PersonalizePageView.this.ism.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iym = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iyf != null) {
                    PersonalizePageView.this.iyf.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ixY = 0L;
        this.mSkinType = 3;
        this.hGn = false;
        this.ixZ = 0;
        this.iya = true;
        this.iyb = false;
        this.iyc = false;
        this.iyd = 0;
        this.hGx = 0;
        this.iye = false;
        this.eFg = 1;
        this.hqT = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hqR == null) {
                            PersonalizePageView.this.hqR = new n(new l());
                        }
                        PersonalizePageView.this.hqR.a(PersonalizePageView.this.ise, 2);
                    } else if (PersonalizePageView.this.hqR != null) {
                        PersonalizePageView.this.hqR.pD();
                    }
                }
            }
        };
        this.iyg = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ixV != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aZd().aZe(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iwg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                if (aqVar != null) {
                    TiebaStatic.log(new ap("c11693").dn("obj_locate", "1").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("nid", aqVar.getNid()));
                    TiebaStatic.log(new ap("c11989").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                int i = 0;
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (aqVar.threadType == 0) {
                        i = 1;
                    } else if (aqVar.threadType == 40) {
                        i = 2;
                    } else if (aqVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.ixT != null) {
                        PersonalizePageView.this.ixT.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ap("c11693").dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", aqVar.getFid()).dn("obj_param1", aqVar.weight).dn("obj_source", aqVar.source).dn("obj_id", aqVar.extra).dn("obj_type", sb.toString()).dn("obj_name", str).ah(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.irz = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bv) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bv) tag));
                    }
                }
            }
        };
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fuW != i && PersonalizePageView.this.isk != null) {
                    PersonalizePageView.this.fuW = i;
                    if (PersonalizePageView.this.fuW == 1) {
                        PersonalizePageView.this.isk.bxm();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.isk.bxn();
                    } else {
                        PersonalizePageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cme() {
                if (PersonalizePageView.this.isk != null) {
                    PersonalizePageView.this.fuW = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.ise)) {
                        PersonalizePageView.this.isk.bxn();
                    } else {
                        PersonalizePageView.this.isk.bxm();
                    }
                }
            }
        };
        this.iyh = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hyo = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_first_install", true);

            private void cna() {
                if (this.hyo) {
                    this.hyo = false;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void P(int i, int i2, int i3) {
                if (PersonalizePageView.this.ixU == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bWj = PersonalizePageView.this.bWj();
                PersonalizePageView.this.bwX();
                if (bWj) {
                    PersonalizePageView.this.gw(true);
                }
                PersonalizePageView.this.ixU.O(i, i2, i3);
                q.aQI().aQJ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.ixU != null) {
                    PersonalizePageView.this.ixU.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cna();
                } else if (!this.hyo) {
                    PersonalizePageView.this.ism.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cna();
                    PersonalizePageView.this.clQ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cna();
                PersonalizePageView.this.ism.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bwX();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dmf().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cnb() {
                if (PersonalizePageView.this.fsC != null) {
                    PersonalizePageView.this.fsC.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fsC.endLoadData();
                    PersonalizePageView.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iyi = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.brD().AO("page_recommend");
                PersonalizePageView.this.ixV.update();
                PersonalizePageView.this.ixV.oZ(false);
                PersonalizePageView.this.iye = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iwI = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.ixV != null && PersonalizePageView.this.ixV.ccy() != null) {
                    PersonalizePageView.this.ixV.ccy().cmG();
                }
            }
        };
        this.iyj = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bcr() {
                if (PersonalizePageView.this.iye) {
                    PersonalizePageView.this.hGx = 0;
                    PersonalizePageView.this.eFg = 1;
                    PersonalizePageView.this.iye = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iwJ = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.ixV != null) {
                    PersonalizePageView.this.ixV.oZ(true);
                    PersonalizePageView.this.ixV.cng();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aTD().kH(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iyk = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.erZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.clw();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iso = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bwE();
            }
        };
        this.hHm = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hGn = true;
                    }
                }
            }
        };
        this.iyl = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ism != null && !PersonalizePageView.this.ism.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ixR == null) {
                            PersonalizePageView.this.ixR = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ixR.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ixS = PersonalizePageView.this.ixR;
                            PersonalizePageView.this.cmX();
                        } else if (PersonalizePageView.this.ixS != PersonalizePageView.this.ixR) {
                            PersonalizePageView.this.ixS = PersonalizePageView.this.ixR;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ixR.setEnable(true);
                        PersonalizePageView.this.ism.setProgressView(PersonalizePageView.this.ixR);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.ism.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ixQ == null) {
                        PersonalizePageView.this.ixQ = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ixS = PersonalizePageView.this.ixQ;
                        PersonalizePageView.this.cmX();
                    } else if (PersonalizePageView.this.ixS != PersonalizePageView.this.ixQ || !aVar.equals(PersonalizePageView.this.ixQ.cnz())) {
                        PersonalizePageView.this.ixS = PersonalizePageView.this.ixQ;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ixQ.setEnable(true);
                    PersonalizePageView.this.ism.setProgressView(PersonalizePageView.this.ixQ);
                    PersonalizePageView.this.ixQ.a(aVar);
                    PersonalizePageView.this.ism.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iym = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iyf != null) {
                    PersonalizePageView.this.iyf.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ixY = 0L;
        this.mSkinType = 3;
        this.hGn = false;
        this.ixZ = 0;
        this.iya = true;
        this.iyb = false;
        this.iyc = false;
        this.iyd = 0;
        this.hGx = 0;
        this.iye = false;
        this.eFg = 1;
        this.hqT = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hqR == null) {
                            PersonalizePageView.this.hqR = new n(new l());
                        }
                        PersonalizePageView.this.hqR.a(PersonalizePageView.this.ise, 2);
                    } else if (PersonalizePageView.this.hqR != null) {
                        PersonalizePageView.this.hqR.pD();
                    }
                }
            }
        };
        this.iyg = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ixV != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aZd().aZe(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iwg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                if (aqVar != null) {
                    TiebaStatic.log(new ap("c11693").dn("obj_locate", "1").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("nid", aqVar.getNid()));
                    TiebaStatic.log(new ap("c11989").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                int i2 = 0;
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (aqVar.threadType == 0) {
                        i2 = 1;
                    } else if (aqVar.threadType == 40) {
                        i2 = 2;
                    } else if (aqVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.ixT != null) {
                        PersonalizePageView.this.ixT.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ap("c11693").dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", aqVar.getFid()).dn("obj_param1", aqVar.weight).dn("obj_source", aqVar.source).dn("obj_id", aqVar.extra).dn("obj_type", sb.toString()).dn("obj_name", str).ah(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.irz = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bv) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bv) tag));
                    }
                }
            }
        };
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.fuW != i2 && PersonalizePageView.this.isk != null) {
                    PersonalizePageView.this.fuW = i2;
                    if (PersonalizePageView.this.fuW == 1) {
                        PersonalizePageView.this.isk.bxm();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.isk.bxn();
                    } else {
                        PersonalizePageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cme() {
                if (PersonalizePageView.this.isk != null) {
                    PersonalizePageView.this.fuW = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.ise)) {
                        PersonalizePageView.this.isk.bxn();
                    } else {
                        PersonalizePageView.this.isk.bxm();
                    }
                }
            }
        };
        this.iyh = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hyo = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_first_install", true);

            private void cna() {
                if (this.hyo) {
                    this.hyo = false;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void P(int i2, int i22, int i3) {
                if (PersonalizePageView.this.ixU == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bWj = PersonalizePageView.this.bWj();
                PersonalizePageView.this.bwX();
                if (bWj) {
                    PersonalizePageView.this.gw(true);
                }
                PersonalizePageView.this.ixU.O(i2, i22, i3);
                q.aQI().aQJ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.ixU != null) {
                    PersonalizePageView.this.ixU.A(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cna();
                } else if (!this.hyo) {
                    PersonalizePageView.this.ism.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cna();
                    PersonalizePageView.this.clQ();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cna();
                PersonalizePageView.this.ism.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bwX();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dmf().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cnb() {
                if (PersonalizePageView.this.fsC != null) {
                    PersonalizePageView.this.fsC.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fsC.endLoadData();
                    PersonalizePageView.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iyi = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.brD().AO("page_recommend");
                PersonalizePageView.this.ixV.update();
                PersonalizePageView.this.ixV.oZ(false);
                PersonalizePageView.this.iye = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iwI = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.ixV != null && PersonalizePageView.this.ixV.ccy() != null) {
                    PersonalizePageView.this.ixV.ccy().cmG();
                }
            }
        };
        this.iyj = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bcr() {
                if (PersonalizePageView.this.iye) {
                    PersonalizePageView.this.hGx = 0;
                    PersonalizePageView.this.eFg = 1;
                    PersonalizePageView.this.iye = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iwJ = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.ixV != null) {
                    PersonalizePageView.this.ixV.oZ(true);
                    PersonalizePageView.this.ixV.cng();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aTD().kH(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iyk = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.erZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.clw();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iso = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bwE();
            }
        };
        this.hHm = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hGn = true;
                    }
                }
            }
        };
        this.iyl = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ism != null && !PersonalizePageView.this.ism.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ixR == null) {
                            PersonalizePageView.this.ixR = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ixR.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ixS = PersonalizePageView.this.ixR;
                            PersonalizePageView.this.cmX();
                        } else if (PersonalizePageView.this.ixS != PersonalizePageView.this.ixR) {
                            PersonalizePageView.this.ixS = PersonalizePageView.this.ixR;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ixR.setEnable(true);
                        PersonalizePageView.this.ism.setProgressView(PersonalizePageView.this.ixR);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.ism.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ixQ == null) {
                        PersonalizePageView.this.ixQ = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ixS = PersonalizePageView.this.ixQ;
                        PersonalizePageView.this.cmX();
                    } else if (PersonalizePageView.this.ixS != PersonalizePageView.this.ixQ || !aVar.equals(PersonalizePageView.this.ixQ.cnz())) {
                        PersonalizePageView.this.ixS = PersonalizePageView.this.ixQ;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ixQ.setEnable(true);
                    PersonalizePageView.this.ism.setProgressView(PersonalizePageView.this.ixQ);
                    PersonalizePageView.this.ixQ.a(aVar);
                    PersonalizePageView.this.ism.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iym = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iyf != null) {
                    PersonalizePageView.this.iyf.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ise = new BdTypeRecyclerView(context);
        this.dsC = new LinearLayoutManager(this.ise.getContext());
        this.ise.setLayoutManager(this.dsC);
        this.ise.setFadingEdgeLength(0);
        this.ise.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hqR = new n(new l());
            this.hqR.a(this.ise, 2);
        }
        MessageManager.getInstance().registerListener(this.hqT);
        MessageManager.getInstance().registerListener(this.iyg);
        this.ism = new BigdaySwipeRefreshLayout(context);
        this.ism.addView(this.ise);
        this.fsC = new PbListView(context);
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.fsC.setOnClickListener(this.iso);
        this.fsC.bbZ();
        this.ise.setNextPage(this.fsC);
        com.baidu.adp.base.e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        MessageManager.getInstance().registerListener(this.iyl);
        com.baidu.tbadk.core.bigday.b.aTD().hu(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aTD().kH(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.ism);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.iyf = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.iyf, layoutParams);
            this.iyf.setOnClickListener(this.iym);
            this.iyf.setVisibility(8);
        }
        this.ixX = new com.baidu.tieba.homepage.personalize.model.e();
        this.ixT = new af(context, this.ise);
        this.ixT.b(this.ixX);
        this.ixV = new e(this.pageContext, this.ise, this.ixT, this.ism);
        this.ixW = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.hHm);
        this.iyd = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cmX() {
        if (this.ixS != null) {
            this.ixS.setListPullRefreshListener(this.iyi);
            this.ixS.a(this.iwI);
            this.ixS.a(this.iyj);
            this.ixS.a(this.iwJ);
        }
    }

    public void bCM() {
        this.ixT.b(this.iwg);
        this.ixT.a(this.irz);
        this.ixV.a(this.iyh);
        this.ixW.a(this);
        cmX();
        this.ise.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.hGx += i2;
                if (PersonalizePageView.this.iyf != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.ise.getItem(PersonalizePageView.this.dsC.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.iyf.show();
                        } else {
                            PersonalizePageView.this.iyf.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dsC != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.hGx < height * 3 || PersonalizePageView.this.eFg != 1) {
                        if (PersonalizePageView.this.hGx < height * 3 && PersonalizePageView.this.eFg == 2) {
                            PersonalizePageView.this.eFg = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.eFg = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.eFg)));
                    }
                    if (PersonalizePageView.this.dsC.getItemCount() - PersonalizePageView.this.dsC.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bwE();
                    }
                }
            }
        });
        this.ise.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bwE();
            }
        });
        this.ise.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.ixY >= 5000) {
                    PersonalizePageView.this.ixV.cp(i, i2);
                }
            }
        }, 1L);
        this.ise.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.ixV != null && PersonalizePageView.this.ixV.ccy() != null) {
                        PersonalizePageView.this.ixV.ccy().cA(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bSs().stopPlay();
                    }
                }
            }
        });
        this.ise.removeOnScrollListener(this.mOnScrollListener);
        this.ise.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ixU = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fsC != null) {
            this.fsC.setText(getContext().getString(R.string.pb_load_more));
            this.fsC.endLoadData();
            this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ixV.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.ixV != null) {
            this.ixV.pd(!z);
        }
        this.iyc = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.iyc;
    }

    public void e(Long l) {
        this.ixV.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.ixV != null) {
            this.ixV.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.ixV != null) {
            this.ixV.showFloatingView();
        }
    }

    public void cmY() {
        if (this.ixV != null) {
            this.ixV.cmY();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.ixR != null) {
                this.ixR.changeSkin(i);
            }
            if (this.fsC != null) {
                this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
                this.fsC.changeSkin(i);
            }
            this.ixT.onChangeSkinType(i);
            if (this.ixV != null) {
                this.ixV.onChangeSkinType(i);
            }
            if (this.iyf != null) {
                this.iyf.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aN(String str, int i) {
        if (this.fsC != null) {
            this.fsC.setText(getContext().getString(R.string.pb_load_more));
            this.fsC.endLoadData();
            this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ixV.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.ixV != null) {
                        PersonalizePageView.this.ixV.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
            this.ise.setNextPage(this.fsC);
            this.fsC.setText(getContext().getString(R.string.pb_load_more));
            this.fsC.endLoadData();
            this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.ism != null) {
            this.ism.setVisibility(0);
        }
        if (this.ixU != null) {
            this.ixU.clG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bWj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(boolean z) {
        if (this.fBv == null) {
            this.fBv = new g(getContext());
            this.fBv.bi(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.fBv.bkn();
            this.fBv.setWrapStyle(true);
            this.fBv.onChangeSkinType();
        }
        this.fBv.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.ise.setNextPage(null);
        if (this.ism != null) {
            this.ism.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ixV != null) {
            this.ixV.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.ixV != null) {
            this.ixV.nN(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.iyd < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.iyk, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ixV != null) {
            this.ixV.oT(z);
        }
        if (this.isk != null) {
            this.isk.b(this.isl);
            this.isk.a(this.isl);
            this.isl.cme();
        }
    }

    public void clQ() {
        if (this.ixV != null) {
            gw(true);
            this.ixV.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.aTD().aTF();
            com.baidu.tbadk.core.bigday.b.aTD().aTE();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.ixV != null) {
            this.ixV.update();
        } else if (this.ise != null && this.ism != null) {
            showFloatingView();
            this.ise.setSelection(0);
            if (!this.ism.isRefreshing()) {
                if (this.ixV != null && this.ixV.ccy() != null) {
                    this.ixV.ccy().cmG();
                    this.ixV.oZ(false);
                }
                this.ism.setRefreshing(true);
            }
            if (this.isl != null) {
                this.isl.cme();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hqT);
        MessageManager.getInstance().unRegisterListener(this.hHm);
        MessageManager.getInstance().unRegisterListener(this.iyl);
        this.ixV.onDestroy();
        this.ixT.b((NEGFeedBackView.a) null);
        this.ixT.onDestroy();
        this.ixV.a((e.a) null);
        if (this.ixQ != null) {
            this.ixQ.setListPullRefreshListener(null);
            this.ixQ.a((f.d) null);
            this.ixQ.a((f.a) null);
            this.ixQ.a((f.b) null);
            this.ixQ.release();
        }
        if (this.ixR != null) {
            this.ixR.setListPullRefreshListener(null);
            this.ixR.a((f.d) null);
            this.ixR.a((f.a) null);
            this.ixR.a((f.b) null);
            this.ixR.release();
        }
        this.ise.setOnSrollToBottomListener(null);
        if (this.isk != null) {
            this.isk.b(this.isl);
        }
        this.ise.removeOnScrollListener(this.mOnScrollListener);
        if (this.fBv != null) {
            this.fBv.release();
        }
        this.ise.setRecyclerListener(null);
        if (this.ixW != null) {
            this.ixW.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aTD().destroy();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iyk);
    }

    public void onPause() {
        this.ixV.onPause();
        if (this.ixT != null) {
            this.ixT.onPause();
        }
    }

    public void onResume() {
        if (this.hGn) {
            reload();
            this.hGn = false;
        }
        if (this.ism != null) {
            this.ism.resume();
        }
        if (this.ixT != null) {
            this.ixT.onResume();
        }
    }

    public void clw() {
        if (this.ixT != null) {
            this.ixT.notifyDataSetChanged();
        }
    }

    public void clx() {
        if (this.ixV != null) {
            this.ixV.nN(true);
        }
        s.bRL().km(false);
        com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iyk);
    }

    public void cmU() {
        this.ixV.cnm();
    }

    public void cmZ() {
        this.ixV.cmZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        com.baidu.tieba.homepage.framework.a.clF().r(System.currentTimeMillis(), 1);
        if (this.fsC != null && !this.fsC.isLoading()) {
            this.fsC.startLoadData();
            this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ixV.bwE();
    }
}
