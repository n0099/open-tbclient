package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private int gZK;
    private int gZL;
    private int gZM;
    private int gZN;
    private int gZO;
    private int gZP;
    private int gZQ = 1;

    public a() {
        this.gZK = -1;
        this.gZL = -1;
        this.gZM = -1;
        this.gZN = -1;
        this.gZO = -1;
        this.gZP = -1;
        this.gZK = 0;
        this.gZL = 1;
        int i = 2;
        int bNF = bNF();
        if ((bNF & 16) > 0) {
            this.gZM = 2;
            i = 3;
        }
        if ((bNF & 128) > 0) {
            this.gZP = i;
            i++;
        }
        if ((bNF & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.gZN = i;
            i++;
        }
        if ((bNF & 64) > 0) {
            this.gZO = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.gZK;
            case 1:
                return this.gZL;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.gZM;
            case 6:
                return this.gZN;
            case 7:
                return this.gZO;
            case 8:
                return this.gZP;
        }
    }

    public int getType(int i) {
        if (i == this.gZK) {
            return 0;
        }
        if (i == this.gZL) {
            return 1;
        }
        if (i == this.gZM) {
            return 5;
        }
        if (i == this.gZN) {
            return 6;
        }
        if (i == this.gZO) {
            return 7;
        }
        if (i == this.gZP) {
            return 8;
        }
        return -1;
    }

    public int bNE() {
        return this.gZQ;
    }

    private int bNF() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getInt("recommend_tab_show", 55);
    }

    public String B(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.gZK) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.gZL) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.gZM) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.gZN) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.gZO) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.gZP) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
