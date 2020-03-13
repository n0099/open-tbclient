package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private int gZY;
    private int gZZ;
    private int haa;
    private int hab;
    private int hac;
    private int had;
    private int hae = 1;

    public a() {
        this.gZY = -1;
        this.gZZ = -1;
        this.haa = -1;
        this.hab = -1;
        this.hac = -1;
        this.had = -1;
        this.gZY = 0;
        this.gZZ = 1;
        int i = 2;
        int bNI = bNI();
        if ((bNI & 16) > 0) {
            this.haa = 2;
            i = 3;
        }
        if ((bNI & 128) > 0) {
            this.had = i;
            i++;
        }
        if ((bNI & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.hab = i;
            i++;
        }
        if ((bNI & 64) > 0) {
            this.hac = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.gZY;
            case 1:
                return this.gZZ;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.haa;
            case 6:
                return this.hab;
            case 7:
                return this.hac;
            case 8:
                return this.had;
        }
    }

    public int getType(int i) {
        if (i == this.gZY) {
            return 0;
        }
        if (i == this.gZZ) {
            return 1;
        }
        if (i == this.haa) {
            return 5;
        }
        if (i == this.hab) {
            return 6;
        }
        if (i == this.hac) {
            return 7;
        }
        if (i == this.had) {
            return 8;
        }
        return -1;
    }

    public int bNH() {
        return this.hae;
    }

    private int bNI() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt("recommend_tab_show", 55);
    }

    public String B(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.gZY) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.gZZ) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.haa) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.hab) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.hac) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.had) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
