package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.i.b {
    private bf aLi;
    private FrsActivity aPE;
    private Runnable aQh;

    public n(FrsActivity frsActivity) {
        this.aPE = frsActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AS() {
        super.AS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AU() {
        super.AU();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
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
        this.aLi = new bf(this.aPE, this.aPE.aLJ);
        this.aPE.a(this.aLi);
        Cv();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return r.frs_activity;
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Ce() {
    }

    @Override // com.baidu.tbadk.mvc.i.b
    protected void Cf() {
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public void bh(boolean z) {
        super.bh(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.aQh != null) {
            com.baidu.adp.lib.g.i.hs().removeCallbacks(this.aQh);
        }
    }
}
