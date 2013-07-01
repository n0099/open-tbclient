package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.f875a = frsActivity;
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
            azVar = this.f875a.l;
            long itemId = azVar.g().getItemId(i);
            if (itemId == -1) {
                i3 = this.f875a.f;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.f875a;
                    i4 = frsActivity.f;
                    frsActivity.f = i4 - 1;
                    this.f875a.b = 2;
                    this.f875a.z();
                }
            } else if (itemId != -2) {
                azVar2 = this.f875a.l;
                com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) azVar2.g().getItem(i);
                if (baVar != null) {
                    com.baidu.tieba.util.w aA = TiebaApplication.f().aA();
                    if (aA != null && !aA.b(baVar.a())) {
                        aA.a(baVar.a());
                    }
                    String i5 = baVar.i();
                    if (i5 == null || i5.equals("")) {
                        z = false;
                    } else {
                        new Thread(new x(this, i5)).start();
                        z = true;
                    }
                    NewPbActivity.a(this.f875a, baVar, null, 1800003, true, false, z);
                }
            } else {
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this.f875a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity frsActivity2 = this.f875a;
                i2 = frsActivity2.f;
                frsActivity2.f = i2 + 1;
                this.f875a.b = 1;
                this.f875a.z();
            }
        }
    }
}
