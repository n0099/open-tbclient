package com.baidu.tbadk.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e eAj;
    private List<String> eAh = yU(com.baidu.tbadk.core.sharedPref.b.aVP().getString("key_need_add_source_stat_list", ""));
    private List<String> eAi = yU("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static e bhx() {
        if (eAj == null) {
            synchronized (e.class) {
                if (eAj == null) {
                    eAj = new e();
                }
            }
        }
        return eAj;
    }

    public void yT(String str) {
        this.eAh = yU(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_need_add_source_stat_list", str);
    }

    private List<String> yU(String str) {
        if (ar.isEmpty(str)) {
            return null;
        }
        return r(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    private <T> List<T> r(T[] tArr) {
        if (tArr == null || tArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            if (t != null && !TextUtils.isEmpty(t.toString())) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public boolean yV(String str) {
        if (w.isEmpty(this.eAi) || ar.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eAi) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean yW(String str) {
        if (w.isEmpty(this.eAh) || ar.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eAh) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(ao aoVar) {
        if (aoVar != null && !aoVar.wG("page_source")) {
            if (yW(aoVar.getKey()) || yV(aoVar.getKey())) {
                d(aoVar);
            }
        }
    }

    private void d(ao aoVar) {
        Activity currentActivity;
        b dU;
        if (aoVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (dU = c.dU(currentActivity)) != null) {
            String currentPageKey = dU.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aoVar.wG("page_key")) {
                aoVar.dk("page_key", currentPageKey);
            }
            String b = d.b(dU.bht(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aoVar.wG("page_source")) {
                aoVar.dk("page_source", b);
            }
            c.printLog(aoVar.toString());
        }
    }

    public static void a(Context context, ao aoVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && aoVar != null && !TextUtils.isEmpty(aoVar.getKey())) {
            b tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = c.dU(context);
            }
            if (tbPageExtra != null && !tbPageExtra.isDirtyData()) {
                a(aoVar, tbPageExtra);
            }
            c.printLog(aoVar.toString());
        }
    }

    public static void a(ao aoVar, b bVar) {
        if (aoVar != null && bVar != null && !TextUtils.isEmpty(aoVar.getKey())) {
            String currentPageKey = bVar.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aoVar.wG("page_key")) {
                aoVar.dk("page_key", currentPageKey);
            }
            String b = d.b(bVar.bht(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aoVar.wG("page_source")) {
                aoVar.dk("page_source", b);
            }
        }
    }
}
