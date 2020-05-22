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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ab;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.view.FloatingAnimationView;
import com.baidu.tieba.view.FollowUserButton;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes9.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager dhU;
    private final CustomMessageListener edg;
    private int epY;
    private PbListView fbY;
    private int feq;
    private g fkQ;
    private m gYf;
    private CustomMessageListener gYh;
    private BdTypeRecyclerView hWO;
    private ScrollFragmentTabHost hWU;
    ScrollFragmentTabHost.a hWV;
    private BigdaySwipeRefreshLayout hWW;
    private View.OnClickListener hWY;
    private FollowUserButton.a hWm;
    private boolean hnT;
    private CustomMessageListener hoG;
    private int hod;
    private com.baidu.tieba.c.c hps;
    private NEGFeedBackView.a iaQ;
    private com.baidu.tieba.homepage.personalize.bigday.b ibQ;
    private com.baidu.tieba.homepage.personalize.bigday.a ibR;
    private a ibS;
    private ab ibT;
    private com.baidu.tieba.homepage.framework.b ibU;
    private e ibV;
    private com.baidu.tieba.homepage.personalize.a ibW;
    private com.baidu.tieba.homepage.personalize.model.e ibX;
    private long ibY;
    private FloatingAnimationView ibZ;
    f.d ibs;
    f.b ibt;
    private int ica;
    private boolean icb;
    private boolean icc;
    private boolean icd;
    private int ice;
    private boolean icf;
    private FRSRefreshButton icg;
    private CustomMessageListener ich;
    private e.a ici;
    f.c icj;
    f.a ick;
    private Runnable icl;
    public CustomMessageListener icm;
    private View.OnClickListener icn;
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

    static /* synthetic */ int w(PersonalizePageView personalizePageView) {
        int i = personalizePageView.ice + 1;
        personalizePageView.ice = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hWU = scrollFragmentTabHost;
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
            this.hWU.a(this.hWV);
        }
        if (this.ibV != null) {
            this.ibV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ibW != null) {
            this.ibW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.hWW != null) {
            this.hWW.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ibT != null) {
            this.ibT.setPageUniqueId(bdUniqueId);
        }
        if (this.ibV != null) {
            this.ibV.o(bdUniqueId);
        }
        if (this.ibX != null) {
            this.ibX.i(bdUniqueId);
        }
        if (this.ibR != null) {
            this.ibR.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aNY().setTag(bdUniqueId);
        if (this.edg != null) {
            this.edg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.edg);
        }
        if (this.ibW != null) {
            this.ibW.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        p pVar = new p();
        pVar.bS(String.valueOf(floatInfo.activity_id));
        pVar.eA(floatInfo.dynamic_url);
        pVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        pVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        pVar.MC(floatInfo.float_url);
        pVar.er(floatInfo.jump_url);
        pVar.setType(floatInfo.show_type.intValue());
        return pVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.ibY = 0L;
        this.mSkinType = 3;
        this.hnT = false;
        this.ica = 0;
        this.icb = true;
        this.icc = false;
        this.icd = false;
        this.ice = 0;
        this.hod = 0;
        this.icf = false;
        this.epY = 1;
        this.gYh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gYf == null) {
                            PersonalizePageView.this.gYf = new m(new k());
                        }
                        PersonalizePageView.this.gYf.a(PersonalizePageView.this.hWO, 2);
                    } else if (PersonalizePageView.this.gYf != null) {
                        PersonalizePageView.this.gYf.pl();
                    }
                }
            }
        };
        this.ich = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ibV != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aTj().aTk(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iaQ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                if (akVar != null) {
                    TiebaStatic.log(new an("c11693").dh("obj_locate", "1").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("nid", akVar.getNid()));
                    TiebaStatic.log(new an("c11989").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                int i = 0;
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (akVar.threadType == 0) {
                        i = 1;
                    } else if (akVar.threadType == 40) {
                        i = 2;
                    } else if (akVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.ibT != null) {
                        PersonalizePageView.this.ibT.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.hWm = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bk) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bk) tag));
                    }
                }
            }
        };
        this.feq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.feq != i && PersonalizePageView.this.hWU != null) {
                    PersonalizePageView.this.feq = i;
                    if (PersonalizePageView.this.feq == 1) {
                        PersonalizePageView.this.hWU.bre();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hWU.brf();
                    } else {
                        PersonalizePageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ceX() {
                if (PersonalizePageView.this.hWU != null) {
                    PersonalizePageView.this.feq = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hWO)) {
                        PersonalizePageView.this.hWU.brf();
                    } else {
                        PersonalizePageView.this.hWU.bre();
                    }
                }
            }
        };
        this.ici = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hgh = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_first_install", true);

            private void cfP() {
                if (this.hgh) {
                    this.hgh = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.ibU == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bPM = PersonalizePageView.this.bPM();
                PersonalizePageView.this.bqO();
                if (bPM) {
                    PersonalizePageView.this.fV(true);
                }
                PersonalizePageView.this.ibU.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.ibU != null) {
                    PersonalizePageView.this.ibU.z(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cfP();
                } else if (!this.hgh) {
                    PersonalizePageView.this.hWW.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cfP();
                    PersonalizePageView.this.ceM();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cfP();
                PersonalizePageView.this.hWW.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bqO();
                p a2 = PersonalizePageView.this.a(PersonalizePageView.this.ibV.cgc());
                PersonalizePageView.this.eL(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hps != null) {
                    PersonalizePageView.this.hps.a(a2);
                }
                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.deu().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cfQ() {
                if (PersonalizePageView.this.fbY != null) {
                    PersonalizePageView.this.fbY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fbY.endLoadData();
                    PersonalizePageView.this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.icj = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.blZ().zK("page_recommend");
                PersonalizePageView.this.ibV.update();
                PersonalizePageView.this.ibV.oj(false);
                PersonalizePageView.this.icf = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.ibs = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.ibV != null && PersonalizePageView.this.ibV.bVQ() != null) {
                    PersonalizePageView.this.ibV.bVQ().cfz();
                }
            }
        };
        this.ick = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aWz() {
                if (PersonalizePageView.this.icf) {
                    PersonalizePageView.this.hod = 0;
                    PersonalizePageView.this.epY = 1;
                    PersonalizePageView.this.icf = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.ibt = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.ibV != null) {
                    PersonalizePageView.this.ibV.oj(true);
                    PersonalizePageView.this.ibV.cfV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aNY().ka(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.icl = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cer();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bqv();
            }
        };
        this.hoG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hnT = true;
                    }
                }
            }
        };
        this.icm = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hWW != null && !PersonalizePageView.this.hWW.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ibR == null) {
                            PersonalizePageView.this.ibR = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ibR.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ibS = PersonalizePageView.this.ibR;
                            PersonalizePageView.this.cfM();
                        } else if (PersonalizePageView.this.ibS != PersonalizePageView.this.ibR) {
                            PersonalizePageView.this.ibS = PersonalizePageView.this.ibR;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ibR.setEnable(true);
                        PersonalizePageView.this.hWW.setProgressView(PersonalizePageView.this.ibR);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hWW.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ibQ == null) {
                        PersonalizePageView.this.ibQ = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ibS = PersonalizePageView.this.ibQ;
                        PersonalizePageView.this.cfM();
                    } else if (PersonalizePageView.this.ibS != PersonalizePageView.this.ibQ || !aVar.equals(PersonalizePageView.this.ibQ.cgo())) {
                        PersonalizePageView.this.ibS = PersonalizePageView.this.ibQ;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ibQ.setEnable(true);
                    PersonalizePageView.this.hWW.setProgressView(PersonalizePageView.this.ibQ);
                    PersonalizePageView.this.ibQ.a(aVar);
                    PersonalizePageView.this.hWW.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.icn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.icg != null) {
                    PersonalizePageView.this.icg.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibY = 0L;
        this.mSkinType = 3;
        this.hnT = false;
        this.ica = 0;
        this.icb = true;
        this.icc = false;
        this.icd = false;
        this.ice = 0;
        this.hod = 0;
        this.icf = false;
        this.epY = 1;
        this.gYh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gYf == null) {
                            PersonalizePageView.this.gYf = new m(new k());
                        }
                        PersonalizePageView.this.gYf.a(PersonalizePageView.this.hWO, 2);
                    } else if (PersonalizePageView.this.gYf != null) {
                        PersonalizePageView.this.gYf.pl();
                    }
                }
            }
        };
        this.ich = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ibV != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aTj().aTk(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iaQ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                if (akVar != null) {
                    TiebaStatic.log(new an("c11693").dh("obj_locate", "1").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("nid", akVar.getNid()));
                    TiebaStatic.log(new an("c11989").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                int i = 0;
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (akVar.threadType == 0) {
                        i = 1;
                    } else if (akVar.threadType == 40) {
                        i = 2;
                    } else if (akVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.ibT != null) {
                        PersonalizePageView.this.ibT.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.hWm = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bk) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bk) tag));
                    }
                }
            }
        };
        this.feq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.feq != i && PersonalizePageView.this.hWU != null) {
                    PersonalizePageView.this.feq = i;
                    if (PersonalizePageView.this.feq == 1) {
                        PersonalizePageView.this.hWU.bre();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hWU.brf();
                    } else {
                        PersonalizePageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ceX() {
                if (PersonalizePageView.this.hWU != null) {
                    PersonalizePageView.this.feq = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hWO)) {
                        PersonalizePageView.this.hWU.brf();
                    } else {
                        PersonalizePageView.this.hWU.bre();
                    }
                }
            }
        };
        this.ici = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hgh = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_first_install", true);

            private void cfP() {
                if (this.hgh) {
                    this.hgh = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.ibU == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bPM = PersonalizePageView.this.bPM();
                PersonalizePageView.this.bqO();
                if (bPM) {
                    PersonalizePageView.this.fV(true);
                }
                PersonalizePageView.this.ibU.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.ibU != null) {
                    PersonalizePageView.this.ibU.z(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cfP();
                } else if (!this.hgh) {
                    PersonalizePageView.this.hWW.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cfP();
                    PersonalizePageView.this.ceM();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cfP();
                PersonalizePageView.this.hWW.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bqO();
                p a2 = PersonalizePageView.this.a(PersonalizePageView.this.ibV.cgc());
                PersonalizePageView.this.eL(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hps != null) {
                    PersonalizePageView.this.hps.a(a2);
                }
                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.deu().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cfQ() {
                if (PersonalizePageView.this.fbY != null) {
                    PersonalizePageView.this.fbY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fbY.endLoadData();
                    PersonalizePageView.this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.icj = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.blZ().zK("page_recommend");
                PersonalizePageView.this.ibV.update();
                PersonalizePageView.this.ibV.oj(false);
                PersonalizePageView.this.icf = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.ibs = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.ibV != null && PersonalizePageView.this.ibV.bVQ() != null) {
                    PersonalizePageView.this.ibV.bVQ().cfz();
                }
            }
        };
        this.ick = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aWz() {
                if (PersonalizePageView.this.icf) {
                    PersonalizePageView.this.hod = 0;
                    PersonalizePageView.this.epY = 1;
                    PersonalizePageView.this.icf = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.ibt = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.ibV != null) {
                    PersonalizePageView.this.ibV.oj(true);
                    PersonalizePageView.this.ibV.cfV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aNY().ka(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.icl = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cer();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bqv();
            }
        };
        this.hoG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hnT = true;
                    }
                }
            }
        };
        this.icm = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hWW != null && !PersonalizePageView.this.hWW.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ibR == null) {
                            PersonalizePageView.this.ibR = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ibR.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ibS = PersonalizePageView.this.ibR;
                            PersonalizePageView.this.cfM();
                        } else if (PersonalizePageView.this.ibS != PersonalizePageView.this.ibR) {
                            PersonalizePageView.this.ibS = PersonalizePageView.this.ibR;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ibR.setEnable(true);
                        PersonalizePageView.this.hWW.setProgressView(PersonalizePageView.this.ibR);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hWW.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ibQ == null) {
                        PersonalizePageView.this.ibQ = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ibS = PersonalizePageView.this.ibQ;
                        PersonalizePageView.this.cfM();
                    } else if (PersonalizePageView.this.ibS != PersonalizePageView.this.ibQ || !aVar.equals(PersonalizePageView.this.ibQ.cgo())) {
                        PersonalizePageView.this.ibS = PersonalizePageView.this.ibQ;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ibQ.setEnable(true);
                    PersonalizePageView.this.hWW.setProgressView(PersonalizePageView.this.ibQ);
                    PersonalizePageView.this.ibQ.a(aVar);
                    PersonalizePageView.this.hWW.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.icn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.icg != null) {
                    PersonalizePageView.this.icg.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ibY = 0L;
        this.mSkinType = 3;
        this.hnT = false;
        this.ica = 0;
        this.icb = true;
        this.icc = false;
        this.icd = false;
        this.ice = 0;
        this.hod = 0;
        this.icf = false;
        this.epY = 1;
        this.gYh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gYf == null) {
                            PersonalizePageView.this.gYf = new m(new k());
                        }
                        PersonalizePageView.this.gYf.a(PersonalizePageView.this.hWO, 2);
                    } else if (PersonalizePageView.this.gYf != null) {
                        PersonalizePageView.this.gYf.pl();
                    }
                }
            }
        };
        this.ich = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.ibV != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aTj().aTk(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iaQ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                if (akVar != null) {
                    TiebaStatic.log(new an("c11693").dh("obj_locate", "1").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("nid", akVar.getNid()));
                    TiebaStatic.log(new an("c11989").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                int i2 = 0;
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (akVar.threadType == 0) {
                        i2 = 1;
                    } else if (akVar.threadType == 40) {
                        i2 = 2;
                    } else if (akVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.ibT != null) {
                        PersonalizePageView.this.ibT.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.hWm = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bk) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bk) tag));
                    }
                }
            }
        };
        this.feq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.feq != i2 && PersonalizePageView.this.hWU != null) {
                    PersonalizePageView.this.feq = i2;
                    if (PersonalizePageView.this.feq == 1) {
                        PersonalizePageView.this.hWU.bre();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hWU.brf();
                    } else {
                        PersonalizePageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ceX() {
                if (PersonalizePageView.this.hWU != null) {
                    PersonalizePageView.this.feq = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hWO)) {
                        PersonalizePageView.this.hWU.brf();
                    } else {
                        PersonalizePageView.this.hWU.bre();
                    }
                }
            }
        };
        this.ici = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hgh = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_first_install", true);

            private void cfP() {
                if (this.hgh) {
                    this.hgh = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i2, int i22, int i3) {
                if (PersonalizePageView.this.ibU == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bPM = PersonalizePageView.this.bPM();
                PersonalizePageView.this.bqO();
                if (bPM) {
                    PersonalizePageView.this.fV(true);
                }
                PersonalizePageView.this.ibU.P(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.ibU != null) {
                    PersonalizePageView.this.ibU.z(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cfP();
                } else if (!this.hgh) {
                    PersonalizePageView.this.hWW.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cfP();
                    PersonalizePageView.this.ceM();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cfP();
                PersonalizePageView.this.hWW.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bqO();
                p a2 = PersonalizePageView.this.a(PersonalizePageView.this.ibV.cgc());
                PersonalizePageView.this.eL(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hps != null) {
                    PersonalizePageView.this.hps.a(a2);
                }
                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.deu().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cfQ() {
                if (PersonalizePageView.this.fbY != null) {
                    PersonalizePageView.this.fbY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fbY.endLoadData();
                    PersonalizePageView.this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.icj = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.blZ().zK("page_recommend");
                PersonalizePageView.this.ibV.update();
                PersonalizePageView.this.ibV.oj(false);
                PersonalizePageView.this.icf = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.ibs = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.ibV != null && PersonalizePageView.this.ibV.bVQ() != null) {
                    PersonalizePageView.this.ibV.bVQ().cfz();
                }
            }
        };
        this.ick = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aWz() {
                if (PersonalizePageView.this.icf) {
                    PersonalizePageView.this.hod = 0;
                    PersonalizePageView.this.epY = 1;
                    PersonalizePageView.this.icf = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.ibt = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.ibV != null) {
                    PersonalizePageView.this.ibV.oj(true);
                    PersonalizePageView.this.ibV.cfV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aNY().ka(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.icl = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cer();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bqv();
            }
        };
        this.hoG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hnT = true;
                    }
                }
            }
        };
        this.icm = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hWW != null && !PersonalizePageView.this.hWW.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ibR == null) {
                            PersonalizePageView.this.ibR = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ibR.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ibS = PersonalizePageView.this.ibR;
                            PersonalizePageView.this.cfM();
                        } else if (PersonalizePageView.this.ibS != PersonalizePageView.this.ibR) {
                            PersonalizePageView.this.ibS = PersonalizePageView.this.ibR;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ibR.setEnable(true);
                        PersonalizePageView.this.hWW.setProgressView(PersonalizePageView.this.ibR);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hWW.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ibQ == null) {
                        PersonalizePageView.this.ibQ = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ibS = PersonalizePageView.this.ibQ;
                        PersonalizePageView.this.cfM();
                    } else if (PersonalizePageView.this.ibS != PersonalizePageView.this.ibQ || !aVar.equals(PersonalizePageView.this.ibQ.cgo())) {
                        PersonalizePageView.this.ibS = PersonalizePageView.this.ibQ;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ibQ.setEnable(true);
                    PersonalizePageView.this.hWW.setProgressView(PersonalizePageView.this.ibQ);
                    PersonalizePageView.this.ibQ.a(aVar);
                    PersonalizePageView.this.hWW.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.icn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.icg != null) {
                    PersonalizePageView.this.icg.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hWO = new BdTypeRecyclerView(context);
        this.dhU = new LinearLayoutManager(this.hWO.getContext());
        this.hWO.setLayoutManager(this.dhU);
        this.hWO.setFadingEdgeLength(0);
        this.hWO.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYf = new m(new k());
            this.gYf.a(this.hWO, 2);
        }
        MessageManager.getInstance().registerListener(this.gYh);
        MessageManager.getInstance().registerListener(this.ich);
        this.hWW = new BigdaySwipeRefreshLayout(context);
        this.hWW.addView(this.hWO);
        this.fbY = new PbListView(context);
        this.fbY.getView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setLineGone();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.fbY.setOnClickListener(this.hWY);
        this.fbY.aWe();
        this.hWO.setNextPage(this.fbY);
        com.baidu.adp.base.e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        MessageManager.getInstance().registerListener(this.icm);
        com.baidu.tbadk.core.bigday.b.aNY().gJ(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aNY().ka(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.hWW);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.icg = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.icg, layoutParams);
            this.icg.setOnClickListener(this.icn);
            this.icg.setVisibility(8);
        }
        this.ibX = new com.baidu.tieba.homepage.personalize.model.e();
        this.ibT = new ab(context, this.hWO);
        this.ibT.b(this.ibX);
        this.ibV = new e(this.pageContext, this.hWO, this.ibT, this.hWW);
        this.ibW = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.hoG);
        this.ice = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(Context context) {
        if (this.ibZ == null) {
            this.ibZ = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.ibZ, layoutParams);
            this.ibZ.setVisibility(8);
            this.ibZ.setPageId(this.pageContext.getUniqueId());
            this.hps = new com.baidu.tieba.c.c(this.pageContext, this.ibZ, 1);
        }
    }

    public void cfM() {
        if (this.ibS != null) {
            this.ibS.setListPullRefreshListener(this.icj);
            this.ibS.a(this.ibs);
            this.ibS.a(this.ick);
            this.ibS.a(this.ibt);
        }
    }

    public void bwA() {
        this.ibT.b(this.iaQ);
        this.ibT.a(this.hWm);
        this.ibV.a(this.ici);
        this.ibW.a(this);
        cfM();
        this.hWO.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.hod += i2;
                if (PersonalizePageView.this.icg != null) {
                    o item = PersonalizePageView.this.hWO.getItem(PersonalizePageView.this.dhU.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.icg.show();
                        } else {
                            PersonalizePageView.this.icg.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dhU != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.hod < height * 3 || PersonalizePageView.this.epY != 1) {
                        if (PersonalizePageView.this.hod < height * 3 && PersonalizePageView.this.epY == 2) {
                            PersonalizePageView.this.epY = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.epY = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.epY)));
                    }
                    if (PersonalizePageView.this.dhU.getItemCount() - PersonalizePageView.this.dhU.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bqv();
                    }
                }
            }
        });
        this.hWO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bqv();
            }
        });
        this.hWO.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.ibY >= 5000) {
                    PersonalizePageView.this.ibV.cg(i, i2);
                }
            }
        }, 1L);
        this.hWO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.ibV != null && PersonalizePageView.this.ibV.bVQ() != null) {
                        PersonalizePageView.this.ibV.bVQ().ct(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bLU().stopPlay();
                    }
                }
            }
        });
        this.hWO.removeOnScrollListener(this.mOnScrollListener);
        this.hWO.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ibU = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fbY != null) {
            this.fbY.setText(getContext().getString(R.string.pb_load_more));
            this.fbY.endLoadData();
            this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ibV.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.ibV != null) {
            this.ibV.on(!z);
        }
        this.icd = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.icd;
    }

    public void e(Long l) {
        this.ibV.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.ibV != null) {
            this.ibV.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.ibV != null) {
            this.ibV.showFloatingView();
        }
    }

    public void cfN() {
        if (this.ibV != null) {
            this.ibV.cfN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.fkQ != null) {
                this.fkQ.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.ibR != null) {
                this.ibR.changeSkin(i);
            }
            if (this.fbY != null) {
                this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
                this.fbY.changeSkin(i);
            }
            this.ibT.onChangeSkinType(i);
            if (this.ibV != null) {
                this.ibV.onChangeSkinType(i);
            }
            if (this.icg != null) {
                this.icg.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aP(String str, int i) {
        if (this.fbY != null) {
            this.fbY.setText(getContext().getString(R.string.pb_load_more));
            this.fbY.endLoadData();
            this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ibV.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.ibV != null) {
                        PersonalizePageView.this.ibV.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this);
            this.fkQ = null;
            this.hWO.setNextPage(this.fbY);
            this.fbY.setText(getContext().getString(R.string.pb_load_more));
            this.fbY.endLoadData();
            this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.hWW != null) {
            this.hWW.setVisibility(0);
        }
        if (this.ibU != null) {
            this.ibU.ceD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(boolean z) {
        if (this.fkQ == null) {
            this.fkQ = new g(getContext());
            this.fkQ.ba(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.fkQ.bew();
            this.fkQ.setWrapStyle(true);
            this.fkQ.onChangeSkinType();
        }
        this.fkQ.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.hWO.setNextPage(null);
        if (this.hWW != null) {
            this.hWW.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ibV != null) {
            this.ibV.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.hps != null) {
            this.hps.aJZ();
        }
        setViewForeground(false);
        if (this.ibV != null) {
            this.ibV.mX(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.ice < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.icl, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ibV != null) {
            this.ibV.oc(z);
        }
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
            this.hWU.a(this.hWV);
            this.hWV.ceX();
        }
    }

    public void ceM() {
        if (this.ibV != null) {
            fV(true);
            this.ibV.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.aNY().aOa();
            com.baidu.tbadk.core.bigday.b.aNY().aNZ();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.ibV != null) {
            this.ibV.update();
        } else if (this.hWO != null && this.hWW != null) {
            showFloatingView();
            this.hWO.setSelection(0);
            if (!this.hWW.isRefreshing()) {
                if (this.ibV != null && this.ibV.bVQ() != null) {
                    this.ibV.bVQ().cfz();
                    this.ibV.oj(false);
                }
                this.hWW.setRefreshing(true);
            }
            if (this.hWV != null) {
                this.hWV.ceX();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gYh);
        MessageManager.getInstance().unRegisterListener(this.hoG);
        MessageManager.getInstance().unRegisterListener(this.icm);
        this.ibV.onDestroy();
        this.ibT.b((NEGFeedBackView.a) null);
        this.ibT.onDestroy();
        this.ibV.a((e.a) null);
        if (this.ibQ != null) {
            this.ibQ.setListPullRefreshListener(null);
            this.ibQ.a((f.d) null);
            this.ibQ.a((f.a) null);
            this.ibQ.a((f.b) null);
            this.ibQ.release();
        }
        if (this.ibR != null) {
            this.ibR.setListPullRefreshListener(null);
            this.ibR.a((f.d) null);
            this.ibR.a((f.a) null);
            this.ibR.a((f.b) null);
            this.ibR.release();
        }
        this.hWO.setOnSrollToBottomListener(null);
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
        }
        this.hWO.removeOnScrollListener(this.mOnScrollListener);
        if (this.fkQ != null) {
            this.fkQ.release();
        }
        this.hWO.setRecyclerListener(null);
        if (this.ibW != null) {
            this.ibW.onDestroy();
        }
        if (this.hps != null) {
            this.hps.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aNY().destroy();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.icl);
    }

    public void onPause() {
        this.ibV.onPause();
        if (this.ibT != null) {
            this.ibT.onPause();
        }
    }

    public void onResume() {
        if (this.hnT) {
            reload();
            this.hnT = false;
        }
        if (this.hWW != null) {
            this.hWW.resume();
        }
        if (this.ibT != null) {
            this.ibT.onResume();
        }
    }

    public void cer() {
        if (this.ibT != null) {
            this.ibT.notifyDataSetChanged();
        }
    }

    public void ces() {
        if (this.ibV != null) {
            this.ibV.mX(true);
        }
        s.bLq().jv(false);
        com.baidu.tieba.a.d.blZ().de("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.icl);
    }

    public void cfJ() {
        this.ibV.cgb();
    }

    public void cfO() {
        this.ibV.cfO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqv() {
        com.baidu.tieba.homepage.framework.a.ceC().q(System.currentTimeMillis(), 1);
        if (this.fbY != null && !this.fbY.isLoading()) {
            this.fbY.startLoadData();
            this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ibV.bqv();
    }
}
