package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b cfT = new b();
    }

    public static b akS() {
        return a.cfT;
    }

    private b() {
    }

    public void akT() {
        or("kLCSError=1");
    }

    public void jh(int i) {
        or("kNetStatus=" + i);
    }

    public void oq(String str) {
        or("kNewIpResult=" + str);
    }

    private void or(String str) {
        com.baidu.adp.framework.client.socket.i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.bvp, str);
    }
}
