package com.baidu.tieba.editortool;
/* loaded from: classes.dex */
final class v implements as {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
    }

    @Override // com.baidu.tieba.editortool.as
    public final void a() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.a.a;
        pbEditor.e = true;
        pbEditor2 = this.a.a;
        pbEditor2.b.getEditText().requestFocus();
    }
}
