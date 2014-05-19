package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class e {
    public static e a() {
        e eVar;
        eVar = f.a;
        return eVar;
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(e eVar) {
        this();
    }

    public void b() {
        c("kLCSError=1");
    }

    public void a(int i) {
        c("kNetStatus=" + i);
    }

    public void a(int i, String str) {
        c("kPingStatus=" + i + "; kPingIp=" + str);
    }

    public void a(String str) {
        c("kNewIpAvaliable=" + str);
    }

    public void b(String str) {
        c("kNewIpResult=" + str);
    }

    private void c(String str) {
        TiebaStatic.imLog(str, "", "");
        BdLog.d(str);
        com.baidu.tbadk.core.log.a.b(str);
    }
}
