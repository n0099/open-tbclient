package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ct ctVar;
        ct ctVar2;
        com.baidu.tbadk.core.data.m mVar;
        com.baidu.tbadk.core.data.m mVar2;
        com.baidu.tbadk.core.data.m mVar3;
        com.baidu.tbadk.core.data.m mVar4;
        com.baidu.tbadk.core.data.m mVar5;
        ct ctVar3;
        com.baidu.tbadk.core.data.m mVar6;
        if (i >= 0) {
            ctVar = this.a.v;
            long itemId = ctVar.u().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                ctVar2 = this.a.v;
                frsActivity.P = (com.baidu.tbadk.core.data.m) ctVar2.u().getItem(i);
                mVar = this.a.P;
                if (mVar instanceof com.baidu.tbadk.core.data.b) {
                    mVar6 = this.a.P;
                    com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) mVar6;
                    int k = bVar.k();
                    if (k == 0) {
                        this.a.a(bVar, i);
                    } else if (k == 2) {
                        com.baidu.tbadk.i.a().b(bVar.i(), System.currentTimeMillis());
                        this.a.a(bVar);
                    }
                    TiebaStatic.eventStat(this.a, "frs_tb_arc", "");
                } else {
                    mVar2 = this.a.P;
                    if (!(mVar2 instanceof com.baidu.tieba.data.af)) {
                        FrsActivity frsActivity2 = this.a;
                        mVar3 = this.a.P;
                        frsActivity2.t = mVar3.p();
                        mVar4 = this.a.P;
                        String B = mVar4.B();
                        if (B == null || B.equals("")) {
                            this.a.u = false;
                        } else {
                            this.a.u = true;
                        }
                        FrsActivity frsActivity3 = this.a;
                        mVar5 = this.a.P;
                        frsActivity3.b(mVar5);
                        ctVar3 = this.a.v;
                        ctVar3.r();
                    }
                }
            }
        }
        return false;
    }
}
