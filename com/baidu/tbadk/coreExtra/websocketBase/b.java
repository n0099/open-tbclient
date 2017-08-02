package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aya = new b();
    }

    public static b BO() {
        return a.aya;
    }

    private b() {
    }

    public void BP() {
        fk("kLCSError=1");
    }

    public void en(int i) {
        fk("kNetStatus=" + i);
    }

    public void fj(String str) {
        fk("kNewIpResult=" + str);
    }

    private void fk(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.Sc, str);
    }
}
