package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f ym() {
        f fVar;
        fVar = g.aha;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void yn() {
        em("kLCSError=1");
    }

    public void dm(int i) {
        em("kNetStatus=" + i);
    }

    public void el(String str) {
        em("kNewIpResult=" + str);
    }

    private void em(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.l.OO, str);
    }
}
