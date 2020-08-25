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
/* loaded from: classes2.dex */
public class e {
    private static e eRf;
    private List<String> eRd = Cr(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_need_add_source_stat_list", ""));
    private List<String> eRe = Cr("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static e btV() {
        if (eRf == null) {
            synchronized (e.class) {
                if (eRf == null) {
                    eRf = new e();
                }
            }
        }
        return eRf;
    }

    public void Cq(String str) {
        this.eRd = Cr(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putString("key_need_add_source_stat_list", str);
    }

    private List<String> Cr(String str) {
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

    public boolean Cs(String str) {
        if (y.isEmpty(this.eRe) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eRe) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean Ct(String str) {
        if (y.isEmpty(this.eRd) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.eRd) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(aq aqVar) {
        if (aqVar != null && !aqVar.Ac("page_source")) {
            if (Ct(aqVar.getKey()) || Cs(aqVar.getKey())) {
                d(aqVar);
            }
        }
    }

    private void d(aq aqVar) {
        Activity currentActivity;
        b ei;
        if (aqVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (ei = c.ei(currentActivity)) != null) {
            String currentPageKey = ei.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.Ac("page_key")) {
                aqVar.dD("page_key", currentPageKey);
            }
            String b = d.b(ei.btR(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aqVar.Ac("page_source")) {
                aqVar.dD("page_source", b);
            }
            c.printLog(aqVar.toString());
        }
    }

    public static void a(Context context, aq aqVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && aqVar != null && !TextUtils.isEmpty(aqVar.getKey())) {
            b tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = c.ei(context);
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
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.Ac("page_key")) {
                aqVar.dD("page_key", currentPageKey);
            }
            String b = d.b(bVar.btR(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !aqVar.Ac("page_source")) {
                aqVar.dD("page_source", b);
            }
        }
    }
}
