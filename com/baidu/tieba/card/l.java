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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    public static void BE(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Lc(str)) {
            readThreadHistory.La(str);
        }
    }

    public static boolean BF(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Lb(str)) ? false : true;
    }

    public static String bEN() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aKo() {
        return "personalize_page";
    }

    public static String bEO() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (BF(str)) {
                am.setViewTextColor(textView, i2);
            } else {
                am.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bj bjVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !aq.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bjVar != null && bjVar.aKx() == 0) {
            if (z || bjVar.aKR() == 1 || StringUtils.isNull(bjVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aLt = bjVar.aLt();
                if (!com.baidu.tbadk.core.util.v.isEmpty(aLt)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aLt.size(); i++) {
                        if (aLt.get(i) != null && !StringUtils.isNull(aLt.get(i).getText())) {
                            sb.append(aLt.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aLt.size(); i3++) {
                        if (aLt.get(i3) != null && !StringUtils.isNull(aLt.get(i3).getText())) {
                            int length = aLt.get(i3).getText().length();
                            a(spannableString, aLt.get(i3), i2, length);
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
        public int Zy;
        public int gpr;
        public String gps;
        public int gpt;
        public int gpu;

        public a(int i, int i2, int i3) {
            this.gpr = -1;
            this.gps = "";
            this.Zy = R.color.cp_link_tip_c;
            this.gpt = R.drawable.pic_dot_title;
            this.gpu = 0;
            this.gpr = i;
            this.Zy = i2;
            this.gpt = i3;
        }

        public a(int i) {
            this.gpr = -1;
            this.gps = "";
            this.Zy = R.color.cp_link_tip_c;
            this.gpt = R.drawable.pic_dot_title;
            this.gpu = 0;
            this.gpr = i;
        }

        public a(String str) {
            this.gpr = -1;
            this.gps = "";
            this.Zy = R.color.cp_link_tip_c;
            this.gpt = R.drawable.pic_dot_title;
            this.gpu = 0;
            this.gps = str;
        }

        public a(String str, int i) {
            this.gpr = -1;
            this.gps = "";
            this.Zy = R.color.cp_link_tip_c;
            this.gpt = R.drawable.pic_dot_title;
            this.gpu = 0;
            this.gps = str;
            this.gpt = i;
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
                if (aVar.gpr > 0) {
                    aVar.gps = context.getString(aVar.gpr);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.gps)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.gps);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Zy)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.gpt);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                    if (aVar.gpu != 0) {
                        jVar.setOffset(aVar.gpu);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
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
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.aKA() == null || bjVar.aKA().size() == 0)) || bjVar.aKR() == 1) {
            bjVar.s(false, true);
            if (bjVar.aLj() == null || StringUtils.isNull(bjVar.aLj().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bjVar.aLj());
            return;
        }
        textView.setVisibility(0);
        bjVar.drv = 0;
        bjVar.s(false, true);
        SpannableStringBuilder aLj = bjVar.aLj();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(aLj));
        textView.setText(aLj);
        a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    /* renamed from: do  reason: not valid java name */
    public static SpannableStringBuilder m33do(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
