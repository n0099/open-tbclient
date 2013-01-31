package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnLongClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.r = null;
        com.baidu.tieba.a.ad adVar = view.getTag() instanceof com.baidu.tieba.a.ad ? (com.baidu.tieba.a.ad) view.getTag() : null;
        if (adVar != null) {
            this.a.r = adVar;
            String b = adVar.b();
            int d = adVar.d();
            if (com.baidu.tieba.c.ae.d(b)) {
                if (d == 1) {
                    this.a.c.show();
                } else {
                    this.a.d.show();
                }
            }
        }
        return true;
    }
}
