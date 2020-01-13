package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a {
    private int gXJ;
    private int gXK;
    private int gXL;
    private int gXM;
    private int gXN;
    private int gXO;
    private int gXP = 1;

    public a() {
        this.gXJ = -1;
        this.gXK = -1;
        this.gXL = -1;
        this.gXM = -1;
        this.gXN = -1;
        this.gXO = -1;
        this.gXJ = 0;
        this.gXK = 1;
        int i = 2;
        int bMd = bMd();
        if ((bMd & 16) > 0) {
            this.gXL = 2;
            i = 3;
        }
        if ((bMd & 128) > 0) {
            this.gXO = i;
            i++;
        }
        if ((bMd & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.gXM = i;
            i++;
        }
        if ((bMd & 64) > 0) {
            this.gXN = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.gXJ;
            case 1:
                return this.gXK;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.gXL;
            case 6:
                return this.gXM;
            case 7:
                return this.gXN;
            case 8:
                return this.gXO;
        }
    }

    public int getType(int i) {
        if (i == this.gXJ) {
            return 0;
        }
        if (i == this.gXK) {
            return 1;
        }
        if (i == this.gXL) {
            return 5;
        }
        if (i == this.gXM) {
            return 6;
        }
        if (i == this.gXN) {
            return 7;
        }
        if (i == this.gXO) {
            return 8;
        }
        return -1;
    }

    public int bMc() {
        return this.gXP;
    }

    private int bMd() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("recommend_tab_show", 23);
    }

    public String B(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.gXJ) {
            String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.gXK) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.gXL) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.gXM) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.gXN) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.gXO) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
