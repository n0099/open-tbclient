package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b bnA = new b();
    }

    public static b Jq() {
        return a.bnA;
    }

    private b() {
    }

    public void Jr() {
        fC("kLCSError=1");
    }

    public void ht(int i) {
        fC("kNetStatus=" + i);
    }

    public void fB(String str) {
        fC("kNewIpResult=" + str);
    }

    private void fC(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aId, str);
    }
}
