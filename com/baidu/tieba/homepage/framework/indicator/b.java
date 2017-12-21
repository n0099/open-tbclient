package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private int dqj;
    private int dqk;
    private int dql;
    private int dqm;

    public b() {
        this.dqj = -1;
        this.dqk = -1;
        this.dql = -1;
        this.dqm = -1;
        int aua = aua();
        int i = 0;
        if ((aua & 4) > 0) {
            this.dqj = 0;
            i = 1;
        }
        this.dqk = i;
        int i2 = i + 1;
        if ((aua & 8) > 0) {
            this.dql = i2;
            i2++;
        }
        if ((aua & 1) > 0) {
            this.dqm = i2;
        }
    }

    public int lX(int i) {
        switch (i) {
            case 0:
                return this.dqj;
            case 1:
                return this.dqk;
            case 2:
                return this.dql;
            case 3:
                return this.dqm;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dqj) {
            return 0;
        }
        if (i == this.dqk) {
            return 1;
        }
        if (i == this.dql) {
            return 2;
        }
        if (i == this.dqm) {
            return 3;
        }
        return -1;
    }

    private int aua() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String m(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dqj) {
            return context.getString(d.j.tab_name_concern);
        }
        if (i == this.dqk) {
            return context.getString(d.j.tab_name_recommend);
        }
        if (i == this.dql) {
            return context.getString(d.j.tab_name_discover);
        }
        if (i == this.dqm) {
            return context.getString(d.j.tab_name_video_recommend);
        }
        return null;
    }
}
