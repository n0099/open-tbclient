package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b cod = new b();
    }

    public static b apR() {
        return a.cod;
    }

    private b() {
    }

    public void apS() {
        pA("kLCSError=1");
    }

    public void jU(int i) {
        pA("kNetStatus=" + i);
    }

    public void pz(String str) {
        pA("kNewIpResult=" + str);
    }

    private void pA(String str) {
        com.baidu.adp.framework.client.socket.i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.bCy, str);
    }
}
