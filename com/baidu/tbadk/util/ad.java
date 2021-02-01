package com.baidu.tbadk.util;

import android.net.Uri;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ad {
    private static final Pattern fNv = Pattern.compile("http[s]?://tieba\\.baidu\\.com/f(.*)&jump_tieba_native=1(.*)");
    private static final Pattern fNw = Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1");

    public static boolean DT(String str) {
        return DU(str) || DV(str) || DW(str);
    }

    private static boolean DU(String str) {
        if (au.isEmpty(str)) {
            return false;
        }
        return fNv.matcher(str.toLowerCase()).find();
    }

    private static boolean DV(String str) {
        if (au.isEmpty(str)) {
            return false;
        }
        return fNw.matcher(str.toLowerCase()).find();
    }

    private static boolean DW(String str) {
        if (au.isEmpty(str)) {
            return false;
        }
        return AlbumActivityConfig.FROM_PERSON.equalsIgnoreCase(Uri.parse(str).getAuthority());
    }

    public static boolean bFL() {
        if (com.baidu.tbadk.a.d.bjC()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.brQ().getLong("show_login_dialog_strategy_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date2 = new Date(currentTimeMillis);
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong("show_login_dialog_strategy_key", currentTimeMillis);
            return !be.c(date, date2);
        }
        return false;
    }
}
