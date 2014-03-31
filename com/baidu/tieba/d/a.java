package com.baidu.tieba.d;

import com.baidu.adp.lib.a.f;
import com.baidu.tieba.a.c;
import com.baidu.tieba.a.k;
import com.baidu.tieba.r;
import com.baidu.tieba.switchs.features.VoiceSwitchStatic;
/* loaded from: classes.dex */
public final class a {
    public static boolean a(String str, Boolean bool) {
        boolean z;
        if (f.a().b(VoiceSwitchStatic.VOICE) == 0) {
            if (str != null) {
                r.c();
                String[] stringArray = r.d().getResources().getStringArray(c.voice_black_frs_list);
                r.c();
                String string = r.d().getResources().getString(k.forum);
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
