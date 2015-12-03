package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ h aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.aQN = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aQN.JO();
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("enter_forum_edit_mode", false);
    }
}
