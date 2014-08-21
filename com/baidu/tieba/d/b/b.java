package com.baidu.tieba.d.b;

import android.view.View;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a a;
    private final /* synthetic */ View b;
    private final /* synthetic */ com.baidu.tieba.d.a.f c;
    private final /* synthetic */ int d;
    private final /* synthetic */ com.baidu.tieba.d.c.a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, com.baidu.tieba.d.a.f fVar, int i, com.baidu.tieba.d.c.a aVar2) {
        this.a = aVar;
        this.b = view;
        this.c = fVar;
        this.d = i;
        this.e = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.d();
        com.baidu.tbadk.distribute.a.a().a(this.b.getContext(), this.c.y(), "area_download", "pb", this.c.c, this.c.d);
        com.baidu.tbadk.distribute.a.a().a(this.c.y(), this.c.c, this.c.d, "PB", "download");
        com.baidu.tieba.d.b.a(this.b.getContext(), this.c, this.d);
        this.e.a();
    }
}
