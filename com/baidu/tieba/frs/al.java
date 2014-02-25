package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        int intValue = ((Integer) view.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof g) {
            g gVar = (g) item;
            int A = gVar.A();
            if (A == 0) {
                context3 = this.a.a;
                if (context3 instanceof FrsActivity) {
                    context4 = this.a.a;
                    ((FrsActivity) context4).b((g) item, intValue);
                }
            } else if (A == 2) {
                context = this.a.a;
                if (context instanceof FrsActivity) {
                    context2 = this.a.a;
                    ((FrsActivity) context2).a(gVar);
                }
            }
        }
    }
}
