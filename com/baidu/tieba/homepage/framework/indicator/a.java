package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a {
    private int fJA;
    private int fJB = 1;
    private int fJw;
    private int fJx;
    private int fJy;
    private int fJz;

    public a() {
        int i = 1;
        this.fJw = -1;
        this.fJx = -1;
        this.fJy = -1;
        this.fJz = -1;
        this.fJA = -1;
        this.fJw = 0;
        int bmb = bmb();
        if ((bmb & 16) > 0) {
            this.fJz = 1;
            i = 2;
        }
        if ((bmb & 32) > 0) {
            this.fJA = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        if ((bmb & 1) > 0) {
            this.fJx = i2 == 0 ? i : -1;
            this.fJy = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int sv(int i) {
        switch (i) {
            case 1:
                return this.fJw;
            case 2:
            default:
                return -1;
            case 3:
                return this.fJx;
            case 4:
                return this.fJy;
            case 5:
                return this.fJz;
            case 6:
                return this.fJA;
        }
    }

    public int getType(int i) {
        if (i == this.fJw) {
            return 1;
        }
        if (i == this.fJx) {
            return 3;
        }
        if (i == this.fJy) {
            return 4;
        }
        if (i == this.fJz) {
            return 5;
        }
        if (i == this.fJA) {
            return 6;
        }
        return -1;
    }

    public int bma() {
        return this.fJB;
    }

    private int bmb() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 23);
    }

    public String v(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.fJw) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string)) {
                return context.getString(d.j.tab_name_recommend);
            }
            return string;
        } else if (i == this.fJx) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(d.j.tab_name_video_recommend);
            }
            return string2;
        } else if (i == this.fJy) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_daily", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(d.j.tab_name_daily);
            }
            return string3;
        } else if (i == this.fJz) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_topic", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(d.j.tab_name_topic);
            }
            return string4;
        } else if (i == this.fJA) {
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
