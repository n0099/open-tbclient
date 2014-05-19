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
        cs csVar;
        cs csVar2;
        String str;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            csVar = this.a.w;
            long itemId = csVar.v().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.q;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.q;
                    frsActivity.q = i4 - 1;
                    this.a.m = 2;
                    this.a.E();
                }
            } else if (itemId != -2) {
                csVar2 = this.a.w;
                com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) csVar2.v().getItem(i);
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
                    com.baidu.tieba.util.p C = com.baidu.tieba.ad.c().C();
                    if (C != null && !C.b(oVar.k())) {
                        C.a(oVar.k());
                    }
                    boolean z = false;
                    String w = oVar.w();
                    if (w != null && !w.equals("")) {
                        z = true;
                        new Thread(new o(this, w)).start();
                    }
                    String l = oVar.l();
                    if (oVar.p() == 2 && !l.startsWith("pb:")) {
                        com.baidu.tbadk.core.util.bi a = com.baidu.tbadk.core.util.bi.a();
                        FrsActivity frsActivity2 = this.a;
                        String[] strArr = new String[3];
                        strArr[0] = l;
                        strArr[1] = "";
                        a.a(frsActivity2, strArr);
                        return;
                    }
                    if (l.startsWith("pb:")) {
                        oVar.a(l.substring(3));
                    }
                    FrsActivity frsActivity3 = this.a;
                    com.baidu.tbadk.core.atomData.as asVar = new com.baidu.tbadk.core.atomData.as(this.a);
                    str = this.a.n;
                    frsActivity3.sendMessage(new CustomMessage(2006001, asVar.a(oVar, str, null, 18003, true, false, z)));
                }
            } else {
                TiebaStatic.eventStat(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity frsActivity4 = this.a;
                i2 = frsActivity4.q;
                frsActivity4.q = i2 + 1;
                this.a.m = 1;
                this.a.E();
            }
        }
    }
}
