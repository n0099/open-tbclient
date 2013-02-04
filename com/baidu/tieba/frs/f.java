package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.as;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.view.l lVar;
        ab abVar;
        ab abVar2;
        ab abVar3;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        lVar = this.a.K;
        if (lVar != null) {
            i--;
        }
        if (i < 0) {
            return;
        }
        abVar = this.a.w;
        long itemId = abVar.getItemId(i);
        if (itemId == -1) {
            i3 = this.a.l;
            if (i3 <= 1) {
                this.a.e = 4;
                return;
            }
            FrsActivity frsActivity = this.a;
            i4 = frsActivity.l;
            frsActivity.l = i4 - 1;
            this.a.e = 2;
            this.a.v();
        } else if (itemId == -2) {
            FrsActivity frsActivity2 = this.a;
            i2 = frsActivity2.l;
            frsActivity2.l = i2 + 1;
            this.a.e = 1;
            this.a.v();
        } else if (itemId != -3) {
            abVar2 = this.a.w;
            as asVar = (as) abVar2.getItem(i);
            if (asVar != null) {
                com.baidu.tieba.c.aa ai = TiebaApplication.a().ai();
                if (ai != null && !ai.b(asVar.a())) {
                    ai.a(asVar.a());
                }
                abVar3 = this.a.w;
                abVar3.notifyDataSetChanged();
                String k = asVar.k();
                if (k == null || k.equals("")) {
                    z = false;
                } else {
                    new Thread(new g(this, k)).start();
                }
                PbActivity.a(this.a, asVar.a(), "tb_frslist", z);
            }
        }
    }
}
