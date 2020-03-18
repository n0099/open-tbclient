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
        uL("kLCSError=1");
    }

    public void mh(int i) {
        uL("kNetStatus=" + i);
    }

    public void uK(String str) {
        uL("kNewIpResult=" + str);
    }

    private void uL(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
