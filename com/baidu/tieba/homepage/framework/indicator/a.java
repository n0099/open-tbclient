package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private int gih;
    private int gii;
    private int gij;
    private int gik;
    private int gil;
    private int gim;
    private int gin;
    private int gio = 1;

    public a() {
        this.gih = -1;
        this.gii = -1;
        this.gij = -1;
        this.gik = -1;
        this.gil = -1;
        this.gim = -1;
        this.gin = -1;
        this.gih = 0;
        this.gii = 1;
        int i = 2;
        int bwG = bwG();
        if ((bwG & 16) > 0) {
            this.gil = 2;
            i = 3;
        }
        if ((bwG & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.gim = i;
            i++;
        }
        if ((bwG & 64) > 0) {
            this.gin = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("ribao_switch", 0);
        if ((bwG & 1) > 0) {
            this.gij = i2 == 0 ? i : -1;
            this.gik = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int ua(int i) {
        switch (i) {
            case 0:
                return this.gih;
            case 1:
                return this.gii;
            case 2:
            default:
                return -1;
            case 3:
                return this.gij;
            case 4:
                return this.gik;
            case 5:
                return this.gil;
            case 6:
                return this.gim;
            case 7:
                return this.gin;
        }
    }

    public int getType(int i) {
        if (i == this.gih) {
            return 0;
        }
        if (i == this.gii) {
            return 1;
        }
        if (i == this.gij) {
            return 3;
        }
        if (i == this.gik) {
            return 4;
        }
        if (i == this.gil) {
            return 5;
        }
        if (i == this.gim) {
            return 6;
        }
        if (i == this.gin) {
            return 7;
        }
        return -1;
    }

    public int bwF() {
        return this.gio;
    }

    private int bwG() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("recommend_tab_show", 23);
    }

    public String v(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.gih) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.gii) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.gij) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_video", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string3;
        } else if (i == this.gik) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_daily", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_daily);
            }
            return string4;
        } else if (i == this.gil) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_topic", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string5;
        } else if (i == this.gim) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_live", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_live);
            }
            return string6;
        } else if (i == this.gin) {
            String string7 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_game_video", "");
            if (StringUtils.isNull(string7)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string7;
        } else {
            return null;
        }
    }
}
