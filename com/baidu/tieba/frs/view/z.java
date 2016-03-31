package com.baidu.tieba.frs.view;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    final /* synthetic */ u bwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.bwT = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.bwT.blH.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
