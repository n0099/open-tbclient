package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class by implements com.baidu.adp.widget.ScrollView.m {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.m
    public void a() {
        TiebaStatic.eventStat(this.a, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.a.t = null;
        this.a.s = true;
        this.a.c(1);
    }
}
