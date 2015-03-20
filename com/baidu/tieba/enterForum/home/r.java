package com.baidu.tieba.enterForum.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(a aVar) {
        this.aCT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aCT.GD();
    }
}
