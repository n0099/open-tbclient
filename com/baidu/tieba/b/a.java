package com.baidu.tieba.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a aTW;
    private HashMap<String, Integer> aTX = new HashMap<>();
    private HashMap<String, String> aTY = new HashMap<>();
    private String aTZ;

    public static synchronized a Lf() {
        a aVar;
        synchronized (a.class) {
            if (aTW == null) {
                aTW = new a();
            }
            aVar = aTW;
        }
        return aVar;
    }

    private a() {
        Lj();
        this.aTZ = ay.uc();
    }

    public boolean Lg() {
        Date handleDate = StringUtils.handleDate("2016-02-07 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-08 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.sQ().getBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, false);
    }

    public boolean Lh() {
        Date handleDate = StringUtils.handleDate("2016-02-09 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-14 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.sQ().getBoolean(this.aTZ, false);
    }

    public Integer Li() {
        Integer num = this.aTX.get(this.aTZ);
        if (num == null || b.sQ().getBoolean(this.aTZ, false)) {
            return 0;
        }
        return Integer.valueOf(num.intValue());
    }

    private void Lj() {
        this.aTX.put("2016-02-09", Integer.valueOf(t.f.custom_ad_1));
        this.aTX.put("2016-02-10", Integer.valueOf(t.f.custom_ad_2));
        this.aTX.put("2016-02-11", Integer.valueOf(t.f.custom_ad_3));
        this.aTX.put("2016-02-13", Integer.valueOf(t.f.custom_ad_5));
        this.aTY.put("2016-02-09", "444");
        this.aTY.put("2016-02-10", "445");
        this.aTY.put("2016-02-11", "446");
        this.aTY.put("2016-02-13", "448");
    }

    public void Lk() {
        b.sQ().putBoolean(this.aTZ, true);
    }

    public void Ll() {
        b.sQ().putBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, true);
    }

    public String Lm() {
        return this.aTY.get(this.aTZ);
    }
}
