package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    public static void zU(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Jp(str)) {
            readThreadHistory.Jn(str);
        }
    }

    public static boolean zV(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Jo(str)) ? false : true;
    }

    public static String bvd() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aCd() {
        return "personalize_page";
    }

    public static String bve() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (zV(str)) {
                am.setViewTextColor(textView, i2);
            } else {
                am.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bj bjVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !aq.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bjVar != null && bjVar.aCm() == 0) {
            if (z || bjVar.aCG() == 1 || StringUtils.isNull(bjVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aDi = bjVar.aDi();
                if (!com.baidu.tbadk.core.util.v.isEmpty(aDi)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aDi.size(); i++) {
                        if (aDi.get(i) != null && !StringUtils.isNull(aDi.get(i).getText())) {
                            sb.append(aDi.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aDi.size(); i3++) {
                        if (aDi.get(i3) != null && !StringUtils.isNull(aDi.get(i3).getText())) {
                            int length = aDi.get(i3).getText().length();
                            a(spannableString, aDi.get(i3), i2, length);
                            i2 += length;
                        }
                    }
                    spannableStringBuilder.insert(0, (CharSequence) spannableString);
                }
            }
        }
    }

    private static void a(SpannableString spannableString, com.baidu.tbadk.widget.richText.b bVar, int i, int i2) {
        if (spannableString != null && bVar != null && i + i2 <= spannableString.length()) {
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(bVar), i, i + i2, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(bVar.textSize), i, i + i2, 33);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Gk;
        public int fKF;
        public String fKG;
        public int fKH;
        public int yOffset;

        public a(int i, int i2, int i3) {
            this.fKF = -1;
            this.fKG = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fKH = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fKF = i;
            this.Gk = i2;
            this.fKH = i3;
        }

        public a(int i) {
            this.fKF = -1;
            this.fKG = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fKH = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fKF = i;
        }

        public a(String str) {
            this.fKF = -1;
            this.fKG = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fKH = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fKG = str;
        }

        public a(String str, int i) {
            this.fKF = -1;
            this.fKG = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fKH = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fKG = str;
            this.fKH = i;
        }
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z) {
        return a(context, str, arrayList, z, true);
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z, boolean z2) {
        if (str == null || context == null || arrayList == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i != arrayList.size(); i++) {
            a aVar = arrayList.get(i);
            if (aVar != null) {
                if (aVar.fKF > 0) {
                    aVar.fKG = context.getString(aVar.fKF);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.fKG)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.fKG);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Gk)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.fKH);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                    if (aVar.yOffset != 0) {
                        jVar.setOffset(aVar.yOffset);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) HanziToPinyin.Token.SEPARATOR);
                    spannableStringBuilder.setSpan(jVar, length2, spannableStringBuilder.length(), 17);
                } else {
                    continue;
                }
            }
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    public static void a(bj bjVar, TextView textView) {
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.aCp() == null || bjVar.aCp().size() == 0)) || bjVar.aCG() == 1) {
            bjVar.t(false, true);
            if (bjVar.aCY() == null || StringUtils.isNull(bjVar.aCY().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bjVar.aCY());
            return;
        }
        textView.setVisibility(0);
        bjVar.cSi = 0;
        bjVar.t(false, true);
        SpannableStringBuilder aCY = bjVar.aCY();
        textView.setOnTouchListener(new com.baidu.tieba.view.h(aCY));
        textView.setText(aCY);
        a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder da(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + HanziToPinyin.Token.SEPARATOR + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
