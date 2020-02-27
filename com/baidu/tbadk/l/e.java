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
    private static e dCR;
    private List<String> dCQ;

    public static e aQR() {
        if (dCR == null) {
            synchronized (e.class) {
                if (dCR == null) {
                    dCR = new e();
                }
            }
        }
        return dCR;
    }

    public e() {
        vC(com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_need_add_source_stat_list", ""));
    }

    public void vB(String str) {
        this.dCQ = vC(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.aFB().putString("key_need_add_source_stat_list", str);
    }

    private List<String> vC(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    public boolean vD(String str) {
        if (v.isEmpty(this.dCQ) || aq.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.dCQ) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(an anVar) {
        Activity currentActivity;
        b ea;
        if (anVar != null && !anVar.tu("page_source") && vD(anVar.getKey()) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (ea = c.ea(currentActivity)) != null) {
            String currentPageKey = ea.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey)) {
                anVar.cy("page_key", currentPageKey);
            }
            String b = d.b(ea.aQO(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b)) {
                anVar.cy("page_source", b);
            }
        }
    }
}
