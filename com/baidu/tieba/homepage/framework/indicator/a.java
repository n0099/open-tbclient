package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private int dSA;
    private int dSB;
    private int dSC;
    private int dSz;

    public a() {
        this.dSz = -1;
        this.dSA = -1;
        this.dSB = -1;
        this.dSC = -1;
        int aCZ = aCZ();
        int i = 0;
        if ((aCZ & 4) > 0) {
            this.dSz = 0;
            i = 1;
        }
        this.dSA = i;
        int i2 = i + 1;
        if ((aCZ & 8) > 0) {
            this.dSB = i2;
            i2++;
        }
        if ((aCZ & 1) > 0) {
            this.dSC = i2;
        }
    }

    public int mA(int i) {
        switch (i) {
            case 0:
                return this.dSz;
            case 1:
                return this.dSA;
            case 2:
                return this.dSB;
            case 3:
                return this.dSC;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.dSz) {
            return 0;
        }
        if (i == this.dSA) {
            return 1;
        }
        if (i == this.dSB) {
            return 2;
        }
        if (i == this.dSC) {
            return 3;
        }
        return -1;
    }

    private int aCZ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("recommend_tab_show", 7);
    }

    public String l(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.dSz) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(d.k.tab_name_concern);
            }
            return string;
        } else if (i == this.dSA) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(d.k.tab_name_recommend);
            }
            return string2;
        } else if (i == this.dSB) {
            return context.getString(d.k.tab_name_discover);
        } else {
            if (i == this.dSC) {
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
