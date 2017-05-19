package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ i bGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bGZ = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bGZ.Wm();
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("enter_forum_edit_mode", false);
    }
}
