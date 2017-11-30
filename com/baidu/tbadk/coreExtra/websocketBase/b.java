package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    private static class a {
        private static b aze = new b();
    }

    public static b BY() {
        return a.aze;
    }

    private b() {
    }

    public void BZ() {
        fv("kLCSError=1");
    }

    public void ez(int i) {
        fv("kNetStatus=" + i);
    }

    public void fu(String str) {
        fv("kNewIpResult=" + str);
    }

    private void fv(String str) {
        i.a("IpReconnLogHelper", 0, 0, (String) null, com.baidu.tbadk.core.f.TH, str);
    }
}
