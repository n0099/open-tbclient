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
    private com.baidu.tbadk.c.f MQ;
    private a aBh;
    private boolean aBi = true;
    private NavigationBar anm;
    private BdListView ann;
    private com.baidu.tbadk.mvc.k.a ano;

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.chosen_post_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.anm = (NavigationBar) getView().findViewById(v.chosen_post_navigation_bar);
        this.anm.setTitleText(y.chosen_post_title);
        this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.ann = (BdListView) getView().findViewById(v.chosen_post_list);
        this.aBh = new a(this.amb.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{w.chosen_picture_layout, w.chosen_no_picture_layout}, zT());
        this.ann.setAdapter((ListAdapter) this.aBh);
        BH();
        this.ann.setOnItemClickListener(new f(this));
        this.ann.setOnItemLongClickListener(new g(this));
        this.ann.setExOnSrollToBottomListener(new j(this));
        this.ano = new com.baidu.tbadk.mvc.k.a(zS());
        this.ano.mN();
        getListView().setNextPage(this.ano);
        this.MQ = new com.baidu.tbadk.c.f(getPageContext().getPageActivity());
        this.MQ.b(getView(), true);
        BD();
    }

    @Override // com.baidu.tbadk.mvc.i.d, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Az()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.aBi = false;
                break;
            case 4098:
                this.aBi = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.AA());
                break;
        }
        return super.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (this.MQ != null) {
            this.MQ.p(getView());
        }
        BJ();
        if (this.ano != null) {
            this.ano.dU(y.no_more_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.anm.onChangeSkinType(tbPageContext, i);
        this.aBh.a(tbPageContext, i);
        this.ano.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.Bj()) {
                this.ano.BZ();
                if (bVar.Bh()) {
                    this.ano.dT(y.loading);
                } else if (bVar.Bi()) {
                    this.ano.dV(y.refresh);
                } else {
                    this.ano.dU(y.no_more_msg);
                }
            } else {
                this.ano.hide();
            }
            if (bVar.Bf()) {
                BI();
            } else {
                BJ();
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
            if (dVar.FO().size() <= 0) {
                FN();
                return;
            }
            if (this.MQ != null) {
                this.MQ.p(getView());
            }
            if (this.aBi) {
                this.aBh.q(dVar.FO());
            } else {
                this.aBh.r(dVar.FO());
            }
            BdToast a = BdToast.a(getContext(), this.mContext.getResources().getString(y.chosen_post_recommend, Integer.valueOf(dVar.FO().size())), 0);
            a.bE(48);
            a.bG(getResources().getDimensionPixelSize(t.ds108));
            a.rh().ri();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(getUniqueId());
        zT().dispatchMvcEvent(bVar);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.ann;
    }
}
