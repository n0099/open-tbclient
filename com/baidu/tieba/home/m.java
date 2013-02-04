package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnLongClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.l = null;
        com.baidu.tieba.a.ac acVar = view.getTag() instanceof com.baidu.tieba.a.ac ? (com.baidu.tieba.a.ac) view.getTag() : null;
        if (acVar != null) {
            this.a.l = acVar;
            String b = acVar.b();
            int d = acVar.d();
            if (com.baidu.tieba.c.ad.d(b)) {
                if (d == 1) {
                    this.a.b.show();
                } else {
                    this.a.c.show();
                }
            }
        }
        return true;
    }
}
