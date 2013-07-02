package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class z implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.a, "frs_pulldown", "frsclick", 1);
        }
        this.a.y();
    }
}
