package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.mvc.model.q;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.d.d<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> {
    private ChosenPostActivity aBj;
    private com.baidu.tieba.chosen.posts.request.b aBk;
    private com.baidu.tieba.chosen.posts.request.a aBl;
    private com.baidu.tbadk.mvc.e.b aBm;
    private com.baidu.tbadk.mvc.model.d<com.baidu.tieba.chosen.posts.request.d> aBn;

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity);
        this.aBm = new com.baidu.tbadk.mvc.e.b();
        this.aBn = new c(this);
        this.aBj = chosenPostActivity;
        zZ().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.d, com.baidu.tbadk.mvc.d.e, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.AF() == 4100) {
            this.aBk.AZ();
        }
        return super.a(bVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean ow() {
        this.aBl.AR();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(com.baidu.tieba.chosen.posts.request.c cVar, com.baidu.tieba.chosen.posts.request.d dVar) {
        b(dVar);
        BdLog.e("processResponse:  stopPullRefreshing");
        if (dVar != null) {
            this.aBm.aV(false);
            this.aBm.aW(false);
            a(this.aBm);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.aBk = new com.baidu.tieba.chosen.posts.request.b(this.aBj.getPageContext(), new com.baidu.tieba.chosen.posts.request.c(20));
        this.aBk.a((q) this);
        this.aBl = new com.baidu.tieba.chosen.posts.request.a(this.aBj.getPageContext());
        this.aBl.a(this.aBn);
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean aU(boolean z) {
        this.aBm.aV(true);
        a(this.aBm);
        bp(true);
        this.aBk.AZ();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean AO() {
        this.aBk.AZ();
        this.aBm.aW(true);
        this.aBm.aY(true);
        bp(false);
        a(this.aBm);
        return true;
    }

    private void bp(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(4097, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(4098, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        zZ().dispatchMvcEvent(bVar);
    }
}
