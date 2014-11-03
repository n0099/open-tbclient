package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class f {
    public static f qy() {
        f fVar;
        fVar = g.Px;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void qz() {
        cR("kLCSError=1");
    }

    public void cv(int i) {
        cR("kNetStatus=" + i);
    }

    public void cQ(String str) {
        cR("kNewIpResult=" + str);
    }

    private void cR(String str) {
        com.baidu.adp.framework.client.socket.m.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.k.yO, str);
    }
}
