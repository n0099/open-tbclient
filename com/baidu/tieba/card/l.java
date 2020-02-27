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

    public static String buV() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aBY() {
        return "personalize_page";
    }

    public static String buW() {
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
        if (spannableStringBuilder != null && !aq.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bjVar != null && bjVar.aCh() == 0) {
            if (z || bjVar.aCB() == 1 || StringUtils.isNull(bjVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aDd = bjVar.aDd();
                if (!com.baidu.tbadk.core.util.v.isEmpty(aDd)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aDd.size(); i++) {
                        if (aDd.get(i) != null && !StringUtils.isNull(aDd.get(i).getText())) {
                            sb.append(aDd.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aDd.size(); i3++) {
                        if (aDd.get(i3) != null && !StringUtils.isNull(aDd.get(i3).getText())) {
                            int length = aDd.get(i3).getText().length();
                            a(spannableString, aDd.get(i3), i2, length);
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
        public int fJI;
        public String fJJ;
        public int fJK;
        public int yOffset;

        public a(int i, int i2, int i3) {
            this.fJI = -1;
            this.fJJ = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJK = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJI = i;
            this.Gk = i2;
            this.fJK = i3;
        }

        public a(int i) {
            this.fJI = -1;
            this.fJJ = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJK = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJI = i;
        }

        public a(String str) {
            this.fJI = -1;
            this.fJJ = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJK = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJJ = str;
        }

        public a(String str, int i) {
            this.fJI = -1;
            this.fJJ = "";
            this.Gk = R.color.cp_link_tip_c;
            this.fJK = R.drawable.pic_dot_title;
            this.yOffset = 0;
            this.fJJ = str;
            this.fJK = i;
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
                if (aVar.fJI > 0) {
                    aVar.fJJ = context.getString(aVar.fJI);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.fJJ)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.fJJ);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Gk)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.fJK);
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
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.aCk() == null || bjVar.aCk().size() == 0)) || bjVar.aCB() == 1) {
            bjVar.s(false, true);
            if (bjVar.aCT() == null || StringUtils.isNull(bjVar.aCT().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bjVar.aCT());
            return;
        }
        textView.setVisibility(0);
        bjVar.cRT = 0;
        bjVar.s(false, true);
        SpannableStringBuilder aCT = bjVar.aCT();
        textView.setOnTouchListener(new com.baidu.tieba.view.h(aCT));
        textView.setText(aCT);
        a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder db(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + HanziToPinyin.Token.SEPARATOR + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
