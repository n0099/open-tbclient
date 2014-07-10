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
            ctVar = this.a.v;
            long itemId = ctVar.u().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.p;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.p;
                    frsActivity.p = i4 - 1;
                    this.a.l = 2;
                    this.a.F();
                }
            } else if (itemId != -2) {
                ctVar2 = this.a.v;
                com.baidu.tbadk.core.data.m mVar = (com.baidu.tbadk.core.data.m) ctVar2.u().getItem(i);
                if (mVar != null) {
                    if (mVar instanceof com.baidu.tbadk.core.data.b) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) mVar;
                        int k = bVar.k();
                        if (k == 0) {
                            this.a.a(bVar, i);
                        } else if (k == 2) {
                            com.baidu.tbadk.i.a().b(bVar.i(), System.currentTimeMillis());
                            this.a.a(bVar);
                        }
                        TiebaStatic.eventStat(this.a, "frs_ck_app", null, 1, "app_name", bVar.g());
                    } else if (!(mVar instanceof com.baidu.tieba.data.af)) {
                        com.baidu.tieba.util.p C = com.baidu.tieba.ai.c().C();
                        if (C != null && !C.b(mVar.p())) {
                            C.a(mVar.p());
                        }
                        boolean z = false;
                        String B = mVar.B();
                        if (B != null && !B.equals("")) {
                            z = true;
                            new Thread(new n(this, B)).start();
                        }
                        String q = mVar.q();
                        if (q == null) {
                            q = "";
                        }
                        if (mVar.u() == 2 && !q.startsWith("pb:")) {
                            com.baidu.tbadk.core.util.bq a = com.baidu.tbadk.core.util.bq.a();
                            FrsActivity frsActivity2 = this.a;
                            String[] strArr = new String[3];
                            strArr[0] = q;
                            strArr[1] = "";
                            a.a(frsActivity2, strArr);
                            return;
                        }
                        if (q.startsWith("pb:")) {
                            mVar.a(q.substring(3));
                        }
                        FrsActivity frsActivity3 = this.a;
                        com.baidu.tbadk.core.atomData.aw awVar = new com.baidu.tbadk.core.atomData.aw(this.a);
                        str = this.a.m;
                        frsActivity3.sendMessage(new CustomMessage(2004001, awVar.a(mVar, str, null, 18003, true, false, z)));
                    }
                }
            } else {
                TiebaStatic.eventStat(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity frsActivity4 = this.a;
                i2 = frsActivity4.p;
                frsActivity4.p = i2 + 1;
                this.a.l = 1;
                this.a.F();
            }
        }
    }
}
