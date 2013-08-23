package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.f1118a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        bb bbVar;
        bb bbVar2;
        boolean z;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            bbVar = this.f1118a.l;
            long itemId = bbVar.i().getItemId(i);
            if (itemId == -1) {
                i3 = this.f1118a.f;
                if (i3 > 1) {
                    FrsActivity frsActivity = this.f1118a;
                    i4 = frsActivity.f;
                    frsActivity.f = i4 - 1;
                    this.f1118a.b = 2;
                    this.f1118a.B();
                }
            } else if (itemId != -2) {
                bbVar2 = this.f1118a.l;
                com.baidu.tieba.data.bh bhVar = (com.baidu.tieba.data.bh) bbVar2.i().getItem(i);
                if (bhVar != null) {
                    com.baidu.tieba.util.ag av = TiebaApplication.g().av();
                    if (av != null && !av.b(bhVar.a())) {
                        av.a(bhVar.a());
                    }
                    String i5 = bhVar.i();
                    if (i5 == null || i5.equals("")) {
                        z = false;
                    } else {
                        new Thread(new z(this, i5)).start();
                        z = true;
                    }
                    NewPbActivity.a(this.f1118a, bhVar, null, 18003, true, false, z);
                }
            } else {
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f1118a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity frsActivity2 = this.f1118a;
                i2 = frsActivity2.f;
                frsActivity2.f = i2 + 1;
                this.f1118a.b = 1;
                this.f1118a.B();
            }
        }
    }
}
