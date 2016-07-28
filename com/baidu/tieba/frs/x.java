package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.b;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bqVar = this.bEL.bDK;
        com.baidu.adp.widget.ListView.v aw = bqVar.WN().aw(intValue);
        if (aw instanceof b) {
            b bVar = (b) aw;
            if (!bVar.om()) {
                return;
            }
            this.bEL.b(bVar);
        }
    }
}
