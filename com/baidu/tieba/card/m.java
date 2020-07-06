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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void DO(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Ns(str)) {
            readThreadHistory.Nq(str);
        }
    }

    public static boolean DP(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Nr(str)) ? false : true;
    }

    public static String bOs() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aSb() {
        return "personalize_page";
    }

    public static String bOt() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (DP(str)) {
                an.setViewTextColor(textView, i2);
            } else {
                an.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bu buVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !ar.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && buVar != null && buVar.aSk() == 0) {
            if (z || buVar.aSD() == 1 || StringUtils.isNull(buVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aTj = buVar.aTj();
                if (!com.baidu.tbadk.core.util.w.isEmpty(aTj)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aTj.size(); i++) {
                        if (aTj.get(i) != null && !StringUtils.isNull(aTj.get(i).getText())) {
                            sb.append(aTj.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aTj.size(); i3++) {
                        if (aTj.get(i3) != null && !StringUtils.isNull(aTj.get(i3).getText())) {
                            int length = aTj.get(i3).getText().length();
                            a(spannableString, aTj.get(i3), i2, length);
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
        public int aat;
        public int gRh;
        public String gRi;
        public int gRj;
        public int gRk;

        public a(int i, int i2, int i3) {
            this.gRh = -1;
            this.gRi = "";
            this.aat = R.color.cp_link_tip_c;
            this.gRj = R.drawable.pic_dot_title;
            this.gRk = 0;
            this.gRh = i;
            this.aat = i2;
            this.gRj = i3;
        }

        public a(int i) {
            this.gRh = -1;
            this.gRi = "";
            this.aat = R.color.cp_link_tip_c;
            this.gRj = R.drawable.pic_dot_title;
            this.gRk = 0;
            this.gRh = i;
        }

        public a(String str) {
            this.gRh = -1;
            this.gRi = "";
            this.aat = R.color.cp_link_tip_c;
            this.gRj = R.drawable.pic_dot_title;
            this.gRk = 0;
            this.gRi = str;
        }

        public a(String str, int i) {
            this.gRh = -1;
            this.gRi = "";
            this.aat = R.color.cp_link_tip_c;
            this.gRj = R.drawable.pic_dot_title;
            this.gRk = 0;
            this.gRi = str;
            this.gRj = i;
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
                if (aVar.gRh > 0) {
                    aVar.gRi = context.getString(aVar.gRh);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.gRi)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.gRi);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(aVar.aat)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = an.getBitmap(aVar.gRj);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.gRk != 0) {
                        iVar.setOffset(aVar.gRk);
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

    public static void a(bu buVar, TextView textView) {
        if ((StringUtils.isNull(buVar.getTitle()) && (buVar.aSn() == null || buVar.aSn().size() == 0)) || buVar.aSD() == 1) {
            buVar.v(false, true);
            if (buVar.aSZ() == null || StringUtils.isNull(buVar.aSZ().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(buVar.aSZ());
            return;
        }
        textView.setVisibility(0);
        buVar.dMb = 0;
        buVar.v(false, true);
        SpannableStringBuilder aSZ = buVar.aSZ();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(aSZ));
        textView.setText(aSZ);
        a(textView, buVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder dT(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
