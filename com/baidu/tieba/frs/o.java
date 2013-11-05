package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.f1291a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.a aVar;
        com.baidu.tieba.util.a aVar2;
        ba baVar;
        if (((com.baidu.tieba.view.aa) view).b()) {
            aVar = this.f1291a.L;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.f1291a.L;
                com.baidu.adp.widget.ImageView.e a2 = aVar2.a((String) view.getTag(), new p(this));
                if (a2 != null) {
                    this.f1291a.a(a2, false);
                    return;
                }
                baVar = this.f1291a.o;
                com.baidu.adp.widget.ImageView.e d = baVar.h().a().d(((String) view.getTag()) + "_small");
                if (d != null) {
                    this.f1291a.a(d, true);
                }
            }
        }
    }
}
