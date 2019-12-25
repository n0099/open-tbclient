package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private int gUm;
    private int gUn;
    private int gUo;
    private int gUp;
    private int gUq;
    private int gUr;
    private int gUs = 1;

    public a() {
        this.gUm = -1;
        this.gUn = -1;
        this.gUo = -1;
        this.gUp = -1;
        this.gUq = -1;
        this.gUr = -1;
        this.gUm = 0;
        this.gUn = 1;
        int i = 2;
        int bKX = bKX();
        if ((bKX & 16) > 0) {
            this.gUo = 2;
            i = 3;
        }
        if ((bKX & 128) > 0) {
            this.gUr = i;
            i++;
        }
        if ((bKX & 32) > 0 && MessageManager.getInstance().findTask(2921399) != null) {
            this.gUp = i;
            i++;
        }
        if ((bKX & 64) > 0) {
            this.gUq = i;
            int i2 = i + 1;
        }
    }

    public int getPosition(int i) {
        switch (i) {
            case 0:
                return this.gUm;
            case 1:
                return this.gUn;
            case 2:
            case 3:
            case 4:
            default:
                return -1;
            case 5:
                return this.gUo;
            case 6:
                return this.gUp;
            case 7:
                return this.gUq;
            case 8:
                return this.gUr;
        }
    }

    public int getType(int i) {
        if (i == this.gUm) {
            return 0;
        }
        if (i == this.gUn) {
            return 1;
        }
        if (i == this.gUo) {
            return 5;
        }
        if (i == this.gUp) {
            return 6;
        }
        if (i == this.gUq) {
            return 7;
        }
        if (i == this.gUr) {
            return 8;
        }
        return -1;
    }

    public int bKW() {
        return this.gUs;
    }

    private int bKX() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getInt("recommend_tab_show", 23);
    }

    public String B(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.gUm) {
            String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(R.string.tab_name_concern);
            }
            return string;
        } else if (i == this.gUn) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(R.string.tab_name_recommend);
            }
            return string2;
        } else if (i == this.gUo) {
            String string3 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_topic", "");
            if (StringUtils.isNull(string3)) {
                return context.getString(R.string.tab_name_topic);
            }
            return string3;
        } else if (i == this.gUp) {
            String string4 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_live", "");
            if (StringUtils.isNull(string4)) {
                return context.getString(R.string.tab_name_live);
            }
            return string4;
        } else if (i == this.gUq) {
            String string5 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_game_video", "");
            if (StringUtils.isNull(string5)) {
                return context.getString(R.string.tab_name_game_video);
            }
            return string5;
        } else if (i == this.gUr) {
            String string6 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_video_tab", "");
            if (StringUtils.isNull(string6)) {
                return context.getString(R.string.tab_name_video_recommend);
            }
            return string6;
        } else {
            return null;
        }
    }
}
