package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b eWW = new b();
    }

    public static b bub() {
        return a.eWW;
    }

    private b() {
    }

    public void buc() {
        CH("kLCSError=1");
    }

    public void qF(int i) {
        CH("kNetStatus=" + i);
    }

    public void CG(String str) {
        CH("kNewIpResult=" + str);
    }

    private void CH(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
