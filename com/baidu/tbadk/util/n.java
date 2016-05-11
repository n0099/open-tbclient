package com.baidu.tbadk.util;

import com.baidu.adp.lib.crash.BdNativeCrash;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes.dex */
class n implements BdNativeCrash.NativeCrashCallback {
    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public void onNativeCrashed(int i, int i2, int i3, String str) {
        v vVar = new v();
        Thread thread = new Thread();
        thread.setName("NativeCrashThread");
        vVar.a(thread, (Throwable) new Exception(str), true);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gl;
        boolean gm;
        boolean aq;
        List list3;
        try {
            list2 = l.aAc;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gl = l.gl(str);
            if (gl) {
                return true;
            }
            gm = l.gm(str);
            if (gm) {
                return true;
            }
            aq = l.aq(str, TbadkCoreApplication.m11getInst().getApp().getApplicationInfo().sourceDir);
            if (aq) {
                return true;
            }
            list3 = l.aAc;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = l.aAc;
            list.add(str);
            return false;
        }
    }
}
