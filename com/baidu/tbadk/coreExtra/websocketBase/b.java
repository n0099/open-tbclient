package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b ayD = new b();
    }

    public static b BO() {
        return a.ayD;
    }

    private b() {
    }

    public void BP() {
        fp("kLCSError=1");
    }

    public void ey(int i) {
        fp("kNetStatus=" + i);
    }

    public void fo(String str) {
        fp("kNewIpResult=" + str);
    }

    private void fp(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.Ta, str);
    }
}
