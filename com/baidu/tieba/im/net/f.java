package com.baidu.tieba.im.net;

import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
public final class f {
    public static f a() {
        f fVar;
        fVar = g.a;
        return fVar;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(byte b) {
        this();
    }

    public final void b() {
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
        cb.b(str, "", "");
        com.baidu.adp.lib.util.e.e(str);
        com.baidu.tieba.log.a.b(str);
    }
}
