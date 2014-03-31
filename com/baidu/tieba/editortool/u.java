package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements Runnable {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbEditor pbEditor, int i) {
        this.a = pbEditor;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PbEditor pbEditor = this.a;
        int i = this.b;
        new v(this);
        pbEditor.a(i);
    }
}
