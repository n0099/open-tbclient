package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f tR() {
        f fVar;
        fVar = g.Vj;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void tS() {
        dN("kLCSError=1");
    }

    public void cU(int i) {
        dN("kNetStatus=" + i);
    }

    public void dM(String str) {
        dN("kNewIpResult=" + str);
    }

    private void dN(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.CJ, str);
    }
}
