package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aVN = new b();
    }

    public static b La() {
        return a.aVN;
    }

    private b() {
    }

    public void Lb() {
        ho("kLCSError=1");
    }

    public void fv(int i) {
        ho("kNetStatus=" + i);
    }

    public void hn(String str) {
        ho("kNewIpResult=" + str);
    }

    private void ho(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.g.aod, str);
    }
}
