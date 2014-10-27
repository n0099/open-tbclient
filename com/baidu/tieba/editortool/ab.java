package com.baidu.tieba.editortool;
/* loaded from: classes.dex */
class ab implements az {
    final /* synthetic */ aa arm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.arm = aaVar;
    }

    @Override // com.baidu.tieba.editortool.az
    public void Ci() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.arm.ark;
        pbEditor.ari = true;
        pbEditor2 = this.arm.ark;
        pbEditor2.ard.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.az
    public void Cj() {
    }
}
