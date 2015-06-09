package com.baidu.tbadk.mvc.g.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.mvc.i.b {
    protected com.baidu.tbadk.mvc.k.b aoA;
    protected BdListView aoy;
    protected com.baidu.tbadk.mvc.k.a aoz;

    protected abstract com.baidu.tbadk.mvc.j.c<?, ?, ?> Ch();

    protected abstract boolean Ci();

    protected abstract boolean Cj();

    protected abstract boolean Ck();

    protected abstract boolean Cl();

    protected abstract List<View> t(BdListView bdListView);

    protected abstract List<View> u(BdListView bdListView);

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oH() {
        super.oH();
        if (Ch() != null) {
            Ch().oH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (Ch() != null) {
            Ch().onActivityStop();
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
            if (Ci() && bVar.BZ()) {
                if (bVar.BY()) {
                    CB();
                } else {
                    CC();
                }
            }
            if (Cj() && this.aoz != null) {
                boolean z2 = Ch() == null || Ch().CO() != 0;
                if (bVar.Cc() && z2) {
                    this.aoz.CR();
                    if (bVar.Ca()) {
                        this.aoz.ed(Cm());
                    } else if (bVar.Cb()) {
                        this.aoz.ef(Cn());
                    } else if (Cp()) {
                        this.aoz.hide();
                    } else {
                        this.aoz.ee(Co());
                    }
                } else {
                    this.aoz.hide();
                }
            }
            if (Ck() && this.aoA != null) {
                if (Ch() != null && Ch().CO() == 0) {
                    z = false;
                }
                if (bVar.BX() && z) {
                    this.aoA.CR();
                    if (bVar.BV()) {
                        this.aoA.eg(Cq());
                        return;
                    } else if (bVar.BW()) {
                        this.aoA.ef(Cr());
                        return;
                    } else if (Ct()) {
                        this.aoA.hide();
                        return;
                    } else {
                        this.aoA.eh(Cs());
                        return;
                    }
                }
                this.aoA.hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (Ci()) {
            CC();
        }
        if (Cj() && this.aoz != null) {
            if (Cp()) {
                this.aoz.hide();
            } else {
                this.aoz.ee(Co());
            }
        }
        if (Ck() && this.aoA != null) {
            if (Ct()) {
                this.aoA.hide();
            } else {
                this.aoA.eh(Cs());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void oJ() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void oI() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.aoy = (BdListView) getView().findViewById(q.view_list);
        t(this.aoy);
        u(this.aoy);
        if (Ci()) {
            CA();
        }
        if (Cj()) {
            this.aoz = new com.baidu.tbadk.mvc.k.a(AL());
            this.aoy.setNextPage(this.aoz);
            this.aoz.hide();
        }
        if (Ck()) {
            this.aoA = new com.baidu.tbadk.mvc.k.b(AL());
            this.aoy.setPrePage(this.aoA);
            this.aoA.hide();
        }
        if (Cl()) {
            this.aoy.setExOnSrollToBottomListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (Ch() != null) {
            Ch().a(tbPageContext, i);
        }
        if (Ci()) {
            CF().cy(i);
        }
        if (Cj() && this.aoz != null) {
            this.aoz.a(tbPageContext, i);
        }
        if (Ck() && this.aoA != null) {
            this.aoA.a(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return r.mvc_template_navi_list;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Cf() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Cg() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.aoy;
    }

    protected int Cm() {
        return t.loading;
    }

    protected int Cn() {
        return t.click_load_more;
    }

    protected int Co() {
        return 0;
    }

    protected boolean Cp() {
        return false;
    }

    protected int Cq() {
        return t.loading;
    }

    protected int Cr() {
        return t.click_load_more;
    }

    protected int Cs() {
        return 0;
    }

    protected boolean Ct() {
        return false;
    }
}
