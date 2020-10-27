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
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ag;
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
    private LinearLayoutManager dZe;
    private final CustomMessageListener eZe;
    private int fnl;
    private PbListView gdy;
    private int gga;
    private com.baidu.tbadk.k.g gmB;
    private boolean iCg;
    private int iCq;
    private CustomMessageListener iDf;
    private n imm;
    private CustomMessageListener imo;
    private FollowUserButton.a joC;
    private ScrollFragmentTabHost jpD;
    ScrollFragmentTabHost.a jpE;
    private BigdaySwipeRefreshLayout jpF;
    private View.OnClickListener jpH;
    private BdTypeRecyclerView jpx;
    private NEGFeedBackView.a juC;
    f.d jve;
    f.b jvf;
    private com.baidu.tieba.homepage.personalize.bigday.b jwL;
    private com.baidu.tieba.homepage.personalize.bigday.a jwM;
    private a jwN;
    private ag jwO;
    private com.baidu.tieba.homepage.framework.b jwP;
    private e jwQ;
    private com.baidu.tieba.homepage.personalize.a jwR;
    private com.baidu.tieba.homepage.personalize.model.e jwS;
    private long jwT;
    private int jwU;
    private boolean jwV;
    private boolean jwW;
    private boolean jwX;
    private int jwY;
    private boolean jwZ;
    private FRSRefreshButton jxa;
    private CustomMessageListener jxb;
    private e.a jxc;
    f.c jxd;
    f.a jxe;
    private Runnable jxf;
    public CustomMessageListener jxg;
    private View.OnClickListener jxh;
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
        int i = personalizePageView.jwY + 1;
        personalizePageView.jwY = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jpD = scrollFragmentTabHost;
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
            this.jpD.a(this.jpE);
        }
        if (this.jwQ != null) {
            this.jwQ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jwR != null) {
            this.jwR.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jpF != null) {
            this.jpF.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jwO != null) {
            this.jwO.setPageUniqueId(bdUniqueId);
        }
        if (this.jwQ != null) {
            this.jwQ.o(bdUniqueId);
        }
        if (this.jwS != null) {
            this.jwS.i(bdUniqueId);
        }
        if (this.jwM != null) {
            this.jwM.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bhp().setTag(bdUniqueId);
        if (this.eZe != null) {
            this.eZe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eZe);
        }
        if (this.jwR != null) {
            this.jwR.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.jwT = 0L;
        this.mSkinType = 3;
        this.iCg = false;
        this.jwU = 0;
        this.jwV = true;
        this.jwW = false;
        this.jwX = false;
        this.jwY = 0;
        this.iCq = 0;
        this.jwZ = false;
        this.fnl = 1;
        this.imo = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.imm == null) {
                            PersonalizePageView.this.imm = new n(new l());
                        }
                        PersonalizePageView.this.imm.a(PersonalizePageView.this.jpx, 2);
                    } else if (PersonalizePageView.this.imm != null) {
                        PersonalizePageView.this.imm.rh();
                    }
                }
            }
        };
        this.jxb = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jwQ != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bmU().bmV(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.juC = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jwO != null) {
                        PersonalizePageView.this.jwO.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.joC = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.gga = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gga != i && PersonalizePageView.this.jpD != null) {
                    PersonalizePageView.this.gga = i;
                    if (PersonalizePageView.this.gga == 1) {
                        PersonalizePageView.this.jpD.bMQ();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jpD.bMR();
                    } else {
                        PersonalizePageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpE = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cHk() {
                if (PersonalizePageView.this.jpD != null) {
                    PersonalizePageView.this.gga = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jpx)) {
                        PersonalizePageView.this.jpD.bMR();
                    } else {
                        PersonalizePageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jxc = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean iuh = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_first_install", true);

            private void cIo() {
                if (this.iuh) {
                    this.iuh = false;
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void S(int i, int i2, int i3) {
                if (PersonalizePageView.this.jwP == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cki = PersonalizePageView.this.cki();
                PersonalizePageView.this.TK();
                if (cki) {
                    PersonalizePageView.this.hA(true);
                }
                PersonalizePageView.this.jwP.R(i, i2, i3);
                q.bem().ben();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void C(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jwP != null) {
                    PersonalizePageView.this.jwP.B(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cIo();
                } else if (!this.iuh) {
                    PersonalizePageView.this.jpF.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cIo();
                    PersonalizePageView.this.cGU();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cIo();
                PersonalizePageView.this.jpF.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.TK();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dIs().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cIp() {
                if (PersonalizePageView.this.gdy != null) {
                    PersonalizePageView.this.gdy.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gdy.endLoadData();
                    PersonalizePageView.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jxd = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bGs().EK("page_recommend");
                PersonalizePageView.this.jwQ.update();
                PersonalizePageView.this.jwQ.qM(false);
                PersonalizePageView.this.jwZ = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jve = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jwQ != null && PersonalizePageView.this.jwQ.cwN() != null) {
                    PersonalizePageView.this.jwQ.cwN().cHM();
                }
            }
        };
        this.jxe = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bqm() {
                if (PersonalizePageView.this.jwZ) {
                    PersonalizePageView.this.iCq = 0;
                    PersonalizePageView.this.fnl = 1;
                    PersonalizePageView.this.jwZ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jvf = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jwQ != null) {
                    PersonalizePageView.this.jwQ.qM(true);
                    PersonalizePageView.this.jwQ.cIu();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bnH().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bhp().nG(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.jxf = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eZe = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cGe();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jpH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bMi();
            }
        };
        this.iDf = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iCg = true;
                    }
                }
            }
        };
        this.jxg = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jpF != null && !PersonalizePageView.this.jpF.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jwM == null) {
                            PersonalizePageView.this.jwM = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jwM.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jwN = PersonalizePageView.this.jwM;
                            PersonalizePageView.this.cIk();
                        } else if (PersonalizePageView.this.jwN != PersonalizePageView.this.jwM) {
                            PersonalizePageView.this.jwN = PersonalizePageView.this.jwM;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jwM.setEnable(true);
                        PersonalizePageView.this.jpF.setProgressView(PersonalizePageView.this.jwM);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jpF.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jwL == null) {
                        PersonalizePageView.this.jwL = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jwN = PersonalizePageView.this.jwL;
                        PersonalizePageView.this.cIk();
                    } else if (PersonalizePageView.this.jwN != PersonalizePageView.this.jwL || !aVar.equals(PersonalizePageView.this.jwL.cIQ())) {
                        PersonalizePageView.this.jwN = PersonalizePageView.this.jwL;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jwL.setEnable(true);
                    PersonalizePageView.this.jpF.setProgressView(PersonalizePageView.this.jwL);
                    PersonalizePageView.this.jwL.a(aVar);
                    PersonalizePageView.this.jpF.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jxh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jxa != null) {
                    PersonalizePageView.this.jxa.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwT = 0L;
        this.mSkinType = 3;
        this.iCg = false;
        this.jwU = 0;
        this.jwV = true;
        this.jwW = false;
        this.jwX = false;
        this.jwY = 0;
        this.iCq = 0;
        this.jwZ = false;
        this.fnl = 1;
        this.imo = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.imm == null) {
                            PersonalizePageView.this.imm = new n(new l());
                        }
                        PersonalizePageView.this.imm.a(PersonalizePageView.this.jpx, 2);
                    } else if (PersonalizePageView.this.imm != null) {
                        PersonalizePageView.this.imm.rh();
                    }
                }
            }
        };
        this.jxb = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jwQ != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bmU().bmV(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.juC = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jwO != null) {
                        PersonalizePageView.this.jwO.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.joC = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.gga = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gga != i && PersonalizePageView.this.jpD != null) {
                    PersonalizePageView.this.gga = i;
                    if (PersonalizePageView.this.gga == 1) {
                        PersonalizePageView.this.jpD.bMQ();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jpD.bMR();
                    } else {
                        PersonalizePageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpE = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cHk() {
                if (PersonalizePageView.this.jpD != null) {
                    PersonalizePageView.this.gga = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jpx)) {
                        PersonalizePageView.this.jpD.bMR();
                    } else {
                        PersonalizePageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jxc = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean iuh = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_first_install", true);

            private void cIo() {
                if (this.iuh) {
                    this.iuh = false;
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void S(int i, int i2, int i3) {
                if (PersonalizePageView.this.jwP == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cki = PersonalizePageView.this.cki();
                PersonalizePageView.this.TK();
                if (cki) {
                    PersonalizePageView.this.hA(true);
                }
                PersonalizePageView.this.jwP.R(i, i2, i3);
                q.bem().ben();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void C(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jwP != null) {
                    PersonalizePageView.this.jwP.B(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cIo();
                } else if (!this.iuh) {
                    PersonalizePageView.this.jpF.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cIo();
                    PersonalizePageView.this.cGU();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cIo();
                PersonalizePageView.this.jpF.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.TK();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dIs().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cIp() {
                if (PersonalizePageView.this.gdy != null) {
                    PersonalizePageView.this.gdy.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gdy.endLoadData();
                    PersonalizePageView.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jxd = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bGs().EK("page_recommend");
                PersonalizePageView.this.jwQ.update();
                PersonalizePageView.this.jwQ.qM(false);
                PersonalizePageView.this.jwZ = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jve = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jwQ != null && PersonalizePageView.this.jwQ.cwN() != null) {
                    PersonalizePageView.this.jwQ.cwN().cHM();
                }
            }
        };
        this.jxe = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bqm() {
                if (PersonalizePageView.this.jwZ) {
                    PersonalizePageView.this.iCq = 0;
                    PersonalizePageView.this.fnl = 1;
                    PersonalizePageView.this.jwZ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jvf = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jwQ != null) {
                    PersonalizePageView.this.jwQ.qM(true);
                    PersonalizePageView.this.jwQ.cIu();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bnH().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bhp().nG(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.jxf = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eZe = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cGe();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jpH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bMi();
            }
        };
        this.iDf = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iCg = true;
                    }
                }
            }
        };
        this.jxg = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jpF != null && !PersonalizePageView.this.jpF.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jwM == null) {
                            PersonalizePageView.this.jwM = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jwM.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jwN = PersonalizePageView.this.jwM;
                            PersonalizePageView.this.cIk();
                        } else if (PersonalizePageView.this.jwN != PersonalizePageView.this.jwM) {
                            PersonalizePageView.this.jwN = PersonalizePageView.this.jwM;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jwM.setEnable(true);
                        PersonalizePageView.this.jpF.setProgressView(PersonalizePageView.this.jwM);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jpF.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jwL == null) {
                        PersonalizePageView.this.jwL = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jwN = PersonalizePageView.this.jwL;
                        PersonalizePageView.this.cIk();
                    } else if (PersonalizePageView.this.jwN != PersonalizePageView.this.jwL || !aVar.equals(PersonalizePageView.this.jwL.cIQ())) {
                        PersonalizePageView.this.jwN = PersonalizePageView.this.jwL;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jwL.setEnable(true);
                    PersonalizePageView.this.jpF.setProgressView(PersonalizePageView.this.jwL);
                    PersonalizePageView.this.jwL.a(aVar);
                    PersonalizePageView.this.jpF.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jxh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jxa != null) {
                    PersonalizePageView.this.jxa.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwT = 0L;
        this.mSkinType = 3;
        this.iCg = false;
        this.jwU = 0;
        this.jwV = true;
        this.jwW = false;
        this.jwX = false;
        this.jwY = 0;
        this.iCq = 0;
        this.jwZ = false;
        this.fnl = 1;
        this.imo = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.imm == null) {
                            PersonalizePageView.this.imm = new n(new l());
                        }
                        PersonalizePageView.this.imm.a(PersonalizePageView.this.jpx, 2);
                    } else if (PersonalizePageView.this.imm != null) {
                        PersonalizePageView.this.imm.rh();
                    }
                }
            }
        };
        this.jxb = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jwQ != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bmU().bmV(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.juC = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jwO != null) {
                        PersonalizePageView.this.jwO.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.joC = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.gga = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gga != i2 && PersonalizePageView.this.jpD != null) {
                    PersonalizePageView.this.gga = i2;
                    if (PersonalizePageView.this.gga == 1) {
                        PersonalizePageView.this.jpD.bMQ();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jpD.bMR();
                    } else {
                        PersonalizePageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpE = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cHk() {
                if (PersonalizePageView.this.jpD != null) {
                    PersonalizePageView.this.gga = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jpx)) {
                        PersonalizePageView.this.jpD.bMR();
                    } else {
                        PersonalizePageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jxc = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean iuh = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_first_install", true);

            private void cIo() {
                if (this.iuh) {
                    this.iuh = false;
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void S(int i2, int i22, int i3) {
                if (PersonalizePageView.this.jwP == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cki = PersonalizePageView.this.cki();
                PersonalizePageView.this.TK();
                if (cki) {
                    PersonalizePageView.this.hA(true);
                }
                PersonalizePageView.this.jwP.R(i2, i22, i3);
                q.bem().ben();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void C(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.jwP != null) {
                    PersonalizePageView.this.jwP.B(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cIo();
                } else if (!this.iuh) {
                    PersonalizePageView.this.jpF.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cIo();
                    PersonalizePageView.this.cGU();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cIo();
                PersonalizePageView.this.jpF.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.TK();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dIs().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cIp() {
                if (PersonalizePageView.this.gdy != null) {
                    PersonalizePageView.this.gdy.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gdy.endLoadData();
                    PersonalizePageView.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jxd = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bGs().EK("page_recommend");
                PersonalizePageView.this.jwQ.update();
                PersonalizePageView.this.jwQ.qM(false);
                PersonalizePageView.this.jwZ = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jve = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jwQ != null && PersonalizePageView.this.jwQ.cwN() != null) {
                    PersonalizePageView.this.jwQ.cwN().cHM();
                }
            }
        };
        this.jxe = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bqm() {
                if (PersonalizePageView.this.jwZ) {
                    PersonalizePageView.this.iCq = 0;
                    PersonalizePageView.this.fnl = 1;
                    PersonalizePageView.this.jwZ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jvf = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jwQ != null) {
                    PersonalizePageView.this.jwQ.qM(true);
                    PersonalizePageView.this.jwQ.cIu();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bnH().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bhp().nG(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.jxf = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eZe = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cGe();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jpH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bMi();
            }
        };
        this.iDf = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iCg = true;
                    }
                }
            }
        };
        this.jxg = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jpF != null && !PersonalizePageView.this.jpF.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jwM == null) {
                            PersonalizePageView.this.jwM = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jwM.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jwN = PersonalizePageView.this.jwM;
                            PersonalizePageView.this.cIk();
                        } else if (PersonalizePageView.this.jwN != PersonalizePageView.this.jwM) {
                            PersonalizePageView.this.jwN = PersonalizePageView.this.jwM;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jwM.setEnable(true);
                        PersonalizePageView.this.jpF.setProgressView(PersonalizePageView.this.jwM);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jpF.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jwL == null) {
                        PersonalizePageView.this.jwL = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jwN = PersonalizePageView.this.jwL;
                        PersonalizePageView.this.cIk();
                    } else if (PersonalizePageView.this.jwN != PersonalizePageView.this.jwL || !aVar.equals(PersonalizePageView.this.jwL.cIQ())) {
                        PersonalizePageView.this.jwN = PersonalizePageView.this.jwL;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jwL.setEnable(true);
                    PersonalizePageView.this.jpF.setProgressView(PersonalizePageView.this.jwL);
                    PersonalizePageView.this.jwL.a(aVar);
                    PersonalizePageView.this.jpF.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jxh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jxa != null) {
                    PersonalizePageView.this.jxa.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jpx = new BdTypeRecyclerView(context);
        this.dZe = new LinearLayoutManager(this.jpx.getContext());
        this.jpx.setLayoutManager(this.dZe);
        this.jpx.setFadingEdgeLength(0);
        this.jpx.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.imm = new n(new l());
            this.imm.a(this.jpx, 2);
        }
        MessageManager.getInstance().registerListener(this.imo);
        MessageManager.getInstance().registerListener(this.jxb);
        this.jpF = new BigdaySwipeRefreshLayout(context);
        this.jpF.addView(this.jpx);
        this.gdy = new PbListView(context);
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setLineGone();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gdy.setOnClickListener(this.jpH);
        this.gdy.bpT();
        this.jpx.setNextPage(this.gdy);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        MessageManager.getInstance().registerListener(this.jxg);
        com.baidu.tbadk.core.bigday.b.bhp().ix(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bnH().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bhp().nG(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.jpF);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.jxa = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.jxa, layoutParams);
            this.jxa.setOnClickListener(this.jxh);
            this.jxa.setVisibility(8);
        }
        this.jwS = new com.baidu.tieba.homepage.personalize.model.e();
        this.jwO = new ag(context, this.jpx);
        this.jwO.b(this.jwS);
        this.jwQ = new e(this.pageContext, this.jpx, this.jwO, this.jpF);
        this.jwR = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.iDf);
        this.jwY = com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cIk() {
        if (this.jwN != null) {
            this.jwN.setListPullRefreshListener(this.jxd);
            this.jwN.a(this.jve);
            this.jwN.a(this.jxe);
            this.jwN.a(this.jvf);
        }
    }

    public void bTF() {
        this.jwO.b(this.juC);
        this.jwO.a(this.joC);
        this.jwQ.a(this.jxc);
        this.jwR.a(this);
        cIk();
        this.jpx.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.iCq += i2;
                if (PersonalizePageView.this.jxa != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.jpx.getItem(PersonalizePageView.this.dZe.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.l) {
                        if (((com.baidu.tieba.card.data.l) item).position >= 6) {
                            PersonalizePageView.this.jxa.show();
                        } else {
                            PersonalizePageView.this.jxa.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dZe != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.iCq < height * 3 || PersonalizePageView.this.fnl != 1) {
                        if (PersonalizePageView.this.iCq < height * 3 && PersonalizePageView.this.fnl == 2) {
                            PersonalizePageView.this.fnl = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fnl = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fnl)));
                    }
                    if (PersonalizePageView.this.dZe.getItemCount() - PersonalizePageView.this.dZe.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bMi();
                    }
                }
            }
        });
        this.jpx.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bMi();
            }
        });
        this.jpx.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.jwT >= 5000) {
                    PersonalizePageView.this.jwQ.cC(i, i2);
                }
            }
        }, 1L);
        this.jpx.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.jwQ != null && PersonalizePageView.this.jwQ.cwN() != null) {
                        PersonalizePageView.this.jwQ.cwN().cV(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                        ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).cmx().stopPlay();
                    }
                }
            }
        });
        this.jpx.removeOnScrollListener(this.mOnScrollListener);
        this.jpx.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jwP = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gdy != null) {
            this.gdy.setText(getContext().getString(R.string.pb_load_more));
            this.gdy.endLoadData();
            this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jwQ.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.jwQ != null) {
            this.jwQ.qQ(!z);
        }
        this.jwX = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.jwX;
    }

    public void g(Long l) {
        this.jwQ.g(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jwQ != null) {
            this.jwQ.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void showFloatingView() {
        if (this.jwQ != null) {
            this.jwQ.showFloatingView();
        }
    }

    public void cIl() {
        if (this.jwQ != null) {
            this.jwQ.cIl();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jwM != null) {
                this.jwM.changeSkin(i);
            }
            if (this.gdy != null) {
                this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.gdy.changeSkin(i);
            }
            this.jwO.onChangeSkinType(i);
            if (this.jwQ != null) {
                this.jwQ.onChangeSkinType(i);
            }
            if (this.jxa != null) {
                this.jxa.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aS(String str, int i) {
        if (this.gdy != null) {
            this.gdy.setText(getContext().getString(R.string.pb_load_more));
            this.gdy.endLoadData();
            this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jwQ.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.jwQ != null) {
                        PersonalizePageView.this.jwQ.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
            this.jpx.setNextPage(this.gdy);
            this.gdy.setText(getContext().getString(R.string.pb_load_more));
            this.gdy.endLoadData();
            this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jpF != null) {
            this.jpF.setVisibility(0);
        }
        if (this.jwP != null) {
            this.jwP.cGH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cki() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hA(boolean z) {
        if (this.gmB == null) {
            this.gmB = new com.baidu.tbadk.k.g(getContext());
            this.gmB.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gmB.byH();
            this.gmB.setWrapStyle(true);
            this.gmB.onChangeSkinType();
        }
        this.gmB.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jpx.setNextPage(null);
        if (this.jpF != null) {
            this.jpF.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jwQ != null) {
            this.jwQ.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jwQ != null) {
            this.jwQ.pw(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.jwY < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jxf, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jwQ != null) {
            this.jwQ.qD(z);
        }
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
            this.jpD.a(this.jpE);
            this.jpE.cHk();
        }
    }

    public void cGU() {
        if (this.jwQ != null) {
            hA(true);
            this.jwQ.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bhp().bhr();
            com.baidu.tbadk.core.bigday.b.bhp().bhq();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.jwQ != null) {
            this.jwQ.update();
        } else if (this.jpx != null && this.jpF != null) {
            showFloatingView();
            this.jpx.setSelection(0);
            if (!this.jpF.isRefreshing()) {
                if (this.jwQ != null && this.jwQ.cwN() != null) {
                    this.jwQ.cwN().cHM();
                    this.jwQ.qM(false);
                }
                this.jpF.setRefreshing(true);
            }
            if (this.jpE != null) {
                this.jpE.cHk();
            }
        }
    }

    public void cIm() {
        if (this.refreshView != null) {
            reload();
        } else if (this.jwQ != null) {
            this.jwQ.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.imo);
        MessageManager.getInstance().unRegisterListener(this.iDf);
        MessageManager.getInstance().unRegisterListener(this.jxg);
        this.jwQ.onDestroy();
        this.jwO.b((NEGFeedBackView.a) null);
        this.jwO.onDestroy();
        this.jwQ.a((e.a) null);
        if (this.jwL != null) {
            this.jwL.setListPullRefreshListener(null);
            this.jwL.a((f.d) null);
            this.jwL.a((f.a) null);
            this.jwL.a((f.b) null);
            this.jwL.release();
        }
        if (this.jwM != null) {
            this.jwM.setListPullRefreshListener(null);
            this.jwM.a((f.d) null);
            this.jwM.a((f.a) null);
            this.jwM.a((f.b) null);
            this.jwM.release();
        }
        this.jpx.setOnSrollToBottomListener(null);
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
        }
        this.jpx.removeOnScrollListener(this.mOnScrollListener);
        if (this.gmB != null) {
            this.gmB.release();
        }
        this.jpx.setRecyclerListener(null);
        if (this.jwR != null) {
            this.jwR.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bhp().destroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxf);
    }

    public void onPause() {
        this.jwQ.onPause();
        if (this.jwO != null) {
            this.jwO.onPause();
        }
    }

    public void onResume() {
        if (this.iCg) {
            reload();
            this.iCg = false;
        }
        if (this.jpF != null) {
            this.jpF.resume();
        }
        if (this.jwO != null) {
            this.jwO.onResume();
        }
    }

    public void cGe() {
        if (this.jwO != null) {
            this.jwO.notifyDataSetChanged();
        }
    }

    public void cGf() {
        if (this.jwQ != null) {
            this.jwQ.pw(true);
        }
        t.clQ().lE(false);
        com.baidu.tieba.a.d.bGs().dM("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxf);
    }

    public void cIg() {
        this.jwQ.cIB();
    }

    public void cIn() {
        this.jwQ.cIn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMi() {
        com.baidu.tieba.homepage.framework.a.cGG().y(System.currentTimeMillis(), 1);
        if (this.gdy != null && !this.gdy.isLoading()) {
            this.gdy.startLoadData();
            this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jwQ.bMi();
    }
}
