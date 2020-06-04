package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private int iao;
    private int iap;
    private int iaq;
    private int iar;
    private int ias;
    private int iat;
    private int iau = 1;

    public a() {
        this.iao = -1;
        this.iap = -1;
        this.iaq = -1;
        this.iar = -1;
        this.ias = -1;
        this.iat = -1;
        this.iao = 0;
        this.iap = 1;
        int i = 2;
        int ceZ = ceZ();
        if ((ceZ & 16) > 0) {
            this.iaq = 2;
            i = 3;
        }
        if ((ceZ & 128) > 0) {
            this.iat = i;
            i++;
        }
        if ((ceZ & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null && !d.aMs()) {
            this.iar = i;
            i++;
        }
        if ((ceZ & 64) > 0) {
            this.ias = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.iao;
            case 1:
                return this.iap;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.iaq;
            case 6:
                return this.iar;
            case 7:
                return this.ias;
            case 8:
                return this.iat;
        }
    }

    public int getType(int i) {
        if (i == this.iao) {
            return 0;
        }
        if (i == this.iap) {
            return 1;
        }
        if (i == this.iaq) {
            return 5;
        }
        if (i == this.iar) {
            return 6;
        }
        if (i == this.ias) {
            return 7;
        }
        if (i == this.iat) {
            return 8;
        }
        return -1;
    }

    public int ceY() {
        return this.iau;
    }

    private int ceZ() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("recommend_tab_show", 55);
    }

    public String w(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.iao) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.iap) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.iaq) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.iar) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.ias) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.iat) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
