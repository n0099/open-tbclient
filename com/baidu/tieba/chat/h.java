package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.view.ap;
/* loaded from: classes.dex */
class h implements ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1188a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatActivity chatActivity) {
        this.f1188a = chatActivity;
    }

    @Override // com.baidu.tieba.view.ap
    public void a(int i) {
        aj ajVar;
        if (i != 0) {
            ajVar = this.f1188a.f1168a;
            ajVar.k();
            return;
        }
        new Handler().post(new i(this));
    }
}
