package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private int gaA = 1;
    private int gau;
    private int gav;
    private int gaw;
    private int gax;
    private int gay;
    private int gaz;

    public a() {
        this.gau = -1;
        this.gav = -1;
        this.gaw = -1;
        this.gax = -1;
        this.gay = -1;
        this.gaz = -1;
        this.gau = 0;
        this.gav = 1;
        int i = 2;
        int bty = bty();
        if ((bty & 16) > 0) {
            this.gay = 2;
            i = 3;
        }
        if ((bty & 32) > 0) {
            this.gaz = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.agM().getInt("ribao_switch", 0);
        if ((bty & 1) > 0) {
            this.gaw = i2 == 0 ? i : -1;
            this.gax = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int tC(int i) {
        switch (i) {
            case 0:
                return this.gau;
            case 1:
                return this.gav;
            case 2:
            default:
                return -1;
            case 3:
                return this.gaw;
            case 4:
                return this.gax;
            case 5:
                return this.gay;
            case 6:
                return this.gaz;
        }
    }

    public int getType(int i) {
        if (i == this.gau) {
            return 0;
        }
        if (i == this.gav) {
            return 1;
        }
        if (i == this.gaw) {
            return 3;
        }
        if (i == this.gax) {
            return 4;
        }
        if (i == this.gay) {
            return 5;
        }
        if (i == this.gaz) {
            return 6;
        }
        return -1;
    }

    public int btx() {
        return this.gaA;
    }

    private int bty() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("recommend_tab_show", 23);
    }

    public String v(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.gau) {
            String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.gav) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.gaw) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_video", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string3;
        } else if (i == this.gax) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_daily", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_daily);
            }
            return string4;
        } else if (i == this.gay) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_topic", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string5;
        } else if (i == this.gaz) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_live", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_live);
            }
            return string6;
        } else {
            return null;
        }
    }
}
