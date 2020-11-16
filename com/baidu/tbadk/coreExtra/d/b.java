package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b fkt = new b();
    }

    public static b bxJ() {
        return a.fkt;
    }

    private b() {
    }

    public void bxK() {
        CN("kLCSError=1");
    }

    public void ry(int i) {
        CN("kNetStatus=" + i);
    }

    public void CM(String str) {
        CN("kNewIpResult=" + str);
    }

    private void CN(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
