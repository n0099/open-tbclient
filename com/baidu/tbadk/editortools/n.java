package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ l auh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.auh = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.auh.Do();
    }
}
