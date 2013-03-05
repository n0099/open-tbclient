package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        String x = TiebaApplication.x();
        if (x != null && x.length() > 0) {
            wVar = this.a.s;
            if (wVar == null && view != null && view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.a.y)) {
                this.a.s = new w(this.a, (com.baidu.tieba.a.y) view.getTag());
                wVar2 = this.a.s;
                wVar2.execute(new Object[0]);
                return;
            }
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 1100002);
    }
}
