package com.baidu.tieba.chosen.posts;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.i.d {
    private com.baidu.tbadk.c.f MO;
    int Sh;
    private a aDc;
    private boolean aDd = false;
    private com.baidu.tbadk.c.h aDe;
    private NoNetworkView aoD;
    private NavigationBar aox;
    private BdListView aoy;
    private com.baidu.tbadk.mvc.k.a aoz;
    int paddingTop;

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return r.chosen_post_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.paddingTop = getResources().getDimensionPixelSize(o.ds108);
        this.Sh = getResources().getDimensionPixelSize(o.ds150);
        this.aox = (NavigationBar) getView().findViewById(q.chosen_post_navigation_bar);
        this.aox.setTitleText(t.chosen_post_title);
        this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoy = (BdListView) getView().findViewById(q.chosen_post_list);
        this.aoD = (NoNetworkView) getView().findViewById(q.view_no_network);
        this.aDc = new a(this.anm.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{r.chosen_picture_layout, r.chosen_no_picture_layout, r.chosen_image_text_layout}, AL());
        this.aoy.setAdapter((ListAdapter) this.aDc);
        Cz();
        this.aoy.setOnItemClickListener(new f(this));
        this.aoy.setOnItemLongClickListener(new g(this));
        this.aoy.setExOnSrollToBottomListener(new j(this));
        this.aoz = new com.baidu.tbadk.mvc.k.a(AK());
        this.aoz.a(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.aoz.ng();
        getListView().setNextPage(this.aoz);
        this.MO = new com.baidu.tbadk.c.f(getPageContext().getPageActivity());
        this.MO.rU();
        this.MO.b(getView(), true);
        Cv();
    }

    @Override // com.baidu.tbadk.mvc.i.d, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Br()) {
            case 4097:
                this.aDd = false;
                break;
            case 4098:
                this.aDd = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Bs());
                break;
            case 4102:
                c(bVar);
                break;
        }
        return super.a(bVar);
    }

    private void c(com.baidu.tbadk.mvc.c.b bVar) {
        Object extra = bVar.getExtra();
        if (extra instanceof Long) {
            this.aDc.L(((Long) extra).longValue());
            if (this.aDc.getCount() <= 5) {
                GP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (this.MO != null) {
            this.MO.s(getView());
        }
        if (errorData != null && this.aDc.CN() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(t.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        CB();
        if (this.aoz != null) {
            this.aoz.ee(t.no_more_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aox.onChangeSkinType(tbPageContext, i);
        this.aDc.a(tbPageContext, i);
        this.aoz.a(tbPageContext, i);
        if (this.aoD != null) {
            this.aoD.onChangeSkinType(tbPageContext, i);
        }
        return super.a(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.Cb()) {
                this.aoz.CQ();
                if (bVar.BZ()) {
                    this.aoz.ed(t.loading);
                } else if (!bVar.Ca()) {
                    this.aoz.ee(t.no_more_msg);
                }
            } else {
                this.aoz.hide();
            }
            if (bVar.BX()) {
                CA();
            } else {
                CB();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void oI() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void oJ() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> GS = ((com.baidu.tieba.chosen.posts.request.d) aVar).GS();
            if (GS != null && GS.size() > 0) {
                this.aoy.setVisibility(0);
            }
            if (this.MO != null) {
                this.MO.s(getView());
            }
            if (this.aDd) {
                this.aDc.r(GS);
                return;
            }
            this.aDc.s(GS);
            if (GS != null) {
                BdToast a = BdToast.a(getContext(), getResources().getString(t.chosen_post_recommend, Integer.valueOf(GS.size())), 0);
                a.bG(48);
                a.bI(this.paddingTop);
                a.bE(this.Sh);
                a.rQ().rR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(getUniqueId());
        AL().dispatchMvcEvent(bVar);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.aoy;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aDe == null) {
            this.aDe = new com.baidu.tbadk.c.h(getPageContext().getPageActivity(), new k(this, null));
        }
        this.aDe.eQ(str);
        this.aDe.b(view, z);
        this.aDe.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aDe != null) {
            this.aDe.s(view);
        }
    }
}
