package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b dUN = new b();
    }

    public static b aVR() {
        return a.dUN;
    }

    private b() {
    }

    public void aVS() {
        wa("kLCSError=1");
    }

    public void mt(int i) {
        wa("kNetStatus=" + i);
    }

    public void vZ(String str) {
        wa("kNewIpResult=" + str);
    }

    private void wa(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
