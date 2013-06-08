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
        com.baidu.tieba.d.a aVar;
        com.baidu.tieba.d.a aVar2;
        ba baVar;
        if (((com.baidu.tieba.view.q) view).a()) {
            aVar = this.a.J;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.a.J;
                com.baidu.adp.widget.a.b a = aVar2.a((String) view.getTag(), new d(this));
                if (a == null) {
                    baVar = this.a.l;
                    com.baidu.adp.widget.a.b c = baVar.g().a().c(String.valueOf((String) view.getTag()) + "_small");
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
