package com.baidu.tieba.chat;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatActivity chatActivity) {
        this.f1129a = chatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f1129a.e;
        if (!z) {
            String A = TiebaApplication.A();
            if (A != null && A.length() > 0) {
                this.f1129a.i();
            } else {
                LoginActivity.a((Activity) this.f1129a, this.f1129a.getString(R.string.login_to_use), true, 11029);
            }
        }
    }
}
