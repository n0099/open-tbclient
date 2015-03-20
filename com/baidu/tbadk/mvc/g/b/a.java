package com.baidu.tbadk.mvc.g.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.mvc.i.b {
    protected BdListView ann;
    protected com.baidu.tbadk.mvc.k.a ano;
    protected com.baidu.tbadk.mvc.k.b anp;

    protected abstract com.baidu.tbadk.mvc.j.c<?, ?, ?> Bo();

    protected abstract boolean Bp();

    protected abstract boolean Bq();

    protected abstract boolean Br();

    protected abstract boolean Bs();

    protected abstract List<View> t(BdListView bdListView);

    protected abstract List<View> u(BdListView bdListView);

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void or() {
        super.or();
        if (Bo() != null) {
            Bo().or();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (Bo() != null) {
            Bo().onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void b(com.baidu.tbadk.mvc.e.c cVar) {
        boolean z = true;
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (Bp() && bVar.Bg()) {
                if (bVar.Bf()) {
                    BI();
                } else {
                    BJ();
                }
            }
            if (Bq() && this.ano != null) {
                boolean z2 = Bo() == null || Bo().BV() != 0;
                if (bVar.Bj() && z2) {
                    this.ano.BZ();
                    if (bVar.Bh()) {
                        this.ano.dT(Bt());
                    } else if (bVar.Bi()) {
                        this.ano.dV(Bu());
                    } else if (Bw()) {
                        this.ano.hide();
                    } else {
                        this.ano.dU(Bv());
                    }
                } else {
                    this.ano.hide();
                }
            }
            if (Br() && this.anp != null) {
                if (Bo() != null && Bo().BV() == 0) {
                    z = false;
                }
                if (bVar.Be() && z) {
                    this.anp.BZ();
                    if (bVar.Bc()) {
                        this.anp.dW(Bx());
                        return;
                    } else if (bVar.Bd()) {
                        this.anp.dV(By());
                        return;
                    } else if (BA()) {
                        this.anp.hide();
                        return;
                    } else {
                        this.anp.dX(Bz());
                        return;
                    }
                }
                this.anp.hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (Bp()) {
            BJ();
        }
        if (Bq() && this.ano != null) {
            if (Bw()) {
                this.ano.hide();
            } else {
                this.ano.dU(Bv());
            }
        }
        if (Br() && this.anp != null) {
            if (BA()) {
                this.anp.hide();
            } else {
                this.anp.dX(Bz());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void ot() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void os() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.ann = (BdListView) getView().findViewById(v.view_list);
        t(this.ann);
        u(this.ann);
        if (Bp()) {
            BH();
        }
        if (Bq()) {
            this.ano = new com.baidu.tbadk.mvc.k.a(zS());
            this.ann.setNextPage(this.ano);
            this.ano.hide();
        }
        if (Br()) {
            this.anp = new com.baidu.tbadk.mvc.k.b(zS());
            this.ann.setPrePage(this.anp);
            this.anp.hide();
        }
        if (Bs()) {
            this.ann.setExOnSrollToBottomListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (Bo() != null) {
            Bo().a(tbPageContext, i);
        }
        if (Bp()) {
            BM().ct(i);
        }
        if (Bq() && this.ano != null) {
            this.ano.a(tbPageContext, i);
        }
        if (Br() && this.anp != null) {
            this.anp.a(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.mvc_template_navi_list;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bm() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bn() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.ann;
    }

    protected int Bt() {
        return y.loading;
    }

    protected int Bu() {
        return y.click_load_more;
    }

    protected int Bv() {
        return 0;
    }

    protected boolean Bw() {
        return false;
    }

    protected int Bx() {
        return y.loading;
    }

    protected int By() {
        return y.click_load_more;
    }

    protected int Bz() {
        return 0;
    }

    protected boolean BA() {
        return false;
    }
}
