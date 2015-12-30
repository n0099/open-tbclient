package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c apR = new c(null);
    }

    public static c Am() {
        return a.apR;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void An() {
        eO("kLCSError=1");
    }

    public void dP(int i) {
        eO("kNetStatus=" + i);
    }

    public void eN(String str) {
        eO("kNewIpResult=" + str);
    }

    private void eO(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.k.Ui, str);
    }
}
