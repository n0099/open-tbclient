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
    private BdTypeListView aTz;
    private PbListView beq;
    private com.baidu.tbadk.k.f bgb;
    private View.OnClickListener cYn;
    private boolean cpK;
    private View cqK;
    private final CustomMessageListener cqf;
    private CustomMessageListener cqi;
    private List<com.baidu.tieba.homepage.b.a.a> daK;
    private o dbp;
    private com.baidu.tieba.homepage.framework.b dbq;
    private e dbr;
    private com.baidu.tieba.homepage.personalize.model.e dbs;
    private ScrollFragmentTabHost dbt;
    private boolean dbu;
    private boolean dbv;
    private long dbw;
    private h.a dbx;
    private e.a dby;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dbr != null) {
            this.dbt = scrollFragmentTabHost;
            this.dbr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aTz != null) {
            this.aTz.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dbp != null) {
            this.dbp.setPageUniqueId(bdUniqueId);
        }
        if (this.dbr != null) {
            this.dbr.l(bdUniqueId);
        }
        if (this.dbs != null) {
            this.dbs.p(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cqf != null) {
            this.cqf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cqf);
        }
    }

    public c(Context context) {
        super(context);
        this.dbu = false;
        this.dbw = 0L;
        this.cpK = false;
        this.dbx = new h.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
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
        this.dby = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aE(int i, int i2) {
                if (c.this.dbq == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.ND();
                    return;
                }
                boolean aqa = c.this.aqa();
                c.this.NG();
                if (aqa) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.dbq.aD(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3) {
                if (c.this.dbq != null) {
                    c.this.dbq.u(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.ND();
                if (i != 1) {
                    c.this.aTz.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (i.hi()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aTz.setVisibility(0);
                c.this.ND();
                c.this.NG();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void l(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
                if (c.this.dbq != null && !c.this.dbu) {
                    c.this.dbq.k(list, z);
                }
                c.this.daK = list;
                c.this.dbv = z;
            }
        };
        this.cqf = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                                c.this.apy();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.cYn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Nf();
            }
        };
        this.cqi = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cpK = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTz = new BdTypeListView(context);
        this.aTz.setDividerHeight(0);
        this.aTz.setSelector(17170445);
        this.beq = new PbListView(context);
        this.beq.lb();
        this.beq.dp(d.e.cp_bg_line_c);
        this.beq.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.beq.dq(TbadkCoreApplication.getInst().getSkinType());
        this.beq.setOnClickListener(this.cYn);
        this.aTz.setNextPage(this.beq);
        com.baidu.adp.base.e<?> X = com.baidu.adp.base.i.X(context);
        if (X instanceof TbPageContext) {
            this.pageContext = (TbPageContext) X;
        }
        this.mPullView = new l(this.pageContext);
        this.aTz.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.cqK = BdListViewHelper.a(context, this.aTz, BdListViewHelper.HeadType.DEFAULT);
        this.dbs = new com.baidu.tieba.homepage.personalize.model.e();
        this.dbp = new o(context, this.aTz);
        this.dbp.b(this.dbs);
        this.dbr = new e(this.pageContext, this.aTz, this.dbp);
        addView(this.aTz);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cqi);
    }

    public void apY() {
        this.dbp.a(this.dbx);
        this.dbr.a(this.dby);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.dbu = true;
                c.this.dbr.update();
            }
        });
        this.mPullView.a(new k.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (c.this.dbr != null) {
                    if (c.this.dbr.aho() != null) {
                        c.this.dbr.aho().asj();
                    }
                    c.this.dbr.fS(false);
                }
            }
        });
        this.aTz.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Nf();
            }
        });
        this.aTz.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.dbw >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.dbr.aF(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new k.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (c.this.dbr != null) {
                    c.this.dbr.fS(true);
                    c.this.dbr.aqH();
                }
                if (c.this.dbq != null && c.this.dbu) {
                    c.this.dbq.k(c.this.daK, c.this.dbv);
                }
                c.this.dbu = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aTz.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.dbr != null && c.this.dbr.aho() != null) {
                        c.this.dbr.aho().aZ(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.d) {
                        ((com.baidu.tieba.homepage.personalize.b.d) view.getTag()).Yy().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dbq = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.beq != null) {
            this.beq.wW();
            this.beq.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dbr.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cqK != null && this.cqK.getLayoutParams() != null) {
            if (this.dbr != null) {
                this.dbr.setHeaderViewHeight(i);
            }
            this.cqK.getLayoutParams().height = i;
            this.cqK.setLayoutParams(this.cqK.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.dbr != null) {
            this.dbr.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void showFloatingView() {
        if (this.dbr != null) {
            this.dbr.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgb != null) {
            this.bgb.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
        if (this.beq != null) {
            this.beq.setTextColor(aj.getColor(d.e.cp_cont_d));
            this.beq.dq(i);
        }
        this.dbp.onChangeSkinType(i);
        aj.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.beq != null) {
            this.beq.wW();
            this.beq.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dbr.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dbr != null) {
                        c.this.dbr.update();
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
    public void NG() {
        if (this.refreshView != null) {
            this.refreshView.N(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND() {
        if (this.bgb != null) {
            this.bgb.N(this);
            this.bgb = null;
            this.aTz.setNextPage(this.beq);
        }
        if (this.dbq != null) {
            this.dbq.aqn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqa() {
        if (this.refreshView != null) {
            return this.refreshView.EI();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bgb == null) {
            if (i < 0) {
                this.bgb = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bgb = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bgb.onChangeSkinType();
        }
        this.bgb.c(this, z);
        this.aTz.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dbr != null) {
            this.dbr.setTabInForeBackgroundState(z);
        }
    }

    public void aqb() {
        setViewForeground(false);
        if (this.dbr != null) {
            this.dbr.eO(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dbr != null) {
            this.dbr.fN(z);
        }
    }

    public void apX() {
        if (this.dbr != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.dbr.update();
        }
    }

    public void reload() {
        if (this.aTz != null) {
            showFloatingView();
            this.aTz.setSelection(0);
            if (this.aTz.isRefreshDone()) {
                if (this.dbr != null && this.dbr.aho() != null) {
                    this.dbr.aho().asj();
                    this.dbr.fS(false);
                }
                this.aTz.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cqi);
        this.dbr.onDestroy();
        this.dbp.a((h.a) null);
        this.dbr.a((e.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTz.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        if (this.bgb != null) {
            this.bgb.release();
        }
        this.aTz.setRecyclerListener(null);
    }

    public void onPause() {
        this.dbr.onPause();
    }

    public void onResume() {
        this.dbr.onResume();
        if (this.cpK) {
            reload();
            this.cpK = false;
        }
    }

    public void apy() {
        if (this.dbp != null) {
            this.dbp.notifyDataSetChanged();
        }
    }

    public void aqc() {
        if (this.dbr != null) {
            this.dbr.eO(true);
        }
        u.XY().cC(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aqC() {
        this.dbr.aqO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nf() {
        if (this.beq != null && !this.beq.xa()) {
            this.beq.wV();
            this.beq.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dbr.Nf();
    }
}
