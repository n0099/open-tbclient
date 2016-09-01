package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c arq = new c(null);
    }

    public static c Bu() {
        return a.arq;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Bv() {
        eW("kLCSError=1");
    }

    public void ei(int i) {
        eW("kNetStatus=" + i);
    }

    public void eV(String str) {
        eW("kNewIpResult=" + str);
    }

    private void eW(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.Of, str);
    }
}
