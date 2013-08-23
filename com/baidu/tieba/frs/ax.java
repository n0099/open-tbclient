package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ax implements com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsImageActivity frsImageActivity) {
        this.f1086a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1086a, "frs_pulldown", "frsclick", 1);
        }
        this.f1086a.t = null;
        this.f1086a.s = true;
        this.f1086a.f(1);
    }
}
