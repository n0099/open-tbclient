package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int cXU;
    private int cXV;
    private int cXW;
    private int cXX;

    public b() {
        this.cXU = -1;
        this.cXV = -1;
        this.cXW = -1;
        this.cXX = -1;
        int apo = apo();
        int i = 0;
        if ((apo & 4) > 0) {
            this.cXU = 0;
            i = 1;
        }
        this.cXV = i;
        int i2 = i + 1;
        if ((apo & 8) > 0) {
            this.cXW = i2;
            i2++;
        }
        if ((apo & 1) > 0) {
            this.cXX = i2;
        }
    }

    public int lb(int i) {
        switch (i) {
            case 0:
                return this.cXU;
            case 1:
                return this.cXV;
            case 2:
                return this.cXW;
            case 3:
                return this.cXX;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.cXU) {
            return 0;
        }
        if (i == this.cXV) {
            return 1;
        }
        if (i == this.cXW) {
            return 2;
        }
        if (i == this.cXX) {
            return 3;
        }
        return -1;
    }

    private int apo() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String n(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.cXU) {
            return context.getString(d.l.tab_name_concern);
        }
        if (i == this.cXV) {
            return context.getString(d.l.tab_name_recommend);
        }
        if (i == this.cXW) {
            return context.getString(d.l.tab_name_discover);
        }
        if (i == this.cXX) {
            return context.getString(d.l.tab_name_video_recommend);
        }
        return null;
    }
}
