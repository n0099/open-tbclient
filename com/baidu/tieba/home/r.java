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
        com.baidu.tieba.a.aa aaVar = view.getTag() instanceof com.baidu.tieba.a.aa ? (com.baidu.tieba.a.aa) view.getTag() : null;
        if (aaVar != null) {
            this.a.r = aaVar;
            String b = aaVar.b();
            int d = aaVar.d();
            if (com.baidu.tieba.c.af.d(b)) {
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
