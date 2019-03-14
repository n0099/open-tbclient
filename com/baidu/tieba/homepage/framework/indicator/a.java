package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a {
    private int fJI;
    private int fJJ;
    private int fJK;
    private int fJL;
    private int fJM;
    private int fJN = 1;

    public a() {
        int i = 1;
        this.fJI = -1;
        this.fJJ = -1;
        this.fJK = -1;
        this.fJL = -1;
        this.fJM = -1;
        this.fJI = 0;
        int bme = bme();
        if ((bme & 16) > 0) {
            this.fJL = 1;
            i = 2;
        }
        if ((bme & 32) > 0) {
            this.fJM = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        if ((bme & 1) > 0) {
            this.fJJ = i2 == 0 ? i : -1;
            this.fJK = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int sz(int i) {
        switch (i) {
            case 1:
                return this.fJI;
            case 2:
            default:
                return -1;
            case 3:
                return this.fJJ;
            case 4:
                return this.fJK;
            case 5:
                return this.fJL;
            case 6:
                return this.fJM;
        }
    }

    public int getType(int i) {
        if (i == this.fJI) {
            return 1;
        }
        if (i == this.fJJ) {
            return 3;
        }
        if (i == this.fJK) {
            return 4;
        }
        if (i == this.fJL) {
            return 5;
        }
        if (i == this.fJM) {
            return 6;
        }
        return -1;
    }

    public int bmd() {
        return this.fJN;
    }

    private int bme() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 23);
    }

    public String v(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.fJI) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string)) {
                return context.getString(d.j.tab_name_recommend);
            }
            return string;
        } else if (i == this.fJJ) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(d.j.tab_name_video_recommend);
            }
            return string2;
        } else if (i == this.fJK) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_daily", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(d.j.tab_name_daily);
            }
            return string3;
        } else if (i == this.fJL) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_topic", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(d.j.tab_name_topic);
            }
            return string4;
        } else if (i == this.fJM) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_live", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(d.j.tab_name_live);
            }
            return string5;
        } else {
            return null;
        }
    }
}
