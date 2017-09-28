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
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.q;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.o;
import com.baidu.tieba.homepage.personalize.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aUv;
    private PbListView bgb;
    private com.baidu.tbadk.j.f bhL;
    private View.OnClickListener cVC;
    private o cYB;
    private com.baidu.tieba.homepage.framework.b cYC;
    private e cYD;
    private com.baidu.tieba.homepage.personalize.model.e cYE;
    private long cYF;
    private c.a cYG;
    private e.a cYH;
    private boolean cqX;
    private View crZ;
    private final CustomMessageListener cru;
    private CustomMessageListener crx;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cYD != null) {
            this.cYD.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aUv != null) {
            this.aUv.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cYB != null) {
            this.cYB.setPageUniqueId(bdUniqueId);
        }
        if (this.cYD != null) {
            this.cYD.k(bdUniqueId);
        }
        if (this.cYE != null) {
            this.cYE.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cru != null) {
            this.cru.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cru);
        }
    }

    public c(Context context) {
        super(context);
        this.cYF = 0L;
        this.mSkinType = 3;
        this.cqX = false;
        this.cYG = new c.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new ak("c11693").ad("obj_locate", "1").ad("fid", alVar.getFid()).ad("tid", alVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ad("fid", alVar.getFid()).ad("tid", alVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ArrayList<Integer> arrayList, al alVar) {
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ak("c11693").ad("obj_locate", sb.toString()).ad("fid", alVar.getFid()).ad("tid", alVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.cYH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aO(int i, int i2) {
                if (c.this.cYC == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.NZ();
                    return;
                }
                boolean aoO = c.this.aoO();
                c.this.Oc();
                if (aoO) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cYC.aN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3) {
                if (c.this.cYC != null) {
                    c.this.cYC.z(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.NZ();
                if (i != 1) {
                    c.this.aUv.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (j.hh()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aUv.setVisibility(0);
                c.this.NZ();
                c.this.Oc();
            }
        };
        this.cru = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.apu();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.cVC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Ny();
            }
        };
        this.crx = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cqX = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUv = new BdTypeListView(context);
        this.aUv.setDividerHeight(0);
        this.aUv.setSelector(17170445);
        this.bgb = new PbListView(context);
        this.bgb.getView();
        this.bgb.dy(d.e.cp_bg_line_d);
        this.bgb.wq();
        this.bgb.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.bgb.dx(d.e.cp_cont_e);
        this.bgb.setHeight(l.f(context, d.f.ds140));
        this.bgb.setOnClickListener(this.cVC);
        this.aUv.setNextPage(this.bgb);
        com.baidu.adp.base.e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUv.setPullRefresh(this.mPullView);
        this.mPullView.X(true);
        this.crZ = BdListViewHelper.a(context, this.aUv, BdListViewHelper.HeadType.DEFAULT);
        this.cYE = new com.baidu.tieba.homepage.personalize.model.e();
        this.cYB = new o(context, this.aUv);
        this.cYB.b(this.cYE);
        this.cYD = new e(this.pageContext, this.aUv, this.cYB);
        addView(this.aUv);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.crx);
    }

    public void aoM() {
        this.cYB.a(this.cYG);
        this.cYD.a(this.cYH);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                c.this.cYD.update();
            }
        });
        this.mPullView.a(new g.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.g.c
            public void aN(boolean z) {
                if (c.this.cYD != null) {
                    if (c.this.cYD.ahs() != null) {
                        c.this.cYD.ahs().ard();
                    }
                    c.this.cYD.fF(false);
                }
            }
        });
        this.aUv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Ny();
            }
        });
        this.aUv.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.cYF >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.cYD.aP(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new g.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (c.this.cYD != null) {
                    c.this.cYD.fF(true);
                    c.this.cYD.apy();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aUv.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.cYD != null && c.this.cYD.ahs() != null) {
                        c.this.cYD.ahs().aU(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).Yr().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cYC = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bgb != null) {
            this.bgb.wu();
            this.bgb.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYD.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.crZ != null && this.crZ.getLayoutParams() != null) {
            if (this.cYD != null) {
                this.cYD.setHeaderViewHeight(i);
            }
            this.crZ.getLayoutParams().height = i;
            this.crZ.setLayoutParams(this.crZ.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (this.cYD != null) {
            this.cYD.setRecommendFrsNavigationAnimDispatcher(qVar);
        }
    }

    public void showFloatingView() {
        if (this.cYD != null) {
            this.cYD.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bhL != null) {
                this.bhL.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.bgb != null) {
                this.bgb.setTextColor(aj.getColor(d.e.cp_cont_d));
                this.bgb.dz(i);
            }
            this.cYB.onChangeSkinType(i);
            aj.k(this, d.e.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void N(String str, int i) {
        if (this.bgb != null) {
            this.bgb.wu();
            this.bgb.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYD.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cYD != null) {
                        c.this.cYD.update();
                    }
                }
            });
        }
        this.refreshView.fk(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gr(str);
        this.refreshView.c(view, z);
        this.refreshView.Ew();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NZ() {
        if (this.bhL != null) {
            this.bhL.O(this);
            this.bhL = null;
            this.aUv.setNextPage(this.bgb);
        }
        if (this.cYC != null) {
            this.cYC.ape();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoO() {
        if (this.refreshView != null) {
            return this.refreshView.En();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bhL == null) {
            if (i < 0) {
                this.bhL = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bhL = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bhL.onChangeSkinType();
        }
        this.bhL.c(this, z);
        this.aUv.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cYD != null) {
            this.cYD.setTabInForeBackgroundState(z);
        }
    }

    public void aoQ() {
        setViewForeground(false);
        if (this.cYD != null) {
            this.cYD.eF(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cYD != null) {
            this.cYD.fA(z);
        }
    }

    public void aoL() {
        if (this.cYD != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cYD.update();
        }
    }

    public void reload() {
        if (this.aUv != null) {
            showFloatingView();
            this.aUv.setSelection(0);
            if (this.aUv.isRefreshDone()) {
                if (this.cYD != null && this.cYD.ahs() != null) {
                    this.cYD.ahs().ard();
                    this.cYD.fF(false);
                }
                this.aUv.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.crx);
        this.cYD.onDestroy();
        this.cYB.a((c.a) null);
        this.cYD.a((e.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUv.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        if (this.bhL != null) {
            this.bhL.release();
        }
        this.aUv.setRecyclerListener(null);
    }

    public void onPause() {
        this.cYD.onPause();
    }

    public void onResume() {
        this.cYD.onResume();
        if (this.cqX) {
            reload();
            this.cqX = false;
        }
    }

    public void apu() {
        if (this.cYB != null) {
            this.cYB.notifyDataSetChanged();
        }
    }

    public void aoR() {
        if (this.cYD != null) {
            this.cYD.eF(true);
        }
        u.XR().cB(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aps() {
        this.cYD.apF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny() {
        if (this.bgb != null && !this.bgb.wz()) {
            this.bgb.wt();
            this.bgb.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYD.Ny();
    }
}
