package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        cm cmVar;
        cm cmVar2;
        String str;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            cmVar = this.a.r;
            long itemId = cmVar.t().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.l;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.l;
                    frsActivity.l = i4 - 1;
                    this.a.h = 2;
                    this.a.o();
                }
            } else if (itemId != -2) {
                cmVar2 = this.a.r;
                com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) cmVar2.t().getItem(i);
                if (oVar != null) {
                    if (oVar instanceof com.baidu.tbadk.core.data.b) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) oVar;
                        int g = bVar.g();
                        if (g == 0) {
                            this.a.a(bVar, i);
                            return;
                        } else if (g == 2) {
                            this.a.a(bVar);
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tieba.util.p C = com.baidu.tieba.r.c().C();
                    if (C != null && !C.b(oVar.l())) {
                        C.a(oVar.l());
                    }
                    boolean z = false;
                    String v = oVar.v();
                    if (v != null && !v.equals("")) {
                        z = true;
                        new Thread(new o(this, v)).start();
                    }
                    String m = oVar.m();
                    if (oVar.q() == 2 && !m.startsWith("pb:")) {
                        com.baidu.tbadk.core.util.bg a = com.baidu.tbadk.core.util.bg.a();
                        FrsActivity frsActivity2 = this.a;
                        String[] strArr = new String[3];
                        strArr[0] = m;
                        strArr[1] = "";
                        a.a(frsActivity2, strArr);
                        return;
                    }
                    if (m.startsWith("pb:")) {
                        oVar.a(m.substring(3));
                    }
                    FrsActivity frsActivity3 = this.a;
                    com.baidu.tbadk.core.b.af afVar = new com.baidu.tbadk.core.b.af(this.a);
                    str = this.a.i;
                    frsActivity3.sendMessage(new com.baidu.adp.framework.message.a(2004001, afVar.a(oVar, str, null, 18003, true, false, z)));
                }
            } else {
                TiebaStatic.a(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity frsActivity4 = this.a;
                i2 = frsActivity4.l;
                frsActivity4.l = i2 + 1;
                this.a.h = 1;
                this.a.o();
            }
        }
    }
}
