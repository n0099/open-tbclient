package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.a aVar2;
        aa aaVar;
        if (((com.baidu.tieba.view.q) view).a()) {
            aVar = this.a.aa;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.a.aa;
                Bitmap a = aVar2.a((String) view.getTag(), new x(this));
                if (a == null) {
                    aaVar = this.a.y;
                    Bitmap c = aaVar.a().c(String.valueOf((String) view.getTag()) + "_small");
                    if (c == null) {
                        return;
                    }
                    this.a.a(c, true);
                    return;
                }
                this.a.a(a, false);
            }
        }
    }
}
