package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int dpa;
    private int dpb;
    private int dpc;
    private int dpd;

    public b() {
        this.dpa = -1;
        this.dpb = -1;
        this.dpc = -1;
        this.dpd = -1;
        int atR = atR();
        int i = 0;
        if ((atR & 4) > 0) {
            this.dpa = 0;
            i = 1;
        }
        this.dpb = i;
        int i2 = i + 1;
        if ((atR & 8) > 0) {
            this.dpc = i2;
            i2++;
        }
        if ((atR & 1) > 0) {
            this.dpd = i2;
        }
    }

    public int lQ(int i) {
        switch (i) {
            case 0:
                return this.dpa;
            case 1:
                return this.dpb;
            case 2:
                return this.dpc;
            case 3:
                return this.dpd;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dpa) {
            return 0;
        }
        if (i == this.dpb) {
            return 1;
        }
        if (i == this.dpc) {
            return 2;
        }
        if (i == this.dpd) {
            return 3;
        }
        return -1;
    }

    private int atR() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dpa) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.dpb) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.dpc) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.dpd) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
