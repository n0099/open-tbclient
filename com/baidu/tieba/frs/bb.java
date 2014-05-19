package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        int intValue = ((Integer) view.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) item;
            int g = bVar.g();
            if (g == 0) {
                context3 = this.a.a;
                if (context3 instanceof FrsActivity) {
                    context4 = this.a.a;
                    ((FrsActivity) context4).b((com.baidu.tbadk.core.data.b) item, intValue);
                }
            } else if (g == 2) {
                context = this.a.a;
                if (context instanceof FrsActivity) {
                    context2 = this.a.a;
                    ((FrsActivity) context2).a(bVar);
                }
            }
        }
    }
}
