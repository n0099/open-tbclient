package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.view.ao;
/* loaded from: classes.dex */
class h implements ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f964a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatActivity chatActivity) {
        this.f964a = chatActivity;
    }

    @Override // com.baidu.tieba.view.ao
    public void a(int i) {
        ac acVar;
        if (i != 0) {
            acVar = this.f964a.f951a;
            acVar.i();
            return;
        }
        new Handler().post(new i(this));
    }
}
