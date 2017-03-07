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
        k.gd(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean ge;
        boolean gf;
        boolean ao;
        List list3;
        try {
            list2 = k.aIM;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            ge = k.ge(str);
            if (ge) {
                return true;
            }
            gf = k.gf(str);
            if (gf) {
                return true;
            }
            ao = k.ao(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (ao) {
                return true;
            }
            list3 = k.aIM;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = k.aIM;
            list.add(str);
            return false;
        }
    }
}
