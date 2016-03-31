package com.baidu.tieba.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a aYc;
    private HashMap<String, Integer> aYd = new HashMap<>();
    private HashMap<String, String> aYe = new HashMap<>();
    private String aYf;

    public static synchronized a Mw() {
        a aVar;
        synchronized (a.class) {
            if (aYc == null) {
                aYc = new a();
            }
            aVar = aYc;
        }
        return aVar;
    }

    private a() {
        MA();
        this.aYf = ay.ww();
    }

    public boolean Mx() {
        Date handleDate = StringUtils.handleDate("2016-02-07 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-08 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.vk().getBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, false);
    }

    public boolean My() {
        Date handleDate = StringUtils.handleDate("2016-02-09 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-14 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.vk().getBoolean(this.aYf, false);
    }

    public Integer Mz() {
        Integer num = this.aYd.get(this.aYf);
        if (num == null || b.vk().getBoolean(this.aYf, false)) {
            return 0;
        }
        return Integer.valueOf(num.intValue());
    }

    private void MA() {
        this.aYd.put("2016-02-09", Integer.valueOf(t.f.custom_ad_1));
        this.aYd.put("2016-02-10", Integer.valueOf(t.f.custom_ad_2));
        this.aYd.put("2016-02-11", Integer.valueOf(t.f.custom_ad_3));
        this.aYd.put("2016-02-13", Integer.valueOf(t.f.custom_ad_5));
        this.aYe.put("2016-02-09", "444");
        this.aYe.put("2016-02-10", "445");
        this.aYe.put("2016-02-11", "446");
        this.aYe.put("2016-02-13", "448");
    }

    public void MB() {
        b.vk().putBoolean(this.aYf, true);
    }

    public void MC() {
        b.vk().putBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, true);
    }

    public String MD() {
        return this.aYe.get(this.aYf);
    }
}
