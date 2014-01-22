package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bk bkVar;
        bk bkVar2;
        boolean z;
        String str;
        int i2;
        if (i >= 0) {
            bkVar = this.a.n;
            long itemId = bkVar.n().getItemId(i);
            if (itemId == -1) {
                i2 = this.a.i;
                if (i2 > 1) {
                    FrsActivity.j(this.a);
                    this.a.e = 2;
                    this.a.A();
                }
            } else if (itemId != -2) {
                bkVar2 = this.a.n;
                com.baidu.tieba.data.bb bbVar = (com.baidu.tieba.data.bb) bkVar2.n().getItem(i);
                if (bbVar != null) {
                    com.baidu.tieba.util.bq au = TiebaApplication.h().au();
                    if (au != null && !au.b(bbVar.a())) {
                        au.a(bbVar.a());
                    }
                    String l = bbVar.l();
                    if (l == null || l.equals("")) {
                        z = false;
                    } else {
                        new Thread(new h(this, l)).start();
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
                by.a(this.a, "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsActivity.w(this.a);
                this.a.e = 1;
                this.a.A();
            }
        }
    }
}
