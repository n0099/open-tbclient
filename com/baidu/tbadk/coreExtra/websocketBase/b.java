package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b axK = new b();
    }

    public static b Bo() {
        return a.axK;
    }

    private b() {
    }

    public void Bp() {
        fh("kLCSError=1");
    }

    public void ey(int i) {
        fh("kNetStatus=" + i);
    }

    public void fg(String str) {
        fh("kNewIpResult=" + str);
    }

    private void fh(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.SF, str);
    }
}
