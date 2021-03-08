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
    public static void IW(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.TU(str)) {
            readThreadHistory.TS(str);
        }
    }

    public static boolean IX(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.TT(str)) ? false : true;
    }

    public static String csx() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String bnE() {
        return "personalize_page";
    }

    public static String csy() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (IX(str) && TbSingleton.getInstance().isInFrs) {
                ap.setViewTextColor(textView, i2);
            } else {
                ap.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(cb cbVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !au.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && cbVar != null && cbVar.bnN() == 0) {
            if (z || cbVar.bog() == 1 || StringUtils.isNull(cbVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> boN = cbVar.boN();
                if (!com.baidu.tbadk.core.util.y.isEmpty(boN)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < boN.size(); i++) {
                        if (boN.get(i) != null && !StringUtils.isNull(boN.get(i).getText())) {
                            sb.append(boN.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < boN.size(); i3++) {
                        if (boN.get(i3) != null && !StringUtils.isNull(boN.get(i3).getText())) {
                            int length = boN.get(i3).getText().length();
                            a(spannableString, boN.get(i3), i2, length);
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
        public int aeJ;
        public int iyO;
        public String iyP;
        public int iyQ;
        public int iyR;

        public a(int i, int i2, int i3) {
            this.iyO = -1;
            this.iyP = "";
            this.aeJ = R.color.CAM_X0304;
            this.iyQ = R.drawable.pic_dot_title;
            this.iyR = 0;
            this.iyO = i;
            this.aeJ = i2;
            this.iyQ = i3;
        }

        public a(int i) {
            this.iyO = -1;
            this.iyP = "";
            this.aeJ = R.color.CAM_X0304;
            this.iyQ = R.drawable.pic_dot_title;
            this.iyR = 0;
            this.iyO = i;
        }

        public a(String str) {
            this.iyO = -1;
            this.iyP = "";
            this.aeJ = R.color.CAM_X0304;
            this.iyQ = R.drawable.pic_dot_title;
            this.iyR = 0;
            this.iyP = str;
        }

        public a(String str, int i) {
            this.iyO = -1;
            this.iyP = "";
            this.aeJ = R.color.CAM_X0304;
            this.iyQ = R.drawable.pic_dot_title;
            this.iyR = 0;
            this.iyP = str;
            this.iyQ = i;
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
                if (aVar.iyO > 0) {
                    aVar.iyP = context.getString(aVar.iyO);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.iyP)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.iyP);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(aVar.aeJ)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ap.getBitmap(aVar.iyQ);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.iyR != 0) {
                        iVar.setOffset(aVar.iyR);
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
        if ((StringUtils.isNull(cbVar.getTitle()) && (cbVar.bnQ() == null || cbVar.bnQ().size() == 0)) || cbVar.bog() == 1) {
            cbVar.y(false, true);
            if (cbVar.boB() == null || StringUtils.isNull(cbVar.boB().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(cbVar.boB());
            return;
        }
        textView.setVisibility(0);
        cbVar.eSH = 0;
        cbVar.y(false, true);
        SpannableStringBuilder boB = cbVar.boB();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(boB));
        textView.setText(boB);
        a(textView, cbVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public static SpannableStringBuilder eJ(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
