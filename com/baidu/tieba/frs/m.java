package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ct ctVar;
        ct ctVar2;
        String str;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            ctVar = this.a.w;
            long itemId = ctVar.v().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.q;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.q;
                    frsActivity.q = i4 - 1;
                    this.a.m = 2;
                    this.a.F();
                }
            } else if (itemId != -2) {
                ctVar2 = this.a.w;
                com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) ctVar2.v().getItem(i);
                if (nVar != null) {
                    if (nVar instanceof com.baidu.tbadk.core.data.b) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) nVar;
                        int k = bVar.k();
                        if (k == 0) {
                            this.a.a(bVar, i);
                        } else if (k == 2) {
                            this.a.a(bVar);
                        }
                        new com.baidu.tbadk.core.util.bb("", "frs_ck", bVar.g()).start();
                        TiebaStatic.eventStat(this.a, "frs_tb_arc", "");
                        return;
                    }
                    com.baidu.tieba.util.p C = com.baidu.tieba.ai.c().C();
                    if (C != null && !C.b(nVar.p())) {
                        C.a(nVar.p());
                    }
                    boolean z = false;
                    String B = nVar.B();
                    if (B != null && !B.equals("")) {
                        z = true;
                        new Thread(new n(this, B)).start();
                    }
                    String q = nVar.q();
                    if (nVar.u() == 2 && !q.startsWith("pb:")) {
                        com.baidu.tbadk.core.util.bk a = com.baidu.tbadk.core.util.bk.a();
                        FrsActivity frsActivity2 = this.a;
                        String[] strArr = new String[3];
                        strArr[0] = q;
                        strArr[1] = "";
                        a.a(frsActivity2, strArr);
                        return;
                    }
                    if (q.startsWith("pb:")) {
                        nVar.a(q.substring(3));
                    }
                    FrsActivity frsActivity3 = this.a;
                    com.baidu.tbadk.core.atomData.ar arVar = new com.baidu.tbadk.core.atomData.ar(this.a);
                    str = this.a.n;
                    frsActivity3.sendMessage(new CustomMessage(2006001, arVar.a(nVar, str, null, 18003, true, false, z)));
                }
            } else {
                TiebaStatic.eventStat(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity frsActivity4 = this.a;
                i2 = frsActivity4.q;
                frsActivity4.q = i2 + 1;
                this.a.m = 1;
                this.a.F();
            }
        }
    }
}
