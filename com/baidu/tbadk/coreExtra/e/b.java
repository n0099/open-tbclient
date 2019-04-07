package com.baidu.tbadk.coreExtra.e;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b cfV = new b();
    }

    public static b akO() {
        return a.cfV;
    }

    private b() {
    }

    public void akP() {
        os("kLCSError=1");
    }

    public void jg(int i) {
        os("kNetStatus=" + i);
    }

    public void or(String str) {
        os("kNewIpResult=" + str);
    }

    private void os(String str) {
        com.baidu.adp.framework.client.socket.i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.bvu, str);
    }
}
