package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatPostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements ah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1132a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatActivity chatActivity) {
        this.f1132a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ah
    public void a() {
        ai aiVar;
        aiVar = this.f1132a.f1116a;
        aiVar.n();
    }

    @Override // com.baidu.tieba.chat.ah
    public void a(boolean z, String str, ChatData chatData) {
        ai aiVar;
        ab abVar;
        ai aiVar2;
        af afVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        aiVar = this.f1132a.f1116a;
        aiVar.o();
        if (z) {
            abVar = this.f1132a.b;
            abVar.a().mergeData(chatData);
            aiVar2 = this.f1132a.f1116a;
            aiVar2.i();
            new Handler().post(new f(this));
            if (chatData.getHasMore()) {
                handler = this.f1132a.h;
                runnable = this.f1132a.k;
                handler.removeCallbacks(runnable);
                handler2 = this.f1132a.h;
                runnable2 = this.f1132a.k;
                handler2.post(runnable2);
            }
            afVar = this.f1132a.c;
            afVar.a((ChatPostData) null);
            return;
        }
        this.f1132a.showToast(str);
    }
}
