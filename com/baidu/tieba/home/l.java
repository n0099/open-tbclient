package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.a.ac acVar = view.getTag() instanceof com.baidu.tieba.a.ac ? (com.baidu.tieba.a.ac) view.getTag() : null;
        if (acVar != null) {
            String b = acVar.b();
            if (com.baidu.tieba.c.ad.d(b)) {
                FrsActivity.a(this.a, b, "tb_forumlist");
            }
        }
    }
}
