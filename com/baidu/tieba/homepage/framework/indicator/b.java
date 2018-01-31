package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private int edZ;
    private int eea;
    private int eeb;
    private int eec;

    public b() {
        this.edZ = -1;
        this.eea = -1;
        this.eeb = -1;
        this.eec = -1;
        int aBk = aBk();
        int i = 0;
        if ((aBk & 4) > 0) {
            this.edZ = 0;
            i = 1;
        }
        this.eea = i;
        int i2 = i + 1;
        if ((aBk & 8) > 0) {
            this.eeb = i2;
            i2++;
        }
        if ((aBk & 1) > 0) {
            this.eec = i2;
        }
    }

    public int oH(int i) {
        switch (i) {
            case 0:
                return this.edZ;
            case 1:
                return this.eea;
            case 2:
                return this.eeb;
            case 3:
                return this.eec;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.edZ) {
            return 0;
        }
        if (i == this.eea) {
            return 1;
        }
        if (i == this.eeb) {
            return 2;
        }
        if (i == this.eec) {
            return 3;
        }
        return -1;
    }

    private int aBk() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String z(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.edZ) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.eea) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.eeb) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.eec) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
