package com.baidu.tieba.frs;

import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
class aw implements com.baidu.adp.widget.ScrollView.m {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.m
    public void a() {
        cb.a(this.a, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.a.q = null;
        this.a.p = true;
        this.a.c(1);
    }
}
