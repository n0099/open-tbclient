package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b azr = new b();
    }

    public static b BW() {
        return a.azr;
    }

    private b() {
    }

    public void BX() {
        fq("kLCSError=1");
    }

    public void ep(int i) {
        fq("kNetStatus=" + i);
    }

    public void fp(String str) {
        fq("kNewIpResult=" + str);
    }

    private void fq(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.Tz, str);
    }
}
