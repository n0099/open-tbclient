package com.baidu.tieba.e;

import com.baidu.adp.lib.a.f;
import com.baidu.tieba.ai;
import com.baidu.tieba.p;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class b {
    private static boolean a(String str) {
        String[] stringArray = ai.c().d().getResources().getStringArray(p.voice_black_frs_list);
        String string = ai.c().d().getResources().getString(x.forum);
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
