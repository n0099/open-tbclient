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
        az azVar;
        az azVar2;
        boolean z;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            azVar = this.a.m;
            long itemId = azVar.g().getItemId(i);
            if (itemId == -1) {
                i3 = this.a.g;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.a;
                    i4 = frsActivity.g;
                    frsActivity.g = i4 - 1;
                    this.a.c = 2;
                    this.a.z();
                }
            } else if (itemId != -2) {
                azVar2 = this.a.m;
                com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) azVar2.g().getItem(i);
                if (baVar != null) {
                    com.baidu.tieba.util.w ay = TiebaApplication.f().ay();
                    if (ay != null && !ay.b(baVar.a())) {
                        ay.a(baVar.a());
                    }
                    String i5 = baVar.i();
                    if (i5 == null || i5.equals("")) {
                        z = false;
                    } else {
                        new Thread(new x(this, i5)).start();
                        z = true;
                    }
                    NewPbActivity.a(this.a, baVar, null, 1800003, true, false, z);
                }
            } else {
                if (TiebaApplication.f().s()) {
                    StatService.onEvent(this.a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity frsActivity2 = this.a;
                i2 = frsActivity2.g;
                frsActivity2.g = i2 + 1;
                this.a.c = 1;
                this.a.z();
            }
        }
    }
}
