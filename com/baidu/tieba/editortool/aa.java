package com.baidu.tieba.editortool;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ PbEditor ark;
    private final /* synthetic */ int arl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbEditor pbEditor, int i) {
        this.ark = pbEditor;
        this.arl = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ark.a(this.arl, new ab(this));
    }
}
