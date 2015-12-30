package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u au = this.bed.bdm.Of().au(((Integer) view.getTag()).intValue());
        if (au instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) au;
            if (!bVar.rm()) {
                return;
            }
            this.bed.b(bVar);
        }
    }
}
