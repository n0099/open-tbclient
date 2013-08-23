package com.baidu.tieba.chat;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f941a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatActivity chatActivity) {
        this.f941a = chatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f941a.e;
        if (!z) {
            String E = TiebaApplication.E();
            if (E == null || E.length() <= 0) {
                LoginActivity.a((Activity) this.f941a, this.f941a.getString(R.string.login_to_use), true, 11029);
            } else {
                this.f941a.m();
            }
        }
    }
}
