package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.view.aq;
/* loaded from: classes.dex */
class h implements aq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatActivity chatActivity) {
        this.f939a = chatActivity;
    }

    @Override // com.baidu.tieba.view.aq
    public void a(int i) {
        ad adVar;
        if (i != 0) {
            adVar = this.f939a.f925a;
            adVar.i();
            return;
        }
        new Handler().post(new i(this));
    }
}
