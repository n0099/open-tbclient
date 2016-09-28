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
        l.gw(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gx;
        boolean gy;
        boolean aq;
        List list3;
        try {
            list2 = l.aEp;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gx = l.gx(str);
            if (gx) {
                return true;
            }
            gy = l.gy(str);
            if (gy) {
                return true;
            }
            aq = l.aq(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (aq) {
                return true;
            }
            list3 = l.aEp;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = l.aEp;
            list.add(str);
            return false;
        }
    }
}
