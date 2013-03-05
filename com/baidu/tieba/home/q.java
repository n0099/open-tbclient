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
        com.baidu.tieba.a.y yVar = null;
        if (view.getTag() instanceof com.baidu.tieba.a.y) {
            yVar = (com.baidu.tieba.a.y) view.getTag();
        }
        if (yVar != null) {
            String b = yVar.b();
            if (com.baidu.tieba.c.af.d(b)) {
                FrsActivity.a(this.a, b, "tb_forumlist");
            }
        }
    }
}
