package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.mvc.model.q;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.d.d<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> {
    private ChosenPostActivity aBb;
    private com.baidu.tieba.chosen.posts.request.b aBc;
    private com.baidu.tieba.chosen.posts.request.a aBd;
    private com.baidu.tbadk.mvc.e.b aBe;
    private com.baidu.tbadk.mvc.model.d<com.baidu.tieba.chosen.posts.request.d> aBf;

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity);
        this.aBe = new com.baidu.tbadk.mvc.e.b();
        this.aBf = new c(this);
        this.aBb = chosenPostActivity;
        zT().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.d, com.baidu.tbadk.mvc.d.e, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.Az() == 4100) {
            this.aBc.AT();
        }
        return super.a(bVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean ow() {
        this.aBd.AL();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(com.baidu.tieba.chosen.posts.request.c cVar, com.baidu.tieba.chosen.posts.request.d dVar) {
        b(dVar);
        BdLog.e("processResponse:  stopPullRefreshing");
        if (dVar != null) {
            this.aBe.aV(false);
            this.aBe.aW(false);
            a(this.aBe);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.aBc = new com.baidu.tieba.chosen.posts.request.b(this.aBb.getPageContext(), new com.baidu.tieba.chosen.posts.request.c(20));
        this.aBc.a((q) this);
        this.aBd = new com.baidu.tieba.chosen.posts.request.a(this.aBb.getPageContext());
        this.aBd.a(this.aBf);
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean aU(boolean z) {
        this.aBe.aV(true);
        a(this.aBe);
        bp(true);
        this.aBc.AT();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean AI() {
        this.aBc.AT();
        this.aBe.aW(true);
        this.aBe.aY(true);
        bp(false);
        a(this.aBe);
        return true;
    }

    private void bp(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(4098, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        zT().dispatchMvcEvent(bVar);
    }
}
