package com.baidu.tieba.gift.giftTab;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    public static SpannableString l(long j, boolean z) {
        String formatOverBaiwanNum = at.formatOverBaiwanNum(j);
        String str = z ? "=[icon]" + formatOverBaiwanNum : "[icon]" + formatOverBaiwanNum;
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ao.getDrawable(R.drawable.icon_huobi_tdou);
        int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
        drawable.setBounds(0, 0, dimens, dimens);
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(drawable);
        dVar.setPaddingLeft(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        dVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)));
        if (z) {
            UtilHelper.setSpan(spannableString, str, "=", new ForegroundColorSpan(ao.getColor(R.color.CAM_X0108)));
        }
        return spannableString;
    }

    public static SpannableString aJ(String str, String str2, String str3) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)));
        UtilHelper.setSpan(spannableString, str, str2, new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)));
        if (!StringUtils.isNull(str3)) {
            UtilHelper.setSpan(spannableString, str, str3, new StrikethroughSpan());
            return spannableString;
        }
        return spannableString;
    }

    public static SpannableString C(long j, int i) {
        Drawable drawable;
        String formatOverBaiwanNum = at.formatOverBaiwanNum(j);
        String str = "[icon]" + formatOverBaiwanNum;
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            drawable = ao.getDrawable(R.drawable.icon_huobi_tdou);
        } else {
            drawable = ao.getDrawable(R.drawable.icon_gift_bluedrill);
        }
        if (TbadkApplication.getInst().getSkinType() == 1) {
            drawable.setAlpha(179);
        } else {
            drawable.setAlpha(255);
        }
        int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
        if (i == 1) {
            drawable.setBounds(0, 0, dimens, dimens);
        } else {
            drawable.setBounds(0, 0, dimens, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20));
        }
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(drawable);
        dVar.setPaddingLeft(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        dVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(ao.getColor(R.color.CAM_X0108)));
        return spannableString;
    }
}
