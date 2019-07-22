package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private int gfA;
    private int gfB;
    private int gfC;
    private int gfD;
    private int gfE;
    private int gfF = 1;
    private int gfy;
    private int gfz;

    public a() {
        this.gfy = -1;
        this.gfz = -1;
        this.gfA = -1;
        this.gfB = -1;
        this.gfC = -1;
        this.gfD = -1;
        this.gfE = -1;
        this.gfy = 0;
        this.gfz = 1;
        int i = 2;
        int bvF = bvF();
        if ((bvF & 16) > 0) {
            this.gfC = 2;
            i = 3;
        }
        if ((bvF & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.gfD = i;
            i++;
        }
        if ((bvF & 64) > 0) {
            this.gfE = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("ribao_switch", 0);
        if ((bvF & 1) > 0) {
            this.gfA = i2 == 0 ? i : -1;
            this.gfB = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int tU(int i) {
        switch (i) {
            case 0:
                return this.gfy;
            case 1:
                return this.gfz;
            case 2:
            default:
                return -1;
            case 3:
                return this.gfA;
            case 4:
                return this.gfB;
            case 5:
                return this.gfC;
            case 6:
                return this.gfD;
            case 7:
                return this.gfE;
        }
    }

    public int getType(int i) {
        if (i == this.gfy) {
            return 0;
        }
        if (i == this.gfz) {
            return 1;
        }
        if (i == this.gfA) {
            return 3;
        }
        if (i == this.gfB) {
            return 4;
        }
        if (i == this.gfC) {
            return 5;
        }
        if (i == this.gfD) {
            return 6;
        }
        if (i == this.gfE) {
            return 7;
        }
        return -1;
    }

    public int bvE() {
        return this.gfF;
    }

    private int bvF() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("recommend_tab_show", 23);
    }

    public String v(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.gfy) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.gfz) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.gfA) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_video", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string3;
        } else if (i == this.gfB) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_daily", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_daily);
            }
            return string4;
        } else if (i == this.gfC) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_topic", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string5;
        } else if (i == this.gfD) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_live", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_live);
            }
            return string6;
        } else if (i == this.gfE) {
            String string7 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_game_video", "");
            if (StringUtils.isNull(string7)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string7;
        } else {
            return null;
        }
    }
}
