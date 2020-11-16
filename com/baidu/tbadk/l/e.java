package com.baidu.tbadk.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e ftM;
    private List<String> ftK = DG(com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_need_add_source_stat_list", ""));
    private List<String> ftL = DG("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static e bBs() {
        if (ftM == null) {
            synchronized (e.class) {
                if (ftM == null) {
                    ftM = new e();
                }
            }
        }
        return ftM;
    }

    public void DF(String str) {
        this.ftK = DG(str);
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_need_add_source_stat_list", str);
    }

    private List<String> DG(String str) {
        if (au.isEmpty(str)) {
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

    public boolean DH(String str) {
        if (y.isEmpty(this.ftL) || au.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.ftL) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean DI(String str) {
        if (y.isEmpty(this.ftK) || au.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.ftK) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(ar arVar) {
        if (arVar != null && !arVar.Br("page_source")) {
            if (DI(arVar.getKey()) || DH(arVar.getKey())) {
                d(arVar);
            }
        }
    }

    private void d(ar arVar) {
        Activity currentActivity;
        b er;
        if (arVar != null && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (er = c.er(currentActivity)) != null) {
            String currentPageKey = er.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !arVar.Br("page_key")) {
                arVar.dR("page_key", currentPageKey);
            }
            String b = d.b(er.bBo(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !arVar.Br("page_source")) {
                arVar.dR("page_source", b);
            }
            c.printLog(arVar.toString());
        }
    }

    public static void a(Context context, ar arVar, com.baidu.tbadk.m.d dVar) {
        if (dVar != null && arVar != null && !TextUtils.isEmpty(arVar.getKey())) {
            b tbPageExtra = dVar.getTbPageExtra();
            if (tbPageExtra == null || tbPageExtra.isDirtyData()) {
                tbPageExtra = c.er(context);
            }
            if (tbPageExtra != null && !tbPageExtra.isDirtyData()) {
                a(arVar, tbPageExtra);
            }
            c.printLog(arVar.toString());
        }
    }

    public static void a(ar arVar, b bVar) {
        if (arVar != null && bVar != null && !TextUtils.isEmpty(arVar.getKey())) {
            String currentPageKey = bVar.getCurrentPageKey();
            if (!TextUtils.isEmpty(currentPageKey) && !arVar.Br("page_key")) {
                arVar.dR("page_key", currentPageKey);
            }
            String b = d.b(bVar.bBo(), currentPageKey, 6);
            if (!TextUtils.isEmpty(b) && !arVar.Br("page_source")) {
                arVar.dR("page_source", b);
            }
        }
    }
}
