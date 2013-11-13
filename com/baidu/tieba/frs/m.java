package com.baidu.tieba.frs;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class m implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.f1357a = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1357a, "frs_pulldown", "frsclick", 1);
        }
        this.f1357a.A();
    }
}
