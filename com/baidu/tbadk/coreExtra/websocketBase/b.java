package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b ayv = new b();
    }

    public static b BC() {
        return a.ayv;
    }

    private b() {
    }

    public void BD() {
        fo("kLCSError=1");
    }

    public void ez(int i) {
        fo("kNetStatus=" + i);
    }

    public void fn(String str) {
        fo("kNewIpResult=" + str);
    }

    private void fo(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.Ta, str);
    }
}
