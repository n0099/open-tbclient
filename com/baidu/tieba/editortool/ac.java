package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbEditor ark;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.ark = pbEditor;
        this.arn = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.ark.er(i);
        } else if (i == 3) {
            this.ark.Cf();
        } else if (i == 5) {
            this.ark.er(i);
        } else if (i == 6) {
            this.ark.Cf();
        } else if (i == 8) {
            this.ark.er(i);
        } else if (i == 9) {
            this.ark.Cf();
        } else if (i != 0) {
            if (i == 18) {
                if (this.ark.BZ()) {
                    this.ark.ard.BX();
                } else {
                    this.ark.ard.BY();
                }
            } else if (i == 12) {
                this.arn.handleAction(35, obj);
                this.ark.ard.Bg();
                this.ark.are.x(this.ark.ard.getEditText());
            } else if (i == 38) {
                this.ark.er(i);
            } else if (i == 44) {
                this.ark.er(i);
            } else if (i == 50) {
                this.ark.er(i);
            }
        }
        this.arn.handleAction(i, obj);
    }
}
