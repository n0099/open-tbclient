package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.bbw = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bbw.NN();
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("enter_forum_edit_mode", false);
    }
}
