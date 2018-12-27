package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aVQ = new b();
    }

    public static b Lb() {
        return a.aVQ;
    }

    private b() {
    }

    public void Lc() {
        hp("kLCSError=1");
    }

    public void fw(int i) {
        hp("kNetStatus=" + i);
    }

    public void ho(String str) {
        hp("kNewIpResult=" + str);
    }

    private void hp(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aod, str);
    }
}
