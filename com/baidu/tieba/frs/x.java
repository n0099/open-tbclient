package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.a aVar2;
        ab abVar;
        if (((com.baidu.tieba.view.q) view).a()) {
            aVar = this.a.Y;
            aVar.b();
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                return;
            }
            aVar2 = this.a.Y;
            Bitmap a = aVar2.a((String) view.getTag(), new y(this));
            if (a != null) {
                this.a.a(a, false);
                return;
            }
            abVar = this.a.w;
            Bitmap c = abVar.a().c(String.valueOf((String) view.getTag()) + "_small");
            if (c != null) {
                this.a.a(c, true);
            }
        }
    }
}
