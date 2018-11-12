package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aSq = new b();
    }

    public static b JW() {
        return a.aSq;
    }

    private b() {
    }

    public void JX() {
        gW("kLCSError=1");
    }

    public void fh(int i) {
        gW("kNetStatus=" + i);
    }

    public void gV(String str) {
        gW("kNewIpResult=" + str);
    }

    private void gW(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.akB, str);
    }
}
