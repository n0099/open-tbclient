package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private int emO;
    private int emP;
    private int emQ;
    private int emR;
    private int emS;
    private int emT;

    public a() {
        this.emO = -1;
        this.emP = -1;
        this.emQ = -1;
        this.emR = -1;
        this.emS = -1;
        this.emT = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.emO = i == 0 ? 0 : 1;
        this.emP = i == 0 ? 1 : 0;
        this.emT = i != 0 ? 0 : 1;
        int aIY = aIY();
        int i2 = 2;
        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        if ((aIY & 1) > 0) {
            this.emR = i3 == 0 ? 2 : -1;
            this.emS = i3 != 0 ? 2 : -1;
            i2 = 3;
        }
        if ((aIY & 8) > 0) {
            this.emQ = i2;
            int i4 = i2 + 1;
        }
    }

    public int oi(int i) {
        switch (i) {
            case 0:
                return this.emO;
            case 1:
                return this.emP;
            case 2:
                return this.emQ;
            case 3:
                return this.emR;
            case 4:
                return this.emS;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.emO) {
            return 0;
        }
        if (i == this.emP) {
            return 1;
        }
        if (i == this.emQ) {
            return 2;
        }
        if (i == this.emR) {
            return 3;
        }
        if (i == this.emS) {
            return 4;
        }
        return -1;
    }

    public int aIX() {
        return this.emT;
    }

    private int aIY() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String p(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.emO) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(e.j.tab_name_concern);
            }
            return string;
        } else if (i == this.emP) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(e.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.emQ) {
            return context.getString(e.j.tab_name_discover);
        } else {
            if (i == this.emR) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(e.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.emS) {
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
