package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.i.b {
    private bf aJa;
    private Runnable aNV;
    private FrsActivity aNs;

    public n(FrsActivity frsActivity) {
        this.aNs = frsActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ag() {
        super.Ag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ai() {
        super.Ai();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
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
        this.aJa = new bf(this.aNs, this.aNs.aJC);
        this.aNs.a(this.aJa);
        BJ();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.frs_activity;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bs() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bt() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public void ba(boolean z) {
        super.ba(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.aNV != null) {
            com.baidu.adp.lib.g.i.hI().removeCallbacks(this.aNV);
        }
    }

    public void Kv() {
        if (this.aNV == null) {
            this.aNV = new o(this);
        }
        com.baidu.adp.lib.g.i.hI().postDelayed(this.aNV, 2000L);
    }
}
