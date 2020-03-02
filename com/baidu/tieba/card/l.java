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
    public static void zS(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Jp(str)) {
            readThreadHistory.Jn(str);
        }
    }

    public static boolean zT(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Jo(str)) ? false : true;
    }

    public static String buX() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aCa() {
        return "personalize_page";
    }

    public static String buY() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (zT(str)) {
                am.setViewTextColor(textView, i2);
            } else {
                am.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bj bjVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !aq.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bjVar != null && bjVar.aCj() == 0) {
            if (z || bjVar.aCD() == 1 || StringUtils.isNull(bjVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aDf = bjVar.aDf();
                if (!com.baidu.tbadk.core.util.v.isEmpty(aDf)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aDf.size(); i++) {
                        if (aDf.get(i) != null && !StringUtils.isNull(aDf.get(i).getText())) {
                            sb.append(aDf.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aDf.size(); i3++) {
                        if (aDf.get(i3) != null && !StringUtils.isNull(aDf.get(i3).getText())) {
                            int length = aDf.get(i3).getText().length();
                            a(spannableString, aDf.get(i3), i2, length);
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
        public int fJK;
        public String fJL;
        public int fJM;
        public int yOffset;

        public a(int i, int i2, int i3) {
            this.fJK = -1;
            this.fJL = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJM = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJK = i;
            this.Gk = i2;
            this.fJM = i3;
        }

        public a(int i) {
            this.fJK = -1;
            this.fJL = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJM = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJK = i;
        }

        public a(String str) {
            this.fJK = -1;
            this.fJL = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJM = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJL = str;
        }

        public a(String str, int i) {
            this.fJK = -1;
            this.fJL = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJM = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJL = str;
            this.fJM = i;
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
                if (aVar.fJK > 0) {
                    aVar.fJL = context.getString(aVar.fJK);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.fJL)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.fJL);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Gk)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.fJM);
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
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.aCm() == null || bjVar.aCm().size() == 0)) || bjVar.aCD() == 1) {
            bjVar.s(false, true);
            if (bjVar.aCV() == null || StringUtils.isNull(bjVar.aCV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bjVar.aCV());
            return;
        }
        textView.setVisibility(0);
        bjVar.cRU = 0;
        bjVar.s(false, true);
        SpannableStringBuilder aCV = bjVar.aCV();
        textView.setOnTouchListener(new com.baidu.tieba.view.h(aCV));
        textView.setText(aCV);
        a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder db(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + HanziToPinyin.Token.SEPARATOR + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
