package com.baidu.tieba.frs.view;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.b {
    final /* synthetic */ q bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar) {
        this.bes = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.bes.aVn.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
