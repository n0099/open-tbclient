package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class ax implements com.baidu.adp.widget.ScrollView.m {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.m
    public final void a() {
        com.baidu.tieba.util.cb.a(this.a, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.a.q = null;
        this.a.p = true;
        this.a.b(1);
    }
}
