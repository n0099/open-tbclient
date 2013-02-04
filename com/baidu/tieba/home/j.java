package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 1100002);
            return;
        }
        rVar = this.a.m;
        if (rVar != null || view == null || view.getTag() == null || !(view.getTag() instanceof com.baidu.tieba.a.ac)) {
            return;
        }
        this.a.m = new r(this.a, (com.baidu.tieba.a.ac) view.getTag());
        rVar2 = this.a.m;
        rVar2.execute(new Object[0]);
    }
}
