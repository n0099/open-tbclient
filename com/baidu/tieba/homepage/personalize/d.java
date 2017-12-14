package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.k;
import com.baidu.tieba.homepage.personalize.f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private BdTypeListView aXy;
    private com.baidu.tbadk.j.f bhA;
    private PbListView blv;
    private boolean cHN;
    private View cIO;
    private final CustomMessageListener cIk;
    private CustomMessageListener cIn;
    private View.OnClickListener dnO;
    private k dqU;
    private com.baidu.tieba.homepage.framework.b dqV;
    private f dqW;
    private a dqX;
    private com.baidu.tieba.homepage.personalize.model.e dqY;
    private long dqZ;
    private boolean dra;
    private c.a drb;
    private f.a drc;
    private i mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dqW != null) {
            this.dqW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dqX != null) {
            this.dqX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aXy != null) {
            this.aXy.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqU != null) {
            this.dqU.setPageUniqueId(bdUniqueId);
        }
        if (this.dqW != null) {
            this.dqW.k(bdUniqueId);
        }
        if (this.dqY != null) {
            this.dqY.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cIk != null) {
            this.cIk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIk);
        }
    }

    public d(Context context) {
        super(context);
        this.dqZ = 0L;
        this.mSkinType = 3;
        this.cHN = false;
        this.dra = false;
        this.drb = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ArrayList<Integer> arrayList, ah ahVar) {
                if (arrayList != null && ahVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.drc = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void aQ(int i, int i2) {
                if (d.this.dqV == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.NO();
                    return;
                }
                boolean atA = d.this.atA();
                d.this.Pr();
                if (atA) {
                    d.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.dqV.aP(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void E(int i, int i2, int i3) {
                if (d.this.dqV != null) {
                    d.this.dqV.D(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.NO();
                if (i != 1) {
                    d.this.aXy.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.hh()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.aXy.setVisibility(0);
                d.this.NO();
                d.this.Pr();
            }
        };
        this.cIk = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.d.2
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
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.atD();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dnO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.OI();
            }
        };
        this.cIn = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.cHN = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aXy = new BdTypeListView(context);
        this.aXy.setDividerHeight(0);
        this.aXy.setSelector(17170445);
        this.blv = new PbListView(context);
        this.blv.getView();
        this.blv.dy(d.C0096d.cp_bg_line_e);
        this.blv.ws();
        this.blv.setTextColor(aj.getColor(d.C0096d.cp_cont_j));
        this.blv.setTextSize(d.e.tbds30);
        this.blv.dx(d.C0096d.cp_cont_e);
        this.blv.setHeight(l.f(context, d.e.tbds182));
        this.blv.setOnClickListener(this.dnO);
        this.aXy.setNextPage(this.blv);
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new i(this.pageContext);
        this.aXy.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.cIO = BdListViewHelper.a(context, this.aXy, BdListViewHelper.HeadType.DEFAULT);
        this.dqY = new com.baidu.tieba.homepage.personalize.model.e();
        this.dqU = new k(context, this.aXy);
        this.dqU.b(this.dqY);
        this.dqW = new f(this.pageContext, this.aXy, this.dqU);
        this.dqX = new a(this.pageContext);
        addView(this.aXy);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cIn);
    }

    public void aoZ() {
        this.dqU.a(this.drb);
        this.dqW.a(this.drc);
        this.dqX.a(this);
        this.mPullView.a(new h.b() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefresh(boolean z) {
                d.this.dqW.update();
            }
        });
        this.mPullView.a(new h.c() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tbadk.core.view.h.c
            public void aL(boolean z) {
                if (d.this.dqW != null) {
                    if (d.this.dqW.alM() != null) {
                        d.this.dqW.alM().avu();
                    }
                    d.this.dqW.gb(false);
                }
            }
        });
        this.aXy.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.OI();
            }
        });
        this.aXy.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.dqZ >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.dqW.aR(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new h.a() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.tbadk.core.view.h.a
            public void b(View view, boolean z) {
                if (d.this.dqW != null) {
                    d.this.dqW.gb(true);
                    d.this.dqW.auk();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aXy.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.dqW != null && d.this.dqW.alM() != null) {
                        d.this.dqW.alM().aT(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).acC().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dqV = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.blv != null) {
            this.blv.ww();
            this.blv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dqW.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dqW != null) {
            this.dqW.fZ(!z);
        }
        this.dra = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dra;
    }

    public void e(Long l) {
        this.dqW.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIO != null && this.cIO.getLayoutParams() != null) {
            if (this.dqW != null) {
                this.dqW.setHeaderViewHeight(i);
            }
            if (this.dqX != null) {
                this.dqX.setHeaderViewHeight(i);
            }
            this.cIO.getLayoutParams().height = i;
            this.cIO.setLayoutParams(this.cIO.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dqW != null) {
            this.dqW.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dqW != null) {
            this.dqW.showFloatingView();
        }
    }

    public void aug() {
        if (this.dqW != null) {
            this.dqW.aug();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bhA != null) {
                this.bhA.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.blv != null) {
                this.blv.setTextColor(aj.getColor(d.C0096d.cp_cont_d));
                this.blv.dz(i);
            }
            this.dqU.onChangeSkinType(i);
            aj.k(this, d.C0096d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void W(String str, int i) {
        if (this.blv != null) {
            this.blv.ww();
            this.blv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dqW.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dqW != null) {
                        d.this.dqW.update();
                    }
                }
            });
        }
        this.refreshView.fi(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gB(str);
        this.refreshView.c(view, z);
        this.refreshView.EW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NO() {
        if (this.bhA != null) {
            this.bhA.P(this);
            this.bhA = null;
            this.aXy.setNextPage(this.blv);
        }
        if (this.dqV != null) {
            this.dqV.atQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atA() {
        if (this.refreshView != null) {
            return this.refreshView.EO();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhA == null) {
            if (i < 0) {
                this.bhA = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bhA = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bhA.onChangeSkinType();
        }
        this.bhA.c(this, z);
        this.aXy.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dqW != null) {
            this.dqW.setTabInForeBackgroundState(z);
        }
    }

    public void atC() {
        setViewForeground(false);
        if (this.dqW != null) {
            this.dqW.eX(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dqW != null) {
            this.dqW.fU(z);
        }
    }

    public void aty() {
        if (this.dqW != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dqW.update();
        }
    }

    public void reload() {
        if (this.aXy != null) {
            showFloatingView();
            this.aXy.setSelection(0);
            if (this.aXy.isRefreshDone()) {
                if (this.dqW != null && this.dqW.alM() != null) {
                    this.dqW.alM().avu();
                    this.dqW.gb(false);
                }
                this.aXy.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIn);
        this.dqW.onDestroy();
        this.dqU.a((c.a) null);
        this.dqW.a((f.a) null);
        this.mPullView.a((h.b) null);
        this.mPullView.a((h.c) null);
        this.aXy.setOnSrollToBottomListener(null);
        this.mPullView.a((h.a) null);
        this.mPullView.release();
        if (this.bhA != null) {
            this.bhA.release();
        }
        this.aXy.setRecyclerListener(null);
        if (this.dqX != null) {
            this.dqX.onDestroy();
        }
    }

    public void onPause() {
        this.dqW.onPause();
    }

    public void onResume() {
        this.dqW.onResume();
        if (this.cHN) {
            reload();
            this.cHN = false;
        }
        atD();
    }

    public void atD() {
        if (this.dqU != null) {
            this.dqU.notifyDataSetChanged();
        }
    }

    public void atE() {
        if (this.dqW != null) {
            this.dqW.eX(true);
        }
        com.baidu.tieba.card.s.abX().cC(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aue() {
        this.dqW.auq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.blv != null && !this.blv.wA()) {
            this.blv.wv();
            this.blv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dqW.OI();
    }
}
