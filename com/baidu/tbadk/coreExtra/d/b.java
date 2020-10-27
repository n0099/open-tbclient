package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b ffs = new b();
    }

    public static b bvU() {
        return a.ffs;
    }

    private b() {
    }

    public void bvV() {
        Da("kLCSError=1");
    }

    public void qQ(int i) {
        Da("kNetStatus=" + i);
    }

    public void CZ(String str) {
        Da("kNewIpResult=" + str);
    }

    private void Da(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
