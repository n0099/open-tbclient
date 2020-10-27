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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void II(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.SL(str)) {
            readThreadHistory.SJ(str);
        }
    }

    public static boolean IJ(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.SK(str)) ? false : true;
    }

    public static String clH() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String bjM() {
        return "personalize_page";
    }

    public static String clI() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (IJ(str) && TbSingleton.getInstance().isInFrs) {
                ap.setViewTextColor(textView, i2);
            } else {
                ap.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bw bwVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !at.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bwVar != null && bwVar.bjV() == 0) {
            if (z || bwVar.bko() == 1 || StringUtils.isNull(bwVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> bkU = bwVar.bkU();
                if (!com.baidu.tbadk.core.util.y.isEmpty(bkU)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bkU.size(); i++) {
                        if (bkU.get(i) != null && !StringUtils.isNull(bkU.get(i).getText())) {
                            sb.append(bkU.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < bkU.size(); i3++) {
                        if (bkU.get(i3) != null && !StringUtils.isNull(bkU.get(i3).getText())) {
                            int length = bkU.get(i3).getText().length();
                            a(spannableString, bkU.get(i3), i2, length);
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
        public int abG;
        public int hSd;
        public String hSe;
        public int hSf;
        public int hSg;

        public a(int i, int i2, int i3) {
            this.hSd = -1;
            this.hSe = "";
            this.abG = R.color.cp_link_tip_c;
            this.hSf = R.drawable.pic_dot_title;
            this.hSg = 0;
            this.hSd = i;
            this.abG = i2;
            this.hSf = i3;
        }

        public a(int i) {
            this.hSd = -1;
            this.hSe = "";
            this.abG = R.color.cp_link_tip_c;
            this.hSf = R.drawable.pic_dot_title;
            this.hSg = 0;
            this.hSd = i;
        }

        public a(String str) {
            this.hSd = -1;
            this.hSe = "";
            this.abG = R.color.cp_link_tip_c;
            this.hSf = R.drawable.pic_dot_title;
            this.hSg = 0;
            this.hSe = str;
        }

        public a(String str, int i) {
            this.hSd = -1;
            this.hSe = "";
            this.abG = R.color.cp_link_tip_c;
            this.hSf = R.drawable.pic_dot_title;
            this.hSg = 0;
            this.hSe = str;
            this.hSf = i;
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
                if (aVar.hSd > 0) {
                    aVar.hSe = context.getString(aVar.hSd);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.hSe)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.hSe);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(aVar.abG)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ap.getBitmap(aVar.hSf);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.hSg != 0) {
                        iVar.setOffset(aVar.hSg);
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
        if ((StringUtils.isNull(bwVar.getTitle()) && (bwVar.bjY() == null || bwVar.bjY().size() == 0)) || bwVar.bko() == 1) {
            bwVar.z(false, true);
            if (bwVar.bkK() == null || StringUtils.isNull(bwVar.bkK().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bwVar.bkK());
            return;
        }
        textView.setVisibility(0);
        bwVar.eyC = 0;
        bwVar.z(false, true);
        SpannableStringBuilder bkK = bwVar.bkK();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(bkK));
        textView.setText(bkK);
        a(textView, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public static SpannableStringBuilder eD(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
