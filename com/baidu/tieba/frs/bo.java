package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {
    final /* synthetic */ bn bmt;
    private final /* synthetic */ com.baidu.tbadk.core.data.c bmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar, com.baidu.tbadk.core.data.c cVar) {
        this.bmt = bnVar;
        this.bmu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10827");
        awVar.ac("obj_id", new StringBuilder(String.valueOf(this.bmu.getFid())).toString());
        TiebaStatic.log(awVar);
        com.baidu.tbadk.browser.f.a(this.bmt.bix.getPageContext().getPageActivity(), true, this.bmu.Sq);
    }
}
