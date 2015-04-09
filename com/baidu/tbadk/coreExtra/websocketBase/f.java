package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f xz() {
        f fVar;
        fVar = g.afZ;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void xA() {
        dV("kLCSError=1");
    }

    public void dd(int i) {
        dV("kNetStatus=" + i);
    }

    public void dU(String str) {
        dV("kNewIpResult=" + str);
    }

    private void dV(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.l.Os, str);
    }
}
