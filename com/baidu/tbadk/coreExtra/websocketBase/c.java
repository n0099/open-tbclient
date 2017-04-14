package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c awp = new c(null);
    }

    public static c Ce() {
        return a.awp;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Cf() {
        eP("kLCSError=1");
    }

    public void ek(int i) {
        eP("kNetStatus=" + i);
    }

    public void eO(String str) {
        eP("kNewIpResult=" + str);
    }

    private void eP(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.n.SM, str);
    }
}
