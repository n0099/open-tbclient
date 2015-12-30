package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a.b {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.aUE = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aUE.Kh();
        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("enter_forum_edit_mode", false);
    }
}
