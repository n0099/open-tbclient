package com.baidu.tieba.gift.giftTab;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ao {
    public static SpannableString d(long j, boolean z) {
        String str;
        String A = ax.A(j);
        if (z) {
            str = String.valueOf("=") + "[icon]" + A;
        } else {
            str = String.valueOf("[icon]") + A;
        }
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = as.getDrawable(n.e.icon_huobi_tdou);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds24);
        drawable.setBounds(0, 0, d, d);
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(drawable);
        fVar.eT(com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds10));
        fVar.eU(com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", fVar);
        UtilHelper.setSpan(spannableString, str, A, new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
        if (z) {
            UtilHelper.setSpan(spannableString, str, "=", new ForegroundColorSpan(as.getColor(n.c.cp_cont_c)));
        }
        return spannableString;
    }

    public static SpannableString s(String str, String str2, String str3) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, new ForegroundColorSpan(as.getColor(n.c.cp_cont_d)));
        UtilHelper.setSpan(spannableString, str, str2, new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
        if (!StringUtils.isNull(str3)) {
            UtilHelper.setSpan(spannableString, str, str3, new StrikethroughSpan());
            return spannableString;
        }
        return spannableString;
    }
}
