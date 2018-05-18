package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aAn = new b();
    }

    public static b CD() {
        return a.aAn;
    }

    private b() {
    }

    public void CE() {
        fK("kLCSError=1");
    }

    public void er(int i) {
        fK("kNetStatus=" + i);
    }

    public void fJ(String str) {
        fK("kNewIpResult=" + str);
    }

    private void fK(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.UH, str);
    }
}
