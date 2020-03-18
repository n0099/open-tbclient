package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private int hbg;
    private int hbh;
    private int hbi;
    private int hbj;
    private int hbk;
    private int hbl;
    private int hbm = 1;

    public a() {
        this.hbg = -1;
        this.hbh = -1;
        this.hbi = -1;
        this.hbj = -1;
        this.hbk = -1;
        this.hbl = -1;
        this.hbg = 0;
        this.hbh = 1;
        int i = 2;
        int bNW = bNW();
        if ((bNW & 16) > 0) {
            this.hbi = 2;
            i = 3;
        }
        if ((bNW & 128) > 0) {
            this.hbl = i;
            i++;
        }
        if ((bNW & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.hbj = i;
            i++;
        }
        if ((bNW & 64) > 0) {
            this.hbk = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.hbg;
            case 1:
                return this.hbh;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.hbi;
            case 6:
                return this.hbj;
            case 7:
                return this.hbk;
            case 8:
                return this.hbl;
        }
    }

    public int getType(int i) {
        if (i == this.hbg) {
            return 0;
        }
        if (i == this.hbh) {
            return 1;
        }
        if (i == this.hbi) {
            return 5;
        }
        if (i == this.hbj) {
            return 6;
        }
        if (i == this.hbk) {
            return 7;
        }
        if (i == this.hbl) {
            return 8;
        }
        return -1;
    }

    public int bNV() {
        return this.hbm;
    }

    private int bNW() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getInt("recommend_tab_show", 55);
    }

    public String B(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.hbg) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.hbh) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.hbi) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.hbj) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.hbk) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.hbl) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
