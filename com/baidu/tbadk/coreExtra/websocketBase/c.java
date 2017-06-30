package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    private static class a {
        private static c axi = new c(null);
    }

    public static c BD() {
        return a.axi;
    }

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    public void BE() {
        fg("kLCSError=1");
    }

    public void el(int i) {
        fg("kNetStatus=" + i);
    }

    public void ff(String str) {
        fg("kNewIpResult=" + str);
    }

    private void fg(String str) {
        com.baidu.adp.framework.client.socket.k.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.o.RP, str);
    }
}
