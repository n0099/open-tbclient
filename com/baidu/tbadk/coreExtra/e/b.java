package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b cqs = new b();
    }

    public static b ark() {
        return a.cqs;
    }

    private b() {
    }

    public void arl() {
        qb("kLCSError=1");
    }

    public void ke(int i) {
        qb("kNetStatus=" + i);
    }

    public void qa(String str) {
        qb("kNewIpResult=" + str);
    }

    private void qb(String str) {
        com.baidu.adp.framework.client.socket.i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.bDU, str);
    }
}
