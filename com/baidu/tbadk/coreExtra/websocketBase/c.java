package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c avZ = new c(null);
    }

    public static c BG() {
        return a.avZ;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void BH() {
        eJ("kLCSError=1");
    }

    public void eh(int i) {
        eJ("kNetStatus=" + i);
    }

    public void eI(String str) {
        eJ("kNewIpResult=" + str);
    }

    private void eJ(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.Su, str);
    }
}
