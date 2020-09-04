package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b eII = new b();
    }

    public static b bqx() {
        return a.eII;
    }

    private b() {
    }

    public void bqy() {
        Bz("kLCSError=1");
    }

    public void pU(int i) {
        Bz("kNetStatus=" + i);
    }

    public void By(String str) {
        Bz("kNewIpResult=" + str);
    }

    private void Bz(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
