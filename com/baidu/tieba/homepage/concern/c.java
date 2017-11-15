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
    private BdTypeListView aUv;
    private f bem;
    private PbListView bgN;
    private CustomMessageListener cyM;
    private View czA;
    private com.baidu.tieba.homepage.concern.a ddX;
    private a ddY;
    private d ddZ;
    private g dea;
    private boolean deb;
    private d.a dec;
    private View.OnClickListener ded;
    private CustomMessageListener dee;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.k.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lO(String str);

        void onPullToRefresh();

        void z(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aUv != null) {
            this.aUv.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ddX != null) {
            this.ddX.setPageUniqueId(bdUniqueId);
        }
        if (this.ddZ != null) {
            this.ddZ.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cyM != null) {
            this.cyM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyM);
        }
        if (this.dee != null) {
            this.dee.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dee);
        }
    }

    public c(Context context) {
        super(context);
        this.deb = false;
        this.mSkinType = 3;
        this.dec = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void arC() {
                if (c.this.ddY == null) {
                    if (c.this.dea != null) {
                        c.this.dea.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.x(false, false);
                    return;
                }
                boolean ary = c.this.ary();
                c.this.On();
                if (ary) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.ddY.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lN(String str) {
                if (c.this.ddY != null) {
                    c.this.ddY.lO(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.x(false, false);
                if (i == 1) {
                    if (c.this.ddZ != null) {
                        c.this.fB(c.this.ddZ.hasMore());
                    }
                    if (j.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aUv.setVisibility(8);
                if (c.this.dea != null) {
                    c.this.dea.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void y(boolean z, boolean z2) {
                if (c.this.ddZ != null) {
                    c.this.fB(c.this.ddZ.hasMore());
                }
                c.this.aUv.setVisibility(0);
                c.this.x(z, z2);
                c.this.On();
            }
        };
        this.ded = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.NQ();
            }
        };
        this.cyM = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.v(c.this.ddZ.getDataList()) && (c.this.ddZ.getDataList().get(0) instanceof com.baidu.tbadk.data.f) && !v.v(((com.baidu.tbadk.data.f) c.this.ddZ.getDataList().get(0)).getList())) {
                        List<com.baidu.adp.widget.ListView.f> list = ((com.baidu.tbadk.data.f) c.this.ddZ.getDataList().get(0)).getList();
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
                        gVar.azM = String.valueOf(0);
                        gVar.azL = bVar;
                        if (i != -1) {
                            list.set(i, gVar);
                        } else {
                            list.add(1, gVar);
                        }
                        c.this.ddZ.arE();
                    }
                }
            }
        };
        this.dee = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.deb = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUv = new BdTypeListView(context);
        this.aUv.setDividerHeight(0);
        this.aUv.setSelector(17170445);
        this.bgN = new PbListView(context);
        this.bgN.getView();
        this.bgN.dx(d.C0080d.cp_bg_line_d);
        this.bgN.setHeight(l.f(context, d.e.ds140));
        this.bgN.wq();
        this.bgN.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        this.bgN.dw(d.C0080d.cp_cont_e);
        this.bgN.setOnClickListener(this.ded);
        this.aUv.setNextPage(this.bgN);
        e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUv.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        if (TbadkCoreApplication.isLogin()) {
            this.czA = BdListViewHelper.a(context, this.aUv, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ddX = new com.baidu.tieba.homepage.concern.a(context, this.aUv);
        this.ddZ = new d(this.pageContext, this.aUv, this.ddX);
        addView(this.aUv);
        this.aUv.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.czA != null && this.czA.getLayoutParams() != null) {
            this.czA.getLayoutParams().height = i;
            this.czA.setLayoutParams(this.czA.getLayoutParams());
        }
    }

    public void amW() {
        this.ddZ.a(this.dec);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.ddZ.update();
                }
            }
        });
        this.aUv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.NQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(boolean z) {
        if (this.bgN != null) {
            if (z) {
                this.bgN.ww();
                this.bgN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bgN.dB(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.ddY = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bgN != null) {
            this.bgN.wu();
            this.bgN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ddZ.a(z, dataRes, 0, null);
    }

    public void arx() {
        if (!TbadkCoreApplication.isLogin()) {
            arz();
        } else if (this.ddZ != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.ddZ.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.ddZ != null) {
            this.ddZ.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dea != null) {
                this.dea.onChangeSkinType(i);
            }
            if (this.bem != null) {
                this.bem.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.bgN != null) {
                this.bgN.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
                this.bgN.dy(i);
            }
            this.ddX.onChangeSkinType(i);
            aj.k(this, d.C0080d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void T(String str, int i) {
        if (this.bgN != null) {
            this.bgN.wu();
            this.bgN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ddZ.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.ddZ != null && TbadkCoreApplication.isLogin()) {
                        c.this.ddZ.update();
                    }
                }
            });
        }
        this.refreshView.fj(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gz(str);
        this.refreshView.c(view, z);
        this.refreshView.EO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        if (this.bem != null) {
            this.bem.O(this);
            this.bem = null;
            this.aUv.setNextPage(this.bgN);
        }
        if (this.ddY != null) {
            this.ddY.z(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ary() {
        if (this.refreshView != null) {
            return this.refreshView.EG();
        }
        return false;
    }

    private void arz() {
        if (this.dea == null) {
            this.dea = new com.baidu.tieba.homepage.concern.view.g(getContext());
            this.dea.onChangeSkinType(this.mSkinType);
        }
        if (this.dea.getParent() == null) {
            this.aUv.setVisibility(8);
            this.dea.setVisibility(0);
            addView(this.dea);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bem == null) {
            if (i < 0) {
                this.bem = new f(getContext());
            } else {
                this.bem = new f(getContext(), i);
            }
            this.bem.onChangeSkinType();
        }
        this.bem.c(this, z);
        this.aUv.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ddZ != null) {
            this.ddZ.setTabInForeBackgroundState(z);
        }
    }

    public void arA() {
        setViewForeground(false);
        if (this.ddZ != null) {
            this.ddZ.eF(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ddZ != null) {
            this.ddZ.fC(z);
        }
    }

    public void reload() {
        if (this.aUv != null) {
            if (this.deb && this.aUv.getFirstVisiblePosition() != 0) {
                this.deb = false;
                return;
            }
            this.aUv.setSelection(0);
            if (this.aUv.isRefreshDone()) {
                this.aUv.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.ddZ.a((d.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUv.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.aUv.setRecyclerListener(null);
    }

    public void arB() {
        if (this.ddZ != null) {
            this.ddZ.eF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NQ() {
        if (this.bgN != null && !this.bgN.wz()) {
            this.bgN.wt();
            this.bgN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ddZ.NQ();
    }
}
