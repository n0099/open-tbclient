package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b cpq = new b();
    }

    public static b aqW() {
        return a.cpq;
    }

    private b() {
    }

    public void aqX() {
        pQ("kLCSError=1");
    }

    public void ka(int i) {
        pQ("kNetStatus=" + i);
    }

    public void pP(String str) {
        pQ("kNewIpResult=" + str);
    }

    private void pQ(String str) {
        com.baidu.adp.framework.client.socket.i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.bDw, str);
    }
}
