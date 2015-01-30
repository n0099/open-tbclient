package com.baidu.tieba.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements m {
    final /* synthetic */ i aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aZW = iVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.m
    public void Og() {
        ao aoVar;
        ao aoVar2;
        int i;
        aoVar = this.aZW.aZV;
        if (aoVar == null) {
            return;
        }
        aoVar2 = this.aZW.aZV;
        i = this.aZW.index;
        aoVar2.delete(i);
    }
}
