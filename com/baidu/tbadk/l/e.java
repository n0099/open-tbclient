package com.baidu.tbadk.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e foH;
    private List<String> foF = DT(com.baidu.tbadk.core.sharedPref.b.bnH().getString("key_need_add_source_stat_list", ""));
    private List<String> foG = DT("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static e bzD() {
        if (foH == null) {
            synchronized (e.class) {
                if (foH == null) {
                    foH = new e();
                }
            }
        }
        return foH;
    }

    public void DS(String str) {
        this.foF = DT(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_need_add_source_stat_list", str);
    }

    private List<String> DT(String str) {
        if (at.isEmpty(str)) {
            return null;
        }
        return q(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    private <T> List<T> q(T[] tArr) {
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

    public boolean DU(String str) {
        if (y.isEmpty(this.foG) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.foG) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean DV(String str) {
        if (y.isEmpty(this.foF) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.foF) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(aq aqVar) {
        if (aqVar != null && !aqVar.BE("page_source")) {
            if (DV(aqVar.getKey()) || DU(aqVar.getKey())) {
                d(aqVar);
            }
        }
    }

    private void d(aq aqVar) {
        Activity currentActivity;
        b er;
        if (aqVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (er = c.er(currentActivity)) != null) {
            String currentPageKey = er.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.BE("page_key")) {
                aqVar.dR("page_key", currentPageKey);
            }
            String b = d.b(er.bzz(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aqVar.BE("page_source")) {
                aqVar.dR("page_source", b);
            }
            c.printLog(aqVar.toString());
        }
    }

    public static void a(Context context, aq aqVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && aqVar != null && !TextUtils.isEmpty(aqVar.getKey())) {
            b tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = c.er(context);
            }
            if (tbPageExtra != null && !tbPageExtra.isDirtyData()) {
                a(aqVar, tbPageExtra);
            }
            c.printLog(aqVar.toString());
        }
    }

    public static void a(aq aqVar, b bVar) {
        if (aqVar != null && bVar != null && !TextUtils.isEmpty(aqVar.getKey())) {
            String currentPageKey = bVar.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.BE("page_key")) {
                aqVar.dR("page_key", currentPageKey);
            }
            String b = d.b(bVar.bzz(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aqVar.BE("page_source")) {
                aqVar.dR("page_source", b);
            }
        }
    }
}
