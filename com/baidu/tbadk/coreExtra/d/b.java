package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b dUS = new b();
    }

    public static b aVP() {
        return a.dUS;
    }

    private b() {
    }

    public void aVQ() {
        wd("kLCSError=1");
    }

    public void mt(int i) {
        wd("kNetStatus=" + i);
    }

    public void wc(String str) {
        wd("kNewIpResult=" + str);
    }

    private void wd(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
