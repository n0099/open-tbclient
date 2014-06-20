package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.adp.lib.webSocket.l {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(Map<String, String> map) {
        int i;
        i = this.a.b;
        if (i >= 5) {
            com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.l.b());
            a.a().a(com.baidu.adp.framework.client.socket.l.b());
            a.a().e();
        }
        this.a.b = 0;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(int i, String str) {
        int i2;
        int i3;
        BdLog.i("RetryIPList code:" + i + "--reason:" + str);
        if ((i == 2 || i == 9) && UtilHelper.isNetOk()) {
            r rVar = this.a;
            i2 = rVar.b;
            rVar.b = i2 + 1;
            i3 = this.a.b;
            if (i3 >= 5) {
                com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                this.a.e();
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a() {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(String str) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(int i, com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void c(com.baidu.adp.lib.webSocket.d dVar) {
    }
}
