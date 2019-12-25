package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b dpZ = new b();
    }

    public static b aKy() {
        return a.dpZ;
    }

    private b() {
    }

    public void aKz() {
        up("kLCSError=1");
    }

    public void lN(int i) {
        up("kNetStatus=" + i);
    }

    public void uo(String str) {
        up("kNewIpResult=" + str);
    }

    private void up(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
