package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int daB;
    private int daC;
    private int daD;

    public b() {
        this.daB = -1;
        this.daC = -1;
        this.daD = -1;
        int aqw = aqw();
        int i = 0;
        if ((aqw & 4) > 0) {
            this.daB = 0;
            i = 1;
        }
        this.daC = i;
        int i2 = i + 1;
        if ((aqw & 1) > 0) {
            this.daD = i2;
        }
    }

    public int le(int i) {
        switch (i) {
            case 0:
                return this.daB;
            case 1:
                return this.daC;
            case 2:
                return this.daD;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.daB) {
            return 0;
        }
        if (i == this.daC) {
            return 1;
        }
        if (i == this.daD) {
            return 2;
        }
        return -1;
    }

    private int aqw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public int getTabCount() {
        int i = 0;
        if (this.daB != -1) {
            i = 1;
        }
        if (this.daC != -1) {
            i++;
        }
        if (this.daD != -1) {
            return i + 1;
        }
        return i;
    }

    public String r(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.daB) {
            return context.getString(d.l.tab_name_concern);
        }
        if (i == this.daC) {
            return context.getString(d.l.tab_name_recommend);
        }
        if (i == this.daD) {
            return context.getString(d.l.tab_name_discover);
        }
        return null;
    }
}
