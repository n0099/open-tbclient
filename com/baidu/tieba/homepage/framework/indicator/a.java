package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private int dPi;
    private int dPj;
    private int dPk;
    private int dPl;

    public a() {
        this.dPi = -1;
        this.dPj = -1;
        this.dPk = -1;
        this.dPl = -1;
        int aCv = aCv();
        int i = 0;
        if ((aCv & 4) > 0) {
            this.dPi = 0;
            i = 1;
        }
        this.dPj = i;
        int i2 = i + 1;
        if ((aCv & 8) > 0) {
            this.dPk = i2;
            i2++;
        }
        if ((aCv & 1) > 0) {
            this.dPl = i2;
        }
    }

    public int mt(int i) {
        switch (i) {
            case 0:
                return this.dPi;
            case 1:
                return this.dPj;
            case 2:
                return this.dPk;
            case 3:
                return this.dPl;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dPi) {
            return 0;
        }
        if (i == this.dPj) {
            return 1;
        }
        if (i == this.dPk) {
            return 2;
        }
        if (i == this.dPl) {
            return 3;
        }
        return -1;
    }

    private int aCv() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String l(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dPi) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(d.k.tab_name_concern);
            }
            return string;
        } else if (i == this.dPj) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(d.k.tab_name_recommend);
            }
            return string2;
        } else if (i == this.dPk) {
            return context.getString(d.k.tab_name_discover);
        } else {
            if (i == this.dPl) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(d.k.tab_name_video_recommend);
                }
                return string3;
            }
            return null;
        }
    }
}
