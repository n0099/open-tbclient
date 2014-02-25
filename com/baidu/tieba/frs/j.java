package com.baidu.tieba.frs;

import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        cb.a(this.a, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.a.C();
    }
}
