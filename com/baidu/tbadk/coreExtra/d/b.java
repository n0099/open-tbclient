package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    private static class a {
        private static b eIE = new b();
    }

    public static b bqw() {
        return a.eIE;
    }

    private b() {
    }

    public void bqx() {
        By("kLCSError=1");
    }

    public void pU(int i) {
        By("kNetStatus=" + i);
    }

    public void Bx(String str) {
        By("kNewIpResult=" + str);
    }

    private void By(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
