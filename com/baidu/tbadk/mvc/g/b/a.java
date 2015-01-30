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
    protected BdListView aeW;
    protected com.baidu.tbadk.mvc.k.a aeX;
    protected com.baidu.tbadk.mvc.k.b aeY;

    protected abstract List<View> t(BdListView bdListView);

    protected abstract List<View> u(BdListView bdListView);

    protected abstract com.baidu.tbadk.mvc.j.b<?, ?, ?> yg();

    protected abstract boolean yh();

    protected abstract boolean yi();

    protected abstract boolean yj();

    protected abstract boolean yk();

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kF() {
        super.kF();
        if (yg() != null) {
            yg().kF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (yg() != null) {
            yg().onActivityStop();
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
            if (yh() && bVar.xY()) {
                if (bVar.xX()) {
                    yA();
                } else {
                    yB();
                }
            }
            if (yi() && this.aeX != null) {
                boolean z2 = yg() == null || yg().yN() != 0;
                if (bVar.yb() && z2) {
                    this.aeX.yR();
                    if (bVar.xZ()) {
                        this.aeX.dP(yl());
                    } else if (bVar.ya()) {
                        this.aeX.dR(ym());
                    } else if (yo()) {
                        this.aeX.hide();
                    } else {
                        this.aeX.dQ(yn());
                    }
                } else {
                    this.aeX.hide();
                }
            }
            if (yj() && this.aeY != null) {
                if (yg() != null && yg().yN() == 0) {
                    z = false;
                }
                if (bVar.xW() && z) {
                    this.aeY.yR();
                    if (bVar.xU()) {
                        this.aeY.dS(yp());
                        return;
                    } else if (bVar.xV()) {
                        this.aeY.dR(yq());
                        return;
                    } else if (ys()) {
                        this.aeY.hide();
                        return;
                    } else {
                        this.aeY.dT(yr());
                        return;
                    }
                }
                this.aeY.hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (yh()) {
            yB();
        }
        if (yi() && this.aeX != null) {
            if (yo()) {
                this.aeX.hide();
            } else {
                this.aeX.dQ(yn());
            }
        }
        if (yj() && this.aeY != null) {
            if (ys()) {
                this.aeY.hide();
            } else {
                this.aeY.dT(yr());
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
        this.aeW = (BdListView) getView().findViewById(w.view_list);
        t(this.aeW);
        u(this.aeW);
        if (yh()) {
            yz();
        }
        if (yi()) {
            this.aeX = new com.baidu.tbadk.mvc.k.a(wM());
            this.aeW.setNextPage(this.aeX);
            this.aeX.hide();
        }
        if (yj()) {
            this.aeY = new com.baidu.tbadk.mvc.k.b(wM());
            this.aeW.setPrePage(this.aeY);
            this.aeY.hide();
        }
        if (yk()) {
            this.aeW.setExOnSrollToBottomListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (yg() != null) {
            yg().a(tbPageContext, i);
        }
        if (yh()) {
            yE().cs(i);
        }
        if (yi() && this.aeX != null) {
            this.aeX.a(tbPageContext, i);
        }
        if (yj() && this.aeY != null) {
            this.aeY.a(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return x.mvc_template_navi_list;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void ye() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void yf() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.aeW;
    }

    protected int yl() {
        return z.loading;
    }

    protected int ym() {
        return z.click_load_more;
    }

    protected int yn() {
        return 0;
    }

    protected boolean yo() {
        return false;
    }

    protected int yp() {
        return z.loading;
    }

    protected int yq() {
        return z.click_load_more;
    }

    protected int yr() {
        return 0;
    }

    protected boolean ys() {
        return false;
    }
}
