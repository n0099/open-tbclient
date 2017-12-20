package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int dqf;
    private int dqg;
    private int dqh;
    private int dqi;

    public b() {
        this.dqf = -1;
        this.dqg = -1;
        this.dqh = -1;
        this.dqi = -1;
        int atZ = atZ();
        int i = 0;
        if ((atZ & 4) > 0) {
            this.dqf = 0;
            i = 1;
        }
        this.dqg = i;
        int i2 = i + 1;
        if ((atZ & 8) > 0) {
            this.dqh = i2;
            i2++;
        }
        if ((atZ & 1) > 0) {
            this.dqi = i2;
        }
    }

    public int lX(int i) {
        switch (i) {
            case 0:
                return this.dqf;
            case 1:
                return this.dqg;
            case 2:
                return this.dqh;
            case 3:
                return this.dqi;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dqf) {
            return 0;
        }
        if (i == this.dqg) {
            return 1;
        }
        if (i == this.dqh) {
            return 2;
        }
        if (i == this.dqi) {
            return 3;
        }
        return -1;
    }

    private int atZ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dqf) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.dqg) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.dqh) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.dqi) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
