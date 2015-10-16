package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ d aLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.aLW = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aLW.Il();
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("enter_forum_edit_mode", false);
    }
}
