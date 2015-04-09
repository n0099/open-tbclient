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
    protected BdListView anv;
    protected com.baidu.tbadk.mvc.k.a anw;
    protected com.baidu.tbadk.mvc.k.b anx;

    protected abstract com.baidu.tbadk.mvc.j.c<?, ?, ?> Bu();

    protected abstract boolean Bv();

    protected abstract boolean Bw();

    protected abstract boolean Bx();

    protected abstract boolean By();

    protected abstract List<View> t(BdListView bdListView);

    protected abstract List<View> u(BdListView bdListView);

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void or() {
        super.or();
        if (Bu() != null) {
            Bu().or();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (Bu() != null) {
            Bu().onActivityStop();
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
            if (Bv() && bVar.Bm()) {
                if (bVar.Bl()) {
                    BO();
                } else {
                    BP();
                }
            }
            if (Bw() && this.anw != null) {
                boolean z2 = Bu() == null || Bu().Cb() != 0;
                if (bVar.Bp() && z2) {
                    this.anw.Cf();
                    if (bVar.Bn()) {
                        this.anw.dT(Bz());
                    } else if (bVar.Bo()) {
                        this.anw.dV(BA());
                    } else if (BC()) {
                        this.anw.hide();
                    } else {
                        this.anw.dU(BB());
                    }
                } else {
                    this.anw.hide();
                }
            }
            if (Bx() && this.anx != null) {
                if (Bu() != null && Bu().Cb() == 0) {
                    z = false;
                }
                if (bVar.Bk() && z) {
                    this.anx.Cf();
                    if (bVar.Bi()) {
                        this.anx.dW(BD());
                        return;
                    } else if (bVar.Bj()) {
                        this.anx.dV(BE());
                        return;
                    } else if (BG()) {
                        this.anx.hide();
                        return;
                    } else {
                        this.anx.dX(BF());
                        return;
                    }
                }
                this.anx.hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (Bv()) {
            BP();
        }
        if (Bw() && this.anw != null) {
            if (BC()) {
                this.anw.hide();
            } else {
                this.anw.dU(BB());
            }
        }
        if (Bx() && this.anx != null) {
            if (BG()) {
                this.anx.hide();
            } else {
                this.anx.dX(BF());
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
        this.anv = (BdListView) getView().findViewById(v.view_list);
        t(this.anv);
        u(this.anv);
        if (Bv()) {
            BN();
        }
        if (Bw()) {
            this.anw = new com.baidu.tbadk.mvc.k.a(zY());
            this.anv.setNextPage(this.anw);
            this.anw.hide();
        }
        if (Bx()) {
            this.anx = new com.baidu.tbadk.mvc.k.b(zY());
            this.anv.setPrePage(this.anx);
            this.anx.hide();
        }
        if (By()) {
            this.anv.setExOnSrollToBottomListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (Bu() != null) {
            Bu().a(tbPageContext, i);
        }
        if (Bv()) {
            BS().ct(i);
        }
        if (Bw() && this.anw != null) {
            this.anw.a(tbPageContext, i);
        }
        if (Bx() && this.anx != null) {
            this.anx.a(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.mvc_template_navi_list;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bs() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bt() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.anv;
    }

    protected int Bz() {
        return y.loading;
    }

    protected int BA() {
        return y.click_load_more;
    }

    protected int BB() {
        return 0;
    }

    protected boolean BC() {
        return false;
    }

    protected int BD() {
        return y.loading;
    }

    protected int BE() {
        return y.click_load_more;
    }

    protected int BF() {
        return 0;
    }

    protected boolean BG() {
        return false;
    }
}
