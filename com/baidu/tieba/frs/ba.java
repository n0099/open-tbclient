package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.a = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        int intValue = ((Integer) view.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) item;
            com.baidu.tbadk.f.a().b(bVar.i(), System.currentTimeMillis());
            int k = bVar.k();
            if (k == 0) {
                context4 = this.a.b;
                if (context4 instanceof FrsActivity) {
                    context5 = this.a.b;
                    ((FrsActivity) context5).b((com.baidu.tbadk.core.data.b) item, intValue);
                }
            } else if (k == 2) {
                context = this.a.b;
                if (context instanceof FrsActivity) {
                    context2 = this.a.b;
                    ((FrsActivity) context2).a(bVar);
                }
            }
            context3 = this.a.b;
            TiebaStatic.eventStat(context3, "frs_tb_btc", "");
        }
    }
}
