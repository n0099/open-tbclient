package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    final /* synthetic */ i aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.aWN = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aWN.LZ();
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("enter_forum_edit_mode", false);
    }
}
