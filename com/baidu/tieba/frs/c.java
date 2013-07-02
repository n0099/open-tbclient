package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.a aVar;
        com.baidu.tieba.util.a aVar2;
        az azVar;
        if (((com.baidu.tieba.view.o) view).a()) {
            aVar = this.a.J;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.a.J;
                com.baidu.adp.widget.a.b a = aVar2.a((String) view.getTag(), new d(this));
                if (a == null) {
                    azVar = this.a.l;
                    com.baidu.adp.widget.a.b c = azVar.g().a().c(String.valueOf((String) view.getTag()) + "_small");
                    if (c != null) {
                        this.a.a(c, true);
                        return;
                    }
                    return;
                }
                this.a.a(a, false);
            }
        }
    }
}
