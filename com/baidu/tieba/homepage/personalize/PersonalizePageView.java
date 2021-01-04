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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.s;
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
    private LinearLayoutManager etu;
    private int fJJ;
    private final CustomMessageListener fvn;
    private PbListView gCf;
    private int gEG;
    private com.baidu.tbadk.l.g gLj;
    private l iQe;
    private CustomMessageListener iQg;
    private FollowUserButton.a jVS;
    private BdTypeRecyclerView jWV;
    private ScrollFragmentTabHost jXb;
    ScrollFragmentTabHost.a jXc;
    private BigdaySwipeRefreshLayout jXd;
    private View.OnClickListener jXf;
    private boolean jfV;
    private CustomMessageListener jgW;
    private int jgf;
    f.d kcP;
    f.b kcQ;
    private NEGFeedBackView.a kcn;
    private e keA;
    private com.baidu.tieba.homepage.personalize.a keB;
    private com.baidu.tieba.homepage.personalize.model.e keC;
    private long keD;
    private int keE;
    private boolean keF;
    private long keG;
    private boolean keH;
    private boolean keI;
    private int keJ;
    private boolean keK;
    private FRSRefreshButton keL;
    private CustomMessageListener keM;
    private e.a keN;
    f.c keO;
    f.a keP;
    private Runnable keQ;
    public CustomMessageListener keR;
    private View.OnClickListener keS;
    private com.baidu.tieba.homepage.personalize.bigday.b keu;
    private com.baidu.tieba.homepage.personalize.bigday.a kev;
    private a kew;
    private ab kex;
    private com.baidu.tieba.homepage.framework.b kez;
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

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.keJ + 1;
        personalizePageView.keJ = i;
        return i;
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jXb = scrollFragmentTabHost;
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
        }
        if (this.keA != null) {
            this.keA.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.keB != null) {
            this.keB.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jXd != null) {
            this.jXd.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kex != null) {
            this.kex.setPageUniqueId(bdUniqueId);
        }
        if (this.keA != null) {
            this.keA.o(bdUniqueId);
        }
        if (this.keC != null) {
            this.keC.i(bdUniqueId);
        }
        if (this.kev != null) {
            this.kev.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.boC().setTag(bdUniqueId);
        if (this.fvn != null) {
            this.fvn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fvn);
        }
        if (this.keB != null) {
            this.keB.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.keD = 0L;
        this.mSkinType = 3;
        this.jfV = false;
        this.keE = 0;
        this.keF = false;
        this.keG = -1L;
        this.keH = false;
        this.keI = false;
        this.keJ = 0;
        this.jgf = 0;
        this.keK = false;
        this.fJJ = 1;
        this.iQg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iQe == null) {
                            PersonalizePageView.this.iQe = new l(new j());
                        }
                        PersonalizePageView.this.iQe.a(PersonalizePageView.this.jWV, 2);
                    } else if (PersonalizePageView.this.iQe != null) {
                        PersonalizePageView.this.iQe.qL();
                    }
                }
            }
        };
        this.keM = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.keA != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.buD().buE(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kcn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new aq("c11693").dX("obj_locate", "1").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX(IntentConfig.NID, atVar.bpO()));
                    TiebaStatic.log(new aq("c11989").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                int i = 0;
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (atVar.threadType == 0) {
                        i = 1;
                    } else if (atVar.threadType == 40) {
                        i = 2;
                    } else if (atVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.kex != null) {
                        PersonalizePageView.this.kex.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dX("tid", atVar.getTid()).dX(IntentConfig.NID, atVar.bpO()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", atVar.getFid()).dX("obj_param1", atVar.weight).dX("obj_source", atVar.source).dX("obj_id", atVar.extra).dX("obj_type", sb.toString()).dX("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jVS = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bz) {
                        TiebaStatic.log(com.baidu.tieba.s.a.d("c13696", (bz) tag));
                    }
                }
            }
        };
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gEG != i && PersonalizePageView.this.jXb != null) {
                    PersonalizePageView.this.gEG = i;
                    if (PersonalizePageView.this.gEG == 1) {
                        PersonalizePageView.this.jXb.bUX();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jXb.bUY();
                    } else {
                        PersonalizePageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cRM() {
                if (PersonalizePageView.this.jXb != null) {
                    PersonalizePageView.this.gEG = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jWV)) {
                        PersonalizePageView.this.jXb.bUY();
                    } else {
                        PersonalizePageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.keN = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iXY = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_first_install", true);

            private void cSR() {
                if (this.iXY) {
                    this.iXY = false;
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void V(int i, int i2, int i3) {
                if (PersonalizePageView.this.kez == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean ctt = PersonalizePageView.this.ctt();
                PersonalizePageView.this.Zi();
                if (ctt) {
                    PersonalizePageView.this.it(true);
                }
                PersonalizePageView.this.kez.U(i, i2, i3);
                q.blA().blB();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void I(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.kez != null) {
                    PersonalizePageView.this.kez.H(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cSR();
                } else if (!this.iXY) {
                    PersonalizePageView.this.jXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cSR();
                    PersonalizePageView.this.cRw();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void sa(boolean z) {
                cSR();
                PersonalizePageView.this.jXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Zi();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQi().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.keF = true;
                    PersonalizePageView.this.keG = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cSS() {
                if (PersonalizePageView.this.gCf != null) {
                    PersonalizePageView.this.gCf.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gCf.endLoadData();
                    PersonalizePageView.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.keO = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bOm().Fl("page_recommend");
                PersonalizePageView.this.keA.update();
                PersonalizePageView.this.keA.rW(false);
                PersonalizePageView.this.keK = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kcP = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.keA != null && PersonalizePageView.this.keA.cGd() != null) {
                    PersonalizePageView.this.keA.cGd().cSo();
                }
            }
        };
        this.keP = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bxX() {
                if (PersonalizePageView.this.keK) {
                    PersonalizePageView.this.jgf = 0;
                    PersonalizePageView.this.fJJ = 1;
                    PersonalizePageView.this.keK = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kcQ = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.keA != null) {
                    PersonalizePageView.this.keA.rW(true);
                    PersonalizePageView.this.keA.cSX();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bvq().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.boC().ou(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.keQ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fvn = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cQG();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bUp();
            }
        };
        this.jgW = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jfV = true;
                    }
                }
            }
        };
        this.keR = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jXd != null && !PersonalizePageView.this.jXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kev == null) {
                            PersonalizePageView.this.kev = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kev.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kew = PersonalizePageView.this.kev;
                            PersonalizePageView.this.cSM();
                        } else if (PersonalizePageView.this.kew != PersonalizePageView.this.kev) {
                            PersonalizePageView.this.kew = PersonalizePageView.this.kev;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kev.setEnable(true);
                        PersonalizePageView.this.jXd.setProgressView(PersonalizePageView.this.kev);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jXd.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.keu == null) {
                        PersonalizePageView.this.keu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kew = PersonalizePageView.this.keu;
                        PersonalizePageView.this.cSM();
                    } else if (PersonalizePageView.this.kew != PersonalizePageView.this.keu || !aVar.equals(PersonalizePageView.this.keu.cTs())) {
                        PersonalizePageView.this.kew = PersonalizePageView.this.keu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.keu.setEnable(true);
                    PersonalizePageView.this.jXd.setProgressView(PersonalizePageView.this.keu);
                    PersonalizePageView.this.keu.a(aVar);
                    PersonalizePageView.this.jXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.keS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.keL != null) {
                    PersonalizePageView.this.keL.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.keD = 0L;
        this.mSkinType = 3;
        this.jfV = false;
        this.keE = 0;
        this.keF = false;
        this.keG = -1L;
        this.keH = false;
        this.keI = false;
        this.keJ = 0;
        this.jgf = 0;
        this.keK = false;
        this.fJJ = 1;
        this.iQg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iQe == null) {
                            PersonalizePageView.this.iQe = new l(new j());
                        }
                        PersonalizePageView.this.iQe.a(PersonalizePageView.this.jWV, 2);
                    } else if (PersonalizePageView.this.iQe != null) {
                        PersonalizePageView.this.iQe.qL();
                    }
                }
            }
        };
        this.keM = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.keA != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.buD().buE(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kcn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new aq("c11693").dX("obj_locate", "1").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX(IntentConfig.NID, atVar.bpO()));
                    TiebaStatic.log(new aq("c11989").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                int i = 0;
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (atVar.threadType == 0) {
                        i = 1;
                    } else if (atVar.threadType == 40) {
                        i = 2;
                    } else if (atVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.kex != null) {
                        PersonalizePageView.this.kex.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dX("tid", atVar.getTid()).dX(IntentConfig.NID, atVar.bpO()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", atVar.getFid()).dX("obj_param1", atVar.weight).dX("obj_source", atVar.source).dX("obj_id", atVar.extra).dX("obj_type", sb.toString()).dX("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jVS = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bz) {
                        TiebaStatic.log(com.baidu.tieba.s.a.d("c13696", (bz) tag));
                    }
                }
            }
        };
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gEG != i && PersonalizePageView.this.jXb != null) {
                    PersonalizePageView.this.gEG = i;
                    if (PersonalizePageView.this.gEG == 1) {
                        PersonalizePageView.this.jXb.bUX();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jXb.bUY();
                    } else {
                        PersonalizePageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cRM() {
                if (PersonalizePageView.this.jXb != null) {
                    PersonalizePageView.this.gEG = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jWV)) {
                        PersonalizePageView.this.jXb.bUY();
                    } else {
                        PersonalizePageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.keN = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iXY = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_first_install", true);

            private void cSR() {
                if (this.iXY) {
                    this.iXY = false;
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void V(int i, int i2, int i3) {
                if (PersonalizePageView.this.kez == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean ctt = PersonalizePageView.this.ctt();
                PersonalizePageView.this.Zi();
                if (ctt) {
                    PersonalizePageView.this.it(true);
                }
                PersonalizePageView.this.kez.U(i, i2, i3);
                q.blA().blB();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void I(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.kez != null) {
                    PersonalizePageView.this.kez.H(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cSR();
                } else if (!this.iXY) {
                    PersonalizePageView.this.jXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cSR();
                    PersonalizePageView.this.cRw();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void sa(boolean z) {
                cSR();
                PersonalizePageView.this.jXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Zi();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQi().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.keF = true;
                    PersonalizePageView.this.keG = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cSS() {
                if (PersonalizePageView.this.gCf != null) {
                    PersonalizePageView.this.gCf.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gCf.endLoadData();
                    PersonalizePageView.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.keO = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bOm().Fl("page_recommend");
                PersonalizePageView.this.keA.update();
                PersonalizePageView.this.keA.rW(false);
                PersonalizePageView.this.keK = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kcP = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.keA != null && PersonalizePageView.this.keA.cGd() != null) {
                    PersonalizePageView.this.keA.cGd().cSo();
                }
            }
        };
        this.keP = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bxX() {
                if (PersonalizePageView.this.keK) {
                    PersonalizePageView.this.jgf = 0;
                    PersonalizePageView.this.fJJ = 1;
                    PersonalizePageView.this.keK = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kcQ = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.keA != null) {
                    PersonalizePageView.this.keA.rW(true);
                    PersonalizePageView.this.keA.cSX();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bvq().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.boC().ou(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.keQ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fvn = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cQG();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bUp();
            }
        };
        this.jgW = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jfV = true;
                    }
                }
            }
        };
        this.keR = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jXd != null && !PersonalizePageView.this.jXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kev == null) {
                            PersonalizePageView.this.kev = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kev.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kew = PersonalizePageView.this.kev;
                            PersonalizePageView.this.cSM();
                        } else if (PersonalizePageView.this.kew != PersonalizePageView.this.kev) {
                            PersonalizePageView.this.kew = PersonalizePageView.this.kev;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kev.setEnable(true);
                        PersonalizePageView.this.jXd.setProgressView(PersonalizePageView.this.kev);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jXd.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.keu == null) {
                        PersonalizePageView.this.keu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kew = PersonalizePageView.this.keu;
                        PersonalizePageView.this.cSM();
                    } else if (PersonalizePageView.this.kew != PersonalizePageView.this.keu || !aVar.equals(PersonalizePageView.this.keu.cTs())) {
                        PersonalizePageView.this.kew = PersonalizePageView.this.keu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.keu.setEnable(true);
                    PersonalizePageView.this.jXd.setProgressView(PersonalizePageView.this.keu);
                    PersonalizePageView.this.keu.a(aVar);
                    PersonalizePageView.this.jXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.keS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.keL != null) {
                    PersonalizePageView.this.keL.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.keD = 0L;
        this.mSkinType = 3;
        this.jfV = false;
        this.keE = 0;
        this.keF = false;
        this.keG = -1L;
        this.keH = false;
        this.keI = false;
        this.keJ = 0;
        this.jgf = 0;
        this.keK = false;
        this.fJJ = 1;
        this.iQg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iQe == null) {
                            PersonalizePageView.this.iQe = new l(new j());
                        }
                        PersonalizePageView.this.iQe.a(PersonalizePageView.this.jWV, 2);
                    } else if (PersonalizePageView.this.iQe != null) {
                        PersonalizePageView.this.iQe.qL();
                    }
                }
            }
        };
        this.keM = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.keA != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.buD().buE(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.kcn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new aq("c11693").dX("obj_locate", "1").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX(IntentConfig.NID, atVar.bpO()));
                    TiebaStatic.log(new aq("c11989").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                int i2 = 0;
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (atVar.threadType == 0) {
                        i2 = 1;
                    } else if (atVar.threadType == 40) {
                        i2 = 2;
                    } else if (atVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.kex != null) {
                        PersonalizePageView.this.kex.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dX("tid", atVar.getTid()).dX(IntentConfig.NID, atVar.bpO()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", atVar.getFid()).dX("obj_param1", atVar.weight).dX("obj_source", atVar.source).dX("obj_id", atVar.extra).dX("obj_type", sb.toString()).dX("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jVS = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bz) {
                        TiebaStatic.log(com.baidu.tieba.s.a.d("c13696", (bz) tag));
                    }
                }
            }
        };
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gEG != i2 && PersonalizePageView.this.jXb != null) {
                    PersonalizePageView.this.gEG = i2;
                    if (PersonalizePageView.this.gEG == 1) {
                        PersonalizePageView.this.jXb.bUX();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jXb.bUY();
                    } else {
                        PersonalizePageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cRM() {
                if (PersonalizePageView.this.jXb != null) {
                    PersonalizePageView.this.gEG = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jWV)) {
                        PersonalizePageView.this.jXb.bUY();
                    } else {
                        PersonalizePageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.keN = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iXY = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_first_install", true);

            private void cSR() {
                if (this.iXY) {
                    this.iXY = false;
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void V(int i2, int i22, int i3) {
                if (PersonalizePageView.this.kez == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean ctt = PersonalizePageView.this.ctt();
                PersonalizePageView.this.Zi();
                if (ctt) {
                    PersonalizePageView.this.it(true);
                }
                PersonalizePageView.this.kez.U(i2, i22, i3);
                q.blA().blB();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void I(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.kez != null) {
                    PersonalizePageView.this.kez.H(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cSR();
                } else if (!this.iXY) {
                    PersonalizePageView.this.jXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cSR();
                    PersonalizePageView.this.cRw();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void sa(boolean z) {
                cSR();
                PersonalizePageView.this.jXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Zi();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQi().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.keF = true;
                    PersonalizePageView.this.keG = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cSS() {
                if (PersonalizePageView.this.gCf != null) {
                    PersonalizePageView.this.gCf.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gCf.endLoadData();
                    PersonalizePageView.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.keO = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bOm().Fl("page_recommend");
                PersonalizePageView.this.keA.update();
                PersonalizePageView.this.keA.rW(false);
                PersonalizePageView.this.keK = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.kcP = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.keA != null && PersonalizePageView.this.keA.cGd() != null) {
                    PersonalizePageView.this.keA.cGd().cSo();
                }
            }
        };
        this.keP = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bxX() {
                if (PersonalizePageView.this.keK) {
                    PersonalizePageView.this.jgf = 0;
                    PersonalizePageView.this.fJJ = 1;
                    PersonalizePageView.this.keK = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.kcQ = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.keA != null) {
                    PersonalizePageView.this.keA.rW(true);
                    PersonalizePageView.this.keA.cSX();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bvq().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.boC().ou(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.keQ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fvn = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cQG();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bUp();
            }
        };
        this.jgW = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jfV = true;
                    }
                }
            }
        };
        this.keR = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jXd != null && !PersonalizePageView.this.jXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.kev == null) {
                            PersonalizePageView.this.kev = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.kev.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.kew = PersonalizePageView.this.kev;
                            PersonalizePageView.this.cSM();
                        } else if (PersonalizePageView.this.kew != PersonalizePageView.this.kev) {
                            PersonalizePageView.this.kew = PersonalizePageView.this.kev;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.kev.setEnable(true);
                        PersonalizePageView.this.jXd.setProgressView(PersonalizePageView.this.kev);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jXd.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.keu == null) {
                        PersonalizePageView.this.keu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.kew = PersonalizePageView.this.keu;
                        PersonalizePageView.this.cSM();
                    } else if (PersonalizePageView.this.kew != PersonalizePageView.this.keu || !aVar.equals(PersonalizePageView.this.keu.cTs())) {
                        PersonalizePageView.this.kew = PersonalizePageView.this.keu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.keu.setEnable(true);
                    PersonalizePageView.this.jXd.setProgressView(PersonalizePageView.this.keu);
                    PersonalizePageView.this.keu.a(aVar);
                    PersonalizePageView.this.jXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.keS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.keL != null) {
                    PersonalizePageView.this.keL.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jWV = new BdTypeRecyclerView(context);
        this.etu = new LinearLayoutManager(this.jWV.getContext());
        this.jWV.setLayoutManager(this.etu);
        this.jWV.setFadingEdgeLength(0);
        this.jWV.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jWV.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iQe = new l(new j());
            this.iQe.a(this.jWV, 2);
        }
        MessageManager.getInstance().registerListener(this.iQg);
        MessageManager.getInstance().registerListener(this.keM);
        this.jXd = new BigdaySwipeRefreshLayout(context);
        this.jXd.addView(this.jWV);
        this.gCf = new PbListView(context);
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gCf.setOnClickListener(this.jXf);
        this.gCf.bxC();
        this.jWV.setNextPage(this.gCf);
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        MessageManager.getInstance().registerListener(this.keR);
        com.baidu.tbadk.core.bigday.b.boC().jr(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bvq().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.boC().ou(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.jXd);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.keL = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.keL, layoutParams);
            this.keL.setOnClickListener(this.keS);
            this.keL.setVisibility(8);
        }
        this.keC = new com.baidu.tieba.homepage.personalize.model.e();
        this.kex = new ab(context, this.jWV);
        this.kex.b(this.keC);
        this.keA = new e(this.pageContext, this.jWV, this.kex, this.jXd);
        this.keB = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.jgW);
        this.keJ = com.baidu.tbadk.core.sharedPref.b.bvq().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cSM() {
        if (this.kew != null) {
            this.kew.setListPullRefreshListener(this.keO);
            this.kew.a(this.kcP);
            this.kew.a(this.keP);
            this.kew.a(this.kcQ);
        }
    }

    public void cbX() {
        this.kex.b(this.kcn);
        this.kex.a(this.jVS);
        this.keA.a(this.keN);
        this.keB.a(this);
        cSM();
        this.jWV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.jgf += i2;
                if (PersonalizePageView.this.keL != null) {
                    n item = PersonalizePageView.this.jWV.getItem(PersonalizePageView.this.etu.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.keL.show();
                        } else {
                            PersonalizePageView.this.keL.hide();
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.etu != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.jgf < height * 3 || PersonalizePageView.this.fJJ != 1) {
                        if (PersonalizePageView.this.jgf < height * 3 && PersonalizePageView.this.fJJ == 2) {
                            PersonalizePageView.this.fJJ = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fJJ = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fJJ)));
                    }
                    if (PersonalizePageView.this.etu.getItemCount() - PersonalizePageView.this.etu.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bUp();
                    }
                }
            }
        });
        this.jWV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bUp();
            }
        });
        this.jWV.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.keD >= 5000) {
                    PersonalizePageView.this.keA.cG(i, i2);
                }
            }
        }, 1L);
        this.jWV.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.keA != null && PersonalizePageView.this.keA.cGd() != null) {
                        PersonalizePageView.this.keA.cGd().dv(view);
                    }
                    if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                        ((HomePageCardVideoViewHolder) view.getTag()).cvG().stopPlay();
                    }
                }
            }
        });
        this.jWV.removeOnScrollListener(this.mOnScrollListener);
        this.jWV.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.kez = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gCf != null) {
            this.gCf.setText(getContext().getString(R.string.pb_load_more));
            this.gCf.endLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.keA.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.keA != null) {
            this.keA.sb(!z);
        }
        this.keI = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.keI;
    }

    public void h(Long l) {
        this.keA.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (this.keA != null) {
            this.keA.setRecommendFrsNavigationAnimDispatcher(yVar);
        }
    }

    public void showFloatingView() {
        if (this.keA != null) {
            this.keA.showFloatingView();
        }
    }

    public void cSN() {
        if (this.keA != null) {
            this.keA.cSN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.kev != null) {
                this.kev.changeSkin(i);
            }
            if (this.gCf != null) {
                this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
                this.gCf.changeSkin(i);
            }
            this.kex.onChangeSkinType(i);
            if (this.keA != null) {
                this.keA.onChangeSkinType(i);
            }
            if (this.keL != null) {
                this.keL.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void bc(String str, int i) {
        if (this.gCf != null) {
            this.gCf.setText(getContext().getString(R.string.pb_load_more));
            this.gCf.endLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.keA.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.keA != null) {
                        PersonalizePageView.this.keA.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
            this.jWV.setNextPage(this.gCf);
            this.gCf.setText(getContext().getString(R.string.pb_load_more));
            this.gCf.endLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jXd != null) {
            this.jXd.setVisibility(0);
        }
        if (this.kez != null) {
            this.kez.cRj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctt() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void it(boolean z) {
        if (this.gLj == null) {
            this.gLj = new com.baidu.tbadk.l.g(getContext());
            this.gLj.bv(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gLj.bGs();
            this.gLj.setWrapStyle(true);
            this.gLj.onChangeSkinType();
        }
        this.gLj.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jWV.setNextPage(null);
        if (this.jXd != null) {
            this.jXd.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.keA != null) {
            this.keA.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.keA != null) {
            this.keA.qD(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.keJ < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.keQ, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.keA != null) {
            this.keA.rN(z);
        }
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
            this.jXc.cRM();
        }
    }

    public void cRw() {
        if (this.keA != null) {
            it(true);
            this.keA.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.boC().boE();
            com.baidu.tbadk.core.bigday.b.boC().boD();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.keA != null) {
            this.keA.update();
        } else if (this.jWV != null && this.jXd != null) {
            showFloatingView();
            this.jWV.setSelection(0);
            if (!this.jXd.isRefreshing()) {
                if (this.keA != null && this.keA.cGd() != null) {
                    this.keA.cGd().cSo();
                    this.keA.rW(false);
                }
                this.jXd.setRefreshing(true);
            }
            if (this.jXc != null) {
                this.jXc.cRM();
            }
        }
    }

    public void cSO() {
        if (this.refreshView != null) {
            reload();
        } else if (this.keA != null) {
            this.keA.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iQg);
        MessageManager.getInstance().unRegisterListener(this.jgW);
        MessageManager.getInstance().unRegisterListener(this.keR);
        this.keA.onDestroy();
        this.kex.b((NEGFeedBackView.a) null);
        this.kex.onDestroy();
        this.keA.a((e.a) null);
        if (this.keu != null) {
            this.keu.setListPullRefreshListener(null);
            this.keu.a((f.d) null);
            this.keu.a((f.a) null);
            this.keu.a((f.b) null);
            this.keu.release();
        }
        if (this.kev != null) {
            this.kev.setListPullRefreshListener(null);
            this.kev.a((f.d) null);
            this.kev.a((f.a) null);
            this.kev.a((f.b) null);
            this.kev.release();
        }
        this.jWV.setOnSrollToBottomListener(null);
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
        }
        this.jWV.removeOnScrollListener(this.mOnScrollListener);
        if (this.gLj != null) {
            this.gLj.release();
        }
        this.jWV.setRecyclerListener(null);
        if (this.keB != null) {
            this.keB.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.boC().destroy();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.keQ);
    }

    public void onPause() {
        this.keA.onPause();
        if (this.kex != null) {
            this.kex.onPause();
        }
    }

    public void onResume() {
        if (this.jfV) {
            reload();
            this.jfV = false;
        }
        if (this.jXd != null) {
            this.jXd.resume();
        }
        if (this.kex != null) {
            this.kex.onResume();
        }
    }

    public void cQG() {
        if (this.kex != null) {
            this.kex.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.keF) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cSP();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSP() {
        if (!this.keH) {
            long CR = com.baidu.tieba.homepage.framework.a.cRi().CR(1) + com.baidu.tieba.homepage.framework.a.cRi().getCreateTime();
            long CP = com.baidu.tieba.homepage.framework.a.cRi().CP(1);
            if (CP > 0) {
                CR = System.currentTimeMillis() - CP;
            }
            com.baidu.tbadk.n.n nVar = new com.baidu.tbadk.n.n();
            nVar.bHN();
            nVar.bHO();
            com.baidu.tbadk.n.l.bHK().eE(CR);
            if (this.keG > 0) {
                com.baidu.tbadk.n.l.bHK().eI(System.currentTimeMillis() - this.keG);
            }
            com.baidu.tbadk.n.l.bHK().eF(nVar.bHP());
        }
        this.keH = true;
    }

    public void cQH() {
        if (this.keA != null) {
            this.keA.qD(true);
        }
        s.cva().mG(false);
        com.baidu.tieba.a.d.bOm().dR("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.keQ);
    }

    public void cSI() {
        this.keA.cTe();
    }

    public void cSQ() {
        this.keA.cSQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUp() {
        com.baidu.tieba.homepage.framework.a.cRi().G(System.currentTimeMillis(), 1);
        if (this.gCf != null && !this.gCf.isLoading()) {
            this.gCf.startLoadData();
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.keA.bUp();
    }
}
