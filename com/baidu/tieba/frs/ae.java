package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.b {
    final /* synthetic */ FrsActivity bed;
    private final /* synthetic */ com.baidu.tbadk.core.data.b bej;
    private final /* synthetic */ boolean bek;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity, com.baidu.tbadk.core.data.b bVar, boolean z, int i) {
        this.bed = frsActivity;
        this.bej = bVar;
        this.bek = z;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.bej.rl()) {
            this.bed.a(this.bej, this.bek ? "area_download" : "btn_download");
            this.bed.a(this.bej, this.val$position);
            aVar.dismiss();
        }
    }
}
