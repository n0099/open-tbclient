package com.baidu.tbadk.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e eGz;
    private List<String> eGx = Ab(com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_need_add_source_stat_list", ""));
    private List<String> eGy = Ab("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static e bli() {
        if (eGz == null) {
            synchronized (e.class) {
                if (eGz == null) {
                    eGz = new e();
                }
            }
        }
        return eGz;
    }

    public void Aa(String str) {
        this.eGx = Ab(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_need_add_source_stat_list", str);
    }

    private List<String> Ab(String str) {
        if (as.isEmpty(str)) {
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

    public boolean Ac(String str) {
        if (x.isEmpty(this.eGy) || as.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eGy) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean Ad(String str) {
        if (x.isEmpty(this.eGx) || as.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eGx) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(ap apVar) {
        if (apVar != null && !apVar.xO("page_source")) {
            if (Ad(apVar.getKey()) || Ac(apVar.getKey())) {
                d(apVar);
            }
        }
    }

    private void d(ap apVar) {
        Activity currentActivity;
        b dZ;
        if (apVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (dZ = c.dZ(currentActivity)) != null) {
            String currentPageKey = dZ.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !apVar.xO("page_key")) {
                apVar.dn("page_key", currentPageKey);
            }
            String b = d.b(dZ.ble(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !apVar.xO("page_source")) {
                apVar.dn("page_source", b);
            }
            c.printLog(apVar.toString());
        }
    }

    public static void a(Context context, ap apVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && apVar != null && !TextUtils.isEmpty(apVar.getKey())) {
            b tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = c.dZ(context);
            }
            if (tbPageExtra != null && !tbPageExtra.isDirtyData()) {
                a(apVar, tbPageExtra);
            }
            c.printLog(apVar.toString());
        }
    }

    public static void a(ap apVar, b bVar) {
        if (apVar != null && bVar != null && !TextUtils.isEmpty(apVar.getKey())) {
            String currentPageKey = bVar.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !apVar.xO("page_key")) {
                apVar.dn("page_key", currentPageKey);
            }
            String b = d.b(bVar.ble(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !apVar.xO("page_source")) {
                apVar.dn("page_source", b);
            }
        }
    }
}
