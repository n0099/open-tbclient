package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class j implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public final void a(boolean z) {
        com.baidu.tieba.util.cb.a(this.a, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.a.n();
    }
}
