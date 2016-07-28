package com.baidu.tbadk.util;

import com.baidu.adp.lib.crash.BdNativeCrash;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes.dex */
class n implements BdNativeCrash.NativeCrashCallback {
    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public void onNativeCrashed(int i, int i2, int i3, String str, String str2) {
        w wVar = new w();
        Thread thread = new Thread();
        thread.setName("NativeCrashThread");
        wVar.a(thread, (Throwable) new Exception(str), true);
        l.gp(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gq;
        boolean gr;
        boolean aq;
        List list3;
        try {
            list2 = l.aBK;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gq = l.gq(str);
            if (gq) {
                return true;
            }
            gr = l.gr(str);
            if (gr) {
                return true;
            }
            aq = l.aq(str, TbadkCoreApplication.m10getInst().getApp().getApplicationInfo().sourceDir);
            if (aq) {
                return true;
            }
            list3 = l.aBK;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = l.aBK;
            list.add(str);
            return false;
        }
    }
}
