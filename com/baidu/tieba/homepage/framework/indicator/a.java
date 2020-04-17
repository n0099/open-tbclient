package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private int hKV;
    private int hKW;
    private int hKX;
    private int hKY;
    private int hKZ;
    private int hLa;
    private int hLb = 1;

    public a() {
        this.hKV = -1;
        this.hKW = -1;
        this.hKX = -1;
        this.hKY = -1;
        this.hKZ = -1;
        this.hLa = -1;
        this.hKV = 0;
        this.hKW = 1;
        int i = 2;
        int bYx = bYx();
        if ((bYx & 16) > 0) {
            this.hKX = 2;
            i = 3;
        }
        if ((bYx & 128) > 0) {
            this.hLa = i;
            i++;
        }
        if ((bYx & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.hKY = i;
            i++;
        }
        if ((bYx & 64) > 0) {
            this.hKZ = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.hKV;
            case 1:
                return this.hKW;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.hKX;
            case 6:
                return this.hKY;
            case 7:
                return this.hKZ;
            case 8:
                return this.hLa;
        }
    }

    public int getType(int i) {
        if (i == this.hKV) {
            return 0;
        }
        if (i == this.hKW) {
            return 1;
        }
        if (i == this.hKX) {
            return 5;
        }
        if (i == this.hKY) {
            return 6;
        }
        if (i == this.hKZ) {
            return 7;
        }
        if (i == this.hLa) {
            return 8;
        }
        return -1;
    }

    public int bYw() {
        return this.hLb;
    }

    private int bYx() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getInt("recommend_tab_show", 55);
    }

    public String w(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.hKV) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.hKW) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.hKX) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.hKY) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.hKZ) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.hLa) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
