package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private int dWn;
    private int dWo;
    private int dWp;
    private int dWq;
    private int dWr;
    private int dWs;

    public a() {
        this.dWn = -1;
        this.dWo = -1;
        this.dWp = -1;
        this.dWq = -1;
        this.dWr = -1;
        this.dWs = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.dWn = i == 0 ? 0 : 1;
        this.dWo = i == 0 ? 1 : 0;
        this.dWs = i != 0 ? 0 : 1;
        int aDY = aDY();
        int i2 = 2;
        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        if ((aDY & 1) > 0) {
            this.dWq = i3 == 0 ? 2 : -1;
            this.dWr = i3 != 0 ? 2 : -1;
            i2 = 3;
        }
        if ((aDY & 8) > 0) {
            this.dWp = i2;
            int i4 = i2 + 1;
        }
    }

    public int mO(int i) {
        switch (i) {
            case 0:
                return this.dWn;
            case 1:
                return this.dWo;
            case 2:
                return this.dWp;
            case 3:
                return this.dWq;
            case 4:
                return this.dWr;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dWn) {
            return 0;
        }
        if (i == this.dWo) {
            return 1;
        }
        if (i == this.dWp) {
            return 2;
        }
        if (i == this.dWq) {
            return 3;
        }
        if (i == this.dWr) {
            return 4;
        }
        return -1;
    }

    public int aDX() {
        return this.dWs;
    }

    private int aDY() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dWn) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(d.j.tab_name_concern);
            }
            return string;
        } else if (i == this.dWo) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(d.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.dWp) {
            return context.getString(d.j.tab_name_discover);
        } else {
            if (i == this.dWq) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(d.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.dWr) {
                String string4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_daily", "");
                if (StringUtils.isNull(string4)) {
                    return context.getString(d.j.tab_name_daily);
                }
                return string4;
            } else {
                return null;
            }
        }
    }
}
