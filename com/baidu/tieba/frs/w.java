package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ba baVar;
        ba baVar2;
        boolean z;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            baVar = this.a.l;
            long itemId = baVar.g().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.h;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.h;
                    frsActivity.h = i4 - 1;
                    this.a.d = 2;
                    this.a.z();
                }
            } else if (itemId != -2) {
                baVar2 = this.a.l;
                com.baidu.tieba.a.bc bcVar = (com.baidu.tieba.a.bc) baVar2.g().getItem(i);
                if (bcVar != null) {
                    com.baidu.tieba.d.ab az = TiebaApplication.e().az();
                    if (az != null && !az.b(bcVar.a())) {
                        az.a(bcVar.a());
                    }
                    String i5 = bcVar.i();
                    if (i5 == null || i5.equals("")) {
                        z = false;
                    } else {
                        new Thread(new x(this, i5)).start();
                        z = true;
                    }
                    NewPbActivity.a(this.a, bcVar, null, 1800003, true, false, z);
                }
            } else {
                if (TiebaApplication.e().p()) {
                    StatService.onEvent(this.a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity frsActivity2 = this.a;
                i2 = frsActivity2.h;
                frsActivity2.h = i2 + 1;
                this.a.d = 1;
                this.a.z();
            }
        }
    }
}
