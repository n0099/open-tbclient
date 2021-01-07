package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b fBy = new b();
    }

    public static b bDF() {
        return a.fBy;
    }

    private b() {
    }

    public void bDG() {
        Ds("kLCSError=1");
    }

    public void sl(int i) {
        Ds("kNetStatus=" + i);
    }

    public void Dr(String str) {
        Ds("kNewIpResult=" + str);
    }

    private void Ds(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
