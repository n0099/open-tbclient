package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f xt() {
        f fVar;
        fVar = g.afR;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void xu() {
        dS("kLCSError=1");
    }

    public void dd(int i) {
        dS("kNetStatus=" + i);
    }

    public void dR(String str) {
        dS("kNewIpResult=" + str);
    }

    private void dS(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.l.Oq, str);
    }
}
