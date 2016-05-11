package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c amO = new c(null);
    }

    public static c zZ() {
        return a.amO;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Aa() {
        eR("kLCSError=1");
    }

    public void dT(int i) {
        eR("kNetStatus=" + i);
    }

    public void eQ(String str) {
        eR("kNewIpResult=" + str);
    }

    private void eR(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.LT, str);
    }
}
