package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private int eil;
    private int eim;
    private int ein;
    private int eio;

    public b() {
        this.eil = -1;
        this.eim = -1;
        this.ein = -1;
        this.eio = -1;
        int aCE = aCE();
        int i = 0;
        if ((aCE & 4) > 0) {
            this.eil = 0;
            i = 1;
        }
        this.eim = i;
        int i2 = i + 1;
        if ((aCE & 8) > 0) {
            this.ein = i2;
            i2++;
        }
        if ((aCE & 1) > 0) {
            this.eio = i2;
        }
    }

    public int oI(int i) {
        switch (i) {
            case 0:
                return this.eil;
            case 1:
                return this.eim;
            case 2:
                return this.ein;
            case 3:
                return this.eio;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.eil) {
            return 0;
        }
        if (i == this.eim) {
            return 1;
        }
        if (i == this.ein) {
            return 2;
        }
        if (i == this.eio) {
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
        if (i == this.eil) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.eim) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.ein) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.eio) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
