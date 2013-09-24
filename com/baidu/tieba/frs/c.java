package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.f1144a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.a aVar;
        com.baidu.tieba.util.a aVar2;
        ba baVar;
        if (((com.baidu.tieba.view.aa) view).c()) {
            aVar = this.f1144a.M;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.f1144a.M;
                com.baidu.adp.widget.a.c a2 = aVar2.a((String) view.getTag(), new d(this));
                if (a2 == null) {
                    baVar = this.f1144a.o;
                    com.baidu.adp.widget.a.c d = baVar.g().a().d(String.valueOf((String) view.getTag()) + "_small");
                    if (d != null) {
                        this.f1144a.a(d, true);
                        return;
                    }
                    return;
                }
                this.f1144a.a(a2, false);
            }
        }
    }
}
