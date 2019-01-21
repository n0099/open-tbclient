package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private int exl;
    private int exm;
    private int exn = -1;
    private int exo;
    private int exp;
    private int exq;

    public a() {
        this.exl = -1;
        this.exm = -1;
        this.exo = -1;
        this.exp = -1;
        this.exq = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.exl = i == 0 ? 0 : 1;
        this.exm = i == 0 ? 1 : 0;
        this.exq = i != 0 ? 0 : 1;
        int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        this.exo = i2 == 0 ? 2 : -1;
        this.exp = i2 != 0 ? 2 : -1;
    }

    public int oQ(int i) {
        switch (i) {
            case 0:
                return this.exl;
            case 1:
                return this.exm;
            case 2:
                return this.exn;
            case 3:
                return this.exo;
            case 4:
                return this.exp;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.exl) {
            return 0;
        }
        if (i == this.exm) {
            return 1;
        }
        if (i == this.exn) {
            return 2;
        }
        if (i == this.exo) {
            return 3;
        }
        if (i == this.exp) {
            return 4;
        }
        return -1;
    }

    public int aMb() {
        return this.exq;
    }

    public String p(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.exl) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(e.j.tab_name_concern);
            }
            return string;
        } else if (i == this.exm) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(e.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.exn) {
            return context.getString(e.j.tab_name_discover);
        } else {
            if (i == this.exo) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(e.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.exp) {
                String string4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_daily", "");
                if (StringUtils.isNull(string4)) {
                    return context.getString(e.j.tab_name_daily);
                }
                return string4;
            } else {
                return null;
            }
        }
    }
}
