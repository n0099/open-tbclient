package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private int elA;
    private int elv;
    private int elw;
    private int elx;
    private int ely;
    private int elz;

    public a() {
        this.elv = -1;
        this.elw = -1;
        this.elx = -1;
        this.ely = -1;
        this.elz = -1;
        this.elA = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.elv = i == 0 ? 0 : 1;
        this.elw = i == 0 ? 1 : 0;
        this.elA = i != 0 ? 0 : 1;
        int aJA = aJA();
        int i2 = 2;
        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        if ((aJA & 1) > 0) {
            this.ely = i3 == 0 ? 2 : -1;
            this.elz = i3 != 0 ? 2 : -1;
            i2 = 3;
        }
        if ((aJA & 8) > 0) {
            this.elx = i2;
            int i4 = i2 + 1;
        }
    }

    public int nQ(int i) {
        switch (i) {
            case 0:
                return this.elv;
            case 1:
                return this.elw;
            case 2:
                return this.elx;
            case 3:
                return this.ely;
            case 4:
                return this.elz;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.elv) {
            return 0;
        }
        if (i == this.elw) {
            return 1;
        }
        if (i == this.elx) {
            return 2;
        }
        if (i == this.ely) {
            return 3;
        }
        if (i == this.elz) {
            return 4;
        }
        return -1;
    }

    public int aJz() {
        return this.elA;
    }

    private int aJA() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String p(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.elv) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(e.j.tab_name_concern);
            }
            return string;
        } else if (i == this.elw) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(e.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.elx) {
            return context.getString(e.j.tab_name_discover);
        } else {
            if (i == this.ely) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(e.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.elz) {
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
