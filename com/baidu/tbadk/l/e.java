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
    private static e eUa;
    private List<String> eTY = CO(com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_need_add_source_stat_list", ""));
    private List<String> eTZ = CO("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static e bva() {
        if (eUa == null) {
            synchronized (e.class) {
                if (eUa == null) {
                    eUa = new e();
                }
            }
        }
        return eUa;
    }

    public void CN(String str) {
        this.eTY = CO(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_need_add_source_stat_list", str);
    }

    private List<String> CO(String str) {
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

    public boolean CP(String str) {
        if (y.isEmpty(this.eTZ) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eTZ) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean CQ(String str) {
        if (y.isEmpty(this.eTY) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eTY) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(aq aqVar) {
        if (aqVar != null && !aqVar.Az("page_source")) {
            if (CQ(aqVar.getKey()) || CP(aqVar.getKey())) {
                d(aqVar);
            }
        }
    }

    private void d(aq aqVar) {
        Activity currentActivity;
        b ek;
        if (aqVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (ek = c.ek(currentActivity)) != null) {
            String currentPageKey = ek.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.Az("page_key")) {
                aqVar.dF("page_key", currentPageKey);
            }
            String b = d.b(ek.buW(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aqVar.Az("page_source")) {
                aqVar.dF("page_source", b);
            }
            c.printLog(aqVar.toString());
        }
    }

    public static void a(Context context, aq aqVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && aqVar != null && !TextUtils.isEmpty(aqVar.getKey())) {
            b tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = c.ek(context);
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
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.Az("page_key")) {
                aqVar.dF("page_key", currentPageKey);
            }
            String b = d.b(bVar.buW(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aqVar.Az("page_source")) {
                aqVar.dF("page_source", b);
            }
        }
    }
}
