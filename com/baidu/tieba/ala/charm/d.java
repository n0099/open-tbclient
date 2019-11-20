package com.baidu.tieba.ala.charm;

import android.content.Context;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
/* loaded from: classes6.dex */
public class d {
    public static String mv(int i) {
        if (i == 2) {
            return SdkStaticKeys.CHARM_TYPE_WEEK;
        }
        if (i == 1) {
            return SdkStaticKeys.CHARM_TYPE_ALL;
        }
        if (i != 3) {
            return "";
        }
        return SdkStaticKeys.CHARM_TYPE_DAY;
    }

    public static String t(Context context, int i) {
        if (context == null) {
            return "";
        }
        if (i == 2) {
            return context.getResources().getString(a.i.charm_week_top_txt);
        }
        if (i != 3) {
            return "";
        }
        return context.getResources().getString(a.i.charm_day_top_txt);
    }
}
