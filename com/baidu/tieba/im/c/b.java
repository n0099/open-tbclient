package com.baidu.tieba.im.c;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.webSocket.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.net.link.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1485a = aVar;
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(int i, String str) {
        this.f1485a.e();
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void c() {
        this.f1485a.d();
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(byte[] bArr) {
        Handler handler;
        Handler handler2;
        int i;
        this.f1485a.o();
        handler = this.f1485a.D;
        handler2 = this.f1485a.D;
        Message obtainMessage = handler2.obtainMessage(1);
        i = this.f1485a.j;
        handler.sendMessageDelayed(obtainMessage, i);
        this.f1485a.u = System.currentTimeMillis();
        com.baidu.tieba.im.messageCenter.f.a().b(false);
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(am amVar) {
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(String str) {
    }
}
