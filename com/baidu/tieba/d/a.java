package com.baidu.tieba.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ba;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a bei;
    private HashMap<String, Integer> bej = new HashMap<>();
    private HashMap<String, String> bek = new HashMap<>();
    private String bel;

    public static synchronized a OI() {
        a aVar;
        synchronized (a.class) {
            if (bei == null) {
                bei = new a();
            }
            aVar = bei;
        }
        return aVar;
    }

    private a() {
        OM();
        this.bel = ba.vh();
    }

    public boolean OJ() {
        Date handleDate = StringUtils.handleDate("2016-02-07 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-08 23:59:59", "yyyy-MM-dd HH:mm:ss");
        if (handleDate == null || handleDate2 == null) {
            return false;
        }
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.tS().getBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, false);
    }

    public boolean OK() {
        Date handleDate = StringUtils.handleDate("2016-02-09 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-14 23:59:59", "yyyy-MM-dd HH:mm:ss");
        if (handleDate == null || handleDate2 == null) {
            return false;
        }
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.tS().getBoolean(this.bel, false);
    }

    public Integer OL() {
        Integer num = this.bej.get(this.bel);
        if (num == null || b.tS().getBoolean(this.bel, false)) {
            return 0;
        }
        return Integer.valueOf(num.intValue());
    }

    private void OM() {
        this.bek.put("2016-02-09", "444");
        this.bek.put("2016-02-10", "445");
        this.bek.put("2016-02-11", "446");
        this.bek.put("2016-02-13", "448");
    }

    public void ON() {
        b.tS().putBoolean(this.bel, true);
    }

    public void OO() {
        b.tS().putBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, true);
    }

    public String OP() {
        return this.bek.get(this.bel);
    }
}
