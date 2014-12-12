package com.baidu.tbadk.mvc.g.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.mvc.i.b {
    protected com.baidu.tbadk.mvc.k.a aeA;
    protected com.baidu.tbadk.mvc.k.b aeB;
    protected BdListView aez;

    protected abstract List<View> t(BdListView bdListView);

    protected abstract List<View> u(BdListView bdListView);

    protected abstract com.baidu.tbadk.mvc.j.b<?, ?, ?> xQ();

    protected abstract boolean xR();

    protected abstract boolean xS();

    protected abstract boolean xT();

    protected abstract boolean xU();

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kF() {
        super.kF();
        if (xQ() != null) {
            xQ().kF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (xQ() != null) {
            xQ().onActivityStop();
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
            if (xR() && bVar.xI()) {
                if (bVar.xH()) {
                    yk();
                } else {
                    yl();
                }
            }
            if (xS() && this.aeA != null) {
                boolean z2 = xQ() == null || xQ().yx() != 0;
                if (bVar.xL() && z2) {
                    this.aeA.yB();
                    if (bVar.xJ()) {
                        this.aeA.dJ(xV());
                    } else if (bVar.xK()) {
                        this.aeA.dL(xW());
                    } else if (xY()) {
                        this.aeA.hide();
                    } else {
                        this.aeA.dK(xX());
                    }
                } else {
                    this.aeA.hide();
                }
            }
            if (xT() && this.aeB != null) {
                if (xQ() != null && xQ().yx() == 0) {
                    z = false;
                }
                if (bVar.xG() && z) {
                    this.aeB.yB();
                    if (bVar.xE()) {
                        this.aeB.dM(xZ());
                        return;
                    } else if (bVar.xF()) {
                        this.aeB.dL(ya());
                        return;
                    } else if (yc()) {
                        this.aeB.hide();
                        return;
                    } else {
                        this.aeB.dN(yb());
                        return;
                    }
                }
                this.aeB.hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (xR()) {
            yl();
        }
        if (xS() && this.aeA != null) {
            if (xY()) {
                this.aeA.hide();
            } else {
                this.aeA.dK(xX());
            }
        }
        if (xT() && this.aeB != null) {
            if (yc()) {
                this.aeB.hide();
            } else {
                this.aeB.dN(yb());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void kH() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void kG() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.aez = (BdListView) getView().findViewById(w.view_list);
        t(this.aez);
        u(this.aez);
        if (xR()) {
            yj();
        }
        if (xS()) {
            this.aeA = new com.baidu.tbadk.mvc.k.a(ww());
            this.aez.setNextPage(this.aeA);
            this.aeA.hide();
        }
        if (xT()) {
            this.aeB = new com.baidu.tbadk.mvc.k.b(ww());
            this.aez.setPrePage(this.aeB);
            this.aeB.hide();
        }
        if (xU()) {
            this.aez.setExOnSrollToBottomListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (xQ() != null) {
            xQ().a(tbPageContext, i);
        }
        if (xR()) {
            yo().cl(i);
        }
        if (xS() && this.aeA != null) {
            this.aeA.a(tbPageContext, i);
        }
        if (xT() && this.aeB != null) {
            this.aeB.a(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return x.mvc_template_navi_list;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void xO() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void xP() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.aez;
    }

    protected int xV() {
        return z.loading;
    }

    protected int xW() {
        return z.click_load_more;
    }

    protected int xX() {
        return 0;
    }

    protected boolean xY() {
        return false;
    }

    protected int xZ() {
        return z.loading;
    }

    protected int ya() {
        return z.click_load_more;
    }

    protected int yb() {
        return 0;
    }

    protected boolean yc() {
        return false;
    }
}
