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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void Dn(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.MQ(str)) {
            readThreadHistory.MO(str);
        }
    }

    public static boolean Do(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.MP(str)) ? false : true;
    }

    public static String bLj() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aQj() {
        return "personalize_page";
    }

    public static String bLk() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (Do(str)) {
                am.setViewTextColor(textView, i2);
            } else {
                am.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bk bkVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !aq.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bkVar != null && bkVar.aQs() == 0) {
            if (z || bkVar.aQM() == 1 || StringUtils.isNull(bkVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aRs = bkVar.aRs();
                if (!com.baidu.tbadk.core.util.v.isEmpty(aRs)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aRs.size(); i++) {
                        if (aRs.get(i) != null && !StringUtils.isNull(aRs.get(i).getText())) {
                            sb.append(aRs.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aRs.size(); i3++) {
                        if (aRs.get(i3) != null && !StringUtils.isNull(aRs.get(i3).getText())) {
                            int length = aRs.get(i3).getText().length();
                            a(spannableString, aRs.get(i3), i2, length);
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
        public int ZO;
        public int gEr;
        public String gEs;
        public int gEt;
        public int gEu;

        public a(int i, int i2, int i3) {
            this.gEr = -1;
            this.gEs = "";
            this.ZO = R.color.cp_link_tip_c;
            this.gEt = R.drawable.pic_dot_title;
            this.gEu = 0;
            this.gEr = i;
            this.ZO = i2;
            this.gEt = i3;
        }

        public a(int i) {
            this.gEr = -1;
            this.gEs = "";
            this.ZO = R.color.cp_link_tip_c;
            this.gEt = R.drawable.pic_dot_title;
            this.gEu = 0;
            this.gEr = i;
        }

        public a(String str) {
            this.gEr = -1;
            this.gEs = "";
            this.ZO = R.color.cp_link_tip_c;
            this.gEt = R.drawable.pic_dot_title;
            this.gEu = 0;
            this.gEs = str;
        }

        public a(String str, int i) {
            this.gEr = -1;
            this.gEs = "";
            this.ZO = R.color.cp_link_tip_c;
            this.gEt = R.drawable.pic_dot_title;
            this.gEu = 0;
            this.gEs = str;
            this.gEt = i;
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
                if (aVar.gEr > 0) {
                    aVar.gEs = context.getString(aVar.gEr);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.gEs)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.gEs);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.ZO)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.gEt);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.gEu != 0) {
                        iVar.setOffset(aVar.gEu);
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

    public static void a(bk bkVar, TextView textView) {
        if ((StringUtils.isNull(bkVar.getTitle()) && (bkVar.aQv() == null || bkVar.aQv().size() == 0)) || bkVar.aQM() == 1) {
            bkVar.v(false, true);
            if (bkVar.aRi() == null || StringUtils.isNull(bkVar.aRi().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bkVar.aRi());
            return;
        }
        textView.setVisibility(0);
        bkVar.dFq = 0;
        bkVar.v(false, true);
        SpannableStringBuilder aRi = bkVar.aRi();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(aRi));
        textView.setText(aRi);
        a(textView, bkVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder dO(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
