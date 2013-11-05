package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.data.chat.ChatData;
/* loaded from: classes.dex */
class g implements ad {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1101a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatActivity chatActivity) {
        this.f1101a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ad
    public void a() {
        this.b = false;
    }

    @Override // com.baidu.tieba.chat.ad
    public void b() {
        ai aiVar;
        aiVar = this.f1101a.f1083a;
        this.b = aiVar.l();
    }

    @Override // com.baidu.tieba.chat.ad
    public void a(boolean z, String str, boolean z2, int i, ChatData chatData, boolean z3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        Handler handler3;
        Runnable runnable3;
        ai aiVar;
        ab abVar;
        ab abVar2;
        ai aiVar2;
        ai aiVar3;
        ai aiVar4;
        this.f1101a.g = true;
        if (z) {
            aiVar = this.f1101a.f1083a;
            abVar = this.f1101a.b;
            String f = abVar.f();
            abVar2 = this.f1101a.b;
            aiVar.a(f, abVar2.e());
            if (i > 0) {
                this.f1101a.f = true;
            }
            aiVar2 = this.f1101a.f1083a;
            aiVar2.a(chatData);
            if (!z2) {
                if (i > 0) {
                    aiVar4 = this.f1101a.f1083a;
                    aiVar4.b(i);
                }
            } else if (this.b && i > 0) {
                aiVar3 = this.f1101a.f1083a;
                aiVar3.j();
            }
        }
        handler = this.f1101a.j;
        runnable = this.f1101a.m;
        handler.removeCallbacks(runnable);
        if (z3) {
            handler3 = this.f1101a.j;
            runnable3 = this.f1101a.m;
            handler3.postDelayed(runnable3, 0L);
            return;
        }
        handler2 = this.f1101a.j;
        runnable2 = this.f1101a.m;
        handler2.postDelayed(runnable2, 30000L);
    }
}
