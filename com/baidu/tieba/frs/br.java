package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.c bhH;
    final /* synthetic */ bq bia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar, com.baidu.tbadk.core.data.c cVar) {
        this.bia = bqVar;
        this.bhH = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10827");
        auVar.aa("obj_id", new StringBuilder(String.valueOf(this.bhH.getFid())).toString());
        TiebaStatic.log(auVar);
        com.baidu.tbadk.browser.f.a(this.bia.bdK.getPageContext().getPageActivity(), true, this.bhH.UL);
    }
}
