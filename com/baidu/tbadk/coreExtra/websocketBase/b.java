package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b azj = new b();
    }

    public static b BZ() {
        return a.azj;
    }

    private b() {
    }

    public void Ca() {
        fu("kLCSError=1");
    }

    public void ez(int i) {
        fu("kNetStatus=" + i);
    }

    public void ft(String str) {
        fu("kNewIpResult=" + str);
    }

    private void fu(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.TD, str);
    }
}
