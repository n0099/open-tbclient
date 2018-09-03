package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class a {
    private int dWj;
    private int dWk;
    private int dWl;
    private int dWm;
    private int dWn;
    private int dWo;

    public a() {
        this.dWj = -1;
        this.dWk = -1;
        this.dWl = -1;
        this.dWm = -1;
        this.dWn = -1;
        this.dWo = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.dWj = i == 0 ? 0 : 1;
        this.dWk = i == 0 ? 1 : 0;
        this.dWo = i != 0 ? 0 : 1;
        int aDV = aDV();
        int i2 = 2;
        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        if ((aDV & 1) > 0) {
            this.dWm = i3 == 0 ? 2 : -1;
            this.dWn = i3 != 0 ? 2 : -1;
            i2 = 3;
        }
        if ((aDV & 8) > 0) {
            this.dWl = i2;
            int i4 = i2 + 1;
        }
    }

    public int mO(int i) {
        switch (i) {
            case 0:
                return this.dWj;
            case 1:
                return this.dWk;
            case 2:
                return this.dWl;
            case 3:
                return this.dWm;
            case 4:
                return this.dWn;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dWj) {
            return 0;
        }
        if (i == this.dWk) {
            return 1;
        }
        if (i == this.dWl) {
            return 2;
        }
        if (i == this.dWm) {
            return 3;
        }
        if (i == this.dWn) {
            return 4;
        }
        return -1;
    }

    public int aDU() {
        return this.dWo;
    }

    private int aDV() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dWj) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(f.j.tab_name_concern);
            }
            return string;
        } else if (i == this.dWk) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(f.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.dWl) {
            return context.getString(f.j.tab_name_discover);
        } else {
            if (i == this.dWm) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(f.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.dWn) {
                String string4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_daily", "");
                if (StringUtils.isNull(string4)) {
                    return context.getString(f.j.tab_name_daily);
                }
                return string4;
            } else {
                return null;
            }
        }
    }
}
