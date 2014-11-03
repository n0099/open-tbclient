package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ PbEditor art;
    private final /* synthetic */ int aru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbEditor pbEditor, int i) {
        this.art = pbEditor;
        this.aru = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.art.a(this.aru, new ab(this));
    }
}
