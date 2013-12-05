package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FrsImageActivity frsImageActivity) {
        this.f1383a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.f1383a, "frs_pulldown", "frsclick", 1);
        }
        this.f1383a.r = null;
        this.f1383a.q = true;
        this.f1383a.c(1);
    }
}
