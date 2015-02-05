package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f uc() {
        f fVar;
        fVar = g.VL;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void ud() {
        dJ("kLCSError=1");
    }

    public void db(int i) {
        dJ("kNetStatus=" + i);
    }

    public void dI(String str) {
        dJ("kNewIpResult=" + str);
    }

    private void dJ(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.CG, str);
    }
}
