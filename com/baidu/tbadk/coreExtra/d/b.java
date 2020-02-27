package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b dus = new b();
    }

    public static b aNn() {
        return a.dus;
    }

    private b() {
    }

    public void aNo() {
        uL("kLCSError=1");
    }

    public void mf(int i) {
        uL("kNetStatus=" + i);
    }

    public void uK(String str) {
        uL("kNewIpResult=" + str);
    }

    private void uL(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
