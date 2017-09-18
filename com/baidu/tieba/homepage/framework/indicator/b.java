package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int dbv;
    private int dbw;
    private int dbx;

    public b() {
        this.dbv = -1;
        this.dbw = -1;
        this.dbx = -1;
        int aqH = aqH();
        int i = 0;
        if ((aqH & 4) > 0) {
            this.dbv = 0;
            i = 1;
        }
        this.dbw = i;
        int i2 = i + 1;
        if ((aqH & 1) > 0) {
            this.dbx = i2;
        }
    }

    public int lg(int i) {
        switch (i) {
            case 0:
                return this.dbv;
            case 1:
                return this.dbw;
            case 2:
                return this.dbx;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dbv) {
            return 0;
        }
        if (i == this.dbw) {
            return 1;
        }
        if (i == this.dbx) {
            return 2;
        }
        return -1;
    }

    private int aqH() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public int getTabCount() {
        int i = 0;
        if (this.dbv != -1) {
            i = 1;
        }
        if (this.dbw != -1) {
            i++;
        }
        if (this.dbx != -1) {
            return i + 1;
        }
        return i;
    }

    public String q(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dbv) {
            return context.getString(d.l.tab_name_concern);
        }
        if (i == this.dbw) {
            return context.getString(d.l.tab_name_recommend);
        }
        if (i == this.dbx) {
            return context.getString(d.l.tab_name_discover);
        }
        return null;
    }
}
