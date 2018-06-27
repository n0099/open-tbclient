package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aJF = new b();
    }

    public static b Gy() {
        return a.aJF;
    }

    private b() {
    }

    public void Gz() {
        gm("kLCSError=1");
    }

    public void ew(int i) {
        gm("kNetStatus=" + i);
    }

    public void gl(String str) {
        gm("kNewIpResult=" + str);
    }

    private void gm(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.acK, str);
    }
}
