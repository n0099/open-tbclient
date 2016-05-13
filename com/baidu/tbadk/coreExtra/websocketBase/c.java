package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c amO = new c(null);
    }

    public static c Aa() {
        return a.amO;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Ab() {
        eR("kLCSError=1");
    }

    public void dS(int i) {
        eR("kNetStatus=" + i);
    }

    public void eQ(String str) {
        eR("kNewIpResult=" + str);
    }

    private void eR(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.LT, str);
    }
}
