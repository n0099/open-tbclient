package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c aoj = new c(null);
    }

    public static c Af() {
        return a.aoj;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Ag() {
        eT("kLCSError=1");
    }

    public void dU(int i) {
        eT("kNetStatus=" + i);
    }

    public void eS(String str) {
        eT("kNewIpResult=" + str);
    }

    private void eT(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.LR, str);
    }
}
