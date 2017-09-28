package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b axW = new b();
    }

    public static b Bu() {
        return a.axW;
    }

    private b() {
    }

    public void Bv() {
        fi("kLCSError=1");
    }

    public void ez(int i) {
        fi("kNetStatus=" + i);
    }

    public void fh(String str) {
        fi("kNewIpResult=" + str);
    }

    private void fi(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.ST, str);
    }
}
