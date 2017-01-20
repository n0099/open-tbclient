package com.baidu.tieba.e;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a bud;
    private DateFormat bue = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static synchronized a Tj() {
        a aVar;
        synchronized (a.class) {
            if (bud == null) {
                bud = new a();
            }
            aVar = bud;
        }
        return aVar;
    }

    public boolean Tk() {
        try {
            Date parse = this.bue.parse("2017-01-27 00:00:00");
            Date parse2 = this.bue.parse("2017-01-29 23:59:59");
            Date date = new Date(System.currentTimeMillis());
            if (date.getTime() - parse.getTime() < 0 || parse2.getTime() - date.getTime() < 0) {
                return false;
            }
            return new Date(b.tQ().getLong(GuildActivityConfig.CUSTOM_GUIDE_SHOWED_TIME, 0L)).getTime() - parse.getTime() < 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void Tl() {
        b.tQ().putLong(GuildActivityConfig.CUSTOM_GUIDE_SHOWED_TIME, System.currentTimeMillis());
    }
}
