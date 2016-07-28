package com.baidu.tieba.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ba;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a aYp;
    private HashMap<String, Integer> aYq = new HashMap<>();
    private HashMap<String, String> aYr = new HashMap<>();
    private String aYs;

    public static synchronized a Md() {
        a aVar;
        synchronized (a.class) {
            if (aYp == null) {
                aYp = new a();
            }
            aVar = aYp;
        }
        return aVar;
    }

    private a() {
        Mh();
        this.aYs = ba.ub();
    }

    public boolean Me() {
        Date handleDate = StringUtils.handleDate("2016-02-07 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-08 23:59:59", "yyyy-MM-dd HH:mm:ss");
        if (handleDate == null || handleDate2 == null) {
            return false;
        }
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.sN().getBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, false);
    }

    public boolean Mf() {
        Date handleDate = StringUtils.handleDate("2016-02-09 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-14 23:59:59", "yyyy-MM-dd HH:mm:ss");
        if (handleDate == null || handleDate2 == null) {
            return false;
        }
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.sN().getBoolean(this.aYs, false);
    }

    public Integer Mg() {
        Integer num = this.aYq.get(this.aYs);
        if (num == null || b.sN().getBoolean(this.aYs, false)) {
            return 0;
        }
        return Integer.valueOf(num.intValue());
    }

    private void Mh() {
        this.aYr.put("2016-02-09", "444");
        this.aYr.put("2016-02-10", "445");
        this.aYr.put("2016-02-11", "446");
        this.aYr.put("2016-02-13", "448");
    }

    public void Mi() {
        b.sN().putBoolean(this.aYs, true);
    }

    public void Mj() {
        b.sN().putBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, true);
    }

    public String Mk() {
        return this.aYr.get(this.aYs);
    }
}
