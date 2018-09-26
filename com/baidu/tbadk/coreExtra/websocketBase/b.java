package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aMY = new b();
    }

    public static b HK() {
        return a.aMY;
    }

    private b() {
    }

    public void HL() {
        gH("kLCSError=1");
    }

    public void eK(int i) {
        gH("kNetStatus=" + i);
    }

    public void gG(String str) {
        gH("kNewIpResult=" + str);
    }

    private void gH(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aeR, str);
    }
}
