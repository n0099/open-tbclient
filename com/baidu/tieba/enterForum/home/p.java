package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ l bFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bFb = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bFb.Vw();
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("enter_forum_edit_mode", false);
    }
}
