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
    final /* synthetic */ FrsActivity f1354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.f1354a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bn bnVar;
        bn bnVar2;
        boolean z;
        String str;
        int i2;
        if (i >= 0) {
            bnVar = this.f1354a.n;
            long itemId = bnVar.l().getItemId(i);
            if (itemId == -1) {
                i2 = this.f1354a.i;
                if (i2 > 1) {
                    FrsActivity.i(this.f1354a);
                    this.f1354a.e = 2;
                    this.f1354a.B();
                }
            } else if (itemId != -2) {
                bnVar2 = this.f1354a.n;
                com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) bnVar2.l().getItem(i);
                if (baVar != null) {
                    com.baidu.tieba.util.bc aw = TiebaApplication.g().aw();
                    if (aw != null && !aw.b(baVar.a())) {
                        aw.a(baVar.a());
                    }
                    String l = baVar.l();
                    if (l == null || l.equals("")) {
                        z = false;
                    } else {
                        new Thread(new k(this, l)).start();
                        z = true;
                    }
                    String b = baVar.b();
                    if (baVar.f() == 2 && !b.startsWith("pb:")) {
                        UtilHelper.a(this.f1354a, b, "", null);
                        return;
                    }
                    if (b.startsWith("pb:")) {
                        baVar.a(b.substring(3));
                    }
                    FrsActivity frsActivity = this.f1354a;
                    str = this.f1354a.f;
                    NewPbActivity.a(frsActivity, baVar, str, null, 18003, true, false, z);
                }
            } else {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1354a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity.x(this.f1354a);
                this.f1354a.e = 1;
                this.f1354a.B();
            }
        }
    }
}
