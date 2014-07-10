package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.a = pbEditor;
        this.b = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        if (i == 2) {
            this.a.b(i);
        } else if (i == 3) {
            this.a.k();
        } else if (i == 5) {
            this.a.b(i);
        } else if (i == 6) {
            this.a.k();
        } else if (i == 8) {
            this.a.b(i);
        } else if (i == 9) {
            this.a.k();
        } else if (i != 0) {
            if (i == 18) {
                if (this.a.c()) {
                    this.a.b.e();
                } else {
                    this.a.b.f();
                }
            } else if (i == 12) {
                this.b.a(35, obj);
                this.a.b.k();
                this.a.c.c(this.a.b.getEditText());
            } else if (i == 38) {
                this.a.b(i);
            } else if (i == 44) {
                this.a.b(i);
            } else if (i == 50) {
                this.a.b(i);
            }
        }
        this.b.a(i, obj);
    }
}
