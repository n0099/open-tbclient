package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c arb = new c(null);
    }

    public static c By() {
        return a.arb;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Bz() {
        eZ("kLCSError=1");
    }

    public void ei(int i) {
        eZ("kNetStatus=" + i);
    }

    public void eY(String str) {
        eZ("kNewIpResult=" + str);
    }

    private void eZ(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.Og, str);
    }
}
