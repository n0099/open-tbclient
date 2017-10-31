package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int dga;
    private int dgb;
    private int dgc;
    private int dgd;

    public b() {
        this.dga = -1;
        this.dgb = -1;
        this.dgc = -1;
        this.dgd = -1;
        int arI = arI();
        int i = 0;
        if ((arI & 4) > 0) {
            this.dga = 0;
            i = 1;
        }
        this.dgb = i;
        int i2 = i + 1;
        if ((arI & 8) > 0) {
            this.dgc = i2;
            i2++;
        }
        if ((arI & 1) > 0) {
            this.dgd = i2;
        }
    }

    public int ls(int i) {
        switch (i) {
            case 0:
                return this.dga;
            case 1:
                return this.dgb;
            case 2:
                return this.dgc;
            case 3:
                return this.dgd;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dga) {
            return 0;
        }
        if (i == this.dgb) {
            return 1;
        }
        if (i == this.dgc) {
            return 2;
        }
        if (i == this.dgd) {
            return 3;
        }
        return -1;
    }

    private int arI() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dga) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.dgb) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.dgc) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.dgd) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
