package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b coe = new b();
    }

    public static b apR() {
        return a.coe;
    }

    private b() {
    }

    public void apS() {
        pz("kLCSError=1");
    }

    public void jU(int i) {
        pz("kNetStatus=" + i);
    }

    public void py(String str) {
        pz("kNewIpResult=" + str);
    }

    private void pz(String str) {
        com.baidu.adp.framework.client.socket.i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.bCz, str);
    }
}
