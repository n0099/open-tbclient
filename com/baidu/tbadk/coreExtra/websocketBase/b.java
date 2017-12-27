package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b bnr = new b();
    }

    public static b JB() {
        return a.bnr;
    }

    private b() {
    }

    public void JC() {
        fB("kLCSError=1");
    }

    public void hx(int i) {
        fB("kNetStatus=" + i);
    }

    public void fA(String str) {
        fB("kNewIpResult=" + str);
    }

    private void fB(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aIf, str);
    }
}
