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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
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
    private BdTypeListView aSB;
    private PbListView bdh;
    private f beN;
    private d.a cOA;
    private View.OnClickListener cOB;
    private com.baidu.tieba.homepage.concern.a cOv;
    private a cOw;
    private d cOx;
    private boolean cOy;
    private boolean cOz;
    private CustomMessageListener ciI;
    private View cjx;
    private com.baidu.tieba.d.a cwZ;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lh(String str);

        void onPullToRefresh();

        void v(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aSB != null) {
            this.aSB.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cOv != null) {
            this.cOv.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ciI != null) {
            this.ciI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ciI);
        }
    }

    public c(Context context) {
        super(context);
        this.cOz = false;
        this.cOA = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void anI() {
                if (c.this.cOw == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.t(false, false);
                    return;
                }
                boolean anF = c.this.anF();
                c.this.Nl();
                if (anF) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cOw.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lg(String str) {
                if (c.this.cOw != null) {
                    c.this.cOw.lh(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.t(false, false);
                if (i == 1) {
                    if (c.this.cOx != null) {
                        c.this.fB(c.this.cOx.hasMore());
                    }
                    if (i.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aSB.setVisibility(8);
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void u(boolean z, boolean z2) {
                if (c.this.cOx != null) {
                    c.this.fB(c.this.cOx.hasMore());
                }
                c.this.aSB.setVisibility(0);
                c.this.t(z, z2);
                c.this.Nl();
            }
        };
        this.cOB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.MN();
            }
        };
        this.ciI = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !u.v(c.this.cOx.getDataList()) && (c.this.cOx.getDataList().get(0) instanceof e) && !u.v(((e) c.this.cOx.getDataList().get(0)).Cl())) {
                        List<com.baidu.adp.widget.ListView.f> Cl = ((e) c.this.cOx.getDataList().get(0)).Cl();
                        int size = Cl.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((Cl.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) Cl.get(i2)).user_id))) {
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
                        fVar.azk = String.valueOf(0);
                        fVar.azj = bVar;
                        if (i != -1) {
                            Cl.set(i, fVar);
                        } else {
                            Cl.add(1, fVar);
                        }
                        c.this.cOx.anK();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aSB = new BdTypeListView(context);
        this.aSB.setDividerHeight(0);
        this.aSB.setSelector(17170445);
        this.bdh = new PbListView(context);
        this.bdh.la();
        this.bdh.dm(d.e.cp_bg_line_c);
        this.bdh.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.bdh.dn(TbadkCoreApplication.getInst().getSkinType());
        this.bdh.setOnClickListener(this.cOB);
        this.aSB.setNextPage(this.bdh);
        com.baidu.adp.base.e<?> Z = com.baidu.adp.base.i.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        this.mPullView = new l(this.pageContext);
        this.aSB.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.cjx = BdListViewHelper.a(context, this.aSB, BdListViewHelper.HeadType.DEFAULT);
        this.cOv = new com.baidu.tieba.homepage.concern.a(context, this.aSB);
        this.cOx = new d(this.pageContext, this.aSB, this.cOv);
        addView(this.aSB);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void anC() {
        this.cOx.a(this.cOA);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cOx.update();
            }
        });
        this.mPullView.a(new k.a() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (c.this.cOz && TbadkCoreApplication.isLogin() && z && !c.this.cOy && c.this.aSB.getVisibility() == 0 && !u.v(c.this.aSB.getData())) {
                    c.this.anD();
                    c.this.cOz = false;
                }
            }
        });
        this.aSB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.4
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.MN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        if (this.cwZ == null) {
            this.cwZ = new com.baidu.tieba.d.a(this.pageContext, this);
            this.cwZ.hH(d.g.story_home_guide_bg);
            this.cwZ.hK(1);
            this.cwZ.hJ(500);
            this.cwZ.hI(-1);
            this.cwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cwZ != null) {
                        c.this.cwZ.Yd();
                    }
                }
            });
        }
        this.cwZ.jk("story_home_page_guide_mask");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(boolean z) {
        if (this.bdh != null) {
            if (z) {
                this.bdh.wP();
                this.bdh.m10do(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bdh.dp(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.cOw = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bdh != null) {
            this.bdh.wO();
            this.bdh.m10do(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cOx.a(z, dataRes, 0, null);
    }

    public void anE() {
        if (!TbadkCoreApplication.isLogin()) {
            this.aSB.setNextPage(null);
        } else if (this.cOx != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cOx.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cOx != null) {
            this.cOx.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.beN != null) {
            this.beN.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dn(i);
        }
        if (this.bdh != null) {
            this.bdh.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.bdh.dn(i);
        }
        this.cOv.onChangeSkinType(i);
        ai.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.bdh != null) {
            this.bdh.wO();
            this.bdh.m10do(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cOx.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cOx != null) {
                        c.this.cOx.update();
                    }
                }
            });
        }
        this.refreshView.eX(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gq(str);
        this.refreshView.c(view, z);
        this.refreshView.EL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nl() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        if (this.beN != null) {
            this.beN.I(this);
            this.beN = null;
            this.aSB.setNextPage(this.bdh);
        }
        if (this.cOw != null) {
            this.cOw.v(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anF() {
        if (this.refreshView != null) {
            return this.refreshView.EC();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.beN == null) {
            if (i < 0) {
                this.beN = new f(getContext());
            } else {
                this.beN = new f(getContext(), i);
            }
            this.beN.onChangeSkinType();
        }
        this.beN.c(this, z);
        this.aSB.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cOx != null) {
            this.cOx.setTabInForeBackgroundState(z);
        }
    }

    public void anG() {
        this.cOy = false;
        setViewForeground(false);
        if (this.cOx != null) {
            this.cOx.eJ(false);
        }
    }

    public void onLazyLoad() {
        this.cOz = true;
    }

    public void setViewForeground(boolean z) {
        if (this.cOx != null) {
            this.cOx.fC(z);
        }
    }

    public void reload() {
        if (this.aSB != null) {
            this.aSB.setSelection(0);
            if (this.aSB.isRefreshDone()) {
                this.aSB.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cOx.a((d.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aSB.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aSB.setRecyclerListener(null);
        if (this.cwZ != null) {
            this.cwZ.Yd();
            this.cwZ = null;
        }
    }

    public void anH() {
        this.cOy = true;
        if (this.cOx != null) {
            this.cOx.eJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MN() {
        if (this.bdh != null && !this.bdh.wT()) {
            this.bdh.wN();
            this.bdh.m10do(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cOx.MN();
    }
}
