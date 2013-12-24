package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bn bnVar;
        bn bnVar2;
        boolean z;
        String str;
        int i2;
        if (i >= 0) {
            bnVar = this.a.n;
            long itemId = bnVar.m().getItemId(i);
            if (itemId == -1) {
                i2 = this.a.i;
                if (i2 > 1) {
                    FrsActivity.i(this.a);
                    this.a.e = 2;
                    this.a.B();
                }
            } else if (itemId != -2) {
                bnVar2 = this.a.n;
                com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) bnVar2.m().getItem(i);
                if (azVar != null) {
                    com.baidu.tieba.util.ba aw = TiebaApplication.h().aw();
                    if (aw != null && !aw.b(azVar.a())) {
                        aw.a(azVar.a());
                    }
                    String l = azVar.l();
                    if (l == null || l.equals("")) {
                        z = false;
                    } else {
                        new Thread(new k(this, l)).start();
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
                    FrsActivity frsActivity = this.a;
                    str = this.a.f;
                    NewPbActivity.a(frsActivity, azVar, str, null, 18003, true, false, z);
                }
            } else {
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity.x(this.a);
                this.a.e = 1;
                this.a.B();
            }
        }
    }
}
