package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
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
    private BdTypeListView aXw;
    private com.baidu.tbadk.j.f bhz;
    private PbListView blu;
    private boolean cHE;
    private View cIF;
    private final CustomMessageListener cIb;
    private CustomMessageListener cIe;
    private View.OnClickListener dmJ;
    private k dpP;
    private com.baidu.tieba.homepage.framework.b dpQ;
    private f dpR;
    private a dpS;
    private com.baidu.tieba.homepage.personalize.model.e dpT;
    private long dpU;
    private boolean dpV;
    private c.a dpW;
    private f.a dpX;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dpR != null) {
            this.dpR.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dpS != null) {
            this.dpS.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aXw != null) {
            this.aXw.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dpP != null) {
            this.dpP.setPageUniqueId(bdUniqueId);
        }
        if (this.dpR != null) {
            this.dpR.k(bdUniqueId);
        }
        if (this.dpT != null) {
            this.dpT.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cIb != null) {
            this.cIb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIb);
        }
    }

    public d(Context context) {
        super(context);
        this.dpU = 0L;
        this.mSkinType = 3;
        this.cHE = false;
        this.dpV = false;
        this.dpW = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dpX = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void aP(int i, int i2) {
                if (d.this.dpQ == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.NO();
                    return;
                }
                boolean atr = d.this.atr();
                d.this.Pr();
                if (atr) {
                    d.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.dpQ.aO(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void E(int i, int i2, int i3) {
                if (d.this.dpQ != null) {
                    d.this.dpQ.D(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.NO();
                if (i != 1) {
                    d.this.aXw.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.hh()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.aXw.setVisibility(0);
                d.this.NO();
                d.this.Pr();
            }
        };
        this.cIb = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.d.2
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
                                d.this.atu();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dmJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.OI();
            }
        };
        this.cIe = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.cHE = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aXw = new BdTypeListView(context);
        this.aXw.setDividerHeight(0);
        this.aXw.setSelector(17170445);
        this.blu = new PbListView(context);
        this.blu.getView();
        this.blu.dy(d.C0082d.cp_bg_line_e);
        this.blu.wu();
        this.blu.setTextColor(aj.getColor(d.C0082d.cp_cont_j));
        this.blu.setTextSize(d.e.tbds30);
        this.blu.dx(d.C0082d.cp_cont_e);
        this.blu.setHeight(l.f(context, d.e.tbds182));
        this.blu.setOnClickListener(this.dmJ);
        this.aXw.setNextPage(this.blu);
        com.baidu.adp.base.e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aXw.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.cIF = BdListViewHelper.a(context, this.aXw, BdListViewHelper.HeadType.DEFAULT);
        this.dpT = new com.baidu.tieba.homepage.personalize.model.e();
        this.dpP = new k(context, this.aXw);
        this.dpP.b(this.dpT);
        this.dpR = new f(this.pageContext, this.aXw, this.dpP);
        this.dpS = new a(this.pageContext);
        addView(this.aXw);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cIe);
    }

    public void aoQ() {
        this.dpP.a(this.dpW);
        this.dpR.a(this.dpX);
        this.dpS.a(this);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                d.this.dpR.update();
            }
        });
        this.mPullView.a(new g.c() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tbadk.core.view.g.c
            public void aK(boolean z) {
                if (d.this.dpR != null) {
                    if (d.this.dpR.alD() != null) {
                        d.this.dpR.alD().avl();
                    }
                    d.this.dpR.ga(false);
                }
            }
        });
        this.aXw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.OI();
            }
        });
        this.aXw.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.dpU >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.dpR.aQ(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new g.a() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (d.this.dpR != null) {
                    d.this.dpR.ga(true);
                    d.this.dpR.aub();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aXw.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.dpR != null && d.this.dpR.alD() != null) {
                        d.this.dpR.alD().aQ(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).acs().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dpQ = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.blu != null) {
            this.blu.wy();
            this.blu.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dpR.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dpR != null) {
            this.dpR.fY(!z);
        }
        this.dpV = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dpV;
    }

    public void e(Long l) {
        this.dpR.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIF != null && this.cIF.getLayoutParams() != null) {
            if (this.dpR != null) {
                this.dpR.setHeaderViewHeight(i);
            }
            if (this.dpS != null) {
                this.dpS.setHeaderViewHeight(i);
            }
            this.cIF.getLayoutParams().height = i;
            this.cIF.setLayoutParams(this.cIF.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dpR != null) {
            this.dpR.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dpR != null) {
            this.dpR.showFloatingView();
        }
    }

    public void atX() {
        if (this.dpR != null) {
            this.dpR.atX();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bhz != null) {
                this.bhz.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.blu != null) {
                this.blu.setTextColor(aj.getColor(d.C0082d.cp_cont_d));
                this.blu.dz(i);
            }
            this.dpP.onChangeSkinType(i);
            aj.k(this, d.C0082d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void V(String str, int i) {
        if (this.blu != null) {
            this.blu.wy();
            this.blu.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dpR.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dpR != null) {
                        d.this.dpR.update();
                    }
                }
            });
        }
        this.refreshView.fi(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gC(str);
        this.refreshView.c(view, z);
        this.refreshView.EV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NO() {
        if (this.bhz != null) {
            this.bhz.O(this);
            this.bhz = null;
            this.aXw.setNextPage(this.blu);
        }
        if (this.dpQ != null) {
            this.dpQ.atH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atr() {
        if (this.refreshView != null) {
            return this.refreshView.EN();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhz == null) {
            if (i < 0) {
                this.bhz = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bhz = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bhz.onChangeSkinType();
        }
        this.bhz.c(this, z);
        this.aXw.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dpR != null) {
            this.dpR.setTabInForeBackgroundState(z);
        }
    }

    public void att() {
        setViewForeground(false);
        if (this.dpR != null) {
            this.dpR.eW(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dpR != null) {
            this.dpR.fT(z);
        }
    }

    public void atp() {
        if (this.dpR != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dpR.update();
        }
    }

    public void reload() {
        if (this.aXw != null) {
            showFloatingView();
            this.aXw.setSelection(0);
            if (this.aXw.isRefreshDone()) {
                if (this.dpR != null && this.dpR.alD() != null) {
                    this.dpR.alD().avl();
                    this.dpR.ga(false);
                }
                this.aXw.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIe);
        this.dpR.onDestroy();
        this.dpP.a((c.a) null);
        this.dpR.a((f.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aXw.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        if (this.bhz != null) {
            this.bhz.release();
        }
        this.aXw.setRecyclerListener(null);
        if (this.dpS != null) {
            this.dpS.onDestroy();
        }
    }

    public void onPause() {
        this.dpR.onPause();
    }

    public void onResume() {
        this.dpR.onResume();
        if (this.cHE) {
            reload();
            this.cHE = false;
        }
        atu();
    }

    public void atu() {
        if (this.dpP != null) {
            this.dpP.notifyDataSetChanged();
        }
    }

    public void atv() {
        if (this.dpR != null) {
            this.dpR.eW(true);
        }
        com.baidu.tieba.card.s.abU().cB(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void atV() {
        this.dpR.auh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.blu != null && !this.blu.wC()) {
            this.blu.wx();
            this.blu.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dpR.OI();
    }
}
