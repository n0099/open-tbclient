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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.f1359a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bn bnVar;
        bn bnVar2;
        boolean z;
        String str;
        int i2;
        if (i >= 0) {
            bnVar = this.f1359a.n;
            long itemId = bnVar.l().getItemId(i);
            if (itemId == -1) {
                i2 = this.f1359a.i;
                if (i2 > 1) {
                    FrsActivity.i(this.f1359a);
                    this.f1359a.e = 2;
                    this.f1359a.B();
                }
            } else if (itemId != -2) {
                bnVar2 = this.f1359a.n;
                com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) bnVar2.l().getItem(i);
                if (azVar != null) {
                    com.baidu.tieba.util.bc aw = TiebaApplication.g().aw();
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
                        UtilHelper.a(this.f1359a, b, "", null);
                        return;
                    }
                    if (b.startsWith("pb:")) {
                        azVar.a(b.substring(3));
                    }
                    FrsActivity frsActivity = this.f1359a;
                    str = this.f1359a.f;
                    NewPbActivity.a(frsActivity, azVar, str, null, 18003, true, false, z);
                }
            } else {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1359a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity.x(this.f1359a);
                this.f1359a.e = 1;
                this.f1359a.B();
            }
        }
    }
}
