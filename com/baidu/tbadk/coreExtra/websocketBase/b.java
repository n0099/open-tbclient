package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b bpN = new b();
    }

    public static b JZ() {
        return a.bpN;
    }

    private b() {
    }

    public void Ka() {
        fT("kLCSError=1");
    }

    public void hs(int i) {
        fT("kNetStatus=" + i);
    }

    public void fS(String str) {
        fT("kNewIpResult=" + str);
    }

    private void fT(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aJq, str);
    }
}
