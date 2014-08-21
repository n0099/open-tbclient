package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cv cvVar;
        int intValue = ((Integer) view.getTag()).intValue();
        cvVar = this.a.B;
        Object item = cvVar.v().getItem(intValue);
        if (item instanceof com.baidu.tbadk.core.data.a) {
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) item;
            if (aVar.c()) {
                this.a.a(aVar, "btn_click");
                this.a.b(aVar, "click");
                com.baidu.tbadk.core.util.bg.a().a(this.a, new String[]{aVar.e});
            }
        }
    }
}
