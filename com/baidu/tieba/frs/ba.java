package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FrsImageActivity frsImageActivity) {
        this.f1332a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1332a, "frs_pulldown", "frsclick", 1);
        }
        this.f1332a.r = null;
        this.f1332a.q = true;
        this.f1332a.c(1);
    }
}
