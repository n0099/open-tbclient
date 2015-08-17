package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ d aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.aMD = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aMD.IB();
        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("enter_forum_edit_mode", false);
    }
}
