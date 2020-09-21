package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b eKP = new b();
    }

    public static b brr() {
        return a.eKP;
    }

    private b() {
    }

    public void brs() {
        BV("kLCSError=1");
    }

    public void qh(int i) {
        BV("kNetStatus=" + i);
    }

    public void BU(String str) {
        BV("kNewIpResult=" + str);
    }

    private void BV(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
