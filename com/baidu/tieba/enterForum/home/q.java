package com.baidu.tieba.enterForum.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a aVar) {
        this.aFd = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.aFd.HN();
    }
}
