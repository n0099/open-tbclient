package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ k bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.bvO = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bvO.SK();
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("enter_forum_edit_mode", false);
    }
}
