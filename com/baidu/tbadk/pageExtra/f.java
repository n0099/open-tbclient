package com.baidu.tbadk.pageExtra;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f fGx;
    private List<String> fGv = Dc(com.baidu.tbadk.core.sharedPref.b.brx().getString("key_need_add_source_stat_list", ""));
    private List<String> fGw = Dc("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static f bDw() {
        if (fGx == null) {
            synchronized (f.class) {
                if (fGx == null) {
                    fGx = new f();
                }
            }
        }
        return fGx;
    }

    public void Db(String str) {
        this.fGv = Dc(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.brx().putString("key_need_add_source_stat_list", str);
    }

    private List<String> Dc(String str) {
        if (at.isEmpty(str)) {
            return null;
        }
        return r(str.split(","));
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

    public boolean Dd(String str) {
        if (x.isEmpty(this.fGw) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.fGw) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean De(String str) {
        if (x.isEmpty(this.fGv) || at.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.fGv) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(aq aqVar) {
        if (aqVar != null && !aqVar.AL("page_source")) {
            if (De(aqVar.getKey()) || Dd(aqVar.getKey())) {
                d(aqVar);
            }
        }
    }

    private void d(aq aqVar) {
        Activity currentActivity;
        c fr;
        if (aqVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (fr = d.fr(currentActivity)) != null) {
            String currentPageKey = fr.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.AL("page_key")) {
                aqVar.dW("page_key", currentPageKey);
            }
            String b2 = e.b(fr.bDs(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b2) && !aqVar.AL("page_source")) {
                aqVar.dW("page_source", b2);
            }
            d.printLog(aqVar.toString());
        }
    }

    public static void a(Context context, aq aqVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && aqVar != null && !TextUtils.isEmpty(aqVar.getKey())) {
            c tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = d.fr(context);
            }
            if (tbPageExtra != null && !tbPageExtra.isDirtyData()) {
                a(aqVar, tbPageExtra);
            }
            d.printLog(aqVar.toString());
        }
    }

    public static void a(aq aqVar, c cVar) {
        if (aqVar != null && cVar != null && !TextUtils.isEmpty(aqVar.getKey())) {
            String currentPageKey = cVar.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !aqVar.AL("page_key")) {
                aqVar.dW("page_key", currentPageKey);
            }
            String b2 = e.b(cVar.bDs(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b2) && !aqVar.AL("page_source")) {
                aqVar.dW("page_source", b2);
            }
        }
    }
}
