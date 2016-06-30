package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c anu = new c(null);
    }

    public static c Af() {
        return a.anu;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Ag() {
        eV("kLCSError=1");
    }

    public void dU(int i) {
        eV("kNetStatus=" + i);
    }

    public void eU(String str) {
        eV("kNewIpResult=" + str);
    }

    private void eV(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.LT, str);
    }
}
