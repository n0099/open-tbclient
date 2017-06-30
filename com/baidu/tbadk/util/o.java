package com.baidu.tbadk.util;

import com.baidu.adp.lib.crash.BdNativeCrash;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes.dex */
class o implements BdNativeCrash.NativeCrashCallback {
    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public void onNativeCrashed(int i, int i2, int i3, String str, String str2) {
        z zVar = new z();
        Thread thread = new Thread();
        thread.setName("NativeCrashThread");
        zVar.a(thread, (Throwable) new Exception(str), true);
        m.gB(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gC;
        boolean gD;
        boolean ao;
        List list3;
        try {
            list2 = m.aKi;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gC = m.gC(str);
            if (gC) {
                return true;
            }
            gD = m.gD(str);
            if (gD) {
                return true;
            }
            ao = m.ao(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (ao) {
                return true;
            }
            list3 = m.aKi;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = m.aKi;
            list.add(str);
            return false;
        }
    }
}
