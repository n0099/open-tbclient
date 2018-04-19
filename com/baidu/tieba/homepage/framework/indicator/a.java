package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private int dCV;
    private int dCW;
    private int dCX;
    private int dCY;

    public a() {
        this.dCV = -1;
        this.dCW = -1;
        this.dCX = -1;
        this.dCY = -1;
        int axC = axC();
        int i = 0;
        if ((axC & 4) > 0) {
            this.dCV = 0;
            i = 1;
        }
        this.dCW = i;
        int i2 = i + 1;
        if ((axC & 8) > 0) {
            this.dCX = i2;
            i2++;
        }
        if ((axC & 1) > 0) {
            this.dCY = i2;
        }
    }

    public int mh(int i) {
        switch (i) {
            case 0:
                return this.dCV;
            case 1:
                return this.dCW;
            case 2:
                return this.dCX;
            case 3:
                return this.dCY;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dCV) {
            return 0;
        }
        if (i == this.dCW) {
            return 1;
        }
        if (i == this.dCX) {
            return 2;
        }
        if (i == this.dCY) {
            return 3;
        }
        return -1;
    }

    private int axC() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String l(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dCV) {
            return context.getString(d.k.tab_name_concern);
        }
        if (i == this.dCW) {
            return context.getString(d.k.tab_name_recommend);
        }
        if (i == this.dCX) {
            return context.getString(d.k.tab_name_discover);
        }
        if (i == this.dCY) {
            return context.getString(d.k.tab_name_video_recommend);
        }
        return null;
    }
}
