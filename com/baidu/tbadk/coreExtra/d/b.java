package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b dqk = new b();
    }

    public static b aKR() {
        return a.dqk;
    }

    private b() {
    }

    public void aKS() {
        uu("kLCSError=1");
    }

    public void lN(int i) {
        uu("kNetStatus=" + i);
    }

    public void ut(String str) {
        uu("kNewIpResult=" + str);
    }

    private void uu(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.g.RETRY_IPLIST, str);
    }
}
