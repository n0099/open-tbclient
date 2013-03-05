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
        com.baidu.tieba.a.y yVar = view.getTag() instanceof com.baidu.tieba.a.y ? (com.baidu.tieba.a.y) view.getTag() : null;
        if (yVar != null) {
            this.a.r = yVar;
            String b = yVar.b();
            int d = yVar.d();
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
