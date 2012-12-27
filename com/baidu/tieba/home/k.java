package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LoginActivity.a(this.a, "goto_home", this.a.getString(R.string.login_home_tab), 1100003);
    }
}
