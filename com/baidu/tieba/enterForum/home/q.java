package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.b {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.bHc = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bHc.Xw();
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("enter_forum_edit_mode", false);
    }
}
