package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private int hZB;
    private int hZC;
    private int hZD;
    private int hZE;
    private int hZF;
    private int hZG;
    private int hZH = 1;

    public a() {
        this.hZB = -1;
        this.hZC = -1;
        this.hZD = -1;
        this.hZE = -1;
        this.hZF = -1;
        this.hZG = -1;
        this.hZB = 0;
        this.hZC = 1;
        int i = 2;
        int ceR = ceR();
        if ((ceR & 16) > 0) {
            this.hZD = 2;
            i = 3;
        }
        if ((ceR & 128) > 0) {
            this.hZG = i;
            i++;
        }
        if ((ceR & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null && !d.aMs()) {
            this.hZE = i;
            i++;
        }
        if ((ceR & 64) > 0) {
            this.hZF = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.hZB;
            case 1:
                return this.hZC;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.hZD;
            case 6:
                return this.hZE;
            case 7:
                return this.hZF;
            case 8:
                return this.hZG;
        }
    }

    public int getType(int i) {
        if (i == this.hZB) {
            return 0;
        }
        if (i == this.hZC) {
            return 1;
        }
        if (i == this.hZD) {
            return 5;
        }
        if (i == this.hZE) {
            return 6;
        }
        if (i == this.hZF) {
            return 7;
        }
        if (i == this.hZG) {
            return 8;
        }
        return -1;
    }

    public int ceQ() {
        return this.hZH;
    }

    private int ceR() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("recommend_tab_show", 55);
    }

    public String w(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.hZB) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.hZC) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.hZD) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.hZE) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.hZF) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.hZG) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
