package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f ui() {
        f fVar;
        fVar = g.VO;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void uj() {
        dM("kLCSError=1");
    }

    public void db(int i) {
        dM("kNetStatus=" + i);
    }

    public void dL(String str) {
        dM("kNewIpResult=" + str);
    }

    private void dM(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.CJ, str);
    }
}
