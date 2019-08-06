package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private int ggo;
    private int ggp;
    private int ggq;
    private int ggr;
    private int ggs;
    private int ggt;
    private int ggu;
    private int ggv = 1;

    public a() {
        this.ggo = -1;
        this.ggp = -1;
        this.ggq = -1;
        this.ggr = -1;
        this.ggs = -1;
        this.ggt = -1;
        this.ggu = -1;
        this.ggo = 0;
        this.ggp = 1;
        int i = 2;
        int bvS = bvS();
        if ((bvS & 16) > 0) {
            this.ggs = 2;
            i = 3;
        }
        if ((bvS & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.ggt = i;
            i++;
        }
        if ((bvS & 64) > 0) {
            this.ggu = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("ribao_switch", 0);
        if ((bvS & 1) > 0) {
            this.ggq = i2 == 0 ? i : -1;
            this.ggr = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int tW(int i) {
        switch (i) {
            case 0:
                return this.ggo;
            case 1:
                return this.ggp;
            case 2:
            default:
                return -1;
            case 3:
                return this.ggq;
            case 4:
                return this.ggr;
            case 5:
                return this.ggs;
            case 6:
                return this.ggt;
            case 7:
                return this.ggu;
        }
    }

    public int getType(int i) {
        if (i == this.ggo) {
            return 0;
        }
        if (i == this.ggp) {
            return 1;
        }
        if (i == this.ggq) {
            return 3;
        }
        if (i == this.ggr) {
            return 4;
        }
        if (i == this.ggs) {
            return 5;
        }
        if (i == this.ggt) {
            return 6;
        }
        if (i == this.ggu) {
            return 7;
        }
        return -1;
    }

    public int bvR() {
        return this.ggv;
    }

    private int bvS() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("recommend_tab_show", 23);
    }

    public String v(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.ggo) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.ggp) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.ggq) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_video", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string3;
        } else if (i == this.ggr) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_daily", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_daily);
            }
            return string4;
        } else if (i == this.ggs) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_topic", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string5;
        } else if (i == this.ggt) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_live", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_live);
            }
            return string6;
        } else if (i == this.ggu) {
            String string7 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_game_video", "");
            if (StringUtils.isNull(string7)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string7;
        } else {
            return null;
        }
    }
}
