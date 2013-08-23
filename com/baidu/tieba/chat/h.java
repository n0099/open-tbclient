package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.view.an;
/* loaded from: classes.dex */
class h implements an {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatActivity chatActivity) {
        this.f947a = chatActivity;
    }

    @Override // com.baidu.tieba.view.an
    public void a(int i) {
        ad adVar;
        if (i != 0) {
            adVar = this.f947a.f933a;
            adVar.i();
            return;
        }
        new Handler().post(new i(this));
    }
}
