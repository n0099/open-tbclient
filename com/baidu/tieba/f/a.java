package com.baidu.tieba.f;

import com.baidu.adp.lib.a.d;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a {
    private static boolean a(String str) {
        String[] stringArray = TiebaApplication.h().getResources().getStringArray(R.array.voice_black_frs_list);
        String string = TiebaApplication.h().getResources().getString(R.string.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(stringArray[i] + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Boolean bool) {
        if (d.a().b(SwitchKey.VOICE) == 0) {
            if ((str == null || !a(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
