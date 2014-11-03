package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbEditor art;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.art = pbEditor;
        this.arw = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.art.er(i);
        } else if (i == 3) {
            this.art.Ch();
        } else if (i == 5) {
            this.art.er(i);
        } else if (i == 6) {
            this.art.Ch();
        } else if (i == 8) {
            this.art.er(i);
        } else if (i == 9) {
            this.art.Ch();
        } else if (i != 0) {
            if (i == 18) {
                if (this.art.Cb()) {
                    this.art.arm.BZ();
                } else {
                    this.art.arm.Ca();
                }
            } else if (i == 12) {
                this.arw.handleAction(35, obj);
                this.art.arm.Bi();
                this.art.arn.x(this.art.arm.getEditText());
            } else if (i == 38) {
                this.art.er(i);
            } else if (i == 44) {
                this.art.er(i);
            } else if (i == 50) {
                this.art.er(i);
            }
        }
        this.arw.handleAction(i, obj);
    }
}
