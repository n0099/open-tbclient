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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.g;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class c extends FrameLayout {
    private f bUO;
    private PbListView bYK;
    private BdTypeListView dZF;
    private com.baidu.tieba.homepage.concern.a dZU;
    private a dZV;
    private d dZW;
    private g dZX;
    private boolean dZY;
    private d.a dZZ;
    private View dyp;
    private Runnable eaa;
    private View.OnClickListener eab;
    private CustomMessageListener eac;
    private j mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void mg(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.dZF != null) {
            this.dZF.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dZU != null) {
            this.dZU.setPageUniqueId(bdUniqueId);
        }
        if (this.dZW != null) {
            this.dZW.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.eac != null) {
            this.eac.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eac);
        }
    }

    public c(Context context) {
        super(context);
        this.dZY = false;
        this.mSkinType = 3;
        this.dZZ = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aAJ() {
                if (c.this.dZV == null) {
                    if (c.this.dZX != null) {
                        c.this.dZX.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.z(false, false);
                    return;
                }
                boolean aAF = c.this.aAF();
                c.this.WQ();
                if (aAF) {
                    c.this.j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.dZV.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void mf(String str) {
                if (c.this.dZV != null) {
                    c.this.dZV.mg(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.z(false, false);
                c.this.completePullRefresh();
                if (i == 1) {
                    if (c.this.dZW != null) {
                        c.this.gs(c.this.dZW.hasMore());
                    }
                    if (com.baidu.adp.lib.util.j.oI()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.dZF.setVisibility(8);
                if (c.this.dZX != null) {
                    c.this.dZX.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void A(boolean z, boolean z2) {
                c.this.completePullRefresh();
                if (c.this.dZW != null) {
                    c.this.gs(c.this.dZW.hasMore());
                }
                c.this.dZF.setVisibility(0);
                c.this.z(z, z2);
                c.this.WQ();
            }
        };
        this.eaa = new Runnable() { // from class: com.baidu.tieba.homepage.concern.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.completePullRefresh();
            }
        };
        this.eab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Wh();
            }
        };
        this.eac = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.dZY = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dZF = new BdTypeListView(context);
        this.dZF.setDividerHeight(0);
        this.dZF.setSelector(17170445);
        this.bYK = new PbListView(context);
        this.bYK.getView();
        this.bYK.gx(d.C0108d.cp_bg_line_e);
        this.bYK.setHeight(l.s(context, d.e.tbds182));
        this.bYK.DQ();
        this.bYK.setTextSize(d.e.tbfontsize33);
        this.bYK.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        this.bYK.gw(d.C0108d.cp_cont_e);
        this.bYK.setOnClickListener(this.eab);
        this.dZF.setNextPage(this.bYK);
        e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new j(this.pageContext);
        this.dZF.setPullRefresh(this.mPullView);
        this.mPullView.aC(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dyp = BdListViewHelper.a(context, this.dZF, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dZU = new com.baidu.tieba.homepage.concern.a(context, this.dZF);
        this.dZW = new d(this.pageContext, this.dZF, this.dZU);
        addView(this.dZF);
        this.dZF.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dyp != null && this.dyp.getLayoutParams() != null) {
            this.dyp.getLayoutParams().height = i;
            this.dyp.setLayoutParams(this.dyp.getLayoutParams());
        }
    }

    public void avZ() {
        this.dZW.a(this.dZZ);
        this.mPullView.a(new i.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.i.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.dZW.update();
                }
                com.baidu.adp.lib.g.e.nr().removeCallbacks(c.this.eaa);
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eaa, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        });
        this.dZF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Wh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gs(boolean z) {
        if (this.bYK != null) {
            if (z) {
                this.bYK.DV();
                this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bYK.gA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dZV = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bYK != null) {
            this.bYK.DU();
            this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dZW.a(z, dataRes, 0, null);
    }

    public void aAE() {
        if (!TbadkCoreApplication.isLogin()) {
            aAG();
        } else if (this.dZW != null) {
            j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dZW.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dZW != null) {
            this.dZW.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dZX != null) {
                this.dZX.onChangeSkinType(i);
            }
            if (this.bUO != null) {
                this.bUO.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gy(i);
            }
            if (this.bYK != null) {
                this.bYK.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
                this.bYK.gy(i);
            }
            this.dZU.onChangeSkinType(i);
            aj.t(this, d.C0108d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void Y(String str, int i) {
        if (this.bYK != null) {
            this.bYK.DU();
            this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dZW.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dZW != null && TbadkCoreApplication.isLogin()) {
                        c.this.dZW.update();
                    }
                }
            });
        }
        this.refreshView.ih(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gE(str);
        this.refreshView.j(view, z);
        this.refreshView.Mv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        if (this.refreshView != null) {
            this.refreshView.bi(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        if (this.bUO != null) {
            this.bUO.bi(this);
            this.bUO = null;
            this.dZF.setNextPage(this.bYK);
        }
        if (this.dZV != null) {
            this.dZV.B(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAF() {
        if (this.refreshView != null) {
            return this.refreshView.Mn();
        }
        return false;
    }

    private void aAG() {
        if (this.dZX == null) {
            this.dZX = new g(getContext());
            this.dZX.onChangeSkinType(this.mSkinType);
        }
        if (this.dZX.getParent() == null) {
            this.dZF.setVisibility(8);
            this.dZX.setVisibility(0);
            addView(this.dZX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.bUO == null) {
            if (i < 0) {
                this.bUO = new f(getContext());
            } else {
                this.bUO = new f(getContext(), i);
            }
            this.bUO.onChangeSkinType();
        }
        this.bUO.j(this, z);
        this.dZF.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dZW != null) {
            this.dZW.setTabInForeBackgroundState(z);
        }
    }

    public void aAH() {
        setViewForeground(false);
        if (this.dZW != null) {
            this.dZW.fD(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dZW != null) {
            this.dZW.gt(z);
        }
    }

    public void reload() {
        if (this.dZF != null) {
            if (this.dZY && this.dZF.getFirstVisiblePosition() != 0) {
                this.dZY = false;
                return;
            }
            this.dZF.setSelection(0);
            if (this.dZF.isRefreshDone()) {
                this.dZF.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dZW.a((d.a) null);
        this.mPullView.a((i.b) null);
        this.mPullView.a((i.c) null);
        this.dZF.setOnSrollToBottomListener(null);
        this.mPullView.a((i.a) null);
        this.mPullView.release();
        this.dZF.setRecyclerListener(null);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eaa);
    }

    public void aAI() {
        if (this.dZW != null) {
            this.dZW.fD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        if (this.bYK != null && !this.bYK.DY()) {
            this.bYK.DT();
            this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dZW.Wh();
    }
}
