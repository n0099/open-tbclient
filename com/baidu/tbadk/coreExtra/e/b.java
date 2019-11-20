package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b cCn = new b();
    }

    public static b ata() {
        return a.cCn;
    }

    private b() {
    }

    public void atb() {
        pl("kLCSError=1");
    }

    public void jA(int i) {
        pl("kNetStatus=" + i);
    }

    public void pk(String str) {
        pl("kNewIpResult=" + str);
    }

    private void pl(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
