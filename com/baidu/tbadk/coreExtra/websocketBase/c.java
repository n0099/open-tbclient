package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c anS = new c(null);
    }

    public static c zJ() {
        return a.anS;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void zK() {
        ex("kLCSError=1");
    }

    public void dF(int i) {
        ex("kNetStatus=" + i);
    }

    public void ew(String str) {
        ex("kNewIpResult=" + str);
    }

    private void ex(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.k.TD, str);
    }
}
