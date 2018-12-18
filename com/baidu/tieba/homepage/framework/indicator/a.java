package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private int etK;
    private int etL;
    private int etM = -1;
    private int etN;
    private int etO;
    private int etP;

    public a() {
        this.etK = -1;
        this.etL = -1;
        this.etN = -1;
        this.etO = -1;
        this.etP = 1;
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_default_page", 0);
        this.etK = i == 0 ? 0 : 1;
        this.etL = i == 0 ? 1 : 0;
        this.etP = i != 0 ? 0 : 1;
        int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("ribao_switch", 0);
        this.etN = i2 == 0 ? 2 : -1;
        this.etO = i2 != 0 ? 2 : -1;
    }

    public int oC(int i) {
        switch (i) {
            case 0:
                return this.etK;
            case 1:
                return this.etL;
            case 2:
                return this.etM;
            case 3:
                return this.etN;
            case 4:
                return this.etO;
            default:
                return -1;
        }
    }

    public int getType(int i) {
        if (i == this.etK) {
            return 0;
        }
        if (i == this.etL) {
            return 1;
        }
        if (i == this.etM) {
            return 2;
        }
        if (i == this.etN) {
            return 3;
        }
        if (i == this.etO) {
            return 4;
        }
        return -1;
    }

    public int aKO() {
        return this.etP;
    }

    public String p(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == this.etK) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_concern", "");
            if (StringUtils.isNull(string)) {
                return context.getString(e.j.tab_name_concern);
            }
            return string;
        } else if (i == this.etL) {
            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_rec", "");
            if (StringUtils.isNull(string2)) {
                return context.getString(e.j.tab_name_recommend);
            }
            return string2;
        } else if (i == this.etM) {
            return context.getString(e.j.tab_name_discover);
        } else {
            if (i == this.etN) {
                String string3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video", "");
                if (StringUtils.isNull(string3)) {
                    return context.getString(e.j.tab_name_video_recommend);
                }
                return string3;
            } else if (i == this.etO) {
                String string4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_daily", "");
                if (StringUtils.isNull(string4)) {
                    return context.getString(e.j.tab_name_daily);
                }
                return string4;
            } else {
                return null;
            }
        }
    }
}
