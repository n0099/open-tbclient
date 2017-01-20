package com.baidu.tbadk.util;

import com.baidu.adp.lib.crash.BdNativeCrash;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes.dex */
class m implements BdNativeCrash.NativeCrashCallback {
    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public void onNativeCrashed(int i, int i2, int i3, String str, String str2) {
        v vVar = new v();
        Thread thread = new Thread();
        thread.setName("NativeCrashThread");
        vVar.a(thread, (Throwable) new Exception(str), true);
        k.go(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gp;
        boolean gq;
        boolean ar;
        List list3;
        try {
            list2 = k.aDp;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gp = k.gp(str);
            if (gp) {
                return true;
            }
            gq = k.gq(str);
            if (gq) {
                return true;
            }
            ar = k.ar(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (ar) {
                return true;
            }
            list3 = k.aDp;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = k.aDp;
            list.add(str);
            return false;
        }
    }
}
