package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private int edE;
    private int edF;
    private int edG;
    private int edH;

    public b() {
        this.edE = -1;
        this.edF = -1;
        this.edG = -1;
        this.edH = -1;
        int aBf = aBf();
        int i = 0;
        if ((aBf & 4) > 0) {
            this.edE = 0;
            i = 1;
        }
        this.edF = i;
        int i2 = i + 1;
        if ((aBf & 8) > 0) {
            this.edG = i2;
            i2++;
        }
        if ((aBf & 1) > 0) {
            this.edH = i2;
        }
    }

    public int oH(int i) {
        switch (i) {
            case 0:
                return this.edE;
            case 1:
                return this.edF;
            case 2:
                return this.edG;
            case 3:
                return this.edH;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.edE) {
            return 0;
        }
        if (i == this.edF) {
            return 1;
        }
        if (i == this.edG) {
            return 2;
        }
        if (i == this.edH) {
            return 3;
        }
        return -1;
    }

    private int aBf() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String z(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.edE) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.edF) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.edG) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.edH) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
