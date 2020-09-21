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
/* loaded from: classes21.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager dEH;
    private final CustomMessageListener eEB;
    private int eSE;
    private PbListView fHm;
    private int fJF;
    private com.baidu.tbadk.k.g fQf;
    private n hKQ;
    private CustomMessageListener hKS;
    private FollowUserButton.a iNp;
    private BdTypeRecyclerView iOj;
    private ScrollFragmentTabHost iOp;
    ScrollFragmentTabHost.a iOq;
    private BigdaySwipeRefreshLayout iOr;
    private View.OnClickListener iOt;
    f.d iTJ;
    f.b iTK;
    private NEGFeedBackView.a iTh;
    private boolean iVA;
    private boolean iVB;
    private boolean iVC;
    private int iVD;
    private boolean iVE;
    private FRSRefreshButton iVF;
    private CustomMessageListener iVG;
    private e.a iVH;
    f.c iVI;
    f.a iVJ;
    private Runnable iVK;
    public CustomMessageListener iVL;
    private View.OnClickListener iVM;
    private com.baidu.tieba.homepage.personalize.bigday.b iVq;
    private com.baidu.tieba.homepage.personalize.bigday.a iVr;
    private a iVs;
    private af iVt;
    private com.baidu.tieba.homepage.framework.b iVu;
    private e iVv;
    private com.baidu.tieba.homepage.personalize.a iVw;
    private com.baidu.tieba.homepage.personalize.model.e iVx;
    private long iVy;
    private int iVz;
    private boolean iaJ;
    private int iaT;
    private CustomMessageListener ibI;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes21.dex */
    public interface a {
        void a(f.a aVar);

        void a(f.b bVar);

        void a(f.d dVar);

        void setListPullRefreshListener(f.c cVar);
    }

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.iVD + 1;
        personalizePageView.iVD = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iOp = scrollFragmentTabHost;
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
        }
        if (this.iVv != null) {
            this.iVv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iVw != null) {
            this.iVw.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.iOr != null) {
            this.iOr.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iVt != null) {
            this.iVt.setPageUniqueId(bdUniqueId);
        }
        if (this.iVv != null) {
            this.iVv.o(bdUniqueId);
        }
        if (this.iVx != null) {
            this.iVx.i(bdUniqueId);
        }
        if (this.iVr != null) {
            this.iVr.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bcO().setTag(bdUniqueId);
        if (this.eEB != null) {
            this.eEB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eEB);
        }
        if (this.iVw != null) {
            this.iVw.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.iVy = 0L;
        this.mSkinType = 3;
        this.iaJ = false;
        this.iVz = 0;
        this.iVA = true;
        this.iVB = false;
        this.iVC = false;
        this.iVD = 0;
        this.iaT = 0;
        this.iVE = false;
        this.eSE = 1;
        this.hKS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hKQ == null) {
                            PersonalizePageView.this.hKQ = new n(new l());
                        }
                        PersonalizePageView.this.hKQ.a(PersonalizePageView.this.iOj, 2);
                    } else if (PersonalizePageView.this.hKQ != null) {
                        PersonalizePageView.this.hKQ.rh();
                    }
                }
            }
        };
        this.iVG = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iVv != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bis().bit(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iTh = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dF("obj_locate", "1").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.iVt != null) {
                        PersonalizePageView.this.iVt.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dF("tid", arVar.getTid()).dF("nid", arVar.getNid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", arVar.getFid()).dF("obj_param1", arVar.weight).dF("obj_source", arVar.source).dF("obj_id", arVar.extra).dF("obj_type", sb.toString()).dF("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.iNp = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fJF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fJF != i && PersonalizePageView.this.iOp != null) {
                    PersonalizePageView.this.fJF = i;
                    if (PersonalizePageView.this.fJF == 1) {
                        PersonalizePageView.this.iOp.bHC();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iOp.bHD();
                    } else {
                        PersonalizePageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOq = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cAw() {
                if (PersonalizePageView.this.iOp != null) {
                    PersonalizePageView.this.fJF = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iOj)) {
                        PersonalizePageView.this.iOp.bHD();
                    } else {
                        PersonalizePageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iVH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hSK = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_first_install", true);

            private void cBy() {
                if (this.hSK) {
                    this.hSK = false;
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.iVu == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cdF = PersonalizePageView.this.cdF();
                PersonalizePageView.this.bHn();
                if (cdF) {
                    PersonalizePageView.this.gR(true);
                }
                PersonalizePageView.this.iVu.P(i, i2, i3);
                q.aZL().aZM();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.iVu != null) {
                    PersonalizePageView.this.iVu.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cBy();
                } else if (!this.hSK) {
                    PersonalizePageView.this.iOr.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cBy();
                    PersonalizePageView.this.cAh();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cBy();
                PersonalizePageView.this.iOr.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bHn();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dBy().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cBz() {
                if (PersonalizePageView.this.fHm != null) {
                    PersonalizePageView.this.fHm.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fHm.endLoadData();
                    PersonalizePageView.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iVI = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bBN().DG("page_recommend");
                PersonalizePageView.this.iVv.update();
                PersonalizePageView.this.iVv.pO(false);
                PersonalizePageView.this.iVE = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iTJ = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iVv != null && PersonalizePageView.this.iVv.cqi() != null) {
                    PersonalizePageView.this.iVv.cqi().cAY();
                }
            }
        };
        this.iVJ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void blJ() {
                if (PersonalizePageView.this.iVE) {
                    PersonalizePageView.this.iaT = 0;
                    PersonalizePageView.this.eSE = 1;
                    PersonalizePageView.this.iVE = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iTK = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iVv != null) {
                    PersonalizePageView.this.iVv.pO(true);
                    PersonalizePageView.this.iVv.cBE();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bcO().mY(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iVK = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eEB = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.czA();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iOt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bGU();
            }
        };
        this.ibI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iaJ = true;
                    }
                }
            }
        };
        this.iVL = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iOr != null && !PersonalizePageView.this.iOr.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iVr == null) {
                            PersonalizePageView.this.iVr = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iVr.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iVs = PersonalizePageView.this.iVr;
                            PersonalizePageView.this.cBv();
                        } else if (PersonalizePageView.this.iVs != PersonalizePageView.this.iVr) {
                            PersonalizePageView.this.iVs = PersonalizePageView.this.iVr;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iVr.setEnable(true);
                        PersonalizePageView.this.iOr.setProgressView(PersonalizePageView.this.iVr);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iOr.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iVq == null) {
                        PersonalizePageView.this.iVq = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iVs = PersonalizePageView.this.iVq;
                        PersonalizePageView.this.cBv();
                    } else if (PersonalizePageView.this.iVs != PersonalizePageView.this.iVq || !aVar.equals(PersonalizePageView.this.iVq.cCa())) {
                        PersonalizePageView.this.iVs = PersonalizePageView.this.iVq;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iVq.setEnable(true);
                    PersonalizePageView.this.iOr.setProgressView(PersonalizePageView.this.iVq);
                    PersonalizePageView.this.iVq.a(aVar);
                    PersonalizePageView.this.iOr.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iVM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iVF != null) {
                    PersonalizePageView.this.iVF.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVy = 0L;
        this.mSkinType = 3;
        this.iaJ = false;
        this.iVz = 0;
        this.iVA = true;
        this.iVB = false;
        this.iVC = false;
        this.iVD = 0;
        this.iaT = 0;
        this.iVE = false;
        this.eSE = 1;
        this.hKS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hKQ == null) {
                            PersonalizePageView.this.hKQ = new n(new l());
                        }
                        PersonalizePageView.this.hKQ.a(PersonalizePageView.this.iOj, 2);
                    } else if (PersonalizePageView.this.hKQ != null) {
                        PersonalizePageView.this.hKQ.rh();
                    }
                }
            }
        };
        this.iVG = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iVv != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bis().bit(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iTh = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dF("obj_locate", "1").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.iVt != null) {
                        PersonalizePageView.this.iVt.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dF("tid", arVar.getTid()).dF("nid", arVar.getNid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", arVar.getFid()).dF("obj_param1", arVar.weight).dF("obj_source", arVar.source).dF("obj_id", arVar.extra).dF("obj_type", sb.toString()).dF("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.iNp = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fJF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fJF != i && PersonalizePageView.this.iOp != null) {
                    PersonalizePageView.this.fJF = i;
                    if (PersonalizePageView.this.fJF == 1) {
                        PersonalizePageView.this.iOp.bHC();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iOp.bHD();
                    } else {
                        PersonalizePageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOq = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cAw() {
                if (PersonalizePageView.this.iOp != null) {
                    PersonalizePageView.this.fJF = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iOj)) {
                        PersonalizePageView.this.iOp.bHD();
                    } else {
                        PersonalizePageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iVH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hSK = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_first_install", true);

            private void cBy() {
                if (this.hSK) {
                    this.hSK = false;
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.iVu == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cdF = PersonalizePageView.this.cdF();
                PersonalizePageView.this.bHn();
                if (cdF) {
                    PersonalizePageView.this.gR(true);
                }
                PersonalizePageView.this.iVu.P(i, i2, i3);
                q.aZL().aZM();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.iVu != null) {
                    PersonalizePageView.this.iVu.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cBy();
                } else if (!this.hSK) {
                    PersonalizePageView.this.iOr.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cBy();
                    PersonalizePageView.this.cAh();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cBy();
                PersonalizePageView.this.iOr.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bHn();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dBy().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cBz() {
                if (PersonalizePageView.this.fHm != null) {
                    PersonalizePageView.this.fHm.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fHm.endLoadData();
                    PersonalizePageView.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iVI = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bBN().DG("page_recommend");
                PersonalizePageView.this.iVv.update();
                PersonalizePageView.this.iVv.pO(false);
                PersonalizePageView.this.iVE = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iTJ = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iVv != null && PersonalizePageView.this.iVv.cqi() != null) {
                    PersonalizePageView.this.iVv.cqi().cAY();
                }
            }
        };
        this.iVJ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void blJ() {
                if (PersonalizePageView.this.iVE) {
                    PersonalizePageView.this.iaT = 0;
                    PersonalizePageView.this.eSE = 1;
                    PersonalizePageView.this.iVE = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iTK = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iVv != null) {
                    PersonalizePageView.this.iVv.pO(true);
                    PersonalizePageView.this.iVv.cBE();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bcO().mY(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iVK = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eEB = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.czA();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iOt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bGU();
            }
        };
        this.ibI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iaJ = true;
                    }
                }
            }
        };
        this.iVL = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iOr != null && !PersonalizePageView.this.iOr.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iVr == null) {
                            PersonalizePageView.this.iVr = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iVr.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iVs = PersonalizePageView.this.iVr;
                            PersonalizePageView.this.cBv();
                        } else if (PersonalizePageView.this.iVs != PersonalizePageView.this.iVr) {
                            PersonalizePageView.this.iVs = PersonalizePageView.this.iVr;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iVr.setEnable(true);
                        PersonalizePageView.this.iOr.setProgressView(PersonalizePageView.this.iVr);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iOr.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iVq == null) {
                        PersonalizePageView.this.iVq = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iVs = PersonalizePageView.this.iVq;
                        PersonalizePageView.this.cBv();
                    } else if (PersonalizePageView.this.iVs != PersonalizePageView.this.iVq || !aVar.equals(PersonalizePageView.this.iVq.cCa())) {
                        PersonalizePageView.this.iVs = PersonalizePageView.this.iVq;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iVq.setEnable(true);
                    PersonalizePageView.this.iOr.setProgressView(PersonalizePageView.this.iVq);
                    PersonalizePageView.this.iVq.a(aVar);
                    PersonalizePageView.this.iOr.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iVM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iVF != null) {
                    PersonalizePageView.this.iVF.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVy = 0L;
        this.mSkinType = 3;
        this.iaJ = false;
        this.iVz = 0;
        this.iVA = true;
        this.iVB = false;
        this.iVC = false;
        this.iVD = 0;
        this.iaT = 0;
        this.iVE = false;
        this.eSE = 1;
        this.hKS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hKQ == null) {
                            PersonalizePageView.this.hKQ = new n(new l());
                        }
                        PersonalizePageView.this.hKQ.a(PersonalizePageView.this.iOj, 2);
                    } else if (PersonalizePageView.this.hKQ != null) {
                        PersonalizePageView.this.hKQ.rh();
                    }
                }
            }
        };
        this.iVG = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iVv != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bis().bit(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iTh = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dF("obj_locate", "1").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.iVt != null) {
                        PersonalizePageView.this.iVt.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dF("tid", arVar.getTid()).dF("nid", arVar.getNid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", arVar.getFid()).dF("obj_param1", arVar.weight).dF("obj_source", arVar.source).dF("obj_id", arVar.extra).dF("obj_type", sb.toString()).dF("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.iNp = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fJF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.fJF != i2 && PersonalizePageView.this.iOp != null) {
                    PersonalizePageView.this.fJF = i2;
                    if (PersonalizePageView.this.fJF == 1) {
                        PersonalizePageView.this.iOp.bHC();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iOp.bHD();
                    } else {
                        PersonalizePageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOq = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cAw() {
                if (PersonalizePageView.this.iOp != null) {
                    PersonalizePageView.this.fJF = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iOj)) {
                        PersonalizePageView.this.iOp.bHD();
                    } else {
                        PersonalizePageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iVH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hSK = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_first_install", true);

            private void cBy() {
                if (this.hSK) {
                    this.hSK = false;
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i2, int i22, int i3) {
                if (PersonalizePageView.this.iVu == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cdF = PersonalizePageView.this.cdF();
                PersonalizePageView.this.bHn();
                if (cdF) {
                    PersonalizePageView.this.gR(true);
                }
                PersonalizePageView.this.iVu.P(i2, i22, i3);
                q.aZL().aZM();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.iVu != null) {
                    PersonalizePageView.this.iVu.A(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cBy();
                } else if (!this.hSK) {
                    PersonalizePageView.this.iOr.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cBy();
                    PersonalizePageView.this.cAh();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cBy();
                PersonalizePageView.this.iOr.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bHn();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dBy().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cBz() {
                if (PersonalizePageView.this.fHm != null) {
                    PersonalizePageView.this.fHm.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fHm.endLoadData();
                    PersonalizePageView.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iVI = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bBN().DG("page_recommend");
                PersonalizePageView.this.iVv.update();
                PersonalizePageView.this.iVv.pO(false);
                PersonalizePageView.this.iVE = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iTJ = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iVv != null && PersonalizePageView.this.iVv.cqi() != null) {
                    PersonalizePageView.this.iVv.cqi().cAY();
                }
            }
        };
        this.iVJ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void blJ() {
                if (PersonalizePageView.this.iVE) {
                    PersonalizePageView.this.iaT = 0;
                    PersonalizePageView.this.eSE = 1;
                    PersonalizePageView.this.iVE = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iTK = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iVv != null) {
                    PersonalizePageView.this.iVv.pO(true);
                    PersonalizePageView.this.iVv.cBE();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bcO().mY(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iVK = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eEB = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.czA();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iOt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bGU();
            }
        };
        this.ibI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iaJ = true;
                    }
                }
            }
        };
        this.iVL = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iOr != null && !PersonalizePageView.this.iOr.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iVr == null) {
                            PersonalizePageView.this.iVr = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iVr.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iVs = PersonalizePageView.this.iVr;
                            PersonalizePageView.this.cBv();
                        } else if (PersonalizePageView.this.iVs != PersonalizePageView.this.iVr) {
                            PersonalizePageView.this.iVs = PersonalizePageView.this.iVr;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iVr.setEnable(true);
                        PersonalizePageView.this.iOr.setProgressView(PersonalizePageView.this.iVr);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iOr.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iVq == null) {
                        PersonalizePageView.this.iVq = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iVs = PersonalizePageView.this.iVq;
                        PersonalizePageView.this.cBv();
                    } else if (PersonalizePageView.this.iVs != PersonalizePageView.this.iVq || !aVar.equals(PersonalizePageView.this.iVq.cCa())) {
                        PersonalizePageView.this.iVs = PersonalizePageView.this.iVq;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iVq.setEnable(true);
                    PersonalizePageView.this.iOr.setProgressView(PersonalizePageView.this.iVq);
                    PersonalizePageView.this.iVq.a(aVar);
                    PersonalizePageView.this.iOr.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iVM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iVF != null) {
                    PersonalizePageView.this.iVF.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iOj = new BdTypeRecyclerView(context);
        this.dEH = new LinearLayoutManager(this.iOj.getContext());
        this.iOj.setLayoutManager(this.dEH);
        this.iOj.setFadingEdgeLength(0);
        this.iOj.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hKQ = new n(new l());
            this.hKQ.a(this.iOj, 2);
        }
        MessageManager.getInstance().registerListener(this.hKS);
        MessageManager.getInstance().registerListener(this.iVG);
        this.iOr = new BigdaySwipeRefreshLayout(context);
        this.iOr.addView(this.iOj);
        this.fHm = new PbListView(context);
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setLineGone();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.fHm.setOnClickListener(this.iOt);
        this.fHm.blq();
        this.iOj.setNextPage(this.fHm);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        MessageManager.getInstance().registerListener(this.iVL);
        com.baidu.tbadk.core.bigday.b.bcO().hO(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bcO().mY(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.iOr);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.iVF = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.iVF, layoutParams);
            this.iVF.setOnClickListener(this.iVM);
            this.iVF.setVisibility(8);
        }
        this.iVx = new com.baidu.tieba.homepage.personalize.model.e();
        this.iVt = new af(context, this.iOj);
        this.iVt.b(this.iVx);
        this.iVv = new e(this.pageContext, this.iOj, this.iVt, this.iOr);
        this.iVw = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.ibI);
        this.iVD = com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cBv() {
        if (this.iVs != null) {
            this.iVs.setListPullRefreshListener(this.iVI);
            this.iVs.a(this.iTJ);
            this.iVs.a(this.iVJ);
            this.iVs.a(this.iTK);
        }
    }

    public void bNr() {
        this.iVt.b(this.iTh);
        this.iVt.a(this.iNp);
        this.iVv.a(this.iVH);
        this.iVw.a(this);
        cBv();
        this.iOj.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.iaT += i2;
                if (PersonalizePageView.this.iVF != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.iOj.getItem(PersonalizePageView.this.dEH.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.l) {
                        if (((com.baidu.tieba.card.data.l) item).position >= 6) {
                            PersonalizePageView.this.iVF.show();
                        } else {
                            PersonalizePageView.this.iVF.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dEH != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.iaT < height * 3 || PersonalizePageView.this.eSE != 1) {
                        if (PersonalizePageView.this.iaT < height * 3 && PersonalizePageView.this.eSE == 2) {
                            PersonalizePageView.this.eSE = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.eSE = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.eSE)));
                    }
                    if (PersonalizePageView.this.dEH.getItemCount() - PersonalizePageView.this.dEH.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bGU();
                    }
                }
            }
        });
        this.iOj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bGU();
            }
        });
        this.iOj.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.iVy >= 5000) {
                    PersonalizePageView.this.iVv.cA(i, i2);
                }
            }
        }, 1L);
        this.iOj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.iVv != null && PersonalizePageView.this.iVv.cqi() != null) {
                        PersonalizePageView.this.iVv.cqi().cN(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).cfU().stopPlay();
                    }
                }
            }
        });
        this.iOj.removeOnScrollListener(this.mOnScrollListener);
        this.iOj.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.iVu = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fHm != null) {
            this.fHm.setText(getContext().getString(R.string.pb_load_more));
            this.fHm.endLoadData();
            this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iVv.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.iVv != null) {
            this.iVv.pS(!z);
        }
        this.iVC = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.iVC;
    }

    public void f(Long l) {
        this.iVv.f(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.iVv != null) {
            this.iVv.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void showFloatingView() {
        if (this.iVv != null) {
            this.iVv.showFloatingView();
        }
    }

    public void cBw() {
        if (this.iVv != null) {
            this.iVv.cBw();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.iVr != null) {
                this.iVr.changeSkin(i);
            }
            if (this.fHm != null) {
                this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fHm.changeSkin(i);
            }
            this.iVt.onChangeSkinType(i);
            if (this.iVv != null) {
                this.iVv.onChangeSkinType(i);
            }
            if (this.iVF != null) {
                this.iVF.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aQ(String str, int i) {
        if (this.fHm != null) {
            this.fHm.setText(getContext().getString(R.string.pb_load_more));
            this.fHm.endLoadData();
            this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iVv.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.iVv != null) {
                        PersonalizePageView.this.iVv.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
            this.iOj.setNextPage(this.fHm);
            this.fHm.setText(getContext().getString(R.string.pb_load_more));
            this.fHm.endLoadData();
            this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.iOr != null) {
            this.iOr.setVisibility(0);
        }
        if (this.iVu != null) {
            this.iVu.czW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cdF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(boolean z) {
        if (this.fQf == null) {
            this.fQf = new com.baidu.tbadk.k.g(getContext());
            this.fQf.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.fQf.bue();
            this.fQf.setWrapStyle(true);
            this.fQf.onChangeSkinType();
        }
        this.fQf.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.iOj.setNextPage(null);
        if (this.iOr != null) {
            this.iOr.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.iVv != null) {
            this.iVv.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.iVv != null) {
            this.iVv.oz(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.iVD < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mX().postDelayed(this.iVK, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.iVv != null) {
            this.iVv.pG(z);
        }
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
            this.iOq.cAw();
        }
    }

    public void cAh() {
        if (this.iVv != null) {
            gR(true);
            this.iVv.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bcO().bcQ();
            com.baidu.tbadk.core.bigday.b.bcO().bcP();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.iVv != null) {
            this.iVv.update();
        } else if (this.iOj != null && this.iOr != null) {
            showFloatingView();
            this.iOj.setSelection(0);
            if (!this.iOr.isRefreshing()) {
                if (this.iVv != null && this.iVv.cqi() != null) {
                    this.iVv.cqi().cAY();
                    this.iVv.pO(false);
                }
                this.iOr.setRefreshing(true);
            }
            if (this.iOq != null) {
                this.iOq.cAw();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hKS);
        MessageManager.getInstance().unRegisterListener(this.ibI);
        MessageManager.getInstance().unRegisterListener(this.iVL);
        this.iVv.onDestroy();
        this.iVt.b((NEGFeedBackView.a) null);
        this.iVt.onDestroy();
        this.iVv.a((e.a) null);
        if (this.iVq != null) {
            this.iVq.setListPullRefreshListener(null);
            this.iVq.a((f.d) null);
            this.iVq.a((f.a) null);
            this.iVq.a((f.b) null);
            this.iVq.release();
        }
        if (this.iVr != null) {
            this.iVr.setListPullRefreshListener(null);
            this.iVr.a((f.d) null);
            this.iVr.a((f.a) null);
            this.iVr.a((f.b) null);
            this.iVr.release();
        }
        this.iOj.setOnSrollToBottomListener(null);
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
        }
        this.iOj.removeOnScrollListener(this.mOnScrollListener);
        if (this.fQf != null) {
            this.fQf.release();
        }
        this.iOj.setRecyclerListener(null);
        if (this.iVw != null) {
            this.iVw.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bcO().destroy();
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iVK);
    }

    public void onPause() {
        this.iVv.onPause();
        if (this.iVt != null) {
            this.iVt.onPause();
        }
    }

    public void onResume() {
        if (this.iaJ) {
            reload();
            this.iaJ = false;
        }
        if (this.iOr != null) {
            this.iOr.resume();
        }
        if (this.iVt != null) {
            this.iVt.onResume();
        }
    }

    public void czA() {
        if (this.iVt != null) {
            this.iVt.notifyDataSetChanged();
        }
    }

    public void czB() {
        if (this.iVv != null) {
            this.iVv.oz(true);
        }
        s.cfn().kO(false);
        com.baidu.tieba.a.d.bBN().dA("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iVK);
    }

    public void cBs() {
        this.iVv.cBL();
    }

    public void cBx() {
        this.iVv.cBx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGU() {
        com.baidu.tieba.homepage.framework.a.czV().u(System.currentTimeMillis(), 1);
        if (this.fHm != null && !this.fHm.isLoading()) {
            this.fHm.startLoadData();
            this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iVv.bGU();
    }
}
