package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.view.ao;
/* loaded from: classes.dex */
class h implements ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatActivity chatActivity) {
        this.f1141a = chatActivity;
    }

    @Override // com.baidu.tieba.view.ao
    public void a(int i) {
        ai aiVar;
        if (i != 0) {
            aiVar = this.f1141a.f1122a;
            aiVar.k();
            return;
        }
        new Handler().post(new i(this));
    }
}
