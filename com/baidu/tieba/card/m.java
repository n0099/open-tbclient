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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void Jo(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.TM(str)) {
            readThreadHistory.TK(str);
        }
    }

    public static boolean Jp(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.TL(str)) ? false : true;
    }

    public static String cuR() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String brc() {
        return "personalize_page";
    }

    public static String cuS() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (Jp(str) && TbSingleton.getInstance().isInFrs) {
                ao.setViewTextColor(textView, i2);
            } else {
                ao.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bz bzVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !at.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bzVar != null && bzVar.brl() == 0) {
            if (z || bzVar.brE() == 1 || StringUtils.isNull(bzVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> bsm = bzVar.bsm();
                if (!com.baidu.tbadk.core.util.x.isEmpty(bsm)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bsm.size(); i++) {
                        if (bsm.get(i) != null && !StringUtils.isNull(bsm.get(i).getText())) {
                            sb.append(bsm.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < bsm.size(); i3++) {
                        if (bsm.get(i3) != null && !StringUtils.isNull(bsm.get(i3).getText())) {
                            int length = bsm.get(i3).getText().length();
                            a(spannableString, bsm.get(i3), i2, length);
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
        public int ady;
        public int ivU;
        public String ivV;
        public int ivW;
        public int ivX;

        public a(int i, int i2, int i3) {
            this.ivU = -1;
            this.ivV = "";
            this.ady = R.color.CAM_X0304;
            this.ivW = R.drawable.pic_dot_title;
            this.ivX = 0;
            this.ivU = i;
            this.ady = i2;
            this.ivW = i3;
        }

        public a(int i) {
            this.ivU = -1;
            this.ivV = "";
            this.ady = R.color.CAM_X0304;
            this.ivW = R.drawable.pic_dot_title;
            this.ivX = 0;
            this.ivU = i;
        }

        public a(String str) {
            this.ivU = -1;
            this.ivV = "";
            this.ady = R.color.CAM_X0304;
            this.ivW = R.drawable.pic_dot_title;
            this.ivX = 0;
            this.ivV = str;
        }

        public a(String str, int i) {
            this.ivU = -1;
            this.ivV = "";
            this.ady = R.color.CAM_X0304;
            this.ivW = R.drawable.pic_dot_title;
            this.ivX = 0;
            this.ivV = str;
            this.ivW = i;
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
                if (aVar.ivU > 0) {
                    aVar.ivV = context.getString(aVar.ivU);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.ivV)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.ivV);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(aVar.ady)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ao.getBitmap(aVar.ivW);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.ivX != 0) {
                        iVar.setOffset(aVar.ivX);
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

    public static void a(bz bzVar, TextView textView) {
        if ((StringUtils.isNull(bzVar.getTitle()) && (bzVar.bro() == null || bzVar.bro().size() == 0)) || bzVar.brE() == 1) {
            bzVar.z(false, true);
            if (bzVar.brZ() == null || StringUtils.isNull(bzVar.brZ().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bzVar.brZ());
            return;
        }
        textView.setVisibility(0);
        bzVar.eTF = 0;
        bzVar.z(false, true);
        SpannableStringBuilder brZ = bzVar.brZ();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(brZ));
        textView.setText(brZ);
        a(textView, bzVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public static SpannableStringBuilder eJ(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
