package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b fAF = new b();
    }

    public static b bAg() {
        return a.fAF;
    }

    private b() {
    }

    public void bAh() {
        CF("kLCSError=1");
    }

    public void qL(int i) {
        CF("kNetStatus=" + i);
    }

    public void CE(String str) {
        CF("kNewIpResult=" + str);
    }

    private void CF(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
