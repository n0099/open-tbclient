package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.f1165a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ba baVar;
        ba baVar2;
        boolean z;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            baVar = this.f1165a.o;
            long itemId = baVar.g().getItemId(i);
            if (itemId == -1) {
                i3 = this.f1165a.j;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.f1165a;
                    i4 = frsActivity.j;
                    frsActivity.j = i4 - 1;
                    this.f1165a.d = 2;
                    this.f1165a.E();
                }
            } else if (itemId != -2) {
                baVar2 = this.f1165a.o;
                com.baidu.tieba.data.bh bhVar = (com.baidu.tieba.data.bh) baVar2.g().getItem(i);
                if (bhVar != null) {
                    com.baidu.tieba.util.ak aw = TiebaApplication.g().aw();
                    if (aw != null && !aw.b(bhVar.a())) {
                        aw.a(bhVar.a());
                    }
                    String i5 = bhVar.i();
                    if (i5 == null || i5.equals("")) {
                        z = false;
                    } else {
                        new Thread(new y(this, i5)).start();
                        z = true;
                    }
                    NewPbActivity.a(this.f1165a, bhVar, null, 18003, true, false, z);
                }
            } else {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1165a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity frsActivity2 = this.f1165a;
                i2 = frsActivity2.j;
                frsActivity2.j = i2 + 1;
                this.f1165a.d = 1;
                this.f1165a.E();
            }
        }
    }
}
