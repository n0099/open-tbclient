package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private int ggN;
    private int ggO;
    private int ggP;
    private int ggQ;
    private int ggR;
    private int ggS;
    private int ggT;
    private int ggU = 1;

    public a() {
        this.ggN = -1;
        this.ggO = -1;
        this.ggP = -1;
        this.ggQ = -1;
        this.ggR = -1;
        this.ggS = -1;
        this.ggT = -1;
        this.ggN = 0;
        this.ggO = 1;
        int i = 2;
        int btJ = btJ();
        if ((btJ & 16) > 0) {
            this.ggR = 2;
            i = 3;
        }
        if ((btJ & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.ggS = i;
            i++;
        }
        if ((btJ & 64) > 0) {
            this.ggT = i;
            i++;
        }
        int i2 = com.baidu.tbadk.core.sharedPref.b.alP().getInt("ribao_switch", 0);
        if ((btJ & 1) > 0) {
            this.ggP = i2 == 0 ? i : -1;
            this.ggQ = i2 != 0 ? i : -1;
            int i3 = i + 1;
        }
    }

    public int sU(int i) {
        switch (i) {
            case 0:
                return this.ggN;
            case 1:
                return this.ggO;
            case 2:
            default:
                return -1;
            case 3:
                return this.ggP;
            case 4:
                return this.ggQ;
            case 5:
                return this.ggR;
            case 6:
                return this.ggS;
            case 7:
                return this.ggT;
        }
    }

    public int getType(int i) {
        if (i == this.ggN) {
            return 0;
        }
        if (i == this.ggO) {
            return 1;
        }
        if (i == this.ggP) {
            return 3;
        }
        if (i == this.ggQ) {
            return 4;
        }
        if (i == this.ggR) {
            return 5;
        }
        if (i == this.ggS) {
            return 6;
        }
        if (i == this.ggT) {
            return 7;
        }
        return -1;
    }

    public int btI() {
        return this.ggU;
    }

    private int btJ() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("recommend_tab_show", 23);
    }

    public String u(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.ggN) {
            String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.ggO) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.alP().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.ggP) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.alP().getString("key_video", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string3;
        } else if (i == this.ggQ) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.alP().getString("key_daily", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_daily);
            }
            return string4;
        } else if (i == this.ggR) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.alP().getString("key_topic", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string5;
        } else if (i == this.ggS) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.alP().getString("key_live", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_live);
            }
            return string6;
        } else if (i == this.ggT) {
            String string7 = com.baidu.tbadk.core.sharedPref.b.alP().getString("key_game_video", "");
            if (StringUtils.isNull(string7)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string7;
        } else {
            return null;
        }
    }
}
