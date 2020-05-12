package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private int hLb;
    private int hLc;
    private int hLd;
    private int hLe;
    private int hLf;
    private int hLg;
    private int hLh = 1;

    public a() {
        this.hLb = -1;
        this.hLc = -1;
        this.hLd = -1;
        this.hLe = -1;
        this.hLf = -1;
        this.hLg = -1;
        this.hLb = 0;
        this.hLc = 1;
        int i = 2;
        int bYw = bYw();
        if ((bYw & 16) > 0) {
            this.hLd = 2;
            i = 3;
        }
        if ((bYw & 128) > 0) {
            this.hLg = i;
            i++;
        }
        if ((bYw & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.hLe = i;
            i++;
        }
        if ((bYw & 64) > 0) {
            this.hLf = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.hLb;
            case 1:
                return this.hLc;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.hLd;
            case 6:
                return this.hLe;
            case 7:
                return this.hLf;
            case 8:
                return this.hLg;
        }
    }

    public int getType(int i) {
        if (i == this.hLb) {
            return 0;
        }
        if (i == this.hLc) {
            return 1;
        }
        if (i == this.hLd) {
            return 5;
        }
        if (i == this.hLe) {
            return 6;
        }
        if (i == this.hLf) {
            return 7;
        }
        if (i == this.hLg) {
            return 8;
        }
        return -1;
    }

    public int bYv() {
        return this.hLh;
    }

    private int bYw() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt("recommend_tab_show", 55);
    }

    public String w(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.hLb) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.hLc) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.hLd) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.hLe) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.hLf) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.hLg) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
