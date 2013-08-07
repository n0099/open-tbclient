package com.baidu.tieba.chat;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatActivity chatActivity) {
        this.f931a = chatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f931a.e;
        if (!z) {
            String E = TiebaApplication.E();
            if (E == null || E.length() <= 0) {
                LoginActivity.a((Activity) this.f931a, this.f931a.getString(R.string.login_to_use), true, 11029);
            } else {
                this.f931a.m();
            }
        }
    }
}
