package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b ayE = new b();
    }

    public static b BR() {
        return a.ayE;
    }

    private b() {
    }

    public void BS() {
        fp("kLCSError=1");
    }

    public void eo(int i) {
        fp("kNetStatus=" + i);
    }

    public void fo(String str) {
        fp("kNewIpResult=" + str);
    }

    private void fp(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.SF, str);
    }
}
