package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tbadk.core.data.a b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsActivity frsActivity, com.baidu.tbadk.core.data.a aVar, int i) {
        this.a = frsActivity;
        this.b = aVar;
        this.c = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.b.b()) {
            this.a.a(this.b, "area_download");
            this.a.b(this.b, "download");
            this.a.b(this.b, this.c);
            aVar.c();
        }
    }
}
