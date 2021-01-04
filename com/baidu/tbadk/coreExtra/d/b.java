package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b fBy = new b();
    }

    public static b bDE() {
        return a.fBy;
    }

    private b() {
    }

    public void bDF() {
        Dt("kLCSError=1");
    }

    public void sl(int i) {
        Dt("kNetStatus=" + i);
    }

    public void Ds(String str) {
        Dt("kNewIpResult=" + str);
    }

    private void Dt(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
