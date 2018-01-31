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
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.g;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class c extends FrameLayout {
    private f bVd;
    private PbListView bYZ;
    private View dDl;
    private com.baidu.tieba.homepage.concern.a ebA;
    private a ebB;
    private d ebC;
    private g ebD;
    private boolean ebE;
    private d.a ebF;
    private View.OnClickListener ebG;
    private CustomMessageListener ebH;
    private BdTypeListView ebl;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void ms(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.ebl != null) {
            this.ebl.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ebA != null) {
            this.ebA.setPageUniqueId(bdUniqueId);
        }
        if (this.ebC != null) {
            this.ebC.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ebH != null) {
            this.ebH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ebH);
        }
    }

    public c(Context context) {
        super(context);
        this.ebE = false;
        this.mSkinType = 3;
        this.ebF = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aAQ() {
                if (c.this.ebB == null) {
                    if (c.this.ebD != null) {
                        c.this.ebD.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.z(false, false);
                    return;
                }
                boolean aAM = c.this.aAM();
                c.this.WG();
                if (aAM) {
                    c.this.j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.ebB.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void mr(String str) {
                if (c.this.ebB != null) {
                    c.this.ebB.ms(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.z(false, false);
                if (i == 1) {
                    if (c.this.ebC != null) {
                        c.this.gx(c.this.ebC.hasMore());
                    }
                    if (j.oJ()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.ebl.setVisibility(8);
                if (c.this.ebD != null) {
                    c.this.ebD.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void A(boolean z, boolean z2) {
                if (c.this.ebC != null) {
                    c.this.gx(c.this.ebC.hasMore());
                }
                c.this.ebl.setVisibility(0);
                c.this.z(z, z2);
                c.this.WG();
            }
        };
        this.ebG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.VX();
            }
        };
        this.ebH = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.ebE = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ebl = new BdTypeListView(context);
        this.ebl.setDividerHeight(0);
        this.ebl.setSelector(17170445);
        this.bYZ = new PbListView(context);
        this.bYZ.getView();
        this.bYZ.gu(d.C0108d.cp_bg_line_e);
        this.bYZ.setHeight(l.s(context, d.e.tbds182));
        this.bYZ.DJ();
        this.bYZ.setTextSize(d.e.tbfontsize33);
        this.bYZ.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        this.bYZ.gt(d.C0108d.cp_cont_e);
        this.bYZ.setOnClickListener(this.ebG);
        this.ebl.setNextPage(this.bYZ);
        e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.ebl.setPullRefresh(this.mPullView);
        this.mPullView.aD(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dDl = BdListViewHelper.a(context, this.ebl, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ebA = new com.baidu.tieba.homepage.concern.a(context, this.ebl);
        this.ebC = new d(this.pageContext, this.ebl, this.ebA);
        addView(this.ebl);
        this.ebl.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dDl != null && this.dDl.getLayoutParams() != null) {
            this.dDl.getLayoutParams().height = i;
            this.dDl.setLayoutParams(this.dDl.getLayoutParams());
        }
    }

    public void axh() {
        this.ebC.a(this.ebF);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.ebC.update();
                }
            }
        });
        this.ebl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.VX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        if (this.bYZ != null) {
            if (z) {
                this.bYZ.DO();
                this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bYZ.gx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.ebB = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bYZ != null) {
            this.bYZ.DN();
            this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ebC.a(z, dataRes, 0, null);
    }

    public void aAL() {
        if (!TbadkCoreApplication.isLogin()) {
            aAN();
        } else if (this.ebC != null) {
            j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.ebC.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.ebC != null) {
            this.ebC.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ebD != null) {
                this.ebD.onChangeSkinType(i);
            }
            if (this.bVd != null) {
                this.bVd.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gv(i);
            }
            if (this.bYZ != null) {
                this.bYZ.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
                this.bYZ.gv(i);
            }
            this.ebA.onChangeSkinType(i);
            aj.t(this, d.C0108d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void aa(String str, int i) {
        if (this.bYZ != null) {
            this.bYZ.DN();
            this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ebC.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.ebC != null && TbadkCoreApplication.isLogin()) {
                        c.this.ebC.update();
                    }
                }
            });
        }
        this.refreshView.id(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gM(str);
        this.refreshView.j(view, z);
        this.refreshView.Ml();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WG() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        if (this.bVd != null) {
            this.bVd.bk(this);
            this.bVd = null;
            this.ebl.setNextPage(this.bYZ);
        }
        if (this.ebB != null) {
            this.ebB.B(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAM() {
        if (this.refreshView != null) {
            return this.refreshView.Md();
        }
        return false;
    }

    private void aAN() {
        if (this.ebD == null) {
            this.ebD = new g(getContext());
            this.ebD.onChangeSkinType(this.mSkinType);
        }
        if (this.ebD.getParent() == null) {
            this.ebl.setVisibility(8);
            this.ebD.setVisibility(0);
            addView(this.ebD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.bVd == null) {
            if (i < 0) {
                this.bVd = new f(getContext());
            } else {
                this.bVd = new f(getContext(), i);
            }
            this.bVd.onChangeSkinType();
        }
        this.bVd.j(this, z);
        this.ebl.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ebC != null) {
            this.ebC.setTabInForeBackgroundState(z);
        }
    }

    public void aAO() {
        setViewForeground(false);
        if (this.ebC != null) {
            this.ebC.fJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ebC != null) {
            this.ebC.gy(z);
        }
    }

    public void reload() {
        if (this.ebl != null) {
            if (this.ebE && this.ebl.getFirstVisiblePosition() != 0) {
                this.ebE = false;
                return;
            }
            this.ebl.setSelection(0);
            if (this.ebl.isRefreshDone()) {
                this.ebl.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.ebC.a((d.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.ebl.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.ebl.setRecyclerListener(null);
    }

    public void aAP() {
        if (this.ebC != null) {
            this.ebC.fJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VX() {
        if (this.bYZ != null && !this.bYZ.DR()) {
            this.bYZ.DM();
            this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ebC.VX();
    }
}
