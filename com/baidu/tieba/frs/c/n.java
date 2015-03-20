package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.i.b {
    private bf aIS;
    private Runnable aNE;
    private FrsActivity aNb;

    public n(FrsActivity frsActivity) {
        this.aNb = frsActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Aa() {
        super.Aa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ac() {
        super.Ac();
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
        this.aIS = new bf(this.aNb, this.aNb.aJs);
        this.aNb.a(this.aIS);
        BD();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.frs_activity;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bm() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Bn() {
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
        if (this.aNE != null) {
            com.baidu.adp.lib.g.i.hI().removeCallbacks(this.aNE);
        }
    }

    public void Ko() {
        if (this.aNE == null) {
            this.aNE = new o(this);
        }
        com.baidu.adp.lib.g.i.hI().postDelayed(this.aNE, 2000L);
    }
}
