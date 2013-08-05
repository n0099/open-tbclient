package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class av implements com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1072a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsImageActivity frsImageActivity) {
        this.f1072a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f1072a, "frs_pulldown", "frsclick", 1);
        }
        this.f1072a.t = null;
        this.f1072a.s = true;
        this.f1072a.f(1);
    }
}
