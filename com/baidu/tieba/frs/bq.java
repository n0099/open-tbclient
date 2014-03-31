package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class bq implements com.baidu.adp.widget.ScrollView.m {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.m
    public final void a() {
        TiebaStatic.a(this.a, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.a.q = null;
        this.a.p = true;
        this.a.b(1);
    }
}
