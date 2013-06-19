package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class av implements com.baidu.adp.widget.ScrollView.o {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.o
    public void a() {
        if (TiebaApplication.e().p()) {
            StatService.onEvent(this.a, "frs_pulldown", "frsclick", 1);
        }
        this.a.t = null;
        this.a.s = true;
        this.a.e(1);
    }
}
