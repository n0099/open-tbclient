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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void IM(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.TB(str)) {
            readThreadHistory.Tz(str);
        }
    }

    public static boolean IN(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.TA(str)) ? false : true;
    }

    public static String csk() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String bnC() {
        return "personalize_page";
    }

    public static String csl() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (IN(str) && TbSingleton.getInstance().isInFrs) {
                ap.setViewTextColor(textView, i2);
            } else {
                ap.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(cb cbVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !au.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && cbVar != null && cbVar.bnL() == 0) {
            if (z || cbVar.boe() == 1 || StringUtils.isNull(cbVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> boL = cbVar.boL();
                if (!com.baidu.tbadk.core.util.y.isEmpty(boL)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < boL.size(); i++) {
                        if (boL.get(i) != null && !StringUtils.isNull(boL.get(i).getText())) {
                            sb.append(boL.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < boL.size(); i3++) {
                        if (boL.get(i3) != null && !StringUtils.isNull(boL.get(i3).getText())) {
                            int length = boL.get(i3).getText().length();
                            a(spannableString, boL.get(i3), i2, length);
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
        public int adq;
        public int iwR;
        public String iwS;
        public int iwT;
        public int iwU;

        public a(int i, int i2, int i3) {
            this.iwR = -1;
            this.iwS = "";
            this.adq = R.color.CAM_X0304;
            this.iwT = R.drawable.pic_dot_title;
            this.iwU = 0;
            this.iwR = i;
            this.adq = i2;
            this.iwT = i3;
        }

        public a(int i) {
            this.iwR = -1;
            this.iwS = "";
            this.adq = R.color.CAM_X0304;
            this.iwT = R.drawable.pic_dot_title;
            this.iwU = 0;
            this.iwR = i;
        }

        public a(String str) {
            this.iwR = -1;
            this.iwS = "";
            this.adq = R.color.CAM_X0304;
            this.iwT = R.drawable.pic_dot_title;
            this.iwU = 0;
            this.iwS = str;
        }

        public a(String str, int i) {
            this.iwR = -1;
            this.iwS = "";
            this.adq = R.color.CAM_X0304;
            this.iwT = R.drawable.pic_dot_title;
            this.iwU = 0;
            this.iwS = str;
            this.iwT = i;
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
                if (aVar.iwR > 0) {
                    aVar.iwS = context.getString(aVar.iwR);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.iwS)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.iwS);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(aVar.adq)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ap.getBitmap(aVar.iwT);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.iwU != 0) {
                        iVar.setOffset(aVar.iwU);
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

    public static void a(cb cbVar, TextView textView) {
        if ((StringUtils.isNull(cbVar.getTitle()) && (cbVar.bnO() == null || cbVar.bnO().size() == 0)) || cbVar.boe() == 1) {
            cbVar.y(false, true);
            if (cbVar.boz() == null || StringUtils.isNull(cbVar.boz().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(cbVar.boz());
            return;
        }
        textView.setVisibility(0);
        cbVar.eRg = 0;
        cbVar.y(false, true);
        SpannableStringBuilder boz = cbVar.boz();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(boz));
        textView.setText(boz);
        a(textView, cbVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public static SpannableStringBuilder eJ(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
