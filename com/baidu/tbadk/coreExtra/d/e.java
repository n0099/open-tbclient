package com.baidu.tbadk.coreExtra.d;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public final class e {
    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(byte b) {
        this();
    }

    public final void a() {
        c("kLCSError=1");
    }

    public final void a(int i) {
        c("kNetStatus=" + i);
    }

    public final void a(int i, String str) {
        c("kPingStatus=" + i + "; kPingIp=" + str);
    }

    public final void a(String str) {
        c("kNewIpAvaliable=" + str);
    }

    public final void b(String str) {
        c("kNewIpResult=" + str);
    }

    private static void c(String str) {
        TiebaStatic.b(str, "", "");
        com.baidu.adp.lib.util.f.e(str);
        com.baidu.tbadk.core.log.a.b(str);
    }
}
