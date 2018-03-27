package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private int eip;
    private int eiq;
    private int eir;
    private int eis;

    public b() {
        this.eip = -1;
        this.eiq = -1;
        this.eir = -1;
        this.eis = -1;
        int aCE = aCE();
        int i = 0;
        if ((aCE & 4) > 0) {
            this.eip = 0;
            i = 1;
        }
        this.eiq = i;
        int i2 = i + 1;
        if ((aCE & 8) > 0) {
            this.eir = i2;
            i2++;
        }
        if ((aCE & 1) > 0) {
            this.eis = i2;
        }
    }

    public int oJ(int i) {
        switch (i) {
            case 0:
                return this.eip;
            case 1:
                return this.eiq;
            case 2:
                return this.eir;
            case 3:
                return this.eis;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.eip) {
            return 0;
        }
        if (i == this.eiq) {
            return 1;
        }
        if (i == this.eir) {
            return 2;
        }
        if (i == this.eis) {
            return 3;
        }
        return -1;
    }

    private int aCE() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String A(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.eip) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.eiq) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.eir) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.eis) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
