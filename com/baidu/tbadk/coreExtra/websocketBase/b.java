package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aJL = new b();
    }

    public static b Gu() {
        return a.aJL;
    }

    private b() {
    }

    public void Gv() {
        gk("kLCSError=1");
    }

    public void ez(int i) {
        gk("kNetStatus=" + i);
    }

    public void gj(String str) {
        gk("kNewIpResult=" + str);
    }

    private void gk(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aco, str);
    }
}
