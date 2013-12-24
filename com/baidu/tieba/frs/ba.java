package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ScrollView.n {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.a, "frs_pulldown", "frsclick", 1);
        }
        this.a.r = null;
        this.a.q = true;
        this.a.c(1);
    }
}
