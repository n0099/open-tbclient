package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c ara = new c(null);
    }

    public static c Cf() {
        return a.ara;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void Cg() {
        eU("kLCSError=1");
    }

    public void en(int i) {
        eU("kNetStatus=" + i);
    }

    public void eT(String str) {
        eU("kNewIpResult=" + str);
    }

    private void eU(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.j.Rd, str);
    }
}
