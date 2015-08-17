package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.c aVr;
    final /* synthetic */ FrsActivity this$0;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.this$0 = frsActivity;
        this.aVr = cVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aVr.rw()) {
            this.this$0.a(this.aVr, "area_download");
            this.this$0.b(this.aVr, "download");
            this.this$0.b(this.aVr, this.val$position);
            aVar.dismiss();
        }
    }
}
