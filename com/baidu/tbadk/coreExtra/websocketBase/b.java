package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aRA = new b();
    }

    public static b JK() {
        return a.aRA;
    }

    private b() {
    }

    public void JL() {
        gV("kLCSError=1");
    }

    public void eT(int i) {
        gV("kNetStatus=" + i);
    }

    public void gU(String str) {
        gV("kNewIpResult=" + str);
    }

    private void gV(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.ajO, str);
    }
}
