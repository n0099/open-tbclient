package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aII = new b();
    }

    public static b Gg() {
        return a.aII;
    }

    private b() {
    }

    public void Gh() {
        gi("kLCSError=1");
    }

    public void ev(int i) {
        gi("kNetStatus=" + i);
    }

    public void gh(String str) {
        gi("kNewIpResult=" + str);
    }

    private void gi(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.acH, str);
    }
}
