package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b bpK = new b();
    }

    public static b JY() {
        return a.bpK;
    }

    private b() {
    }

    public void JZ() {
        fT("kLCSError=1");
    }

    public void hs(int i) {
        fT("kNetStatus=" + i);
    }

    public void fS(String str) {
        fT("kNewIpResult=" + str);
    }

    private void fT(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aJp, str);
    }
}
