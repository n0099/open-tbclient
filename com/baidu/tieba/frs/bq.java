package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.c bmu;
    final /* synthetic */ bp bmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, com.baidu.tbadk.core.data.c cVar) {
        this.bmw = bpVar;
        this.bmu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10827");
        awVar.ac("obj_id", new StringBuilder(String.valueOf(this.bmu.getFid())).toString());
        TiebaStatic.log(awVar);
        com.baidu.tbadk.browser.f.a(this.bmw.bix.getPageContext().getPageActivity(), true, this.bmu.Sq);
    }
}
