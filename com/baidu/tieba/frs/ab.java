package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.f1066a = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1066a, "frs_pulldown", "frsclick", 1);
        }
        this.f1066a.A();
    }
}
