package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private int dDY;
    private int dDZ;
    private int dEa;
    private int dEb;

    public a() {
        this.dDY = -1;
        this.dDZ = -1;
        this.dEa = -1;
        this.dEb = -1;
        int axA = axA();
        int i = 0;
        if ((axA & 4) > 0) {
            this.dDY = 0;
            i = 1;
        }
        this.dDZ = i;
        int i2 = i + 1;
        if ((axA & 8) > 0) {
            this.dEa = i2;
            i2++;
        }
        if ((axA & 1) > 0) {
            this.dEb = i2;
        }
    }

    public int mg(int i) {
        switch (i) {
            case 0:
                return this.dDY;
            case 1:
                return this.dDZ;
            case 2:
                return this.dEa;
            case 3:
                return this.dEb;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dDY) {
            return 0;
        }
        if (i == this.dDZ) {
            return 1;
        }
        if (i == this.dEa) {
            return 2;
        }
        if (i == this.dEb) {
            return 3;
        }
        return -1;
    }

    private int axA() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String l(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dDY) {
            return context.getString(d.k.tab_name_concern);
        }
        if (i == this.dDZ) {
            return context.getString(d.k.tab_name_recommend);
        }
        if (i == this.dEa) {
            return context.getString(d.k.tab_name_discover);
        }
        if (i == this.dEb) {
            return context.getString(d.k.tab_name_video_recommend);
        }
        return null;
    }
}
