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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.b.o;
import com.baidu.tieba.homepage.personalize.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aTw;
    private PbListView ben;
    private com.baidu.tbadk.k.f bfY;
    private View.OnClickListener cZh;
    private boolean cqC;
    private final CustomMessageListener cqX;
    private View crD;
    private CustomMessageListener cra;
    private List<com.baidu.tieba.homepage.b.a.a> dbE;
    private o dcj;
    private com.baidu.tieba.homepage.framework.b dck;
    private e dcl;
    private com.baidu.tieba.homepage.personalize.model.e dcm;
    private ScrollFragmentTabHost dcn;
    private boolean dco;
    private boolean dcp;
    private long dcq;
    private h.a dcr;
    private e.a dcs;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dcl != null) {
            this.dcn = scrollFragmentTabHost;
            this.dcl.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aTw != null) {
            this.aTw.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dcj != null) {
            this.dcj.setPageUniqueId(bdUniqueId);
        }
        if (this.dcl != null) {
            this.dcl.l(bdUniqueId);
        }
        if (this.dcm != null) {
            this.dcm.p(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cqX != null) {
            this.cqX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cqX);
        }
    }

    public c(Context context) {
        super(context);
        this.dco = false;
        this.dcq = 0L;
        this.cqC = false;
        this.dcr = new h.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
            @Override // com.baidu.tbadk.core.view.h.a
            public void a(an anVar) {
                if (anVar != null) {
                    TiebaStatic.log(new ak("c11693").ad("obj_locate", "1").ad("fid", anVar.getFid()).ad("tid", anVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ad("fid", anVar.getFid()).ad("tid", anVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tbadk.core.view.h.a
            public void a(an anVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tbadk.core.view.h.a
            public void a(ArrayList<Integer> arrayList, an anVar) {
                if (arrayList != null && anVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ak("c11693").ad("obj_locate", sb.toString()).ad("fid", anVar.getFid()).ad("tid", anVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dcs = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aI(int i, int i2) {
                if (c.this.dck == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.NE();
                    return;
                }
                boolean aql = c.this.aql();
                c.this.NH();
                if (aql) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.dck.aH(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3) {
                if (c.this.dck != null) {
                    c.this.dck.u(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.NE();
                if (i != 1) {
                    c.this.aTw.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (i.hi()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aTw.setVisibility(0);
                c.this.NE();
                c.this.NH();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void l(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
                if (c.this.dck != null && !c.this.dco) {
                    c.this.dck.k(list, z);
                }
                c.this.dbE = list;
                c.this.dcp = z;
            }
        };
        this.cqX = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                        com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.apJ();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.cZh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Ng();
            }
        };
        this.cra = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cqC = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTw = new BdTypeListView(context);
        this.aTw.setDividerHeight(0);
        this.aTw.setSelector(17170445);
        this.ben = new PbListView(context);
        this.ben.lb();
        this.ben.dp(d.e.cp_bg_line_c);
        this.ben.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.ben.dq(TbadkCoreApplication.getInst().getSkinType());
        this.ben.setOnClickListener(this.cZh);
        this.aTw.setNextPage(this.ben);
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new l(this.pageContext);
        this.aTw.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.crD = BdListViewHelper.a(context, this.aTw, BdListViewHelper.HeadType.DEFAULT);
        this.dcm = new com.baidu.tieba.homepage.personalize.model.e();
        this.dcj = new o(context, this.aTw);
        this.dcj.b(this.dcm);
        this.dcl = new e(this.pageContext, this.aTw, this.dcj);
        addView(this.aTw);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cra);
    }

    public void aqj() {
        this.dcj.a(this.dcr);
        this.dcl.a(this.dcs);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.dco = true;
                c.this.dcl.update();
            }
        });
        this.mPullView.a(new k.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (c.this.dcl != null) {
                    if (c.this.dcl.ahz() != null) {
                        c.this.dcl.ahz().asu();
                    }
                    c.this.dcl.fT(false);
                }
            }
        });
        this.aTw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Ng();
            }
        });
        this.aTw.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.dcq >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.dcl.aJ(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new k.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (c.this.dcl != null) {
                    c.this.dcl.fT(true);
                    c.this.dcl.aqS();
                }
                if (c.this.dck != null && c.this.dco) {
                    c.this.dck.k(c.this.dbE, c.this.dcp);
                }
                c.this.dco = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aTw.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.dcl != null && c.this.dcl.ahz() != null) {
                        c.this.dcl.ahz().aZ(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.d) {
                        ((com.baidu.tieba.homepage.personalize.b.d) view.getTag()).YJ().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dck = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.ben != null) {
            this.ben.wW();
            this.ben.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dcl.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.crD != null && this.crD.getLayoutParams() != null) {
            if (this.dcl != null) {
                this.dcl.setHeaderViewHeight(i);
            }
            this.crD.getLayoutParams().height = i;
            this.crD.setLayoutParams(this.crD.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.dcl != null) {
            this.dcl.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void showFloatingView() {
        if (this.dcl != null) {
            this.dcl.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bfY != null) {
            this.bfY.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
        if (this.ben != null) {
            this.ben.setTextColor(aj.getColor(d.e.cp_cont_d));
            this.ben.dq(i);
        }
        this.dcj.onChangeSkinType(i);
        aj.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.ben != null) {
            this.ben.wW();
            this.ben.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dcl.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dcl != null) {
                        c.this.dcl.update();
                    }
                }
            });
        }
        this.refreshView.eZ(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gv(str);
        this.refreshView.c(view, z);
        this.refreshView.ER();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NH() {
        if (this.refreshView != null) {
            this.refreshView.N(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NE() {
        if (this.bfY != null) {
            this.bfY.N(this);
            this.bfY = null;
            this.aTw.setNextPage(this.ben);
        }
        if (this.dck != null) {
            this.dck.aqy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aql() {
        if (this.refreshView != null) {
            return this.refreshView.EI();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bfY == null) {
            if (i < 0) {
                this.bfY = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bfY = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bfY.onChangeSkinType();
        }
        this.bfY.c(this, z);
        this.aTw.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dcl != null) {
            this.dcl.setTabInForeBackgroundState(z);
        }
    }

    public void aqm() {
        setViewForeground(false);
        if (this.dcl != null) {
            this.dcl.eP(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dcl != null) {
            this.dcl.fO(z);
        }
    }

    public void aqi() {
        if (this.dcl != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.dcl.update();
        }
    }

    public void reload() {
        if (this.aTw != null) {
            showFloatingView();
            this.aTw.setSelection(0);
            if (this.aTw.isRefreshDone()) {
                if (this.dcl != null && this.dcl.ahz() != null) {
                    this.dcl.ahz().asu();
                    this.dcl.fT(false);
                }
                this.aTw.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cra);
        this.dcl.onDestroy();
        this.dcj.a((h.a) null);
        this.dcl.a((e.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTw.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        if (this.bfY != null) {
            this.bfY.release();
        }
        this.aTw.setRecyclerListener(null);
    }

    public void onPause() {
        this.dcl.onPause();
    }

    public void onResume() {
        this.dcl.onResume();
        if (this.cqC) {
            reload();
            this.cqC = false;
        }
    }

    public void apJ() {
        if (this.dcj != null) {
            this.dcj.notifyDataSetChanged();
        }
    }

    public void aqn() {
        if (this.dcl != null) {
            this.dcl.eP(true);
        }
        u.Yj().cC(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aqN() {
        this.dcl.aqZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ng() {
        if (this.ben != null && !this.ben.xa()) {
            this.ben.wV();
            this.ben.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dcl.Ng();
    }
}
