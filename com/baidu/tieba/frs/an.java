package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class an implements com.baidu.adp.widget.ScrollView.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsImageActivity frsImageActivity) {
        this.f1257a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.o
    public void a() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1257a, "frs_pulldown", "frsclick", 1);
        }
        this.f1257a.s = null;
        this.f1257a.r = true;
        this.f1257a.f(1);
    }
}
