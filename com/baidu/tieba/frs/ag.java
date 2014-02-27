package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bs bsVar;
        bs bsVar2;
        boolean z;
        String str;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            bsVar = this.a.p;
            long itemId = bsVar.m().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.j;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.j;
                    frsActivity.j = i4 - 1;
                    this.a.f = 2;
                    this.a.o();
                }
            } else if (itemId != -2) {
                bsVar2 = this.a.p;
                com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) bsVar2.m().getItem(i);
                if (azVar != null) {
                    if (azVar instanceof g) {
                        g gVar = (g) azVar;
                        int x = gVar.x();
                        if (x == 0) {
                            this.a.a(gVar, i);
                            return;
                        } else if (x == 2) {
                            this.a.a(gVar);
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tieba.util.bo am = TiebaApplication.g().am();
                    if (am != null && !am.b(azVar.a())) {
                        am.a(azVar.a());
                    }
                    String j2 = azVar.j();
                    if (j2 == null || j2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new ah(this, j2)).start();
                        z = true;
                    }
                    String b = azVar.b();
                    if (azVar.f() == 2 && !b.startsWith("pb:")) {
                        UtilHelper.a(this.a, b, "", null);
                        return;
                    }
                    if (b.startsWith("pb:")) {
                        azVar.a(b.substring(3));
                    }
                    FrsActivity frsActivity2 = this.a;
                    str = this.a.g;
                    NewPbActivity.a(frsActivity2, azVar, str, null, 18003, true, false, z);
                }
            } else {
                com.baidu.tieba.util.cb.a(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity frsActivity3 = this.a;
                i2 = frsActivity3.j;
                frsActivity3.j = i2 + 1;
                this.a.f = 1;
                this.a.o();
            }
        }
    }
}
