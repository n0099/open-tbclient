package com.baidu.tieba.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements m {
    final /* synthetic */ i aYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aYA = iVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.m
    public void NK() {
        ao aoVar;
        ao aoVar2;
        int i;
        aoVar = this.aYA.aYz;
        if (aoVar == null) {
            return;
        }
        aoVar2 = this.aYA.aYz;
        i = this.aYA.index;
        aoVar2.delete(i);
    }
}
