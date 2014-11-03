package com.baidu.tieba.editortool;
/* loaded from: classes.dex */
class ab implements az {
    final /* synthetic */ aa arv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.arv = aaVar;
    }

    @Override // com.baidu.tieba.editortool.az
    public void Ck() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.arv.art;
        pbEditor.arr = true;
        pbEditor2 = this.arv.art;
        pbEditor2.arm.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.az
    public void Cl() {
    }
}
