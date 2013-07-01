package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f855a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.f855a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.a aVar;
        com.baidu.tieba.util.a aVar2;
        az azVar;
        if (((com.baidu.tieba.view.o) view).a()) {
            aVar = this.f855a.J;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.f855a.J;
                com.baidu.adp.widget.a.b a2 = aVar2.a((String) view.getTag(), new d(this));
                if (a2 == null) {
                    azVar = this.f855a.l;
                    com.baidu.adp.widget.a.b c = azVar.g().a().c(String.valueOf((String) view.getTag()) + "_small");
                    if (c != null) {
                        this.f855a.a(c, true);
                        return;
                    }
                    return;
                }
                this.f855a.a(a2, false);
            }
        }
    }
}
