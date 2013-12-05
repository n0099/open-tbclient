package com.baidu.tieba.chat;

import android.os.Handler;
import com.baidu.tieba.data.chat.ChatData;
/* loaded from: classes.dex */
class g implements ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1187a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatActivity chatActivity) {
        this.f1187a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ae
    public void a() {
        this.b = false;
    }

    @Override // com.baidu.tieba.chat.ae
    public void b() {
        aj ajVar;
        ajVar = this.f1187a.f1168a;
        this.b = ajVar.l();
    }

    @Override // com.baidu.tieba.chat.ae
    public void a(boolean z, String str, boolean z2, int i, ChatData chatData, boolean z3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        Handler handler3;
        Runnable runnable3;
        aj ajVar;
        ac acVar;
        ac acVar2;
        aj ajVar2;
        aj ajVar3;
        aj ajVar4;
        this.f1187a.g = true;
        if (z) {
            ajVar = this.f1187a.f1168a;
            acVar = this.f1187a.b;
            String f = acVar.f();
            acVar2 = this.f1187a.b;
            ajVar.a(f, acVar2.e());
            if (i > 0) {
                this.f1187a.f = true;
            }
            ajVar2 = this.f1187a.f1168a;
            ajVar2.a(chatData);
            if (!z2) {
                if (i > 0) {
                    ajVar4 = this.f1187a.f1168a;
                    ajVar4.b(i);
                }
            } else if (this.b && i > 0) {
                ajVar3 = this.f1187a.f1168a;
                ajVar3.j();
            }
        }
        handler = this.f1187a.h;
        runnable = this.f1187a.k;
        handler.removeCallbacks(runnable);
        if (z3) {
            handler3 = this.f1187a.h;
            runnable3 = this.f1187a.k;
            handler3.postDelayed(runnable3, 0L);
            return;
        }
        handler2 = this.f1187a.h;
        runnable2 = this.f1187a.k;
        handler2.postDelayed(runnable2, 30000L);
    }
}
