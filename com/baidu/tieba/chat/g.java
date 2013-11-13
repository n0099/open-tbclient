package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.data.chat.ChatData;
/* loaded from: classes.dex */
class g implements ad {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1134a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatActivity chatActivity) {
        this.f1134a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ad
    public void a() {
        this.b = false;
    }

    @Override // com.baidu.tieba.chat.ad
    public void b() {
        ai aiVar;
        aiVar = this.f1134a.f1116a;
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
        this.f1134a.g = true;
        if (z) {
            aiVar = this.f1134a.f1116a;
            abVar = this.f1134a.b;
            String f = abVar.f();
            abVar2 = this.f1134a.b;
            aiVar.a(f, abVar2.e());
            if (i > 0) {
                this.f1134a.f = true;
            }
            aiVar2 = this.f1134a.f1116a;
            aiVar2.a(chatData);
            if (!z2) {
                if (i > 0) {
                    aiVar4 = this.f1134a.f1116a;
                    aiVar4.b(i);
                }
            } else if (this.b && i > 0) {
                aiVar3 = this.f1134a.f1116a;
                aiVar3.j();
            }
        }
        handler = this.f1134a.h;
        runnable = this.f1134a.k;
        handler.removeCallbacks(runnable);
        if (z3) {
            handler3 = this.f1134a.h;
            runnable3 = this.f1134a.k;
            handler3.postDelayed(runnable3, 0L);
            return;
        }
        handler2 = this.f1134a.h;
        runnable2 = this.f1134a.k;
        handler2.postDelayed(runnable2, 30000L);
    }
}
