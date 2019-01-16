package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aWy = new b();
    }

    public static b Lq() {
        return a.aWy;
    }

    private b() {
    }

    public void Lr() {
        hD("kLCSError=1");
    }

    public void fw(int i) {
        hD("kNetStatus=" + i);
    }

    public void hC(String str) {
        hD("kNewIpResult=" + str);
    }

    private void hD(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aoF, str);
    }
}
