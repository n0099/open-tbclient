package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b frT = new b();
    }

    public static b bBj() {
        return a.frT;
    }

    private b() {
    }

    public void bBk() {
        Dv("kLCSError=1");
    }

    public void rZ(int i) {
        Dv("kNetStatus=" + i);
    }

    public void Du(String str) {
        Dv("kNewIpResult=" + str);
    }

    private void Dv(String str) {
        com.baidu.adp.framework.client.socket.i.debug("IpReconnLogHelper", 0, 0, null, com.baidu.tbadk.core.h.RETRY_IPLIST, str);
    }
}
