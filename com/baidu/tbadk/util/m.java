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
        k.gw(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gx;
        boolean gy;
        boolean ar;
        List list3;
        try {
            list2 = k.aFf;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gx = k.gx(str);
            if (gx) {
                return true;
            }
            gy = k.gy(str);
            if (gy) {
                return true;
            }
            ar = k.ar(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (ar) {
                return true;
            }
            list3 = k.aFf;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = k.aFf;
            list.add(str);
            return false;
        }
    }
}
