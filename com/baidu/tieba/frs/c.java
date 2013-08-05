package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.f1079a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.a aVar;
        com.baidu.tieba.util.a aVar2;
        az azVar;
        if (((com.baidu.tieba.view.r) view).a()) {
            aVar = this.f1079a.J;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.f1079a.J;
                com.baidu.adp.widget.a.b a2 = aVar2.a((String) view.getTag(), new d(this));
                if (a2 == null) {
                    azVar = this.f1079a.l;
                    com.baidu.adp.widget.a.b d = azVar.g().a().d(String.valueOf((String) view.getTag()) + "_small");
                    if (d != null) {
                        this.f1079a.a(d, true);
                        return;
                    }
                    return;
                }
                this.f1079a.a(a2, false);
            }
        }
    }
}
