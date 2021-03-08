package com.baidu.tbadk.pageExtra;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f fKi;
    private List<String> fKg = Dy(com.baidu.tbadk.core.sharedPref.b.brR().getString("key_need_add_source_stat_list", ""));
    private List<String> fKh = Dy("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static f bDR() {
        if (fKi == null) {
            synchronized (f.class) {
                if (fKi == null) {
                    fKi = new f();
                }
            }
        }
        return fKi;
    }

    public void Dx(String str) {
        this.fKg = Dy(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.brR().putString("key_need_add_source_stat_list", str);
    }

    private List<String> Dy(String str) {
        if (au.isEmpty(str)) {
            return null;
        }
        return q(str.split(","));
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

    public boolean Dz(String str) {
        if (y.isEmpty(this.fKh) || au.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.fKh) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean DA(String str) {
        if (y.isEmpty(this.fKg) || au.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.fKg) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(ar arVar) {
        if (arVar != null && !arVar.Bj("page_source")) {
            if (DA(arVar.getKey()) || Dz(arVar.getKey())) {
                d(arVar);
            }
        }
    }

    private void d(ar arVar) {
        Activity currentActivity;
        c fp;
        if (arVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (fp = d.fp(currentActivity)) != null) {
            String currentPageKey = fp.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !arVar.Bj("page_key")) {
                arVar.dR("page_key", currentPageKey);
            }
            String b = e.b(fp.bDN(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !arVar.Bj("page_source")) {
                arVar.dR("page_source", b);
            }
            d.printLog(arVar.toString());
        }
    }

    public static void a(Context context, ar arVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && arVar != null && !TextUtils.isEmpty(arVar.getKey())) {
            c tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = d.fp(context);
            }
            if (tbPageExtra != null && !tbPageExtra.isDirtyData()) {
                a(arVar, tbPageExtra);
            }
            d.printLog(arVar.toString());
        }
    }

    public static void a(ar arVar, c cVar) {
        if (arVar != null && cVar != null && !TextUtils.isEmpty(arVar.getKey())) {
            String currentPageKey = cVar.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !arVar.Bj("page_key")) {
                arVar.dR("page_key", currentPageKey);
            }
            String b = e.b(cVar.bDN(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !arVar.Bj("page_source")) {
                arVar.dR("page_source", b);
            }
        }
    }
}
