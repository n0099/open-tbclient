package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.a.ad adVar = null;
        if (view.getTag() instanceof com.baidu.tieba.a.ad) {
            adVar = (com.baidu.tieba.a.ad) view.getTag();
        }
        if (adVar != null) {
            String b = adVar.b();
            if (com.baidu.tieba.c.ae.d(b)) {
                FrsActivity.a(this.a, b, "tb_forumlist");
            }
        }
    }
}
