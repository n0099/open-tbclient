package com.baidu.tieba.c;

import com.baidu.adp.lib.a.f;
import com.baidu.tieba.ad;
import com.baidu.tieba.m;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a {
    private static boolean a(String str) {
        String[] stringArray = ad.c().d().getResources().getStringArray(m.voice_black_frs_list);
        String string = ad.c().d().getResources().getString(u.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Boolean bool) {
        if (f.a().b("voice") == 0) {
            if ((str == null || !a(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
