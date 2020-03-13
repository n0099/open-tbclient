package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b duG = new b();
    }

    public static b aNq() {
        return a.duG;
    }

    private b() {
    }

    public void aNr() {
        uM("kLCSError=1");
    }

    public void mf(int i) {
        uM("kNetStatus=" + i);
    }

    public void uL(String str) {
        uM("kNewIpResult=" + str);
    }

    private void uM(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
