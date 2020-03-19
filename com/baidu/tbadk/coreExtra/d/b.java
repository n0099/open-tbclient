package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b duT = new b();
    }

    public static b aNu() {
        return a.duT;
    }

    private b() {
    }

    public void aNv() {
        uM("kLCSError=1");
    }

    public void mh(int i) {
        uM("kNetStatus=" + i);
    }

    public void uL(String str) {
        uM("kNewIpResult=" + str);
    }

    private void uM(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
