package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.b;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bqVar = this.bDB.bCD;
        com.baidu.adp.widget.ListView.v at = bqVar.Ww().at(intValue);
        if (at instanceof b) {
            b bVar = (b) at;
            if (!bVar.ox()) {
                return;
            }
            this.bDB.b(bVar);
        }
    }
}
