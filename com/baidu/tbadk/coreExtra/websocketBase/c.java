package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c ary = new c(null);
    }

    public static c Bs() {
        return a.ary;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Bt() {
        eX("kLCSError=1");
    }

    public void el(int i) {
        eX("kNetStatus=" + i);
    }

    public void eW(String str) {
        eX("kNewIpResult=" + str);
    }

    private void eX(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.Of, str);
    }
}
