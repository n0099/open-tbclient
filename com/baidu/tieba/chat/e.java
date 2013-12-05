package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatPostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements ai {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1185a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatActivity chatActivity) {
        this.f1185a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ai
    public void a() {
        aj ajVar;
        ajVar = this.f1185a.f1168a;
        ajVar.n();
    }

    @Override // com.baidu.tieba.chat.ai
    public void a(boolean z, String str, ChatData chatData) {
        aj ajVar;
        ac acVar;
        aj ajVar2;
        ag agVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ajVar = this.f1185a.f1168a;
        ajVar.o();
        if (z) {
            acVar = this.f1185a.b;
            acVar.a().mergeData(chatData);
            ajVar2 = this.f1185a.f1168a;
            ajVar2.i();
            new Handler().post(new f(this));
            if (chatData.getHasMore()) {
                handler = this.f1185a.h;
                runnable = this.f1185a.k;
                handler.removeCallbacks(runnable);
                handler2 = this.f1185a.h;
                runnable2 = this.f1185a.k;
                handler2.post(runnable2);
            }
            agVar = this.f1185a.c;
            agVar.a((ChatPostData) null);
            return;
        }
        this.f1185a.showToast(str);
    }
}
