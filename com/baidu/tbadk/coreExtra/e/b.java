package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b cDe = new b();
    }

    public static b atc() {
        return a.cDe;
    }

    private b() {
    }

    public void atd() {
        pl("kLCSError=1");
    }

    public void jB(int i) {
        pl("kNetStatus=" + i);
    }

    public void pk(String str) {
        pl("kNewIpResult=" + str);
    }

    private void pl(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
