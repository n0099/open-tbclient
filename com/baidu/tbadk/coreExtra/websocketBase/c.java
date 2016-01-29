package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c aqJ = new c(null);
    }

    public static c BC() {
        return a.aqJ;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void BD() {
        eN("kLCSError=1");
    }

    public void ek(int i) {
        eN("kNetStatus=" + i);
    }

    public void eM(String str) {
        eN("kNewIpResult=" + str);
    }

    private void eN(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.TG, str);
    }
}
