package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am implements View.OnClickListener {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.a = alVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        int intValue = ((Integer) view.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof g) {
            g gVar = (g) item;
            int x = gVar.x();
            if (x == 0) {
                context3 = this.a.a;
                if (context3 instanceof FrsActivity) {
                    context4 = this.a.a;
                    ((FrsActivity) context4).b((g) item, intValue);
                }
            } else if (x == 2) {
                context = this.a.a;
                if (context instanceof FrsActivity) {
                    context2 = this.a.a;
                    ((FrsActivity) context2).a(gVar);
                }
            }
        }
    }
}
