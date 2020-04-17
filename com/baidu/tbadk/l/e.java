package com.baidu.tbadk.l;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e eda;
    private List<String> ecY = wS(com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_need_add_source_stat_list", ""));
    private List<String> ecZ = wS("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,stime,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static e aZi() {
        if (eda == null) {
            synchronized (e.class) {
                if (eda == null) {
                    eda = new e();
                }
            }
        }
        return eda;
    }

    public void wR(String str) {
        this.ecY = wS(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_need_add_source_stat_list", str);
    }

    private List<String> wS(String str) {
        if (aq.isEmpty(str)) {
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

    public boolean wT(String str) {
        if (v.isEmpty(this.ecZ) || aq.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.ecZ) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean wU(String str) {
        if (v.isEmpty(this.ecY) || aq.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.ecY) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(an anVar) {
        if (anVar != null && !anVar.uH("page_source")) {
            if (wU(anVar.getKey()) || wT(anVar.getKey())) {
                d(anVar);
            }
        }
    }

    private void d(an anVar) {
        Activity currentActivity;
        b dN;
        if (anVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (dN = c.dN(currentActivity)) != null) {
            String currentPageKey = dN.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey)) {
                anVar.cI("page_key", currentPageKey);
            }
            String b = d.b(dN.aZf(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b)) {
                anVar.cI("page_source", b);
            }
        }
    }
}
