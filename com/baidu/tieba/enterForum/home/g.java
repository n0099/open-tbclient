package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ d aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.aMQ = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aMQ.Ip();
        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("enter_forum_edit_mode", false);
    }
}
