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
    private LinearLayoutManager eoG;
    private int fFc;
    private final CustomMessageListener fqC;
    private com.baidu.tbadk.l.g gGD;
    private PbListView gxy;
    private int gzZ;
    private l iLx;
    private CustomMessageListener iLz;
    private FollowUserButton.a jRn;
    private View.OnClickListener jSA;
    private BdTypeRecyclerView jSq;
    private ScrollFragmentTabHost jSw;
    ScrollFragmentTabHost.a jSx;
    private BigdaySwipeRefreshLayout jSy;
    private NEGFeedBackView.a jXI;
    f.d jYk;
    f.b jYl;
    private com.baidu.tieba.homepage.personalize.bigday.b jZP;
    private com.baidu.tieba.homepage.personalize.bigday.a jZQ;
    private a jZR;
    private ab jZS;
    private com.baidu.tieba.homepage.framework.b jZT;
    private e jZU;
    private com.baidu.tieba.homepage.personalize.a jZV;
    private com.baidu.tieba.homepage.personalize.model.e jZW;
    private long jZX;
    private int jZY;
    private boolean jZZ;
    private boolean jbo;
    private int jby;
    private CustomMessageListener jcp;
    private long kaa;
    private boolean kab;
    private boolean kac;
    private int kad;
    private boolean kae;
    private FRSRefreshButton kaf;
    private CustomMessageListener kag;
    private e.a kah;
    f.c kai;
    f.a kaj;
    private Runnable kak;
    public CustomMessageListener kal;
    private View.OnClickListener kam;
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
        int i = personalizePageView.kad + 1;
        personalizePageView.kad = i;
        return i;
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jSw = scrollFragmentTabHost;
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
        }
        if (this.jZU != null) {
            this.jZU.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jZV != null) {
            this.jZV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jSy != null) {
            this.jSy.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jZS != null) {
            this.jZS.setPageUniqueId(bdUniqueId);
        }
        if (this.jZU != null) {
            this.jZU.o(bdUniqueId);
        }
        if (this.jZW != null) {
            this.jZW.i(bdUniqueId);
        }
        if (this.jZQ != null) {
            this.jZQ.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bkJ().setTag(bdUniqueId);
        if (this.fqC != null) {
            this.fqC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fqC);
        }
        if (this.jZV != null) {
            this.jZV.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.jZX = 0L;
        this.mSkinType = 3;
        this.jbo = false;
        this.jZY = 0;
        this.jZZ = false;
        this.kaa = -1L;
        this.kab = false;
        this.kac = false;
        this.kad = 0;
        this.jby = 0;
        this.kae = false;
        this.fFc = 1;
        this.iLz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iLx == null) {
                            PersonalizePageView.this.iLx = new l(new j());
                        }
                        PersonalizePageView.this.iLx.a(PersonalizePageView.this.jSq, 2);
                    } else if (PersonalizePageView.this.iLx != null) {
                        PersonalizePageView.this.iLx.qL();
                    }
                }
            }
        };
        this.kag = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZU != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bqK().bqL(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jXI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new aq("c11693").dW("obj_locate", "1").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW(IntentConfig.NID, atVar.blV()));
                    TiebaStatic.log(new aq("c11989").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jZS != null) {
                        PersonalizePageView.this.jZS.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dW("tid", atVar.getTid()).dW(IntentConfig.NID, atVar.blV()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", atVar.getFid()).dW("obj_param1", atVar.weight).dW("obj_source", atVar.source).dW("obj_id", atVar.extra).dW("obj_type", sb.toString()).dW("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jRn = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
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
        this.gzZ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gzZ != i && PersonalizePageView.this.jSw != null) {
                    PersonalizePageView.this.gzZ = i;
                    if (PersonalizePageView.this.gzZ == 1) {
                        PersonalizePageView.this.jSw.bRg();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jSw.bRh();
                    } else {
                        PersonalizePageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSx = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNV() {
                if (PersonalizePageView.this.jSw != null) {
                    PersonalizePageView.this.gzZ = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jSq)) {
                        PersonalizePageView.this.jSw.bRh();
                    } else {
                        PersonalizePageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.kah = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iTr = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_first_install", true);

            private void cPa() {
                if (this.iTr) {
                    this.iTr = false;
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void V(int i, int i2, int i3) {
                if (PersonalizePageView.this.jZT == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cpC = PersonalizePageView.this.cpC();
                PersonalizePageView.this.Vq();
                if (cpC) {
                    PersonalizePageView.this.ip(true);
                }
                PersonalizePageView.this.jZT.U(i, i2, i3);
                q.bhH().bhI();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void I(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jZT != null) {
                    PersonalizePageView.this.jZT.H(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPa();
                } else if (!this.iTr) {
                    PersonalizePageView.this.jSy.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPa();
                    PersonalizePageView.this.cNF();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rW(boolean z) {
                cPa();
                PersonalizePageView.this.jSy.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Vq();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dMr().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jZZ = true;
                    PersonalizePageView.this.kaa = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPb() {
                if (PersonalizePageView.this.gxy != null) {
                    PersonalizePageView.this.gxy.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gxy.endLoadData();
                    PersonalizePageView.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kai = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKv().DZ("page_recommend");
                PersonalizePageView.this.jZU.update();
                PersonalizePageView.this.jZU.rS(false);
                PersonalizePageView.this.kae = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jYk = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jZU != null && PersonalizePageView.this.jZU.cCm() != null) {
                    PersonalizePageView.this.jZU.cCm().cOx();
                }
            }
        };
        this.kaj = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bue() {
                if (PersonalizePageView.this.kae) {
                    PersonalizePageView.this.jby = 0;
                    PersonalizePageView.this.fFc = 1;
                    PersonalizePageView.this.kae = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jYl = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jZU != null) {
                    PersonalizePageView.this.jZU.rS(true);
                    PersonalizePageView.this.jZU.cPg();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bkJ().mO(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kak = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fqC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                                PersonalizePageView.this.cMP();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jSA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bQy();
            }
        };
        this.jcp = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jbo = true;
                    }
                }
            }
        };
        this.kal = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jSy != null && !PersonalizePageView.this.jSy.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jZQ == null) {
                            PersonalizePageView.this.jZQ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jZQ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jZR = PersonalizePageView.this.jZQ;
                            PersonalizePageView.this.cOV();
                        } else if (PersonalizePageView.this.jZR != PersonalizePageView.this.jZQ) {
                            PersonalizePageView.this.jZR = PersonalizePageView.this.jZQ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jZQ.setEnable(true);
                        PersonalizePageView.this.jSy.setProgressView(PersonalizePageView.this.jZQ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jSy.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jZP == null) {
                        PersonalizePageView.this.jZP = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jZR = PersonalizePageView.this.jZP;
                        PersonalizePageView.this.cOV();
                    } else if (PersonalizePageView.this.jZR != PersonalizePageView.this.jZP || !aVar.equals(PersonalizePageView.this.jZP.cPB())) {
                        PersonalizePageView.this.jZR = PersonalizePageView.this.jZP;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jZP.setEnable(true);
                    PersonalizePageView.this.jSy.setProgressView(PersonalizePageView.this.jZP);
                    PersonalizePageView.this.jZP.a(aVar);
                    PersonalizePageView.this.jSy.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kam = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kaf != null) {
                    PersonalizePageView.this.kaf.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZX = 0L;
        this.mSkinType = 3;
        this.jbo = false;
        this.jZY = 0;
        this.jZZ = false;
        this.kaa = -1L;
        this.kab = false;
        this.kac = false;
        this.kad = 0;
        this.jby = 0;
        this.kae = false;
        this.fFc = 1;
        this.iLz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iLx == null) {
                            PersonalizePageView.this.iLx = new l(new j());
                        }
                        PersonalizePageView.this.iLx.a(PersonalizePageView.this.jSq, 2);
                    } else if (PersonalizePageView.this.iLx != null) {
                        PersonalizePageView.this.iLx.qL();
                    }
                }
            }
        };
        this.kag = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZU != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bqK().bqL(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jXI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new aq("c11693").dW("obj_locate", "1").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW(IntentConfig.NID, atVar.blV()));
                    TiebaStatic.log(new aq("c11989").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jZS != null) {
                        PersonalizePageView.this.jZS.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dW("tid", atVar.getTid()).dW(IntentConfig.NID, atVar.blV()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", atVar.getFid()).dW("obj_param1", atVar.weight).dW("obj_source", atVar.source).dW("obj_id", atVar.extra).dW("obj_type", sb.toString()).dW("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jRn = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
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
        this.gzZ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gzZ != i && PersonalizePageView.this.jSw != null) {
                    PersonalizePageView.this.gzZ = i;
                    if (PersonalizePageView.this.gzZ == 1) {
                        PersonalizePageView.this.jSw.bRg();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jSw.bRh();
                    } else {
                        PersonalizePageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSx = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNV() {
                if (PersonalizePageView.this.jSw != null) {
                    PersonalizePageView.this.gzZ = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jSq)) {
                        PersonalizePageView.this.jSw.bRh();
                    } else {
                        PersonalizePageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.kah = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iTr = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_first_install", true);

            private void cPa() {
                if (this.iTr) {
                    this.iTr = false;
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void V(int i, int i2, int i3) {
                if (PersonalizePageView.this.jZT == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cpC = PersonalizePageView.this.cpC();
                PersonalizePageView.this.Vq();
                if (cpC) {
                    PersonalizePageView.this.ip(true);
                }
                PersonalizePageView.this.jZT.U(i, i2, i3);
                q.bhH().bhI();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void I(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jZT != null) {
                    PersonalizePageView.this.jZT.H(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPa();
                } else if (!this.iTr) {
                    PersonalizePageView.this.jSy.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPa();
                    PersonalizePageView.this.cNF();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rW(boolean z) {
                cPa();
                PersonalizePageView.this.jSy.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Vq();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dMr().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jZZ = true;
                    PersonalizePageView.this.kaa = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPb() {
                if (PersonalizePageView.this.gxy != null) {
                    PersonalizePageView.this.gxy.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gxy.endLoadData();
                    PersonalizePageView.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kai = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKv().DZ("page_recommend");
                PersonalizePageView.this.jZU.update();
                PersonalizePageView.this.jZU.rS(false);
                PersonalizePageView.this.kae = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jYk = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jZU != null && PersonalizePageView.this.jZU.cCm() != null) {
                    PersonalizePageView.this.jZU.cCm().cOx();
                }
            }
        };
        this.kaj = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bue() {
                if (PersonalizePageView.this.kae) {
                    PersonalizePageView.this.jby = 0;
                    PersonalizePageView.this.fFc = 1;
                    PersonalizePageView.this.kae = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jYl = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jZU != null) {
                    PersonalizePageView.this.jZU.rS(true);
                    PersonalizePageView.this.jZU.cPg();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bkJ().mO(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kak = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fqC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                                PersonalizePageView.this.cMP();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jSA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bQy();
            }
        };
        this.jcp = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jbo = true;
                    }
                }
            }
        };
        this.kal = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jSy != null && !PersonalizePageView.this.jSy.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jZQ == null) {
                            PersonalizePageView.this.jZQ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jZQ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jZR = PersonalizePageView.this.jZQ;
                            PersonalizePageView.this.cOV();
                        } else if (PersonalizePageView.this.jZR != PersonalizePageView.this.jZQ) {
                            PersonalizePageView.this.jZR = PersonalizePageView.this.jZQ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jZQ.setEnable(true);
                        PersonalizePageView.this.jSy.setProgressView(PersonalizePageView.this.jZQ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jSy.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jZP == null) {
                        PersonalizePageView.this.jZP = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jZR = PersonalizePageView.this.jZP;
                        PersonalizePageView.this.cOV();
                    } else if (PersonalizePageView.this.jZR != PersonalizePageView.this.jZP || !aVar.equals(PersonalizePageView.this.jZP.cPB())) {
                        PersonalizePageView.this.jZR = PersonalizePageView.this.jZP;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jZP.setEnable(true);
                    PersonalizePageView.this.jSy.setProgressView(PersonalizePageView.this.jZP);
                    PersonalizePageView.this.jZP.a(aVar);
                    PersonalizePageView.this.jSy.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kam = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kaf != null) {
                    PersonalizePageView.this.kaf.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZX = 0L;
        this.mSkinType = 3;
        this.jbo = false;
        this.jZY = 0;
        this.jZZ = false;
        this.kaa = -1L;
        this.kab = false;
        this.kac = false;
        this.kad = 0;
        this.jby = 0;
        this.kae = false;
        this.fFc = 1;
        this.iLz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iLx == null) {
                            PersonalizePageView.this.iLx = new l(new j());
                        }
                        PersonalizePageView.this.iLx.a(PersonalizePageView.this.jSq, 2);
                    } else if (PersonalizePageView.this.iLx != null) {
                        PersonalizePageView.this.iLx.qL();
                    }
                }
            }
        };
        this.kag = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jZU != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bqK().bqL(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jXI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new aq("c11693").dW("obj_locate", "1").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW(IntentConfig.NID, atVar.blV()));
                    TiebaStatic.log(new aq("c11989").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.jZS != null) {
                        PersonalizePageView.this.jZS.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dW("tid", atVar.getTid()).dW(IntentConfig.NID, atVar.blV()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", atVar.getFid()).dW("obj_param1", atVar.weight).dW("obj_source", atVar.source).dW("obj_id", atVar.extra).dW("obj_type", sb.toString()).dW("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jRn = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
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
        this.gzZ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gzZ != i2 && PersonalizePageView.this.jSw != null) {
                    PersonalizePageView.this.gzZ = i2;
                    if (PersonalizePageView.this.gzZ == 1) {
                        PersonalizePageView.this.jSw.bRg();
                    } else if (PersonalizePageView.this.c(recyclerView)) {
                        PersonalizePageView.this.jSw.bRh();
                    } else {
                        PersonalizePageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSx = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNV() {
                if (PersonalizePageView.this.jSw != null) {
                    PersonalizePageView.this.gzZ = -1;
                    if (PersonalizePageView.this.c(PersonalizePageView.this.jSq)) {
                        PersonalizePageView.this.jSw.bRh();
                    } else {
                        PersonalizePageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.kah = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iTr = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_first_install", true);

            private void cPa() {
                if (this.iTr) {
                    this.iTr = false;
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void V(int i2, int i22, int i3) {
                if (PersonalizePageView.this.jZT == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cpC = PersonalizePageView.this.cpC();
                PersonalizePageView.this.Vq();
                if (cpC) {
                    PersonalizePageView.this.ip(true);
                }
                PersonalizePageView.this.jZT.U(i2, i22, i3);
                q.bhH().bhI();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void I(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.jZT != null) {
                    PersonalizePageView.this.jZT.H(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPa();
                } else if (!this.iTr) {
                    PersonalizePageView.this.jSy.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPa();
                    PersonalizePageView.this.cNF();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rW(boolean z) {
                cPa();
                PersonalizePageView.this.jSy.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Vq();
                if (ad.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dMr().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jZZ = true;
                    PersonalizePageView.this.kaa = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPb() {
                if (PersonalizePageView.this.gxy != null) {
                    PersonalizePageView.this.gxy.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gxy.endLoadData();
                    PersonalizePageView.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.kai = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bKv().DZ("page_recommend");
                PersonalizePageView.this.jZU.update();
                PersonalizePageView.this.jZU.rS(false);
                PersonalizePageView.this.kae = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jYk = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jZU != null && PersonalizePageView.this.jZU.cCm() != null) {
                    PersonalizePageView.this.jZU.cCm().cOx();
                }
            }
        };
        this.kaj = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bue() {
                if (PersonalizePageView.this.kae) {
                    PersonalizePageView.this.jby = 0;
                    PersonalizePageView.this.fFc = 1;
                    PersonalizePageView.this.kae = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jYl = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jZU != null) {
                    PersonalizePageView.this.jZU.rS(true);
                    PersonalizePageView.this.jZU.cPg();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bkJ().mO(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.kak = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fqC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                                PersonalizePageView.this.cMP();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jSA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bQy();
            }
        };
        this.jcp = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.jbo = true;
                    }
                }
            }
        };
        this.kal = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jSy != null && !PersonalizePageView.this.jSy.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jZQ == null) {
                            PersonalizePageView.this.jZQ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jZQ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jZR = PersonalizePageView.this.jZQ;
                            PersonalizePageView.this.cOV();
                        } else if (PersonalizePageView.this.jZR != PersonalizePageView.this.jZQ) {
                            PersonalizePageView.this.jZR = PersonalizePageView.this.jZQ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jZQ.setEnable(true);
                        PersonalizePageView.this.jSy.setProgressView(PersonalizePageView.this.jZQ);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jSy.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jZP == null) {
                        PersonalizePageView.this.jZP = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jZR = PersonalizePageView.this.jZP;
                        PersonalizePageView.this.cOV();
                    } else if (PersonalizePageView.this.jZR != PersonalizePageView.this.jZP || !aVar.equals(PersonalizePageView.this.jZP.cPB())) {
                        PersonalizePageView.this.jZR = PersonalizePageView.this.jZP;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jZP.setEnable(true);
                    PersonalizePageView.this.jSy.setProgressView(PersonalizePageView.this.jZP);
                    PersonalizePageView.this.jZP.a(aVar);
                    PersonalizePageView.this.jSy.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.kam = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.kaf != null) {
                    PersonalizePageView.this.kaf.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jSq = new BdTypeRecyclerView(context);
        this.eoG = new LinearLayoutManager(this.jSq.getContext());
        this.jSq.setLayoutManager(this.eoG);
        this.jSq.setFadingEdgeLength(0);
        this.jSq.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jSq.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iLx = new l(new j());
            this.iLx.a(this.jSq, 2);
        }
        MessageManager.getInstance().registerListener(this.iLz);
        MessageManager.getInstance().registerListener(this.kag);
        this.jSy = new BigdaySwipeRefreshLayout(context);
        this.jSy.addView(this.jSq);
        this.gxy = new PbListView(context);
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gxy.setOnClickListener(this.jSA);
        this.gxy.btJ();
        this.jSq.setNextPage(this.gxy);
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        MessageManager.getInstance().registerListener(this.kal);
        com.baidu.tbadk.core.bigday.b.bkJ().jn(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bkJ().mO(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.jSy);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.kaf = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.kaf, layoutParams);
            this.kaf.setOnClickListener(this.kam);
            this.kaf.setVisibility(8);
        }
        this.jZW = new com.baidu.tieba.homepage.personalize.model.e();
        this.jZS = new ab(context, this.jSq);
        this.jZS.b(this.jZW);
        this.jZU = new e(this.pageContext, this.jSq, this.jZS, this.jSy);
        this.jZV = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.jcp);
        this.kad = com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cOV() {
        if (this.jZR != null) {
            this.jZR.setListPullRefreshListener(this.kai);
            this.jZR.a(this.jYk);
            this.jZR.a(this.kaj);
            this.jZR.a(this.jYl);
        }
    }

    public void bYg() {
        this.jZS.b(this.jXI);
        this.jZS.a(this.jRn);
        this.jZU.a(this.kah);
        this.jZV.a(this);
        cOV();
        this.jSq.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.jby += i2;
                if (PersonalizePageView.this.kaf != null) {
                    n item = PersonalizePageView.this.jSq.getItem(PersonalizePageView.this.eoG.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.kaf.show();
                        } else {
                            PersonalizePageView.this.kaf.hide();
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eoG != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.jby < height * 3 || PersonalizePageView.this.fFc != 1) {
                        if (PersonalizePageView.this.jby < height * 3 && PersonalizePageView.this.fFc == 2) {
                            PersonalizePageView.this.fFc = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fFc = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fFc)));
                    }
                    if (PersonalizePageView.this.eoG.getItemCount() - PersonalizePageView.this.eoG.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bQy();
                    }
                }
            }
        });
        this.jSq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bQy();
            }
        });
        this.jSq.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.jZX >= 5000) {
                    PersonalizePageView.this.jZU.cG(i, i2);
                }
            }
        }, 1L);
        this.jSq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.jZU != null && PersonalizePageView.this.jZU.cCm() != null) {
                        PersonalizePageView.this.jZU.cCm().dv(view);
                    }
                    if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                        ((HomePageCardVideoViewHolder) view.getTag()).crP().stopPlay();
                    }
                }
            }
        });
        this.jSq.removeOnScrollListener(this.mOnScrollListener);
        this.jSq.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jZT = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gxy != null) {
            this.gxy.setText(getContext().getString(R.string.pb_load_more));
            this.gxy.endLoadData();
            this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jZU.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.jZU != null) {
            this.jZU.rX(!z);
        }
        this.kac = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.kac;
    }

    public void h(Long l) {
        this.jZU.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (this.jZU != null) {
            this.jZU.setRecommendFrsNavigationAnimDispatcher(yVar);
        }
    }

    public void showFloatingView() {
        if (this.jZU != null) {
            this.jZU.showFloatingView();
        }
    }

    public void cOW() {
        if (this.jZU != null) {
            this.jZU.cOW();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jZQ != null) {
                this.jZQ.changeSkin(i);
            }
            if (this.gxy != null) {
                this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
                this.gxy.changeSkin(i);
            }
            this.jZS.onChangeSkinType(i);
            if (this.jZU != null) {
                this.jZU.onChangeSkinType(i);
            }
            if (this.kaf != null) {
                this.kaf.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void bd(String str, int i) {
        if (this.gxy != null) {
            this.gxy.setText(getContext().getString(R.string.pb_load_more));
            this.gxy.endLoadData();
            this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jZU.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.jZU != null) {
                        PersonalizePageView.this.jZU.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
            this.jSq.setNextPage(this.gxy);
            this.gxy.setText(getContext().getString(R.string.pb_load_more));
            this.gxy.endLoadData();
            this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jSy != null) {
            this.jSy.setVisibility(0);
        }
        if (this.jZT != null) {
            this.jZT.cNs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cpC() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ip(boolean z) {
        if (this.gGD == null) {
            this.gGD = new com.baidu.tbadk.l.g(getContext());
            this.gGD.bt(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gGD.bCA();
            this.gGD.setWrapStyle(true);
            this.gGD.onChangeSkinType();
        }
        this.gGD.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jSq.setNextPage(null);
        if (this.jSy != null) {
            this.jSy.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jZU != null) {
            this.jZU.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jZU != null) {
            this.jZU.qz(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.kad < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kak, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jZU != null) {
            this.jZU.rJ(z);
        }
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
            this.jSx.cNV();
        }
    }

    public void cNF() {
        if (this.jZU != null) {
            ip(true);
            this.jZU.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bkJ().bkL();
            com.baidu.tbadk.core.bigday.b.bkJ().bkK();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.jZU != null) {
            this.jZU.update();
        } else if (this.jSq != null && this.jSy != null) {
            showFloatingView();
            this.jSq.setSelection(0);
            if (!this.jSy.isRefreshing()) {
                if (this.jZU != null && this.jZU.cCm() != null) {
                    this.jZU.cCm().cOx();
                    this.jZU.rS(false);
                }
                this.jSy.setRefreshing(true);
            }
            if (this.jSx != null) {
                this.jSx.cNV();
            }
        }
    }

    public void cOX() {
        if (this.refreshView != null) {
            reload();
        } else if (this.jZU != null) {
            this.jZU.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iLz);
        MessageManager.getInstance().unRegisterListener(this.jcp);
        MessageManager.getInstance().unRegisterListener(this.kal);
        this.jZU.onDestroy();
        this.jZS.b((NEGFeedBackView.a) null);
        this.jZS.onDestroy();
        this.jZU.a((e.a) null);
        if (this.jZP != null) {
            this.jZP.setListPullRefreshListener(null);
            this.jZP.a((f.d) null);
            this.jZP.a((f.a) null);
            this.jZP.a((f.b) null);
            this.jZP.release();
        }
        if (this.jZQ != null) {
            this.jZQ.setListPullRefreshListener(null);
            this.jZQ.a((f.d) null);
            this.jZQ.a((f.a) null);
            this.jZQ.a((f.b) null);
            this.jZQ.release();
        }
        this.jSq.setOnSrollToBottomListener(null);
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
        }
        this.jSq.removeOnScrollListener(this.mOnScrollListener);
        if (this.gGD != null) {
            this.gGD.release();
        }
        this.jSq.setRecyclerListener(null);
        if (this.jZV != null) {
            this.jZV.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bkJ().destroy();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kak);
    }

    public void onPause() {
        this.jZU.onPause();
        if (this.jZS != null) {
            this.jZS.onPause();
        }
    }

    public void onResume() {
        if (this.jbo) {
            reload();
            this.jbo = false;
        }
        if (this.jSy != null) {
            this.jSy.resume();
        }
        if (this.jZS != null) {
            this.jZS.onResume();
        }
    }

    public void cMP() {
        if (this.jZS != null) {
            this.jZS.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jZZ) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cOY();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOY() {
        if (!this.kab) {
            long Bk = com.baidu.tieba.homepage.framework.a.cNr().Bk(1) + com.baidu.tieba.homepage.framework.a.cNr().getCreateTime();
            long Bi = com.baidu.tieba.homepage.framework.a.cNr().Bi(1);
            if (Bi > 0) {
                Bk = System.currentTimeMillis() - Bi;
            }
            com.baidu.tbadk.n.n nVar = new com.baidu.tbadk.n.n();
            nVar.bDW();
            nVar.bDX();
            com.baidu.tbadk.n.l.bDT().eE(Bk);
            if (this.kaa > 0) {
                com.baidu.tbadk.n.l.bDT().eI(System.currentTimeMillis() - this.kaa);
            }
            com.baidu.tbadk.n.l.bDT().eF(nVar.bDY());
        }
        this.kab = true;
    }

    public void cMQ() {
        if (this.jZU != null) {
            this.jZU.qz(true);
        }
        s.crj().mC(false);
        com.baidu.tieba.a.d.bKv().dQ("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kak);
    }

    public void cOR() {
        this.jZU.cPn();
    }

    public void cOZ() {
        this.jZU.cOZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQy() {
        com.baidu.tieba.homepage.framework.a.cNr().G(System.currentTimeMillis(), 1);
        if (this.gxy != null && !this.gxy.isLoading()) {
            this.gxy.startLoadData();
            this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jZU.bQy();
    }
}
