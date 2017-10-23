package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int cXI;
    private int cXJ;
    private int cXK;
    private int cXL;

    public b() {
        this.cXI = -1;
        this.cXJ = -1;
        this.cXK = -1;
        this.cXL = -1;
        int apj = apj();
        int i = 0;
        if ((apj & 4) > 0) {
            this.cXI = 0;
            i = 1;
        }
        this.cXJ = i;
        int i2 = i + 1;
        if ((apj & 8) > 0) {
            this.cXK = i2;
            i2++;
        }
        if ((apj & 1) > 0) {
            this.cXL = i2;
        }
    }

    public int la(int i) {
        switch (i) {
            case 0:
                return this.cXI;
            case 1:
                return this.cXJ;
            case 2:
                return this.cXK;
            case 3:
                return this.cXL;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.cXI) {
            return 0;
        }
        if (i == this.cXJ) {
            return 1;
        }
        if (i == this.cXK) {
            return 2;
        }
        if (i == this.cXL) {
            return 3;
        }
        return -1;
    }

    private int apj() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.cXI) {
            return context.getString(d.l.tab_name_concern);
        }
        if (i == this.cXJ) {
            return context.getString(d.l.tab_name_recommend);
        }
        if (i == this.cXK) {
            return context.getString(d.l.tab_name_discover);
        }
        if (i == this.cXL) {
            return context.getString(d.l.tab_name_video_recommend);
        }
        return null;
    }
}
