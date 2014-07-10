package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbEditor pbEditor, int i) {
        this.a = pbEditor;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b, new x(this));
    }
}
