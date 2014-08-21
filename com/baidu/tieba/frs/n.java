package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        cv cvVar;
        cv cvVar2;
        String str;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            cvVar = this.a.B;
            long itemId = cvVar.v().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.t;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.t;
                    frsActivity.t = i4 - 1;
                    this.a.c(2);
                }
            } else if (itemId != -2) {
                cvVar2 = this.a.B;
                com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) cvVar2.v().getItem(i);
                if (nVar != null) {
                    if (nVar instanceof com.baidu.tbadk.core.data.a) {
                        com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) nVar;
                        this.a.a(aVar, "area_click");
                        this.a.b(aVar, "click");
                        int i5 = aVar.a;
                        if (i5 == 0) {
                            this.a.a(aVar, i);
                        } else if (i5 == 2) {
                            this.a.a(aVar);
                        }
                        TiebaStatic.eventStat(this.a, "frs_ck_app", null, 1, "app_name", aVar.g);
                    } else if (!(nVar instanceof com.baidu.tieba.data.ag)) {
                        com.baidu.tieba.util.p B = com.baidu.tieba.ai.c().B();
                        if (B != null && !B.b(nVar.h())) {
                            B.a(nVar.h());
                        }
                        boolean z = false;
                        String t = nVar.t();
                        if (t != null && !t.equals("")) {
                            z = true;
                            new Thread(new o(this, t)).start();
                        }
                        String i6 = nVar.i();
                        if (i6 == null) {
                            i6 = "";
                        }
                        if (nVar.m() == 2 && !i6.startsWith("pb:")) {
                            com.baidu.tbadk.core.util.bg a = com.baidu.tbadk.core.util.bg.a();
                            FrsActivity frsActivity2 = this.a;
                            String[] strArr = new String[3];
                            strArr[0] = i6;
                            strArr[1] = "";
                            a.a(frsActivity2, strArr);
                            return;
                        }
                        if (i6.startsWith("pb:")) {
                            nVar.a(i6.substring(3));
                        }
                        FrsActivity frsActivity3 = this.a;
                        com.baidu.tbadk.core.atomData.bc bcVar = new com.baidu.tbadk.core.atomData.bc(this.a);
                        str = this.a.q;
                        frsActivity3.sendMessage(new CustomMessage(2004001, bcVar.a(nVar, str, null, 18003, true, false, z)));
                    }
                }
            } else {
                TiebaStatic.eventStat(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity frsActivity4 = this.a;
                i2 = frsActivity4.t;
                frsActivity4.t = i2 + 1;
                this.a.c(1);
            }
        }
    }
}
