package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b ejb = new b();
    }

    public static b bbY() {
        return a.ejb;
    }

    private b() {
    }

    public void bbZ() {
        xJ("kLCSError=1");
    }

    public void mV(int i) {
        xJ("kNetStatus=" + i);
    }

    public void xI(String str) {
        xJ("kNewIpResult=" + str);
    }

    private void xJ(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
