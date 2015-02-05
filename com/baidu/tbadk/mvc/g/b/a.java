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
    protected BdListView aeT;
    protected com.baidu.tbadk.mvc.k.a aeU;
    protected com.baidu.tbadk.mvc.k.b aeV;

    protected abstract List<View> t(BdListView bdListView);

    protected abstract List<View> u(BdListView bdListView);

    protected abstract com.baidu.tbadk.mvc.j.b<?, ?, ?> ya();

    protected abstract boolean yb();

    protected abstract boolean yc();

    protected abstract boolean yd();

    protected abstract boolean ye();

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ky() {
        super.ky();
        if (ya() != null) {
            ya().ky();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (ya() != null) {
            ya().onActivityStop();
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
            if (yb() && bVar.xS()) {
                if (bVar.xR()) {
                    yu();
                } else {
                    yv();
                }
            }
            if (yc() && this.aeU != null) {
                boolean z2 = ya() == null || ya().yH() != 0;
                if (bVar.xV() && z2) {
                    this.aeU.yL();
                    if (bVar.xT()) {
                        this.aeU.dP(yf());
                    } else if (bVar.xU()) {
                        this.aeU.dR(yg());
                    } else if (yi()) {
                        this.aeU.hide();
                    } else {
                        this.aeU.dQ(yh());
                    }
                } else {
                    this.aeU.hide();
                }
            }
            if (yd() && this.aeV != null) {
                if (ya() != null && ya().yH() == 0) {
                    z = false;
                }
                if (bVar.xQ() && z) {
                    this.aeV.yL();
                    if (bVar.xO()) {
                        this.aeV.dS(yj());
                        return;
                    } else if (bVar.xP()) {
                        this.aeV.dR(yk());
                        return;
                    } else if (ym()) {
                        this.aeV.hide();
                        return;
                    } else {
                        this.aeV.dT(yl());
                        return;
                    }
                }
                this.aeV.hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (yb()) {
            yv();
        }
        if (yc() && this.aeU != null) {
            if (yi()) {
                this.aeU.hide();
            } else {
                this.aeU.dQ(yh());
            }
        }
        if (yd() && this.aeV != null) {
            if (ym()) {
                this.aeV.hide();
            } else {
                this.aeV.dT(yl());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void kA() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a
    protected void kz() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kC() {
        this.aeT = (BdListView) getView().findViewById(w.view_list);
        t(this.aeT);
        u(this.aeT);
        if (yb()) {
            yt();
        }
        if (yc()) {
            this.aeU = new com.baidu.tbadk.mvc.k.a(wG());
            this.aeT.setNextPage(this.aeU);
            this.aeU.hide();
        }
        if (yd()) {
            this.aeV = new com.baidu.tbadk.mvc.k.b(wG());
            this.aeT.setPrePage(this.aeV);
            this.aeV.hide();
        }
        if (ye()) {
            this.aeT.setExOnSrollToBottomListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (ya() != null) {
            ya().a(tbPageContext, i);
        }
        if (yb()) {
            yy().cs(i);
        }
        if (yc() && this.aeU != null) {
            this.aeU.a(tbPageContext, i);
        }
        if (yd() && this.aeV != null) {
            this.aeV.a(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kB() {
        return x.mvc_template_navi_list;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void xY() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void xZ() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.aeT;
    }

    protected int yf() {
        return z.loading;
    }

    protected int yg() {
        return z.click_load_more;
    }

    protected int yh() {
        return 0;
    }

    protected boolean yi() {
        return false;
    }

    protected int yj() {
        return z.loading;
    }

    protected int yk() {
        return z.click_load_more;
    }

    protected int yl() {
        return 0;
    }

    protected boolean ym() {
        return false;
    }
}
