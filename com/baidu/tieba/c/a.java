package com.baidu.tieba.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a aXr;
    private HashMap<String, Integer> aXs = new HashMap<>();
    private HashMap<String, String> aXt = new HashMap<>();
    private String aXu;

    public static synchronized a Me() {
        a aVar;
        synchronized (a.class) {
            if (aXr == null) {
                aXr = new a();
            }
            aVar = aXr;
        }
        return aVar;
    }

    private a() {
        Mi();
        this.aXu = ba.uc();
    }

    public boolean Mf() {
        Date handleDate = StringUtils.handleDate("2016-02-07 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-08 23:59:59", "yyyy-MM-dd HH:mm:ss");
        if (handleDate == null || handleDate2 == null) {
            return false;
        }
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.sO().getBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, false);
    }

    public boolean Mg() {
        Date handleDate = StringUtils.handleDate("2016-02-09 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-14 23:59:59", "yyyy-MM-dd HH:mm:ss");
        if (handleDate == null || handleDate2 == null) {
            return false;
        }
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.sO().getBoolean(this.aXu, false);
    }

    public Integer Mh() {
        Integer num = this.aXs.get(this.aXu);
        if (num == null || b.sO().getBoolean(this.aXu, false)) {
            return 0;
        }
        return Integer.valueOf(num.intValue());
    }

    private void Mi() {
        this.aXs.put("2016-02-09", Integer.valueOf(u.f.custom_ad_1));
        this.aXs.put("2016-02-10", Integer.valueOf(u.f.custom_ad_2));
        this.aXs.put("2016-02-11", Integer.valueOf(u.f.custom_ad_3));
        this.aXs.put("2016-02-13", Integer.valueOf(u.f.custom_ad_5));
        this.aXt.put("2016-02-09", "444");
        this.aXt.put("2016-02-10", "445");
        this.aXt.put("2016-02-11", "446");
        this.aXt.put("2016-02-13", "448");
    }

    public void Mj() {
        b.sO().putBoolean(this.aXu, true);
    }

    public void Mk() {
        b.sO().putBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, true);
    }

    public String Ml() {
        return this.aXt.get(this.aXu);
    }
}
