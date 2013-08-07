package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class av implements com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsImageActivity frsImageActivity) {
        this.f1070a = frsImageActivity;
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f1070a, "frs_pulldown", "frsclick", 1);
        }
        this.f1070a.t = null;
        this.f1070a.s = true;
        this.f1070a.f(1);
    }
}
