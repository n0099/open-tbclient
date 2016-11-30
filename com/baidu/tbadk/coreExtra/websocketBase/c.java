package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c arV = new c(null);
    }

    public static c BF() {
        return a.arV;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void BG() {
        fb("kLCSError=1");
    }

    public void ek(int i) {
        fb("kNetStatus=" + i);
    }

    public void fa(String str) {
        fb("kNewIpResult=" + str);
    }

    private void fb(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.Oj, str);
    }
}
