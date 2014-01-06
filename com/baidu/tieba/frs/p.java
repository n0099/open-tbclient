package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.util.i iVar;
        com.baidu.tieba.util.i iVar2;
        bo boVar;
        if (((com.baidu.tieba.view.af) view).e()) {
            iVar = this.a.O;
            iVar.d();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                iVar2 = this.a.O;
                com.baidu.adp.widget.ImageView.d a = iVar2.a((String) view.getTag(), new q(this));
                if (a != null) {
                    this.a.a(a, false);
                    return;
                }
                boVar = this.a.n;
                com.baidu.adp.widget.ImageView.d d = boVar.n().a().d(((String) view.getTag()) + "_small");
                if (d != null) {
                    this.a.a(d, true);
                }
            }
        }
    }
}
