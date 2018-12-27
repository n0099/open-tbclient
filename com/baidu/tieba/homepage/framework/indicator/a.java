package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private int ewA;
    private int ewB;
    private int ewC = -1;
    private int ewD;
    private int ewE;
    private int ewF;

    public a() {
        this.ewA = -1;
        this.ewB = -1;
        this.ewD = -1;
        this.ewE = -1;
        this.ewF = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.ewA = i == 0 ? 0 : 1;
        this.ewB = i == 0 ? 1 : 0;
        this.ewF = i != 0 ? 0 : 1;
        int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        this.ewD = i2 == 0 ? 2 : -1;
        this.ewE = i2 != 0 ? 2 : -1;
    }

    public int oP(int i) {
        switch (i) {
            case 0:
                return this.ewA;
            case 1:
                return this.ewB;
            case 2:
                return this.ewC;
            case 3:
                return this.ewD;
            case 4:
                return this.ewE;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.ewA) {
            return 0;
        }
        if (i == this.ewB) {
            return 1;
        }
        if (i == this.ewC) {
            return 2;
        }
        if (i == this.ewD) {
            return 3;
        }
        if (i == this.ewE) {
            return 4;
        }
        return -1;
    }

    public int aLC() {
        return this.ewF;
    }

    public String p(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.ewA) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(e.j.tab_name_concern);
            }
            return string;
        } else if (i == this.ewB) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(e.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.ewC) {
            return context.getString(e.j.tab_name_discover);
        } else {
            if (i == this.ewD) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(e.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.ewE) {
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
