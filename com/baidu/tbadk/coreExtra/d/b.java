package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b fll = new b();
    }

    public static b byt() {
        return a.fll;
    }

    private b() {
    }

    public void byu() {
        Do("kLCSError=1");
    }

    public void ra(int i) {
        Do("kNetStatus=" + i);
    }

    public void Dn(String str) {
        Do("kNewIpResult=" + str);
    }

    private void Do(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
