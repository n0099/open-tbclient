package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c aon = new c(null);
    }

    public static c Aw() {
        return a.aon;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Ax() {
        eL("kLCSError=1");
    }

    public void dV(int i) {
        eL("kNetStatus=" + i);
    }

    public void eK(String str) {
        eL("kNewIpResult=" + str);
    }

    private void eL(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.k.TG, str);
    }
}
