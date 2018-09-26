package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class a {
    private int edB;
    private int edC;
    private int edD;
    private int edE;
    private int edF;
    private int edG;

    public a() {
        this.edB = -1;
        this.edC = -1;
        this.edD = -1;
        this.edE = -1;
        this.edF = -1;
        this.edG = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.edB = i == 0 ? 0 : 1;
        this.edC = i == 0 ? 1 : 0;
        this.edG = i != 0 ? 0 : 1;
        int aGi = aGi();
        int i2 = 2;
        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        if ((aGi & 1) > 0) {
            this.edE = i3 == 0 ? 2 : -1;
            this.edF = i3 != 0 ? 2 : -1;
            i2 = 3;
        }
        if ((aGi & 8) > 0) {
            this.edD = i2;
            int i4 = i2 + 1;
        }
    }

    public int ns(int i) {
        switch (i) {
            case 0:
                return this.edB;
            case 1:
                return this.edC;
            case 2:
                return this.edD;
            case 3:
                return this.edE;
            case 4:
                return this.edF;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.edB) {
            return 0;
        }
        if (i == this.edC) {
            return 1;
        }
        if (i == this.edD) {
            return 2;
        }
        if (i == this.edE) {
            return 3;
        }
        if (i == this.edF) {
            return 4;
        }
        return -1;
    }

    public int aGh() {
        return this.edG;
    }

    private int aGi() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String o(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.edB) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(e.j.tab_name_concern);
            }
            return string;
        } else if (i == this.edC) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(e.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.edD) {
            return context.getString(e.j.tab_name_discover);
        } else {
            if (i == this.edE) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(e.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.edF) {
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
