package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private int ect;
    private int ecu;
    private int ecv;
    private int ecw;

    public b() {
        this.ect = -1;
        this.ecu = -1;
        this.ecv = -1;
        this.ecw = -1;
        int aBd = aBd();
        int i = 0;
        if ((aBd & 4) > 0) {
            this.ect = 0;
            i = 1;
        }
        this.ecu = i;
        int i2 = i + 1;
        if ((aBd & 8) > 0) {
            this.ecv = i2;
            i2++;
        }
        if ((aBd & 1) > 0) {
            this.ecw = i2;
        }
    }

    public int oO(int i) {
        switch (i) {
            case 0:
                return this.ect;
            case 1:
                return this.ecu;
            case 2:
                return this.ecv;
            case 3:
                return this.ecw;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.ect) {
            return 0;
        }
        if (i == this.ecu) {
            return 1;
        }
        if (i == this.ecv) {
            return 2;
        }
        if (i == this.ecw) {
            return 3;
        }
        return -1;
    }

    private int aBd() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String z(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.ect) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.ecu) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.ecv) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.ecw) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
