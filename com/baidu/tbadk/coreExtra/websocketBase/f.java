package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f a() {
        f fVar;
        fVar = g.a;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void b() {
        b("kLCSError=1");
    }

    public void a(int i) {
        b("kNetStatus=" + i);
    }

    public void a(String str) {
        b("kNewIpResult=" + str);
    }

    private void b(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.g, str);
    }
}
