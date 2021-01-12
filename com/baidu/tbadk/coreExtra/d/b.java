package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b fwQ = new b();
    }

    public static b bzL() {
        return a.fwQ;
    }

    private b() {
    }

    public void bzM() {
        Ch("kLCSError=1");
    }

    public void qF(int i) {
        Ch("kNetStatus=" + i);
    }

    public void Cg(String str) {
        Ch("kNewIpResult=" + str);
    }

    private void Ch(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
