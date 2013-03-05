package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.at;
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
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        lVar = this.a.M;
        if (lVar != null) {
            i--;
        }
        if (i >= 0) {
            aaVar = this.a.y;
            long itemId = aaVar.getItemId(i);
            if (itemId == -1) {
                i3 = this.a.m;
                if (i3 <= 1) {
                    this.a.f = 4;
                    return;
                }
                FrsActivity frsActivity = this.a;
                i4 = frsActivity.m;
                frsActivity.m = i4 - 1;
                this.a.f = 2;
                this.a.w();
            } else if (itemId == -2) {
                FrsActivity frsActivity2 = this.a;
                i2 = frsActivity2.m;
                frsActivity2.m = i2 + 1;
                this.a.f = 1;
                this.a.w();
            } else if (itemId != -3) {
                aaVar2 = this.a.y;
                at atVar = (at) aaVar2.getItem(i);
                if (atVar != null) {
                    com.baidu.tieba.c.ab am = TiebaApplication.b().am();
                    if (am != null && !am.b(atVar.a())) {
                        am.a(atVar.a());
                    }
                    aaVar3 = this.a.y;
                    aaVar3.notifyDataSetChanged();
                    String k = atVar.k();
                    if (k == null || k.equals("")) {
                        z = false;
                    } else {
                        new Thread(new g(this, k)).start();
                    }
                    PbActivity.a(this.a, atVar.a(), "tb_frslist", z);
                }
            }
        }
    }
}
