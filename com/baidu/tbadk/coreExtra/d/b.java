package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b fzg = new b();
    }

    public static b bAd() {
        return a.fzg;
    }

    private b() {
    }

    public void bAe() {
        Cy("kLCSError=1");
    }

    public void qK(int i) {
        Cy("kNetStatus=" + i);
    }

    public void Cx(String str) {
        Cy("kNewIpResult=" + str);
    }

    private void Cy(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
