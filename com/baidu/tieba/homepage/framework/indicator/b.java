package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int dgu;
    private int dgv;
    private int dgw;
    private int dgx;

    public b() {
        this.dgu = -1;
        this.dgv = -1;
        this.dgw = -1;
        this.dgx = -1;
        int arY = arY();
        int i = 0;
        if ((arY & 4) > 0) {
            this.dgu = 0;
            i = 1;
        }
        this.dgv = i;
        int i2 = i + 1;
        if ((arY & 8) > 0) {
            this.dgw = i2;
            i2++;
        }
        if ((arY & 1) > 0) {
            this.dgx = i2;
        }
    }

    public int ls(int i) {
        switch (i) {
            case 0:
                return this.dgu;
            case 1:
                return this.dgv;
            case 2:
                return this.dgw;
            case 3:
                return this.dgx;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dgu) {
            return 0;
        }
        if (i == this.dgv) {
            return 1;
        }
        if (i == this.dgw) {
            return 2;
        }
        if (i == this.dgx) {
            return 3;
        }
        return -1;
    }

    private int arY() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dgu) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.dgv) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.dgw) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.dgx) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
