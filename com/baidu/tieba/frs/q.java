package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.f1361a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.i iVar;
        com.baidu.tieba.util.i iVar2;
        bn bnVar;
        if (((com.baidu.tieba.view.z) view).d()) {
            iVar = this.f1361a.O;
            iVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                iVar2 = this.f1361a.O;
                com.baidu.adp.widget.ImageView.e a2 = iVar2.a((String) view.getTag(), new r(this));
                if (a2 != null) {
                    this.f1361a.a(a2, false);
                    return;
                }
                bnVar = this.f1361a.n;
                com.baidu.adp.widget.ImageView.e d = bnVar.l().a().d(((String) view.getTag()) + "_small");
                if (d != null) {
                    this.f1361a.a(d, true);
                }
            }
        }
    }
}
