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
    private LinearLayoutManager cxF;
    private int dBw;
    private final CustomMessageListener dor;
    private PbListView elj;
    private int enB;
    private g etX;
    private BdTypeRecyclerView gWO;
    private ScrollFragmentTabHost gWU;
    ScrollFragmentTabHost.a gWV;
    private BigdaySwipeRefreshLayout gWW;
    private View.OnClickListener gWY;
    private k gak;
    private CustomMessageListener gam;
    private boolean goY;
    private CustomMessageListener gpH;
    private int gph;
    private com.baidu.tieba.c.c gqo;
    private NEGFeedBackView.a haZ;
    g.d hbB;
    g.b hbC;
    private com.baidu.tieba.homepage.personalize.bigday.b hca;
    private com.baidu.tieba.homepage.personalize.bigday.a hcb;
    private a hcc;
    private ab hcd;
    private com.baidu.tieba.homepage.framework.b hce;
    private e hcf;
    private com.baidu.tieba.homepage.personalize.a hcg;
    private com.baidu.tieba.homepage.personalize.model.e hch;
    private long hci;
    private FloatingAnimationView hcj;
    private boolean hck;
    private int hcl;
    private boolean hcm;
    private FRSRefreshButton hcn;
    private e.a hco;
    g.c hcp;
    g.a hcq;
    private Runnable hcr;
    public CustomMessageListener hcs;
    private View.OnClickListener hct;
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
        int i = personalizePageView.hcl + 1;
        personalizePageView.hcl = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gWU = scrollFragmentTabHost;
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
            this.gWU.a(this.gWV);
        }
        if (this.hcf != null) {
            this.hcf.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hcg != null) {
            this.hcg.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gWW != null) {
            this.gWW.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hcd != null) {
            this.hcd.setPageUniqueId(bdUniqueId);
        }
        if (this.hcf != null) {
            this.hcf.m(bdUniqueId);
        }
        if (this.hch != null) {
            this.hch.h(bdUniqueId);
        }
        if (this.hcb != null) {
            this.hcb.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.azW().setTag(bdUniqueId);
        if (this.dor != null) {
            this.dor.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dor);
        }
        if (this.hcg != null) {
            this.hcg.setBdUniqueId(bdUniqueId);
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
        this.hci = 0L;
        this.mSkinType = 3;
        this.goY = false;
        this.hck = false;
        this.hcl = 0;
        this.gph = 0;
        this.hcm = false;
        this.dBw = 1;
        this.gam = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gak == null) {
                            PersonalizePageView.this.gak = new k(new i());
                        }
                        PersonalizePageView.this.gak.a(PersonalizePageView.this.gWO, 2);
                    } else if (PersonalizePageView.this.gak != null) {
                        PersonalizePageView.this.gak.kB();
                    }
                }
            }
        };
        this.haZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.hcd != null) {
                        PersonalizePageView.this.hcd.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.enB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.enB != i && PersonalizePageView.this.gWU != null) {
                    PersonalizePageView.this.enB = i;
                    if (PersonalizePageView.this.enB == 1) {
                        PersonalizePageView.this.gWU.bcM();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gWU.bcN();
                    } else {
                        PersonalizePageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNN() {
                if (PersonalizePageView.this.gWU != null) {
                    PersonalizePageView.this.enB = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gWO)) {
                        PersonalizePageView.this.gWU.bcN();
                    } else {
                        PersonalizePageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.hco = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghn = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_first_install", true);

            private void bOF() {
                if (this.ghn) {
                    this.ghn = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hce == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzl = PersonalizePageView.this.bzl();
                PersonalizePageView.this.bcx();
                if (bzl) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hce.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hce != null) {
                    PersonalizePageView.this.hce.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOF();
                } else if (!this.ghn) {
                    PersonalizePageView.this.gWW.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOF();
                    PersonalizePageView.this.bNC();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOF();
                PersonalizePageView.this.gWW.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcx();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcf.bOS());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqo != null) {
                    PersonalizePageView.this.gqo.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOG() {
                if (PersonalizePageView.this.elj != null) {
                    PersonalizePageView.this.elj.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elj.endLoadData();
                    PersonalizePageView.this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcp = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXF().wN("page_recommend");
                PersonalizePageView.this.hcf.update();
                PersonalizePageView.this.hcf.mD(false);
                PersonalizePageView.this.hcm = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbB = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcf != null && PersonalizePageView.this.hcf.bEK() != null) {
                    PersonalizePageView.this.hcf.bEK().bOp();
                }
            }
        };
        this.hcq = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHX() {
                if (PersonalizePageView.this.hcm) {
                    PersonalizePageView.this.gph = 0;
                    PersonalizePageView.this.dBw = 1;
                    PersonalizePageView.this.hcm = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbC = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcf != null) {
                    PersonalizePageView.this.hcf.mD(true);
                    PersonalizePageView.this.hcf.bOL();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcr = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dor = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bNe();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcf();
            }
        };
        this.gpH = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.goY = true;
                    }
                }
            }
        };
        this.hcs = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gWW != null && !PersonalizePageView.this.gWW.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hcb == null) {
                            PersonalizePageView.this.hcb = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hcb.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hcc = PersonalizePageView.this.hcb;
                            PersonalizePageView.this.bOC();
                        } else if (PersonalizePageView.this.hcc != PersonalizePageView.this.hcb) {
                            PersonalizePageView.this.hcc = PersonalizePageView.this.hcb;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hcb.setEnable(true);
                        PersonalizePageView.this.gWW.setProgressView(PersonalizePageView.this.hcb);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gWW.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hca == null) {
                        PersonalizePageView.this.hca = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hcc = PersonalizePageView.this.hca;
                        PersonalizePageView.this.bOC();
                    } else if (PersonalizePageView.this.hcc != PersonalizePageView.this.hca || !aVar.equals(PersonalizePageView.this.hca.bPe())) {
                        PersonalizePageView.this.hcc = PersonalizePageView.this.hca;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hca.setEnable(true);
                    PersonalizePageView.this.gWW.setProgressView(PersonalizePageView.this.hca);
                    PersonalizePageView.this.hca.a(aVar);
                    PersonalizePageView.this.gWW.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hct = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcn != null) {
                    PersonalizePageView.this.hcn.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hci = 0L;
        this.mSkinType = 3;
        this.goY = false;
        this.hck = false;
        this.hcl = 0;
        this.gph = 0;
        this.hcm = false;
        this.dBw = 1;
        this.gam = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gak == null) {
                            PersonalizePageView.this.gak = new k(new i());
                        }
                        PersonalizePageView.this.gak.a(PersonalizePageView.this.gWO, 2);
                    } else if (PersonalizePageView.this.gak != null) {
                        PersonalizePageView.this.gak.kB();
                    }
                }
            }
        };
        this.haZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.hcd != null) {
                        PersonalizePageView.this.hcd.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.enB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.enB != i && PersonalizePageView.this.gWU != null) {
                    PersonalizePageView.this.enB = i;
                    if (PersonalizePageView.this.enB == 1) {
                        PersonalizePageView.this.gWU.bcM();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gWU.bcN();
                    } else {
                        PersonalizePageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNN() {
                if (PersonalizePageView.this.gWU != null) {
                    PersonalizePageView.this.enB = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gWO)) {
                        PersonalizePageView.this.gWU.bcN();
                    } else {
                        PersonalizePageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.hco = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghn = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_first_install", true);

            private void bOF() {
                if (this.ghn) {
                    this.ghn = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hce == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzl = PersonalizePageView.this.bzl();
                PersonalizePageView.this.bcx();
                if (bzl) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hce.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hce != null) {
                    PersonalizePageView.this.hce.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOF();
                } else if (!this.ghn) {
                    PersonalizePageView.this.gWW.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOF();
                    PersonalizePageView.this.bNC();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOF();
                PersonalizePageView.this.gWW.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcx();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcf.bOS());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqo != null) {
                    PersonalizePageView.this.gqo.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOG() {
                if (PersonalizePageView.this.elj != null) {
                    PersonalizePageView.this.elj.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elj.endLoadData();
                    PersonalizePageView.this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcp = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXF().wN("page_recommend");
                PersonalizePageView.this.hcf.update();
                PersonalizePageView.this.hcf.mD(false);
                PersonalizePageView.this.hcm = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbB = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcf != null && PersonalizePageView.this.hcf.bEK() != null) {
                    PersonalizePageView.this.hcf.bEK().bOp();
                }
            }
        };
        this.hcq = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHX() {
                if (PersonalizePageView.this.hcm) {
                    PersonalizePageView.this.gph = 0;
                    PersonalizePageView.this.dBw = 1;
                    PersonalizePageView.this.hcm = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbC = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcf != null) {
                    PersonalizePageView.this.hcf.mD(true);
                    PersonalizePageView.this.hcf.bOL();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcr = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dor = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bNe();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcf();
            }
        };
        this.gpH = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.goY = true;
                    }
                }
            }
        };
        this.hcs = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gWW != null && !PersonalizePageView.this.gWW.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hcb == null) {
                            PersonalizePageView.this.hcb = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hcb.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hcc = PersonalizePageView.this.hcb;
                            PersonalizePageView.this.bOC();
                        } else if (PersonalizePageView.this.hcc != PersonalizePageView.this.hcb) {
                            PersonalizePageView.this.hcc = PersonalizePageView.this.hcb;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hcb.setEnable(true);
                        PersonalizePageView.this.gWW.setProgressView(PersonalizePageView.this.hcb);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gWW.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hca == null) {
                        PersonalizePageView.this.hca = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hcc = PersonalizePageView.this.hca;
                        PersonalizePageView.this.bOC();
                    } else if (PersonalizePageView.this.hcc != PersonalizePageView.this.hca || !aVar.equals(PersonalizePageView.this.hca.bPe())) {
                        PersonalizePageView.this.hcc = PersonalizePageView.this.hca;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hca.setEnable(true);
                    PersonalizePageView.this.gWW.setProgressView(PersonalizePageView.this.hca);
                    PersonalizePageView.this.hca.a(aVar);
                    PersonalizePageView.this.gWW.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hct = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcn != null) {
                    PersonalizePageView.this.hcn.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hci = 0L;
        this.mSkinType = 3;
        this.goY = false;
        this.hck = false;
        this.hcl = 0;
        this.gph = 0;
        this.hcm = false;
        this.dBw = 1;
        this.gam = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gak == null) {
                            PersonalizePageView.this.gak = new k(new i());
                        }
                        PersonalizePageView.this.gak.a(PersonalizePageView.this.gWO, 2);
                    } else if (PersonalizePageView.this.gak != null) {
                        PersonalizePageView.this.gak.kB();
                    }
                }
            }
        };
        this.haZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.hcd != null) {
                        PersonalizePageView.this.hcd.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.enB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.enB != i2 && PersonalizePageView.this.gWU != null) {
                    PersonalizePageView.this.enB = i2;
                    if (PersonalizePageView.this.enB == 1) {
                        PersonalizePageView.this.gWU.bcM();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gWU.bcN();
                    } else {
                        PersonalizePageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNN() {
                if (PersonalizePageView.this.gWU != null) {
                    PersonalizePageView.this.enB = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gWO)) {
                        PersonalizePageView.this.gWU.bcN();
                    } else {
                        PersonalizePageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.hco = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghn = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_first_install", true);

            private void bOF() {
                if (this.ghn) {
                    this.ghn = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i2, int i22, int i3) {
                if (PersonalizePageView.this.hce == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzl = PersonalizePageView.this.bzl();
                PersonalizePageView.this.bcx();
                if (bzl) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hce.M(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.hce != null) {
                    PersonalizePageView.this.hce.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOF();
                } else if (!this.ghn) {
                    PersonalizePageView.this.gWW.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOF();
                    PersonalizePageView.this.bNC();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOF();
                PersonalizePageView.this.gWW.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcx();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcf.bOS());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqo != null) {
                    PersonalizePageView.this.gqo.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOG() {
                if (PersonalizePageView.this.elj != null) {
                    PersonalizePageView.this.elj.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elj.endLoadData();
                    PersonalizePageView.this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcp = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXF().wN("page_recommend");
                PersonalizePageView.this.hcf.update();
                PersonalizePageView.this.hcf.mD(false);
                PersonalizePageView.this.hcm = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbB = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcf != null && PersonalizePageView.this.hcf.bEK() != null) {
                    PersonalizePageView.this.hcf.bEK().bOp();
                }
            }
        };
        this.hcq = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHX() {
                if (PersonalizePageView.this.hcm) {
                    PersonalizePageView.this.gph = 0;
                    PersonalizePageView.this.dBw = 1;
                    PersonalizePageView.this.hcm = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbC = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcf != null) {
                    PersonalizePageView.this.hcf.mD(true);
                    PersonalizePageView.this.hcf.bOL();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcr = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dor = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bNe();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcf();
            }
        };
        this.gpH = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.goY = true;
                    }
                }
            }
        };
        this.hcs = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gWW != null && !PersonalizePageView.this.gWW.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hcb == null) {
                            PersonalizePageView.this.hcb = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hcb.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hcc = PersonalizePageView.this.hcb;
                            PersonalizePageView.this.bOC();
                        } else if (PersonalizePageView.this.hcc != PersonalizePageView.this.hcb) {
                            PersonalizePageView.this.hcc = PersonalizePageView.this.hcb;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hcb.setEnable(true);
                        PersonalizePageView.this.gWW.setProgressView(PersonalizePageView.this.hcb);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gWW.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hca == null) {
                        PersonalizePageView.this.hca = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hcc = PersonalizePageView.this.hca;
                        PersonalizePageView.this.bOC();
                    } else if (PersonalizePageView.this.hcc != PersonalizePageView.this.hca || !aVar.equals(PersonalizePageView.this.hca.bPe())) {
                        PersonalizePageView.this.hcc = PersonalizePageView.this.hca;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hca.setEnable(true);
                    PersonalizePageView.this.gWW.setProgressView(PersonalizePageView.this.hca);
                    PersonalizePageView.this.hca.a(aVar);
                    PersonalizePageView.this.gWW.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hct = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcn != null) {
                    PersonalizePageView.this.hcn.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gWO = new BdTypeRecyclerView(context);
        this.cxF = new LinearLayoutManager(this.gWO.getContext());
        this.gWO.setLayoutManager(this.cxF);
        this.gWO.setFadingEdgeLength(0);
        this.gWO.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gak = new k(new i());
            this.gak.a(this.gWO, 2);
        }
        MessageManager.getInstance().registerListener(this.gam);
        this.gWW = new BigdaySwipeRefreshLayout(context);
        this.gWW.addView(this.gWO);
        this.elj = new PbListView(context);
        this.elj.getView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setLineGone();
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.elj.setOnClickListener(this.gWY);
        this.elj.aHG();
        this.gWO.setNextPage(this.elj);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.hcs);
        com.baidu.tbadk.core.bigday.b.azW().ft(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gWW);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.hcn = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.hcn, layoutParams);
            this.hcn.setOnClickListener(this.hct);
            this.hcn.setVisibility(8);
        }
        this.hch = new com.baidu.tieba.homepage.personalize.model.e();
        this.hcd = new ab(context, this.gWO);
        this.hcd.b(this.hch);
        this.hcf = new e(this.pageContext, this.gWO, this.hcd, this.gWW);
        this.hcg = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gpH);
        this.hcl = com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(Context context) {
        if (this.hcj == null) {
            this.hcj = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.hcj, layoutParams);
            this.hcj.setVisibility(8);
            this.hcj.setPageId(this.pageContext.getUniqueId());
            this.gqo = new com.baidu.tieba.c.c(this.pageContext, this.hcj, 1);
        }
    }

    public void bOC() {
        if (this.hcc != null) {
            this.hcc.setListPullRefreshListener(this.hcp);
            this.hcc.a(this.hbB);
            this.hcc.a(this.hcq);
            this.hcc.a(this.hbC);
        }
    }

    public void initListeners() {
        this.hcd.b(this.haZ);
        this.hcf.a(this.hco);
        this.hcg.a(this);
        bOC();
        this.gWO.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gph += i2;
                if (PersonalizePageView.this.hcn != null) {
                    m item = PersonalizePageView.this.gWO.getItem(PersonalizePageView.this.cxF.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.hcn.show();
                        } else {
                            PersonalizePageView.this.hcn.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.cxF != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gph < height * 3 || PersonalizePageView.this.dBw != 1) {
                        if (PersonalizePageView.this.gph < height * 3 && PersonalizePageView.this.dBw == 2) {
                            PersonalizePageView.this.dBw = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.dBw = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.dBw)));
                    }
                    if (PersonalizePageView.this.cxF.getItemCount() - PersonalizePageView.this.cxF.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bcf();
                    }
                }
            }
        });
        this.gWO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bcf();
            }
        });
        this.gWO.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.hci >= 5000) {
                    PersonalizePageView.this.hcf.bU(i, i2);
                }
            }
        }, 1L);
        this.gWO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.hcf != null && PersonalizePageView.this.hcf.bEK() != null) {
                        PersonalizePageView.this.hcf.bEK().cl(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).bvK().stopPlay();
                    }
                }
            }
        });
        this.gWO.removeOnScrollListener(this.mOnScrollListener);
        this.gWO.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hce = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.elj != null) {
            this.elj.setText(getContext().getString(R.string.pb_load_more));
            this.elj.endLoadData();
            this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcf.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.hcf != null) {
            this.hcf.mH(!z);
        }
        this.hck = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.hck;
    }

    public void e(Long l) {
        this.hcf.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hcf != null) {
            this.hcf.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.hcf != null) {
            this.hcf.showFloatingView();
        }
    }

    public void bOD() {
        if (this.hcf != null) {
            this.hcf.bOD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.etX != null) {
                this.etX.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hcb != null) {
                this.hcb.changeSkin(i);
            }
            if (this.elj != null) {
                this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
                this.elj.changeSkin(i);
            }
            this.hcd.onChangeSkinType(i);
            if (this.hcf != null) {
                this.hcf.onChangeSkinType(i);
            }
            if (this.hcn != null) {
                this.hcn.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aE(String str, int i) {
        if (this.elj != null) {
            this.elj.setText(getContext().getString(R.string.pb_load_more));
            this.elj.endLoadData();
            this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcf.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.hcf != null) {
                        PersonalizePageView.this.hcf.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this);
            this.etX = null;
            this.gWO.setNextPage(this.elj);
            this.elj.setText(getContext().getString(R.string.pb_load_more));
            this.elj.endLoadData();
            this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.gWW != null) {
            this.gWW.setVisibility(0);
        }
        if (this.hce != null) {
            this.hce.bNt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzl() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (this.etX == null) {
            this.etX = new com.baidu.tbadk.k.g(getContext());
            this.etX.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.etX.aPT();
            this.etX.setWrapStyle(true);
            this.etX.onChangeSkinType();
        }
        this.etX.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.gWO.setNextPage(null);
        if (this.gWW != null) {
            this.gWW.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.hcf != null) {
            this.hcf.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.gqo != null) {
            this.gqo.baC();
        }
        setViewForeground(false);
        if (this.hcf != null) {
            this.hcf.lt(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.hcl < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hcr, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hcf != null) {
            this.hcf.mx(z);
        }
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
            this.gWU.a(this.gWV);
            this.gWV.bNN();
        }
    }

    public void bNC() {
        if (this.hcf != null) {
            eM(true);
            this.hcf.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.azW().azY();
            com.baidu.tbadk.core.bigday.b.azW().azX();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.hcf != null) {
            this.hcf.update();
        } else if (this.gWO != null && this.gWW != null) {
            showFloatingView();
            this.gWO.setSelection(0);
            if (!this.gWW.isRefreshing()) {
                if (this.hcf != null && this.hcf.bEK() != null) {
                    this.hcf.bEK().bOp();
                    this.hcf.mD(false);
                }
                this.gWW.setRefreshing(true);
            }
            if (this.gWV != null) {
                this.gWV.bNN();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gam);
        MessageManager.getInstance().unRegisterListener(this.gpH);
        MessageManager.getInstance().unRegisterListener(this.hcs);
        this.hcf.onDestroy();
        this.hcd.b((NEGFeedBackView.a) null);
        this.hcd.onDestroy();
        this.hcf.a((e.a) null);
        if (this.hca != null) {
            this.hca.setListPullRefreshListener(null);
            this.hca.a((g.d) null);
            this.hca.a((g.a) null);
            this.hca.a((g.b) null);
            this.hca.release();
        }
        if (this.hcb != null) {
            this.hcb.setListPullRefreshListener(null);
            this.hcb.a((g.d) null);
            this.hcb.a((g.a) null);
            this.hcb.a((g.b) null);
            this.hcb.release();
        }
        this.gWO.setOnSrollToBottomListener(null);
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
        }
        this.gWO.removeOnScrollListener(this.mOnScrollListener);
        if (this.etX != null) {
            this.etX.release();
        }
        this.gWO.setRecyclerListener(null);
        if (this.hcg != null) {
            this.hcg.onDestroy();
        }
        if (this.gqo != null) {
            this.gqo.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.azW().destroy();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hcr);
    }

    public void onPause() {
        this.hcf.onPause();
        if (this.hcd != null) {
            this.hcd.onPause();
        }
    }

    public void onResume() {
        if (this.goY) {
            reload();
            this.goY = false;
        }
        if (this.gWW != null) {
            this.gWW.resume();
        }
        if (this.hcd != null) {
            this.hcd.onResume();
        }
    }

    public void bNe() {
        if (this.hcd != null) {
            this.hcd.notifyDataSetChanged();
        }
    }

    public void bNf() {
        if (this.hcf != null) {
            this.hcf.lt(true);
        }
        r.bvg().ib(false);
        com.baidu.tieba.a.d.aXF().cv("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hcr);
    }

    public void bOz() {
        this.hcf.bOR();
    }

    public void bOE() {
        this.hcf.bOE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcf() {
        com.baidu.tieba.homepage.framework.a.bNs().q(System.currentTimeMillis(), 1);
        if (this.elj != null && !this.elj.isLoading()) {
            this.elj.startLoadData();
            this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcf.bcf();
    }
}
