package com.baidu.tieba.chosen.posts;

import android.support.v4.app.FragmentTransaction;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.i.d {
    private com.baidu.tbadk.c.f MS;
    private a aBp;
    private boolean aBq = true;
    private NavigationBar anu;
    private BdListView anv;
    private com.baidu.tbadk.mvc.k.a anw;

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.chosen_post_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.anu = (NavigationBar) getView().findViewById(v.chosen_post_navigation_bar);
        this.anu.setTitleText(y.chosen_post_title);
        this.anu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.anv = (BdListView) getView().findViewById(v.chosen_post_list);
        this.aBp = new a(this.amj.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{w.chosen_picture_layout, w.chosen_no_picture_layout}, zZ());
        this.anv.setAdapter((ListAdapter) this.aBp);
        BN();
        this.anv.setOnItemClickListener(new f(this));
        this.anv.setOnItemLongClickListener(new g(this));
        this.anv.setExOnSrollToBottomListener(new j(this));
        this.anw = new com.baidu.tbadk.mvc.k.a(zY());
        this.anw.mN();
        getListView().setNextPage(this.anw);
        this.MS = new com.baidu.tbadk.c.f(getPageContext().getPageActivity());
        this.MS.b(getView(), true);
        BJ();
    }

    @Override // com.baidu.tbadk.mvc.i.d, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.AF()) {
            case 4097:
                this.aBq = false;
                break;
            case 4098:
                this.aBq = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.AG());
                break;
        }
        return super.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (this.MS != null) {
            this.MS.p(getView());
        }
        BP();
        if (this.anw != null) {
            this.anw.dU(y.no_more_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.anu.onChangeSkinType(tbPageContext, i);
        this.aBp.a(tbPageContext, i);
        this.anw.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.Bp()) {
                this.anw.Cf();
                if (bVar.Bn()) {
                    this.anw.dT(y.loading);
                } else if (bVar.Bo()) {
                    this.anw.dV(y.refresh);
                } else {
                    this.anw.dU(y.no_more_msg);
                }
            } else {
                this.anw.hide();
            }
            if (bVar.Bl()) {
                BO();
            } else {
                BP();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void os() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void ot() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            com.baidu.tieba.chosen.posts.request.d dVar = (com.baidu.tieba.chosen.posts.request.d) aVar;
            if (dVar.FU().size() <= 0) {
                FT();
                return;
            }
            if (this.MS != null) {
                this.MS.p(getView());
            }
            if (this.aBq) {
                this.aBp.q(dVar.FU());
            } else {
                this.aBp.r(dVar.FU());
            }
            BdToast a = BdToast.a(getContext(), this.mContext.getResources().getString(y.chosen_post_recommend, Integer.valueOf(dVar.FU().size())), 0);
            a.bE(48);
            a.bG(getResources().getDimensionPixelSize(t.ds108));
            a.rh().ri();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(getUniqueId());
        zZ().dispatchMvcEvent(bVar);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.anv;
    }
}
