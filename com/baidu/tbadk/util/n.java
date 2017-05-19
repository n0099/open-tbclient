package com.baidu.tbadk.util;

import com.baidu.adp.lib.crash.BdNativeCrash;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes.dex */
class n implements BdNativeCrash.NativeCrashCallback {
    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public void onNativeCrashed(int i, int i2, int i3, String str, String str2) {
        y yVar = new y();
        Thread thread = new Thread();
        thread.setName("NativeCrashThread");
        yVar.a(thread, (Throwable) new Exception(str), true);
        l.gh(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gi;
        boolean gj;
        boolean ap;
        List list3;
        try {
            list2 = l.aJg;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gi = l.gi(str);
            if (gi) {
                return true;
            }
            gj = l.gj(str);
            if (gj) {
                return true;
            }
            ap = l.ap(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (ap) {
                return true;
            }
            list3 = l.aJg;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = l.aJg;
            list.add(str);
            return false;
        }
    }
}
