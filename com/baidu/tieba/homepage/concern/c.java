package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aTz;
    private PbListView beq;
    private f bgb;
    private com.baidu.tieba.homepage.concern.a cYh;
    private a cYi;
    private d cYj;
    private boolean cYk;
    private boolean cYl;
    private d.a cYm;
    private View.OnClickListener cYn;
    private CustomMessageListener cYo;
    private CustomMessageListener cpV;
    private View cqK;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lJ(String str);

        void onPullToRefresh();

        void x(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aTz != null) {
            this.aTz.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cYh != null) {
            this.cYh.setPageUniqueId(bdUniqueId);
        }
        if (this.cYj != null) {
            this.cYj.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cpV != null) {
            this.cpV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cpV);
        }
        if (this.cYo != null) {
            this.cYo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYo);
        }
    }

    public c(Context context) {
        super(context);
        this.cYk = false;
        this.cYl = false;
        this.cYm = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aqd() {
                if (c.this.cYi == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.v(false, false);
                    return;
                }
                boolean aqa = c.this.aqa();
                c.this.NG();
                if (aqa) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cYi.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lI(String str) {
                if (c.this.cYi != null) {
                    c.this.cYi.lJ(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.v(false, false);
                if (i == 1) {
                    if (c.this.cYj != null) {
                        c.this.fM(c.this.cYj.hasMore());
                    }
                    if (i.hi()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aTz.setVisibility(8);
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void w(boolean z, boolean z2) {
                if (c.this.cYj != null) {
                    c.this.fM(c.this.cYj.hasMore());
                }
                c.this.aTz.setVisibility(0);
                c.this.v(z, z2);
                c.this.NG();
            }
        };
        this.cYn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Nf();
            }
        };
        this.cpV = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.v(c.this.cYj.getDataList()) && (c.this.cYj.getDataList().get(0) instanceof e) && !v.v(((e) c.this.cYj.getDataList().get(0)).Co())) {
                        List<com.baidu.adp.widget.ListView.f> Co = ((e) c.this.cYj.getDataList().get(0)).Co();
                        int size = Co.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((Co.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) Co.get(i2)).user_id))) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
                        fVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        fVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                        fVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                        fVar.mStatus = 3;
                        fVar.azO = String.valueOf(0);
                        fVar.azN = bVar;
                        if (i != -1) {
                            Co.set(i, fVar);
                        } else {
                            Co.add(1, fVar);
                        }
                        c.this.cYj.aqf();
                    }
                }
            }
        };
        this.cYo = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.cYk = true;
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
        this.cYh = new com.baidu.tieba.homepage.concern.a(context, this.aTz);
        this.cYj = new d(this.pageContext, this.aTz, this.cYh);
        addView(this.aTz);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void apY() {
        this.cYj.a(this.cYm);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cYj.update();
            }
        });
        this.aTz.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Nf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(boolean z) {
        if (this.beq != null) {
            if (z) {
                this.beq.wX();
                this.beq.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.beq.ds(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.cYi = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.beq != null) {
            this.beq.wW();
            this.beq.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYj.a(z, dataRes, 0, null);
    }

    public void apZ() {
        if (this.cYj != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cYj.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cYj != null) {
            this.cYj.setRecommendFrsNavigationAnimDispatcher(rVar);
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
        this.cYh.onChangeSkinType(i);
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
        this.cYj.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cYj != null) {
                        c.this.cYj.update();
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
    public void v(boolean z, boolean z2) {
        if (this.bgb != null) {
            this.bgb.N(this);
            this.bgb = null;
            this.aTz.setNextPage(this.beq);
        }
        if (this.cYi != null) {
            this.cYi.x(z, z2);
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
                this.bgb = new f(getContext());
            } else {
                this.bgb = new f(getContext(), i);
            }
            this.bgb.onChangeSkinType();
        }
        this.bgb.c(this, z);
        this.aTz.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cYj != null) {
            this.cYj.setTabInForeBackgroundState(z);
        }
    }

    public void aqb() {
        setViewForeground(false);
        if (this.cYj != null) {
            this.cYj.eO(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cYj != null) {
            this.cYj.fN(z);
        }
    }

    public void reload() {
        if (this.aTz != null) {
            if (this.cYk && this.aTz.getFirstVisiblePosition() != 0) {
                this.cYk = false;
                return;
            }
            this.aTz.setSelection(0);
            if (this.aTz.isRefreshDone()) {
                this.aTz.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cYj.a((d.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTz.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aTz.setRecyclerListener(null);
    }

    public void aqc() {
        if (this.cYj != null) {
            this.cYj.eO(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nf() {
        if (this.beq != null && !this.beq.xa()) {
            this.beq.wV();
            this.beq.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYj.Nf();
    }
}
