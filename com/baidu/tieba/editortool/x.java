package com.baidu.tieba.editortool;
/* loaded from: classes.dex */
class x implements au {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.tieba.editortool.au
    public void a() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.a.a;
        pbEditor.e = true;
        pbEditor2 = this.a.a;
        pbEditor2.b.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.au
    public void b() {
    }
}
