package com.baidu.tieba.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static a aUq;
    private HashMap<String, Integer> aUr = new HashMap<>();
    private HashMap<String, String> aUs = new HashMap<>();
    private String aUt;

    public static synchronized a Lb() {
        a aVar;
        synchronized (a.class) {
            if (aUq == null) {
                aUq = new a();
            }
            aVar = aUq;
        }
        return aVar;
    }

    private a() {
        Lg();
        this.aUt = aw.wd();
    }

    public boolean Ld() {
        Date handleDate = StringUtils.handleDate("2016-02-07 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-08 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.uO().getBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, false);
    }

    public boolean Le() {
        Date handleDate = StringUtils.handleDate("2016-02-09 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date handleDate2 = StringUtils.handleDate("2016-02-14 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return date.getTime() - handleDate.getTime() >= 0 && handleDate2.getTime() - date.getTime() >= 0 && !b.uO().getBoolean(this.aUt, false);
    }

    public Integer Lf() {
        Integer num = this.aUr.get(this.aUt);
        if (num == null || b.uO().getBoolean(this.aUt, false)) {
            return 0;
        }
        return Integer.valueOf(num.intValue());
    }

    private void Lg() {
        this.aUr.put("2016-02-09", Integer.valueOf(t.f.custom_ad_1));
        this.aUr.put("2016-02-10", Integer.valueOf(t.f.custom_ad_2));
        this.aUr.put("2016-02-11", Integer.valueOf(t.f.custom_ad_3));
        this.aUr.put("2016-02-13", Integer.valueOf(t.f.custom_ad_5));
        this.aUs.put("2016-02-09", "444");
        this.aUs.put("2016-02-10", "445");
        this.aUs.put("2016-02-11", "446");
        this.aUs.put("2016-02-13", "448");
    }

    public void Lh() {
        b.uO().putBoolean(this.aUt, true);
    }

    public void Li() {
        b.uO().putBoolean(GuildActivityConfig.CUSTOM_GUIDE_SHOWED, true);
    }

    public String Lj() {
        return this.aUs.get(this.aUt);
    }
}
