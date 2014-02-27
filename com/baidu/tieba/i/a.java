package com.baidu.tieba.i;

import com.baidu.adp.lib.a.d;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class a {
    public static boolean a(String str, Boolean bool) {
        boolean z;
        if (d.a().b(SwitchKey.VOICE) == 0) {
            if (str != null) {
                String[] stringArray = TiebaApplication.g().b().getResources().getStringArray(R.array.voice_black_frs_list);
                String string = TiebaApplication.g().b().getResources().getString(R.string.forum);
                int length = stringArray.length;
                for (int i = 0; i < length; i++) {
                    if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    return false;
                }
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
