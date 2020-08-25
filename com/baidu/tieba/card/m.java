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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class m {
    public static void GY(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.QY(str)) {
            readThreadHistory.QW(str);
        }
    }

    public static boolean GZ(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.QX(str)) ? false : true;
    }

    public static String cbO() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String beq() {
        return "personalize_page";
    }

    public static String cbP() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (GZ(str) && !com.baidu.tbadk.a.d.bae()) {
                ap.setViewTextColor(textView, i2);
            } else {
                ap.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bw bwVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !at.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bwVar != null && bwVar.bez() == 0) {
            if (z || bwVar.beS() == 1 || StringUtils.isNull(bwVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> bfy = bwVar.bfy();
                if (!com.baidu.tbadk.core.util.y.isEmpty(bfy)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bfy.size(); i++) {
                        if (bfy.get(i) != null && !StringUtils.isNull(bfy.get(i).getText())) {
                            sb.append(bfy.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < bfy.size(); i3++) {
                        if (bfy.get(i3) != null && !StringUtils.isNull(bfy.get(i3).getText())) {
                            int length = bfy.get(i3).getText().length();
                            a(spannableString, bfy.get(i3), i2, length);
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

    /* loaded from: classes2.dex */
    public static class a {
        public int aaT;
        public int hjF;
        public String hjG;
        public int hjH;
        public int hjI;

        public a(int i, int i2, int i3) {
            this.hjF = -1;
            this.hjG = "";
            this.aaT = R.color.cp_link_tip_c;
            this.hjH = R.drawable.pic_dot_title;
            this.hjI = 0;
            this.hjF = i;
            this.aaT = i2;
            this.hjH = i3;
        }

        public a(int i) {
            this.hjF = -1;
            this.hjG = "";
            this.aaT = R.color.cp_link_tip_c;
            this.hjH = R.drawable.pic_dot_title;
            this.hjI = 0;
            this.hjF = i;
        }

        public a(String str) {
            this.hjF = -1;
            this.hjG = "";
            this.aaT = R.color.cp_link_tip_c;
            this.hjH = R.drawable.pic_dot_title;
            this.hjI = 0;
            this.hjG = str;
        }

        public a(String str, int i) {
            this.hjF = -1;
            this.hjG = "";
            this.aaT = R.color.cp_link_tip_c;
            this.hjH = R.drawable.pic_dot_title;
            this.hjI = 0;
            this.hjG = str;
            this.hjH = i;
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
                if (aVar.hjF > 0) {
                    aVar.hjG = context.getString(aVar.hjF);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.hjG)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.hjG);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(aVar.aaT)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ap.getBitmap(aVar.hjH);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.hjI != 0) {
                        iVar.setOffset(aVar.hjI);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(iVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bw bwVar, TextView textView) {
        if ((StringUtils.isNull(bwVar.getTitle()) && (bwVar.beC() == null || bwVar.beC().size() == 0)) || bwVar.beS() == 1) {
            bwVar.z(false, true);
            if (bwVar.bfo() == null || StringUtils.isNull(bwVar.bfo().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bwVar.bfo());
            return;
        }
        textView.setVisibility(0);
        bwVar.ebI = 0;
        bwVar.z(false, true);
        SpannableStringBuilder bfo = bwVar.bfo();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(bfo));
        textView.setText(bfo);
        a(textView, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public static SpannableStringBuilder em(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
