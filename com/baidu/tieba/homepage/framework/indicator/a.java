package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private int dCS;
    private int dCT;
    private int dCU;
    private int dCV;

    public a() {
        this.dCS = -1;
        this.dCT = -1;
        this.dCU = -1;
        this.dCV = -1;
        int axC = axC();
        int i = 0;
        if ((axC & 4) > 0) {
            this.dCS = 0;
            i = 1;
        }
        this.dCT = i;
        int i2 = i + 1;
        if ((axC & 8) > 0) {
            this.dCU = i2;
            i2++;
        }
        if ((axC & 1) > 0) {
            this.dCV = i2;
        }
    }

    public int mh(int i) {
        switch (i) {
            case 0:
                return this.dCS;
            case 1:
                return this.dCT;
            case 2:
                return this.dCU;
            case 3:
                return this.dCV;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dCS) {
            return 0;
        }
        if (i == this.dCT) {
            return 1;
        }
        if (i == this.dCU) {
            return 2;
        }
        if (i == this.dCV) {
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
        if (i == this.dCS) {
            return context.getString(d.k.tab_name_concern);
        }
        if (i == this.dCT) {
            return context.getString(d.k.tab_name_recommend);
        }
        if (i == this.dCU) {
            return context.getString(d.k.tab_name_discover);
        }
        if (i == this.dCV) {
            return context.getString(d.k.tab_name_video_recommend);
        }
        return null;
    }
}
