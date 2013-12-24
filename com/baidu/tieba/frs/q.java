package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.i iVar;
        com.baidu.tieba.util.i iVar2;
        bn bnVar;
        if (((com.baidu.tieba.view.aa) view).e()) {
            iVar = this.a.O;
            iVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                iVar2 = this.a.O;
                com.baidu.adp.widget.ImageView.e a = iVar2.a((String) view.getTag(), new r(this));
                if (a != null) {
                    this.a.a(a, false);
                    return;
                }
                bnVar = this.a.n;
                com.baidu.adp.widget.ImageView.e d = bnVar.m().a().d(((String) view.getTag()) + "_small");
                if (d != null) {
                    this.a.a(d, true);
                }
            }
        }
    }
}
