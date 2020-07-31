package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b eyf = new b();
    }

    public static b bhK() {
        return a.eyf;
    }

    private b() {
    }

    public void bhL() {
        zi("kLCSError=1");
    }

    public void nJ(int i) {
        zi("kNetStatus=" + i);
    }

    public void zh(String str) {
        zi("kNewIpResult=" + str);
    }

    private void zi(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
