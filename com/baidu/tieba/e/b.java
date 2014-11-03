package com.baidu.tieba.e;

import com.baidu.adp.lib.b.f;
import com.baidu.tieba.aj;
import com.baidu.tieba.q;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b {
    private static boolean hv(String str) {
        String[] stringArray = aj.wm().getApp().getResources().getStringArray(q.voice_black_frs_list);
        String string = aj.wm().getApp().getResources().getString(y.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, Boolean bool) {
        if (f.db().U("voice") == 0) {
            if ((str == null || !hv(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
