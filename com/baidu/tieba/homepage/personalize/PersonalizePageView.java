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
/* loaded from: classes7.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager ctD;
    private final CustomMessageListener dkk;
    private int dxs;
    private PbListView ehe;
    private int ejq;
    private g epL;
    private k fYi;
    private CustomMessageListener fYk;
    private BdTypeRecyclerView gUL;
    private ScrollFragmentTabHost gUR;
    ScrollFragmentTabHost.a gUS;
    private BigdaySwipeRefreshLayout gUT;
    private View.OnClickListener gUV;
    private NEGFeedBackView.a gYX;
    g.b gZA;
    private com.baidu.tieba.homepage.personalize.bigday.b gZY;
    private com.baidu.tieba.homepage.personalize.bigday.a gZZ;
    g.d gZz;
    private boolean gmV;
    private CustomMessageListener gnE;
    private int gne;
    private com.baidu.tieba.c.c gol;
    private a haa;
    private ab hab;
    private com.baidu.tieba.homepage.framework.b hac;
    private e had;
    private com.baidu.tieba.homepage.personalize.a hae;
    private com.baidu.tieba.homepage.personalize.model.e haf;
    private long hag;
    private FloatingAnimationView hah;
    private boolean hai;
    private int haj;
    private boolean hak;
    private FRSRefreshButton hal;
    private e.a ham;
    g.c han;
    g.a hao;
    private Runnable hap;
    public CustomMessageListener haq;
    private View.OnClickListener har;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes7.dex */
    public interface a {
        void a(g.a aVar);

        void a(g.b bVar);

        void a(g.d dVar);

        void setListPullRefreshListener(g.c cVar);
    }

    static /* synthetic */ int w(PersonalizePageView personalizePageView) {
        int i = personalizePageView.haj + 1;
        personalizePageView.haj = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gUR = scrollFragmentTabHost;
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
            this.gUR.a(this.gUS);
        }
        if (this.had != null) {
            this.had.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hae != null) {
            this.hae.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gUT != null) {
            this.gUT.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hab != null) {
            this.hab.setPageUniqueId(bdUniqueId);
        }
        if (this.had != null) {
            this.had.m(bdUniqueId);
        }
        if (this.haf != null) {
            this.haf.h(bdUniqueId);
        }
        if (this.gZZ != null) {
            this.gZZ.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.axG().setTag(bdUniqueId);
        if (this.dkk != null) {
            this.dkk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dkk);
        }
        if (this.hae != null) {
            this.hae.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.IQ(String.valueOf(floatInfo.activity_id));
        oVar.ei(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.IP(floatInfo.float_url);
        oVar.IO(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.hag = 0L;
        this.mSkinType = 3;
        this.gmV = false;
        this.hai = false;
        this.haj = 0;
        this.gne = 0;
        this.hak = false;
        this.dxs = 1;
        this.fYk = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fYi == null) {
                            PersonalizePageView.this.fYi = new k(new i());
                        }
                        PersonalizePageView.this.fYi.a(PersonalizePageView.this.gUL, 2);
                    } else if (PersonalizePageView.this.fYi != null) {
                        PersonalizePageView.this.fYi.km();
                    }
                }
            }
        };
        this.gYX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hab != null) {
                        PersonalizePageView.this.hab.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.ejq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.ejq != i && PersonalizePageView.this.gUR != null) {
                    PersonalizePageView.this.ejq = i;
                    if (PersonalizePageView.this.ejq == 1) {
                        PersonalizePageView.this.gUR.bav();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gUR.baw();
                    } else {
                        PersonalizePageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUS = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bMj() {
                if (PersonalizePageView.this.gUR != null) {
                    PersonalizePageView.this.ejq = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gUL)) {
                        PersonalizePageView.this.gUR.baw();
                    } else {
                        PersonalizePageView.this.gUR.bav();
                    }
                }
            }
        };
        this.ham = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gfl = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_first_install", true);

            private void bNb() {
                if (this.gfl) {
                    this.gfl = false;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.hac == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bxH = PersonalizePageView.this.bxH();
                PersonalizePageView.this.baf();
                if (bxH) {
                    PersonalizePageView.this.eF(true);
                }
                PersonalizePageView.this.hac.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hac != null) {
                    PersonalizePageView.this.hac.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bNb();
                } else if (!this.gfl) {
                    PersonalizePageView.this.gUT.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bNb();
                    PersonalizePageView.this.bLX();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bNb();
                PersonalizePageView.this.gUT.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.baf();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.had.bNo());
                PersonalizePageView.this.eN(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gol != null) {
                    PersonalizePageView.this.gol.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bNc() {
                if (PersonalizePageView.this.ehe != null) {
                    PersonalizePageView.this.ehe.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ehe.endLoadData();
                    PersonalizePageView.this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.han = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aVo().wt("page_recommend");
                PersonalizePageView.this.had.update();
                PersonalizePageView.this.had.mB(false);
                PersonalizePageView.this.hak = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gZz = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.had != null && PersonalizePageView.this.had.bDf() != null) {
                    PersonalizePageView.this.had.bDf().bML();
                }
            }
        };
        this.hao = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aFG() {
                if (PersonalizePageView.this.hak) {
                    PersonalizePageView.this.gne = 0;
                    PersonalizePageView.this.dxs = 1;
                    PersonalizePageView.this.hak = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gZA = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.had != null) {
                    PersonalizePageView.this.had.mB(true);
                    PersonalizePageView.this.had.bNh();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aDr().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.axG().jb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hap = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dkk = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bLz();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gUV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aZN();
            }
        };
        this.gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gmV = true;
                    }
                }
            }
        };
        this.haq = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gUT != null && !PersonalizePageView.this.gUT.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gZZ == null) {
                            PersonalizePageView.this.gZZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gZZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.haa = PersonalizePageView.this.gZZ;
                            PersonalizePageView.this.bMY();
                        } else if (PersonalizePageView.this.haa != PersonalizePageView.this.gZZ) {
                            PersonalizePageView.this.haa = PersonalizePageView.this.gZZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gZZ.setEnable(true);
                        PersonalizePageView.this.gUT.setProgressView(PersonalizePageView.this.gZZ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gUT.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gZY == null) {
                        PersonalizePageView.this.gZY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.haa = PersonalizePageView.this.gZY;
                        PersonalizePageView.this.bMY();
                    } else if (PersonalizePageView.this.haa != PersonalizePageView.this.gZY || !aVar.equals(PersonalizePageView.this.gZY.bNA())) {
                        PersonalizePageView.this.haa = PersonalizePageView.this.gZY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gZY.setEnable(true);
                    PersonalizePageView.this.gUT.setProgressView(PersonalizePageView.this.gZY);
                    PersonalizePageView.this.gZY.a(aVar);
                    PersonalizePageView.this.gUT.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.har = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hal != null) {
                    PersonalizePageView.this.hal.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hag = 0L;
        this.mSkinType = 3;
        this.gmV = false;
        this.hai = false;
        this.haj = 0;
        this.gne = 0;
        this.hak = false;
        this.dxs = 1;
        this.fYk = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fYi == null) {
                            PersonalizePageView.this.fYi = new k(new i());
                        }
                        PersonalizePageView.this.fYi.a(PersonalizePageView.this.gUL, 2);
                    } else if (PersonalizePageView.this.fYi != null) {
                        PersonalizePageView.this.fYi.km();
                    }
                }
            }
        };
        this.gYX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hab != null) {
                        PersonalizePageView.this.hab.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.ejq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.ejq != i && PersonalizePageView.this.gUR != null) {
                    PersonalizePageView.this.ejq = i;
                    if (PersonalizePageView.this.ejq == 1) {
                        PersonalizePageView.this.gUR.bav();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gUR.baw();
                    } else {
                        PersonalizePageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUS = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bMj() {
                if (PersonalizePageView.this.gUR != null) {
                    PersonalizePageView.this.ejq = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gUL)) {
                        PersonalizePageView.this.gUR.baw();
                    } else {
                        PersonalizePageView.this.gUR.bav();
                    }
                }
            }
        };
        this.ham = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gfl = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_first_install", true);

            private void bNb() {
                if (this.gfl) {
                    this.gfl = false;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.hac == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bxH = PersonalizePageView.this.bxH();
                PersonalizePageView.this.baf();
                if (bxH) {
                    PersonalizePageView.this.eF(true);
                }
                PersonalizePageView.this.hac.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hac != null) {
                    PersonalizePageView.this.hac.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bNb();
                } else if (!this.gfl) {
                    PersonalizePageView.this.gUT.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bNb();
                    PersonalizePageView.this.bLX();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bNb();
                PersonalizePageView.this.gUT.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.baf();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.had.bNo());
                PersonalizePageView.this.eN(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gol != null) {
                    PersonalizePageView.this.gol.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bNc() {
                if (PersonalizePageView.this.ehe != null) {
                    PersonalizePageView.this.ehe.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ehe.endLoadData();
                    PersonalizePageView.this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.han = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aVo().wt("page_recommend");
                PersonalizePageView.this.had.update();
                PersonalizePageView.this.had.mB(false);
                PersonalizePageView.this.hak = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gZz = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.had != null && PersonalizePageView.this.had.bDf() != null) {
                    PersonalizePageView.this.had.bDf().bML();
                }
            }
        };
        this.hao = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aFG() {
                if (PersonalizePageView.this.hak) {
                    PersonalizePageView.this.gne = 0;
                    PersonalizePageView.this.dxs = 1;
                    PersonalizePageView.this.hak = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gZA = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.had != null) {
                    PersonalizePageView.this.had.mB(true);
                    PersonalizePageView.this.had.bNh();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aDr().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.axG().jb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hap = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dkk = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bLz();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gUV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aZN();
            }
        };
        this.gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gmV = true;
                    }
                }
            }
        };
        this.haq = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gUT != null && !PersonalizePageView.this.gUT.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gZZ == null) {
                            PersonalizePageView.this.gZZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gZZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.haa = PersonalizePageView.this.gZZ;
                            PersonalizePageView.this.bMY();
                        } else if (PersonalizePageView.this.haa != PersonalizePageView.this.gZZ) {
                            PersonalizePageView.this.haa = PersonalizePageView.this.gZZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gZZ.setEnable(true);
                        PersonalizePageView.this.gUT.setProgressView(PersonalizePageView.this.gZZ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gUT.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gZY == null) {
                        PersonalizePageView.this.gZY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.haa = PersonalizePageView.this.gZY;
                        PersonalizePageView.this.bMY();
                    } else if (PersonalizePageView.this.haa != PersonalizePageView.this.gZY || !aVar.equals(PersonalizePageView.this.gZY.bNA())) {
                        PersonalizePageView.this.haa = PersonalizePageView.this.gZY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gZY.setEnable(true);
                    PersonalizePageView.this.gUT.setProgressView(PersonalizePageView.this.gZY);
                    PersonalizePageView.this.gZY.a(aVar);
                    PersonalizePageView.this.gUT.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.har = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hal != null) {
                    PersonalizePageView.this.hal.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hag = 0L;
        this.mSkinType = 3;
        this.gmV = false;
        this.hai = false;
        this.haj = 0;
        this.gne = 0;
        this.hak = false;
        this.dxs = 1;
        this.fYk = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fYi == null) {
                            PersonalizePageView.this.fYi = new k(new i());
                        }
                        PersonalizePageView.this.fYi.a(PersonalizePageView.this.gUL, 2);
                    } else if (PersonalizePageView.this.fYi != null) {
                        PersonalizePageView.this.fYi.km();
                    }
                }
            }
        };
        this.gYX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hab != null) {
                        PersonalizePageView.this.hab.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.ejq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.ejq != i2 && PersonalizePageView.this.gUR != null) {
                    PersonalizePageView.this.ejq = i2;
                    if (PersonalizePageView.this.ejq == 1) {
                        PersonalizePageView.this.gUR.bav();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gUR.baw();
                    } else {
                        PersonalizePageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUS = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bMj() {
                if (PersonalizePageView.this.gUR != null) {
                    PersonalizePageView.this.ejq = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gUL)) {
                        PersonalizePageView.this.gUR.baw();
                    } else {
                        PersonalizePageView.this.gUR.bav();
                    }
                }
            }
        };
        this.ham = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gfl = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_first_install", true);

            private void bNb() {
                if (this.gfl) {
                    this.gfl = false;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i2, int i22, int i3) {
                if (PersonalizePageView.this.hac == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bxH = PersonalizePageView.this.bxH();
                PersonalizePageView.this.baf();
                if (bxH) {
                    PersonalizePageView.this.eF(true);
                }
                PersonalizePageView.this.hac.L(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.hac != null) {
                    PersonalizePageView.this.hac.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bNb();
                } else if (!this.gfl) {
                    PersonalizePageView.this.gUT.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bNb();
                    PersonalizePageView.this.bLX();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bNb();
                PersonalizePageView.this.gUT.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.baf();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.had.bNo());
                PersonalizePageView.this.eN(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gol != null) {
                    PersonalizePageView.this.gol.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bNc() {
                if (PersonalizePageView.this.ehe != null) {
                    PersonalizePageView.this.ehe.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ehe.endLoadData();
                    PersonalizePageView.this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.han = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aVo().wt("page_recommend");
                PersonalizePageView.this.had.update();
                PersonalizePageView.this.had.mB(false);
                PersonalizePageView.this.hak = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gZz = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.had != null && PersonalizePageView.this.had.bDf() != null) {
                    PersonalizePageView.this.had.bDf().bML();
                }
            }
        };
        this.hao = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aFG() {
                if (PersonalizePageView.this.hak) {
                    PersonalizePageView.this.gne = 0;
                    PersonalizePageView.this.dxs = 1;
                    PersonalizePageView.this.hak = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gZA = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.had != null) {
                    PersonalizePageView.this.had.mB(true);
                    PersonalizePageView.this.had.bNh();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aDr().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.axG().jb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hap = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dkk = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bLz();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gUV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aZN();
            }
        };
        this.gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gmV = true;
                    }
                }
            }
        };
        this.haq = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gUT != null && !PersonalizePageView.this.gUT.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gZZ == null) {
                            PersonalizePageView.this.gZZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gZZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.haa = PersonalizePageView.this.gZZ;
                            PersonalizePageView.this.bMY();
                        } else if (PersonalizePageView.this.haa != PersonalizePageView.this.gZZ) {
                            PersonalizePageView.this.haa = PersonalizePageView.this.gZZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gZZ.setEnable(true);
                        PersonalizePageView.this.gUT.setProgressView(PersonalizePageView.this.gZZ);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gUT.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gZY == null) {
                        PersonalizePageView.this.gZY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.haa = PersonalizePageView.this.gZY;
                        PersonalizePageView.this.bMY();
                    } else if (PersonalizePageView.this.haa != PersonalizePageView.this.gZY || !aVar.equals(PersonalizePageView.this.gZY.bNA())) {
                        PersonalizePageView.this.haa = PersonalizePageView.this.gZY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gZY.setEnable(true);
                    PersonalizePageView.this.gUT.setProgressView(PersonalizePageView.this.gZY);
                    PersonalizePageView.this.gZY.a(aVar);
                    PersonalizePageView.this.gUT.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.har = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hal != null) {
                    PersonalizePageView.this.hal.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gUL = new BdTypeRecyclerView(context);
        this.ctD = new LinearLayoutManager(this.gUL.getContext());
        this.gUL.setLayoutManager(this.ctD);
        this.gUL.setFadingEdgeLength(0);
        this.gUL.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fYi = new k(new i());
            this.fYi.a(this.gUL, 2);
        }
        MessageManager.getInstance().registerListener(this.fYk);
        this.gUT = new BigdaySwipeRefreshLayout(context);
        this.gUT.addView(this.gUL);
        this.ehe = new PbListView(context);
        this.ehe.getView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setLineGone();
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.ehe.setOnClickListener(this.gUV);
        this.ehe.aFs();
        this.gUL.setNextPage(this.ehe);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.haq);
        com.baidu.tbadk.core.bigday.b.axG().fm(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aDr().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.axG().jb(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gUT);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.hal = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.hal, layoutParams);
            this.hal.setOnClickListener(this.har);
            this.hal.setVisibility(8);
        }
        this.haf = new com.baidu.tieba.homepage.personalize.model.e();
        this.hab = new ab(context, this.gUL);
        this.hab.b(this.haf);
        this.had = new e(this.pageContext, this.gUL, this.hab, this.gUT);
        this.hae = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gnE);
        this.haj = com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(Context context) {
        if (this.hah == null) {
            this.hah = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.hah, layoutParams);
            this.hah.setVisibility(8);
            this.hah.setPageId(this.pageContext.getUniqueId());
            this.gol = new com.baidu.tieba.c.c(this.pageContext, this.hah, 1);
        }
    }

    public void bMY() {
        if (this.haa != null) {
            this.haa.setListPullRefreshListener(this.han);
            this.haa.a(this.gZz);
            this.haa.a(this.hao);
            this.haa.a(this.gZA);
        }
    }

    public void initListeners() {
        this.hab.b(this.gYX);
        this.had.a(this.ham);
        this.hae.a(this);
        bMY();
        this.gUL.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gne += i2;
                if (PersonalizePageView.this.hal != null) {
                    m item = PersonalizePageView.this.gUL.getItem(PersonalizePageView.this.ctD.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.hal.show();
                        } else {
                            PersonalizePageView.this.hal.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.ctD != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gne < height * 3 || PersonalizePageView.this.dxs != 1) {
                        if (PersonalizePageView.this.gne < height * 3 && PersonalizePageView.this.dxs == 2) {
                            PersonalizePageView.this.dxs = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.dxs = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.dxs)));
                    }
                    if (PersonalizePageView.this.ctD.getItemCount() - PersonalizePageView.this.ctD.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.aZN();
                    }
                }
            }
        });
        this.gUL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aZN();
            }
        });
        this.gUL.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.hag >= 5000) {
                    PersonalizePageView.this.had.bT(i, i2);
                }
            }
        }, 1L);
        this.gUL.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.had != null && PersonalizePageView.this.had.bDf() != null) {
                        PersonalizePageView.this.had.bDf().cl(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).bue().stopPlay();
                    }
                }
            }
        });
        this.gUL.removeOnScrollListener(this.mOnScrollListener);
        this.gUL.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hac = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.ehe != null) {
            this.ehe.setText(getContext().getString(R.string.pb_load_more));
            this.ehe.endLoadData();
            this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.had.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.had != null) {
            this.had.mF(!z);
        }
        this.hai = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.hai;
    }

    public void e(Long l) {
        this.had.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.had != null) {
            this.had.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.had != null) {
            this.had.showFloatingView();
        }
    }

    public void bMZ() {
        if (this.had != null) {
            this.had.bMZ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.epL != null) {
                this.epL.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gZZ != null) {
                this.gZZ.changeSkin(i);
            }
            if (this.ehe != null) {
                this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
                this.ehe.changeSkin(i);
            }
            this.hab.onChangeSkinType(i);
            if (this.had != null) {
                this.had.onChangeSkinType(i);
            }
            if (this.hal != null) {
                this.hal.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aG(String str, int i) {
        if (this.ehe != null) {
            this.ehe.setText(getContext().getString(R.string.pb_load_more));
            this.ehe.endLoadData();
            this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.had.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.had != null) {
                        PersonalizePageView.this.had.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this);
            this.epL = null;
            this.gUL.setNextPage(this.ehe);
            this.ehe.setText(getContext().getString(R.string.pb_load_more));
            this.ehe.endLoadData();
            this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.gUT != null) {
            this.gUT.setVisibility(0);
        }
        if (this.hac != null) {
            this.hac.bLO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxH() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(boolean z) {
        if (this.epL == null) {
            this.epL = new com.baidu.tbadk.k.g(getContext());
            this.epL.mm(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.epL.aNv();
            this.epL.setWrapStyle(true);
            this.epL.onChangeSkinType();
        }
        this.epL.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.gUL.setNextPage(null);
        if (this.gUT != null) {
            this.gUT.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.had != null) {
            this.had.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.gol != null) {
            this.gol.aYl();
        }
        setViewForeground(false);
        if (this.had != null) {
            this.had.lq(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.haj < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hap, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.had != null) {
            this.had.mv(z);
        }
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
            this.gUR.a(this.gUS);
            this.gUS.bMj();
        }
    }

    public void bLX() {
        if (this.had != null) {
            eF(true);
            this.had.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.axG().axI();
            com.baidu.tbadk.core.bigday.b.axG().axH();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.had != null) {
            this.had.update();
        } else if (this.gUL != null && this.gUT != null) {
            showFloatingView();
            this.gUL.setSelection(0);
            if (!this.gUT.isRefreshing()) {
                if (this.had != null && this.had.bDf() != null) {
                    this.had.bDf().bML();
                    this.had.mB(false);
                }
                this.gUT.setRefreshing(true);
            }
            if (this.gUS != null) {
                this.gUS.bMj();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fYk);
        MessageManager.getInstance().unRegisterListener(this.gnE);
        MessageManager.getInstance().unRegisterListener(this.haq);
        this.had.onDestroy();
        this.hab.b((NEGFeedBackView.a) null);
        this.hab.onDestroy();
        this.had.a((e.a) null);
        if (this.gZY != null) {
            this.gZY.setListPullRefreshListener(null);
            this.gZY.a((g.d) null);
            this.gZY.a((g.a) null);
            this.gZY.a((g.b) null);
            this.gZY.release();
        }
        if (this.gZZ != null) {
            this.gZZ.setListPullRefreshListener(null);
            this.gZZ.a((g.d) null);
            this.gZZ.a((g.a) null);
            this.gZZ.a((g.b) null);
            this.gZZ.release();
        }
        this.gUL.setOnSrollToBottomListener(null);
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
        }
        this.gUL.removeOnScrollListener(this.mOnScrollListener);
        if (this.epL != null) {
            this.epL.release();
        }
        this.gUL.setRecyclerListener(null);
        if (this.hae != null) {
            this.hae.onDestroy();
        }
        if (this.gol != null) {
            this.gol.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.axG().destroy();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hap);
    }

    public void onPause() {
        this.had.onPause();
        if (this.hab != null) {
            this.hab.onPause();
        }
    }

    public void onResume() {
        if (this.gmV) {
            reload();
            this.gmV = false;
        }
        if (this.gUT != null) {
            this.gUT.resume();
        }
        if (this.hab != null) {
            this.hab.onResume();
        }
    }

    public void bLz() {
        if (this.hab != null) {
            this.hab.notifyDataSetChanged();
        }
    }

    public void bLA() {
        if (this.had != null) {
            this.had.lq(true);
        }
        r.btA().hU(false);
        com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hap);
    }

    public void bMV() {
        this.had.bNn();
    }

    public void bNa() {
        this.had.bNa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        com.baidu.tieba.homepage.framework.a.bLN().q(System.currentTimeMillis(), 1);
        if (this.ehe != null && !this.ehe.isLoading()) {
            this.ehe.startLoadData();
            this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.had.aZN();
    }
}
