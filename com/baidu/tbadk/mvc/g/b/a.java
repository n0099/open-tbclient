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

    protected abstract com.baidu.tbadk.mvc.j.c<?, ?, ?> Cg();

    protected abstract boolean Ch();

    protected abstract boolean Ci();

    protected abstract boolean Cj();

    protected abstract boolean Ck();

    protected abstract List<View> t(BdListView bdListView);

    protected abstract List<View> u(BdListView bdListView);

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oH() {
        super.oH();
        if (Cg() != null) {
            Cg().oH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (Cg() != null) {
            Cg().onActivityStop();
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
            if (Ch() && bVar.BY()) {
                if (bVar.BX()) {
                    CA();
                } else {
                    CB();
                }
            }
            if (Ci() && this.aoz != null) {
                boolean z2 = Cg() == null || Cg().CN() != 0;
                if (bVar.Cb() && z2) {
                    this.aoz.CQ();
                    if (bVar.BZ()) {
                        this.aoz.ed(Cl());
                    } else if (bVar.Ca()) {
                        this.aoz.ef(Cm());
                    } else if (Co()) {
                        this.aoz.hide();
                    } else {
                        this.aoz.ee(Cn());
                    }
                } else {
                    this.aoz.hide();
                }
            }
            if (Cj() && this.aoA != null) {
                if (Cg() != null && Cg().CN() == 0) {
                    z = false;
                }
                if (bVar.BW() && z) {
                    this.aoA.CQ();
                    if (bVar.BU()) {
                        this.aoA.eg(Cp());
                        return;
                    } else if (bVar.BV()) {
                        this.aoA.ef(Cq());
                        return;
                    } else if (Cs()) {
                        this.aoA.hide();
                        return;
                    } else {
                        this.aoA.eh(Cr());
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
        if (Ch()) {
            CB();
        }
        if (Ci() && this.aoz != null) {
            if (Co()) {
                this.aoz.hide();
            } else {
                this.aoz.ee(Cn());
            }
        }
        if (Cj() && this.aoA != null) {
            if (Cs()) {
                this.aoA.hide();
            } else {
                this.aoA.eh(Cr());
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
        if (Ch()) {
            Cz();
        }
        if (Ci()) {
            this.aoz = new com.baidu.tbadk.mvc.k.a(AK());
            this.aoy.setNextPage(this.aoz);
            this.aoz.hide();
        }
        if (Cj()) {
            this.aoA = new com.baidu.tbadk.mvc.k.b(AK());
            this.aoy.setPrePage(this.aoA);
            this.aoA.hide();
        }
        if (Ck()) {
            this.aoy.setExOnSrollToBottomListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (Cg() != null) {
            Cg().a(tbPageContext, i);
        }
        if (Ch()) {
            CE().cy(i);
        }
        if (Ci() && this.aoz != null) {
            this.aoz.a(tbPageContext, i);
        }
        if (Cj() && this.aoA != null) {
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
    protected void Ce() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Cf() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.aoy;
    }

    protected int Cl() {
        return t.loading;
    }

    protected int Cm() {
        return t.click_load_more;
    }

    protected int Cn() {
        return 0;
    }

    protected boolean Co() {
        return false;
    }

    protected int Cp() {
        return t.loading;
    }

    protected int Cq() {
        return t.click_load_more;
    }

    protected int Cr() {
        return 0;
    }

    protected boolean Cs() {
        return false;
    }
}
