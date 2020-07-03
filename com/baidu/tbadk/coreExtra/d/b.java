package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b erM = new b();
    }

    public static b beb() {
        return a.erM;
    }

    private b() {
    }

    public void bec() {
        yc("kLCSError=1");
    }

    public void nr(int i) {
        yc("kNetStatus=" + i);
    }

    public void yb(String str) {
        yc("kNewIpResult=" + str);
    }

    private void yc(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
