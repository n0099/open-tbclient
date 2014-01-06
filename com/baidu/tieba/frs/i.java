package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bo boVar;
        bo boVar2;
        boolean z;
        String str;
        int i2;
        if (i >= 0) {
            boVar = this.a.n;
            long itemId = boVar.n().getItemId(i);
            if (itemId == -1) {
                i2 = this.a.i;
                if (i2 > 1) {
                    FrsActivity.i(this.a);
                    this.a.e = 2;
                    this.a.C();
                }
            } else if (itemId != -2) {
                boVar2 = this.a.n;
                com.baidu.tieba.data.bb bbVar = (com.baidu.tieba.data.bb) boVar2.n().getItem(i);
                if (bbVar != null) {
                    com.baidu.tieba.util.bk aw = TiebaApplication.g().aw();
                    if (aw != null && !aw.b(bbVar.a())) {
                        aw.a(bbVar.a());
                    }
                    String l = bbVar.l();
                    if (l == null || l.equals("")) {
                        z = false;
                    } else {
                        new Thread(new j(this, l)).start();
                        z = true;
                    }
                    String b = bbVar.b();
                    if (bbVar.f() == 2 && !b.startsWith("pb:")) {
                        UtilHelper.a(this.a, b, "", null);
                        return;
                    }
                    if (b.startsWith("pb:")) {
                        bbVar.a(b.substring(3));
                    }
                    FrsActivity frsActivity = this.a;
                    str = this.a.f;
                    NewPbActivity.a(frsActivity, bbVar, str, null, 18003, true, false, z);
                }
            } else {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity.w(this.a);
                this.a.e = 1;
                this.a.C();
            }
        }
    }
}
