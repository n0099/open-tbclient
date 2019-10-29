package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private int ghE;
    private int ghF;
    private int ghG;
    private int ghH;
    private int ghI;
    private int ghJ;
    private int ghK;
    private int ghL = 1;

    public a() {
        this.ghE = -1;
        this.ghF = -1;
        this.ghG = -1;
        this.ghH = -1;
        this.ghI = -1;
        this.ghJ = -1;
        this.ghK = -1;
        this.ghE = 0;
        this.ghF = 1;
        int i = 2;
        int btL = btL();
        if ((btL & 16) > 0) {
            this.ghI = 2;
            i = 3;
        }
        if ((btL & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.ghJ = i;
            i++;
        }
        if ((btL & 64) > 0) {
            this.ghK = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.alR().getInt("ribao_switch", 0);
        if ((btL & 1) > 0) {
            this.ghG = i2 == 0 ? i : -1;
            this.ghH = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int sV(int i) {
        switch (i) {
            case 0:
                return this.ghE;
            case 1:
                return this.ghF;
            case 2:
            default:
                return -1;
            case 3:
                return this.ghG;
            case 4:
                return this.ghH;
            case 5:
                return this.ghI;
            case 6:
                return this.ghJ;
            case 7:
                return this.ghK;
        }
    }

    public int getType(int i) {
        if (i == this.ghE) {
            return 0;
        }
        if (i == this.ghF) {
            return 1;
        }
        if (i == this.ghG) {
            return 3;
        }
        if (i == this.ghH) {
            return 4;
        }
        if (i == this.ghI) {
            return 5;
        }
        if (i == this.ghJ) {
            return 6;
        }
        if (i == this.ghK) {
            return 7;
        }
        return -1;
    }

    public int btK() {
        return this.ghL;
    }

    private int btL() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt("recommend_tab_show", 23);
    }

    public String u(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.ghE) {
            String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.ghF) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.ghG) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_video", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string3;
        } else if (i == this.ghH) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_daily", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_daily);
            }
            return string4;
        } else if (i == this.ghI) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_topic", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string5;
        } else if (i == this.ghJ) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_live", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_live);
            }
            return string6;
        } else if (i == this.ghK) {
            String string7 = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_game_video", "");
            if (StringUtils.isNull(string7)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string7;
        } else {
            return null;
        }
    }
}
