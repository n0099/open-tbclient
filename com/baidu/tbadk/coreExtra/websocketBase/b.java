package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b bnJ = new b();
    }

    public static b Js() {
        return a.bnJ;
    }

    private b() {
    }

    public void Jt() {
        fJ("kLCSError=1");
    }

    public void ht(int i) {
        fJ("kNetStatus=" + i);
    }

    public void fI(String str) {
        fJ("kNewIpResult=" + str);
    }

    private void fJ(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aIg, str);
    }
}
