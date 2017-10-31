package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.g;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aUn;
    private f bed;
    private PbListView bgE;
    private CustomMessageListener cyt;
    private View czh;
    private com.baidu.tieba.homepage.concern.a ddD;
    private a ddE;
    private d ddF;
    private g ddG;
    private boolean ddH;
    private d.a ddI;
    private View.OnClickListener ddJ;
    private CustomMessageListener ddK;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.k.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lM(String str);

        void onPullToRefresh();

        void z(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aUn != null) {
            this.aUn.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ddD != null) {
            this.ddD.setPageUniqueId(bdUniqueId);
        }
        if (this.ddF != null) {
            this.ddF.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cyt != null) {
            this.cyt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyt);
        }
        if (this.ddK != null) {
            this.ddK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ddK);
        }
    }

    public c(Context context) {
        super(context);
        this.ddH = false;
        this.mSkinType = 3;
        this.ddI = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void arm() {
                if (c.this.ddE == null) {
                    if (c.this.ddG != null) {
                        c.this.ddG.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.x(false, false);
                    return;
                }
                boolean ari = c.this.ari();
                c.this.Oc();
                if (ari) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.ddE.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lL(String str) {
                if (c.this.ddE != null) {
                    c.this.ddE.lM(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.x(false, false);
                if (i == 1) {
                    if (c.this.ddF != null) {
                        c.this.fv(c.this.ddF.hasMore());
                    }
                    if (j.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aUn.setVisibility(8);
                if (c.this.ddG != null) {
                    c.this.ddG.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void y(boolean z, boolean z2) {
                if (c.this.ddF != null) {
                    c.this.fv(c.this.ddF.hasMore());
                }
                c.this.aUn.setVisibility(0);
                c.this.x(z, z2);
                c.this.Oc();
            }
        };
        this.ddJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.NF();
            }
        };
        this.cyt = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.v(c.this.ddF.getDataList()) && (c.this.ddF.getDataList().get(0) instanceof com.baidu.tbadk.data.f) && !v.v(((com.baidu.tbadk.data.f) c.this.ddF.getDataList().get(0)).getList())) {
                        List<com.baidu.adp.widget.ListView.f> list = ((com.baidu.tbadk.data.f) c.this.ddF.getDataList().get(0)).getList();
                        int size = list.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((list.get(i2) instanceof com.baidu.tbadk.data.g) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.g) list.get(i2)).user_id))) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
                        gVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        gVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                        gVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                        gVar.mStatus = 3;
                        gVar.azE = String.valueOf(0);
                        gVar.azD = bVar;
                        if (i != -1) {
                            list.set(i, gVar);
                        } else {
                            list.add(1, gVar);
                        }
                        c.this.ddF.aro();
                    }
                }
            }
        };
        this.ddK = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.ddH = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUn = new BdTypeListView(context);
        this.aUn.setDividerHeight(0);
        this.aUn.setSelector(17170445);
        this.bgE = new PbListView(context);
        this.bgE.getView();
        this.bgE.dy(d.C0080d.cp_bg_line_d);
        this.bgE.setHeight(l.f(context, d.e.ds140));
        this.bgE.wq();
        this.bgE.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        this.bgE.dx(d.C0080d.cp_cont_e);
        this.bgE.setOnClickListener(this.ddJ);
        this.aUn.setNextPage(this.bgE);
        e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUn.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        if (TbadkCoreApplication.isLogin()) {
            this.czh = BdListViewHelper.a(context, this.aUn, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ddD = new com.baidu.tieba.homepage.concern.a(context, this.aUn);
        this.ddF = new d(this.pageContext, this.aUn, this.ddD);
        addView(this.aUn);
        this.aUn.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.czh != null && this.czh.getLayoutParams() != null) {
            this.czh.getLayoutParams().height = i;
            this.czh.setLayoutParams(this.czh.getLayoutParams());
        }
    }

    public void amI() {
        this.ddF.a(this.ddI);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.ddF.update();
                }
            }
        });
        this.aUn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.NF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv(boolean z) {
        if (this.bgE != null) {
            if (z) {
                this.bgE.ww();
                this.bgE.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bgE.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.ddE = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bgE != null) {
            this.bgE.wu();
            this.bgE.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ddF.a(z, dataRes, 0, null);
    }

    public void arh() {
        if (!TbadkCoreApplication.isLogin()) {
            arj();
        } else if (this.ddF != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.ddF.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.ddF != null) {
            this.ddF.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ddG != null) {
                this.ddG.onChangeSkinType(i);
            }
            if (this.bed != null) {
                this.bed.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.bgE != null) {
                this.bgE.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
                this.bgE.dz(i);
            }
            this.ddD.onChangeSkinType(i);
            aj.k(this, d.C0080d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void T(String str, int i) {
        if (this.bgE != null) {
            this.bgE.wu();
            this.bgE.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ddF.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.ddF != null && TbadkCoreApplication.isLogin()) {
                        c.this.ddF.update();
                    }
                }
            });
        }
        this.refreshView.fk(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gy(str);
        this.refreshView.c(view, z);
        this.refreshView.EC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        if (this.bed != null) {
            this.bed.O(this);
            this.bed = null;
            this.aUn.setNextPage(this.bgE);
        }
        if (this.ddE != null) {
            this.ddE.z(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ari() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    private void arj() {
        if (this.ddG == null) {
            this.ddG = new com.baidu.tieba.homepage.concern.view.g(getContext());
            this.ddG.onChangeSkinType(this.mSkinType);
        }
        if (this.ddG.getParent() == null) {
            this.aUn.setVisibility(8);
            this.ddG.setVisibility(0);
            addView(this.ddG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bed == null) {
            if (i < 0) {
                this.bed = new f(getContext());
            } else {
                this.bed = new f(getContext(), i);
            }
            this.bed.onChangeSkinType();
        }
        this.bed.c(this, z);
        this.aUn.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ddF != null) {
            this.ddF.setTabInForeBackgroundState(z);
        }
    }

    public void ark() {
        setViewForeground(false);
        if (this.ddF != null) {
            this.ddF.eA(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ddF != null) {
            this.ddF.fw(z);
        }
    }

    public void reload() {
        if (this.aUn != null) {
            if (this.ddH && this.aUn.getFirstVisiblePosition() != 0) {
                this.ddH = false;
                return;
            }
            this.aUn.setSelection(0);
            if (this.aUn.isRefreshDone()) {
                this.aUn.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.ddF.a((d.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUn.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.aUn.setRecyclerListener(null);
    }

    public void arl() {
        if (this.ddF != null) {
            this.ddF.eA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        if (this.bgE != null && !this.bgE.wz()) {
            this.bgE.wt();
            this.bgE.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ddF.NF();
    }
}
