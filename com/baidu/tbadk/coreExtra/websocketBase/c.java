package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c amg = new c(null);
    }

    public static c zw() {
        return a.amg;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void zx() {
        ep("kLCSError=1");
    }

    public void dx(int i) {
        ep("kNetStatus=" + i);
    }

    public void eo(String str) {
        ep("kNewIpResult=" + str);
    }

    private void ep(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.k.TC, str);
    }
}
