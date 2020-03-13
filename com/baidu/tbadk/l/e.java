package com.baidu.tbadk.l;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e dDf;
    private List<String> dDe;

    public static e aQU() {
        if (dDf == null) {
            synchronized (e.class) {
                if (dDf == null) {
                    dDf = new e();
                }
            }
        }
        return dDf;
    }

    public e() {
        vD(com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_need_add_source_stat_list", ""));
    }

    public void vC(String str) {
        this.dDe = vD(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_need_add_source_stat_list", str);
    }

    private List<String> vD(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    public boolean vE(String str) {
        if (v.isEmpty(this.dDe) || aq.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.dDe) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(an anVar) {
        Activity currentActivity;
        b ea;
        if (anVar != null && !anVar.tu("page_source") && vE(anVar.getKey()) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (ea = c.ea(currentActivity)) != null) {
            String currentPageKey = ea.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey)) {
                anVar.cy("page_key", currentPageKey);
            }
            String b = d.b(ea.aQR(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b)) {
                anVar.cy("page_source", b);
            }
        }
    }
}
