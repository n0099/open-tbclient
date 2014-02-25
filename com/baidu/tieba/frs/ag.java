package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        br brVar;
        br brVar2;
        boolean z;
        String str;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            brVar = this.a.p;
            long itemId = brVar.n().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.j;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.j;
                    frsActivity.j = i4 - 1;
                    this.a.f = 2;
                    this.a.D();
                }
            } else if (itemId != -2) {
                brVar2 = this.a.p;
                com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) brVar2.n().getItem(i);
                if (azVar != null) {
                    if (azVar instanceof g) {
                        g gVar = (g) azVar;
                        int A = gVar.A();
                        if (A == 0) {
                            this.a.a(gVar, i);
                            return;
                        } else if (A == 2) {
                            this.a.a(gVar);
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tieba.util.bo at = TiebaApplication.g().at();
                    if (at != null && !at.b(azVar.a())) {
                        at.a(azVar.a());
                    }
                    String l = azVar.l();
                    if (l == null || l.equals("")) {
                        z = false;
                    } else {
                        new Thread(new ah(this, l)).start();
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
                cb.a(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity frsActivity3 = this.a;
                i2 = frsActivity3.j;
                frsActivity3.j = i2 + 1;
                this.a.f = 1;
                this.a.D();
            }
        }
    }
}
