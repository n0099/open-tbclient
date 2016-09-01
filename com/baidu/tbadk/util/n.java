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
        l.gs(str2);
    }

    @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
    public boolean onSoFound(String str) {
        List list;
        List list2;
        boolean gt;
        boolean gu;
        boolean aq;
        List list3;
        try {
            list2 = l.aER;
            if (list2.indexOf(str) >= 0) {
                return false;
            }
            gt = l.gt(str);
            if (gt) {
                return true;
            }
            gu = l.gu(str);
            if (gu) {
                return true;
            }
            aq = l.aq(str, TbadkCoreApplication.m9getInst().getApp().getApplicationInfo().sourceDir);
            if (aq) {
                return true;
            }
            list3 = l.aER;
            list3.add(str);
            return false;
        } catch (Throwable th) {
            list = l.aER;
            list.add(str);
            return false;
        }
    }
}
