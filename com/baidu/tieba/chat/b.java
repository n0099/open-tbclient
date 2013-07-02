package com.baidu.tieba.chat;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ ChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatActivity chatActivity) {
        this.a = chatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.a.e;
        if (!z) {
            String E = TiebaApplication.E();
            if (E == null || E.length() <= 0) {
                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 1100029);
            } else {
                this.a.o();
            }
        }
    }
}
