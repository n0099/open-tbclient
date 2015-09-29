package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c amu = new c(null);
    }

    public static c zy() {
        return a.amu;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void zz() {
        eB("kLCSError=1");
    }

    public void dG(int i) {
        eB("kNetStatus=" + i);
    }

    public void eA(String str) {
        eB("kNewIpResult=" + str);
    }

    private void eB(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.k.Tp, str);
    }
}
