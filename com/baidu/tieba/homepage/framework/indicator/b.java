package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private int ehZ;
    private int eia;
    private int eib;
    private int eic;

    public b() {
        this.ehZ = -1;
        this.eia = -1;
        this.eib = -1;
        this.eic = -1;
        int aCD = aCD();
        int i = 0;
        if ((aCD & 4) > 0) {
            this.ehZ = 0;
            i = 1;
        }
        this.eia = i;
        int i2 = i + 1;
        if ((aCD & 8) > 0) {
            this.eib = i2;
            i2++;
        }
        if ((aCD & 1) > 0) {
            this.eic = i2;
        }
    }

    public int oI(int i) {
        switch (i) {
            case 0:
                return this.ehZ;
            case 1:
                return this.eia;
            case 2:
                return this.eib;
            case 3:
                return this.eic;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.ehZ) {
            return 0;
        }
        if (i == this.eia) {
            return 1;
        }
        if (i == this.eib) {
            return 2;
        }
        if (i == this.eic) {
            return 3;
        }
        return -1;
    }

    private int aCD() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String A(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.ehZ) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.eia) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.eib) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.eic) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
