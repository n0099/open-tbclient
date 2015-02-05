package com.baidu.tieba.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements m {
    final /* synthetic */ i aZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aZV = iVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.m
    public void Ob() {
        ao aoVar;
        ao aoVar2;
        int i;
        aoVar = this.aZV.aZU;
        if (aoVar == null) {
            return;
        }
        aoVar2 = this.aZV.aZU;
        i = this.aZV.index;
        aoVar2.delete(i);
    }
}
