package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ l bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bqi = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bqi.Te();
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("enter_forum_edit_mode", false);
    }
}
