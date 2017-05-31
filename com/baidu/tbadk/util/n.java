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
        l.gg(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gh;
        boolean gi;
        boolean ao;
        List list3;
        try {
            list2 = l.aIT;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gh = l.gh(str);
            if (gh) {
                return true;
            }
            gi = l.gi(str);
            if (gi) {
                return true;
            }
            ao = l.ao(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (ao) {
                return true;
            }
            list3 = l.aIT;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = l.aIT;
            list.add(str);
            return false;
        }
    }
}
