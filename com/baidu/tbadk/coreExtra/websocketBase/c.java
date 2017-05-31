package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c awf = new c(null);
    }

    public static c Bi() {
        return a.awf;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Bj() {
        eM("kLCSError=1");
    }

    public void ej(int i) {
        eM("kNetStatus=" + i);
    }

    public void eL(String str) {
        eM("kNewIpResult=" + str);
    }

    private void eM(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.o.RU, str);
    }
}
