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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ab;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.view.FloatingAnimationView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes9.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager cxE;
    private int dBv;
    private final CustomMessageListener doq;
    private PbListView eli;
    private int enA;
    private g etW;
    private BdTypeRecyclerView gWM;
    private ScrollFragmentTabHost gWS;
    ScrollFragmentTabHost.a gWT;
    private BigdaySwipeRefreshLayout gWU;
    private View.OnClickListener gWW;
    private k gai;
    private CustomMessageListener gak;
    private boolean goW;
    private CustomMessageListener gpF;
    private int gpf;
    private com.baidu.tieba.c.c gqm;
    private NEGFeedBackView.a haX;
    g.b hbA;
    private com.baidu.tieba.homepage.personalize.bigday.b hbY;
    private com.baidu.tieba.homepage.personalize.bigday.a hbZ;
    g.d hbz;
    private a hca;
    private ab hcb;
    private com.baidu.tieba.homepage.framework.b hcc;
    private e hcd;
    private com.baidu.tieba.homepage.personalize.a hce;
    private com.baidu.tieba.homepage.personalize.model.e hcf;
    private long hcg;
    private FloatingAnimationView hch;
    private boolean hci;
    private int hcj;
    private boolean hck;
    private FRSRefreshButton hcl;
    private e.a hcm;
    g.c hcn;
    g.a hco;
    private Runnable hcp;
    public CustomMessageListener hcq;
    private View.OnClickListener hcr;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void a(g.a aVar);

        void a(g.b bVar);

        void a(g.d dVar);

        void setListPullRefreshListener(g.c cVar);
    }

    static /* synthetic */ int w(PersonalizePageView personalizePageView) {
        int i = personalizePageView.hcj + 1;
        personalizePageView.hcj = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gWS = scrollFragmentTabHost;
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
            this.gWS.a(this.gWT);
        }
        if (this.hcd != null) {
            this.hcd.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hce != null) {
            this.hce.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gWU != null) {
            this.gWU.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hcb != null) {
            this.hcb.setPageUniqueId(bdUniqueId);
        }
        if (this.hcd != null) {
            this.hcd.m(bdUniqueId);
        }
        if (this.hcf != null) {
            this.hcf.h(bdUniqueId);
        }
        if (this.hbZ != null) {
            this.hbZ.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.azU().setTag(bdUniqueId);
        if (this.doq != null) {
            this.doq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.doq);
        }
        if (this.hce != null) {
            this.hce.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.aC(String.valueOf(floatInfo.activity_id));
        oVar.ee(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.Jd(floatInfo.float_url);
        oVar.Jc(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.hcg = 0L;
        this.mSkinType = 3;
        this.goW = false;
        this.hci = false;
        this.hcj = 0;
        this.gpf = 0;
        this.hck = false;
        this.dBv = 1;
        this.gak = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gai == null) {
                            PersonalizePageView.this.gai = new k(new i());
                        }
                        PersonalizePageView.this.gai.a(PersonalizePageView.this.gWM, 2);
                    } else if (PersonalizePageView.this.gai != null) {
                        PersonalizePageView.this.gai.kB();
                    }
                }
            }
        };
        this.haX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                int i = 0;
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (alVar.threadType == 0) {
                        i = 1;
                    } else if (alVar.threadType == 40) {
                        i = 2;
                    } else if (alVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.hcb != null) {
                        PersonalizePageView.this.hcb.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.enA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.enA != i && PersonalizePageView.this.gWS != null) {
                    PersonalizePageView.this.enA = i;
                    if (PersonalizePageView.this.enA == 1) {
                        PersonalizePageView.this.gWS.bcK();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gWS.bcL();
                    } else {
                        PersonalizePageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWT = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNL() {
                if (PersonalizePageView.this.gWS != null) {
                    PersonalizePageView.this.enA = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gWM)) {
                        PersonalizePageView.this.gWS.bcL();
                    } else {
                        PersonalizePageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.hcm = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghl = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_first_install", true);

            private void bOD() {
                if (this.ghl) {
                    this.ghl = false;
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hcc == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzj = PersonalizePageView.this.bzj();
                PersonalizePageView.this.bcv();
                if (bzj) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hcc.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hcc != null) {
                    PersonalizePageView.this.hcc.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOD();
                } else if (!this.ghl) {
                    PersonalizePageView.this.gWU.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOD();
                    PersonalizePageView.this.bNA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOD();
                PersonalizePageView.this.gWU.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcv();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcd.bOQ());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqm != null) {
                    PersonalizePageView.this.gqm.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOE() {
                if (PersonalizePageView.this.eli != null) {
                    PersonalizePageView.this.eli.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.eli.endLoadData();
                    PersonalizePageView.this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcn = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXD().wN("page_recommend");
                PersonalizePageView.this.hcd.update();
                PersonalizePageView.this.hcd.mD(false);
                PersonalizePageView.this.hck = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbz = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcd != null && PersonalizePageView.this.hcd.bEI() != null) {
                    PersonalizePageView.this.hcd.bEI().bOn();
                }
            }
        };
        this.hco = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHV() {
                if (PersonalizePageView.this.hck) {
                    PersonalizePageView.this.gpf = 0;
                    PersonalizePageView.this.dBv = 1;
                    PersonalizePageView.this.hck = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbA = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcd != null) {
                    PersonalizePageView.this.hcd.mD(true);
                    PersonalizePageView.this.hcd.bOJ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFB().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azU().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcp = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doq = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bNc();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gWW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcd();
            }
        };
        this.gpF = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.goW = true;
                    }
                }
            }
        };
        this.hcq = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gWU != null && !PersonalizePageView.this.gWU.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hbZ == null) {
                            PersonalizePageView.this.hbZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hbZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hca = PersonalizePageView.this.hbZ;
                            PersonalizePageView.this.bOA();
                        } else if (PersonalizePageView.this.hca != PersonalizePageView.this.hbZ) {
                            PersonalizePageView.this.hca = PersonalizePageView.this.hbZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hbZ.setEnable(true);
                        PersonalizePageView.this.gWU.setProgressView(PersonalizePageView.this.hbZ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gWU.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hbY == null) {
                        PersonalizePageView.this.hbY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hca = PersonalizePageView.this.hbY;
                        PersonalizePageView.this.bOA();
                    } else if (PersonalizePageView.this.hca != PersonalizePageView.this.hbY || !aVar.equals(PersonalizePageView.this.hbY.bPc())) {
                        PersonalizePageView.this.hca = PersonalizePageView.this.hbY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hbY.setEnable(true);
                    PersonalizePageView.this.gWU.setProgressView(PersonalizePageView.this.hbY);
                    PersonalizePageView.this.hbY.a(aVar);
                    PersonalizePageView.this.gWU.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcl != null) {
                    PersonalizePageView.this.hcl.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hcg = 0L;
        this.mSkinType = 3;
        this.goW = false;
        this.hci = false;
        this.hcj = 0;
        this.gpf = 0;
        this.hck = false;
        this.dBv = 1;
        this.gak = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gai == null) {
                            PersonalizePageView.this.gai = new k(new i());
                        }
                        PersonalizePageView.this.gai.a(PersonalizePageView.this.gWM, 2);
                    } else if (PersonalizePageView.this.gai != null) {
                        PersonalizePageView.this.gai.kB();
                    }
                }
            }
        };
        this.haX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                int i = 0;
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (alVar.threadType == 0) {
                        i = 1;
                    } else if (alVar.threadType == 40) {
                        i = 2;
                    } else if (alVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.hcb != null) {
                        PersonalizePageView.this.hcb.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.enA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.enA != i && PersonalizePageView.this.gWS != null) {
                    PersonalizePageView.this.enA = i;
                    if (PersonalizePageView.this.enA == 1) {
                        PersonalizePageView.this.gWS.bcK();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gWS.bcL();
                    } else {
                        PersonalizePageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWT = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNL() {
                if (PersonalizePageView.this.gWS != null) {
                    PersonalizePageView.this.enA = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gWM)) {
                        PersonalizePageView.this.gWS.bcL();
                    } else {
                        PersonalizePageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.hcm = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghl = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_first_install", true);

            private void bOD() {
                if (this.ghl) {
                    this.ghl = false;
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hcc == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzj = PersonalizePageView.this.bzj();
                PersonalizePageView.this.bcv();
                if (bzj) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hcc.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hcc != null) {
                    PersonalizePageView.this.hcc.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOD();
                } else if (!this.ghl) {
                    PersonalizePageView.this.gWU.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOD();
                    PersonalizePageView.this.bNA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOD();
                PersonalizePageView.this.gWU.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcv();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcd.bOQ());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqm != null) {
                    PersonalizePageView.this.gqm.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOE() {
                if (PersonalizePageView.this.eli != null) {
                    PersonalizePageView.this.eli.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.eli.endLoadData();
                    PersonalizePageView.this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcn = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXD().wN("page_recommend");
                PersonalizePageView.this.hcd.update();
                PersonalizePageView.this.hcd.mD(false);
                PersonalizePageView.this.hck = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbz = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcd != null && PersonalizePageView.this.hcd.bEI() != null) {
                    PersonalizePageView.this.hcd.bEI().bOn();
                }
            }
        };
        this.hco = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHV() {
                if (PersonalizePageView.this.hck) {
                    PersonalizePageView.this.gpf = 0;
                    PersonalizePageView.this.dBv = 1;
                    PersonalizePageView.this.hck = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbA = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcd != null) {
                    PersonalizePageView.this.hcd.mD(true);
                    PersonalizePageView.this.hcd.bOJ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFB().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azU().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcp = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doq = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bNc();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gWW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcd();
            }
        };
        this.gpF = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.goW = true;
                    }
                }
            }
        };
        this.hcq = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gWU != null && !PersonalizePageView.this.gWU.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hbZ == null) {
                            PersonalizePageView.this.hbZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hbZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hca = PersonalizePageView.this.hbZ;
                            PersonalizePageView.this.bOA();
                        } else if (PersonalizePageView.this.hca != PersonalizePageView.this.hbZ) {
                            PersonalizePageView.this.hca = PersonalizePageView.this.hbZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hbZ.setEnable(true);
                        PersonalizePageView.this.gWU.setProgressView(PersonalizePageView.this.hbZ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gWU.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hbY == null) {
                        PersonalizePageView.this.hbY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hca = PersonalizePageView.this.hbY;
                        PersonalizePageView.this.bOA();
                    } else if (PersonalizePageView.this.hca != PersonalizePageView.this.hbY || !aVar.equals(PersonalizePageView.this.hbY.bPc())) {
                        PersonalizePageView.this.hca = PersonalizePageView.this.hbY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hbY.setEnable(true);
                    PersonalizePageView.this.gWU.setProgressView(PersonalizePageView.this.hbY);
                    PersonalizePageView.this.hbY.a(aVar);
                    PersonalizePageView.this.gWU.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcl != null) {
                    PersonalizePageView.this.hcl.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hcg = 0L;
        this.mSkinType = 3;
        this.goW = false;
        this.hci = false;
        this.hcj = 0;
        this.gpf = 0;
        this.hck = false;
        this.dBv = 1;
        this.gak = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gai == null) {
                            PersonalizePageView.this.gai = new k(new i());
                        }
                        PersonalizePageView.this.gai.a(PersonalizePageView.this.gWM, 2);
                    } else if (PersonalizePageView.this.gai != null) {
                        PersonalizePageView.this.gai.kB();
                    }
                }
            }
        };
        this.haX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                int i2 = 0;
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (alVar.threadType == 0) {
                        i2 = 1;
                    } else if (alVar.threadType == 40) {
                        i2 = 2;
                    } else if (alVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.hcb != null) {
                        PersonalizePageView.this.hcb.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.enA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.enA != i2 && PersonalizePageView.this.gWS != null) {
                    PersonalizePageView.this.enA = i2;
                    if (PersonalizePageView.this.enA == 1) {
                        PersonalizePageView.this.gWS.bcK();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gWS.bcL();
                    } else {
                        PersonalizePageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWT = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNL() {
                if (PersonalizePageView.this.gWS != null) {
                    PersonalizePageView.this.enA = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gWM)) {
                        PersonalizePageView.this.gWS.bcL();
                    } else {
                        PersonalizePageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.hcm = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghl = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_first_install", true);

            private void bOD() {
                if (this.ghl) {
                    this.ghl = false;
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i2, int i22, int i3) {
                if (PersonalizePageView.this.hcc == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzj = PersonalizePageView.this.bzj();
                PersonalizePageView.this.bcv();
                if (bzj) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hcc.M(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.hcc != null) {
                    PersonalizePageView.this.hcc.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOD();
                } else if (!this.ghl) {
                    PersonalizePageView.this.gWU.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOD();
                    PersonalizePageView.this.bNA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOD();
                PersonalizePageView.this.gWU.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcv();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcd.bOQ());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqm != null) {
                    PersonalizePageView.this.gqm.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOE() {
                if (PersonalizePageView.this.eli != null) {
                    PersonalizePageView.this.eli.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.eli.endLoadData();
                    PersonalizePageView.this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcn = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXD().wN("page_recommend");
                PersonalizePageView.this.hcd.update();
                PersonalizePageView.this.hcd.mD(false);
                PersonalizePageView.this.hck = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbz = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcd != null && PersonalizePageView.this.hcd.bEI() != null) {
                    PersonalizePageView.this.hcd.bEI().bOn();
                }
            }
        };
        this.hco = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHV() {
                if (PersonalizePageView.this.hck) {
                    PersonalizePageView.this.gpf = 0;
                    PersonalizePageView.this.dBv = 1;
                    PersonalizePageView.this.hck = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbA = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcd != null) {
                    PersonalizePageView.this.hcd.mD(true);
                    PersonalizePageView.this.hcd.bOJ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFB().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azU().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcp = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doq = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bNc();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gWW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcd();
            }
        };
        this.gpF = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.goW = true;
                    }
                }
            }
        };
        this.hcq = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gWU != null && !PersonalizePageView.this.gWU.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hbZ == null) {
                            PersonalizePageView.this.hbZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hbZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hca = PersonalizePageView.this.hbZ;
                            PersonalizePageView.this.bOA();
                        } else if (PersonalizePageView.this.hca != PersonalizePageView.this.hbZ) {
                            PersonalizePageView.this.hca = PersonalizePageView.this.hbZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hbZ.setEnable(true);
                        PersonalizePageView.this.gWU.setProgressView(PersonalizePageView.this.hbZ);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gWU.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hbY == null) {
                        PersonalizePageView.this.hbY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hca = PersonalizePageView.this.hbY;
                        PersonalizePageView.this.bOA();
                    } else if (PersonalizePageView.this.hca != PersonalizePageView.this.hbY || !aVar.equals(PersonalizePageView.this.hbY.bPc())) {
                        PersonalizePageView.this.hca = PersonalizePageView.this.hbY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hbY.setEnable(true);
                    PersonalizePageView.this.gWU.setProgressView(PersonalizePageView.this.hbY);
                    PersonalizePageView.this.hbY.a(aVar);
                    PersonalizePageView.this.gWU.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcl != null) {
                    PersonalizePageView.this.hcl.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gWM = new BdTypeRecyclerView(context);
        this.cxE = new LinearLayoutManager(this.gWM.getContext());
        this.gWM.setLayoutManager(this.cxE);
        this.gWM.setFadingEdgeLength(0);
        this.gWM.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gai = new k(new i());
            this.gai.a(this.gWM, 2);
        }
        MessageManager.getInstance().registerListener(this.gak);
        this.gWU = new BigdaySwipeRefreshLayout(context);
        this.gWU.addView(this.gWM);
        this.eli = new PbListView(context);
        this.eli.getView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setLineGone();
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.eli.setOnClickListener(this.gWW);
        this.eli.aHE();
        this.gWM.setNextPage(this.eli);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.hcq);
        com.baidu.tbadk.core.bigday.b.azU().ft(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFB().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.azU().jt(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gWU);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.hcl = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.hcl, layoutParams);
            this.hcl.setOnClickListener(this.hcr);
            this.hcl.setVisibility(8);
        }
        this.hcf = new com.baidu.tieba.homepage.personalize.model.e();
        this.hcb = new ab(context, this.gWM);
        this.hcb.b(this.hcf);
        this.hcd = new e(this.pageContext, this.gWM, this.hcb, this.gWU);
        this.hce = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gpF);
        this.hcj = com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(Context context) {
        if (this.hch == null) {
            this.hch = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.hch, layoutParams);
            this.hch.setVisibility(8);
            this.hch.setPageId(this.pageContext.getUniqueId());
            this.gqm = new com.baidu.tieba.c.c(this.pageContext, this.hch, 1);
        }
    }

    public void bOA() {
        if (this.hca != null) {
            this.hca.setListPullRefreshListener(this.hcn);
            this.hca.a(this.hbz);
            this.hca.a(this.hco);
            this.hca.a(this.hbA);
        }
    }

    public void initListeners() {
        this.hcb.b(this.haX);
        this.hcd.a(this.hcm);
        this.hce.a(this);
        bOA();
        this.gWM.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gpf += i2;
                if (PersonalizePageView.this.hcl != null) {
                    m item = PersonalizePageView.this.gWM.getItem(PersonalizePageView.this.cxE.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.hcl.show();
                        } else {
                            PersonalizePageView.this.hcl.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.cxE != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gpf < height * 3 || PersonalizePageView.this.dBv != 1) {
                        if (PersonalizePageView.this.gpf < height * 3 && PersonalizePageView.this.dBv == 2) {
                            PersonalizePageView.this.dBv = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.dBv = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.dBv)));
                    }
                    if (PersonalizePageView.this.cxE.getItemCount() - PersonalizePageView.this.cxE.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bcd();
                    }
                }
            }
        });
        this.gWM.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bcd();
            }
        });
        this.gWM.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.hcg >= 5000) {
                    PersonalizePageView.this.hcd.bU(i, i2);
                }
            }
        }, 1L);
        this.gWM.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.hcd != null && PersonalizePageView.this.hcd.bEI() != null) {
                        PersonalizePageView.this.hcd.bEI().cl(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).bvI().stopPlay();
                    }
                }
            }
        });
        this.gWM.removeOnScrollListener(this.mOnScrollListener);
        this.gWM.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hcc = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.eli != null) {
            this.eli.setText(getContext().getString(R.string.pb_load_more));
            this.eli.endLoadData();
            this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcd.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.hcd != null) {
            this.hcd.mH(!z);
        }
        this.hci = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.hci;
    }

    public void e(Long l) {
        this.hcd.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hcd != null) {
            this.hcd.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.hcd != null) {
            this.hcd.showFloatingView();
        }
    }

    public void bOB() {
        if (this.hcd != null) {
            this.hcd.bOB();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.etW != null) {
                this.etW.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hbZ != null) {
                this.hbZ.changeSkin(i);
            }
            if (this.eli != null) {
                this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
                this.eli.changeSkin(i);
            }
            this.hcb.onChangeSkinType(i);
            if (this.hcd != null) {
                this.hcd.onChangeSkinType(i);
            }
            if (this.hcl != null) {
                this.hcl.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aE(String str, int i) {
        if (this.eli != null) {
            this.eli.setText(getContext().getString(R.string.pb_load_more));
            this.eli.endLoadData();
            this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcd.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.hcd != null) {
                        PersonalizePageView.this.hcd.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcv() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this);
            this.etW = null;
            this.gWM.setNextPage(this.eli);
            this.eli.setText(getContext().getString(R.string.pb_load_more));
            this.eli.endLoadData();
            this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.gWU != null) {
            this.gWU.setVisibility(0);
        }
        if (this.hcc != null) {
            this.hcc.bNr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (this.etW == null) {
            this.etW = new com.baidu.tbadk.k.g(getContext());
            this.etW.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.etW.aPR();
            this.etW.setWrapStyle(true);
            this.etW.onChangeSkinType();
        }
        this.etW.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.gWM.setNextPage(null);
        if (this.gWU != null) {
            this.gWU.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.hcd != null) {
            this.hcd.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.gqm != null) {
            this.gqm.baA();
        }
        setViewForeground(false);
        if (this.hcd != null) {
            this.hcd.lt(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.hcj < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hcp, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hcd != null) {
            this.hcd.mx(z);
        }
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
            this.gWS.a(this.gWT);
            this.gWT.bNL();
        }
    }

    public void bNA() {
        if (this.hcd != null) {
            eM(true);
            this.hcd.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.azU().azW();
            com.baidu.tbadk.core.bigday.b.azU().azV();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.hcd != null) {
            this.hcd.update();
        } else if (this.gWM != null && this.gWU != null) {
            showFloatingView();
            this.gWM.setSelection(0);
            if (!this.gWU.isRefreshing()) {
                if (this.hcd != null && this.hcd.bEI() != null) {
                    this.hcd.bEI().bOn();
                    this.hcd.mD(false);
                }
                this.gWU.setRefreshing(true);
            }
            if (this.gWT != null) {
                this.gWT.bNL();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gak);
        MessageManager.getInstance().unRegisterListener(this.gpF);
        MessageManager.getInstance().unRegisterListener(this.hcq);
        this.hcd.onDestroy();
        this.hcb.b((NEGFeedBackView.a) null);
        this.hcb.onDestroy();
        this.hcd.a((e.a) null);
        if (this.hbY != null) {
            this.hbY.setListPullRefreshListener(null);
            this.hbY.a((g.d) null);
            this.hbY.a((g.a) null);
            this.hbY.a((g.b) null);
            this.hbY.release();
        }
        if (this.hbZ != null) {
            this.hbZ.setListPullRefreshListener(null);
            this.hbZ.a((g.d) null);
            this.hbZ.a((g.a) null);
            this.hbZ.a((g.b) null);
            this.hbZ.release();
        }
        this.gWM.setOnSrollToBottomListener(null);
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
        }
        this.gWM.removeOnScrollListener(this.mOnScrollListener);
        if (this.etW != null) {
            this.etW.release();
        }
        this.gWM.setRecyclerListener(null);
        if (this.hce != null) {
            this.hce.onDestroy();
        }
        if (this.gqm != null) {
            this.gqm.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.azU().destroy();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hcp);
    }

    public void onPause() {
        this.hcd.onPause();
        if (this.hcb != null) {
            this.hcb.onPause();
        }
    }

    public void onResume() {
        if (this.goW) {
            reload();
            this.goW = false;
        }
        if (this.gWU != null) {
            this.gWU.resume();
        }
        if (this.hcb != null) {
            this.hcb.onResume();
        }
    }

    public void bNc() {
        if (this.hcb != null) {
            this.hcb.notifyDataSetChanged();
        }
    }

    public void bNd() {
        if (this.hcd != null) {
            this.hcd.lt(true);
        }
        r.bve().ib(false);
        com.baidu.tieba.a.d.aXD().cv("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hcp);
    }

    public void bOx() {
        this.hcd.bOP();
    }

    public void bOC() {
        this.hcd.bOC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        com.baidu.tieba.homepage.framework.a.bNq().q(System.currentTimeMillis(), 1);
        if (this.eli != null && !this.eli.isLoading()) {
            this.eli.startLoadData();
            this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcd.bcd();
    }
}
