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
public class m {
    public static void Hw(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Ry(str)) {
            readThreadHistory.Rw(str);
        }
    }

    public static boolean Hx(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Rx(str)) ? false : true;
    }

    public static String cfe() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String bfk() {
        return "personalize_page";
    }

    public static String cff() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (Hx(str) && TbSingleton.getInstance().isInFrs) {
                ap.setViewTextColor(textView, i2);
            } else {
                ap.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bw bwVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !at.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bwVar != null && bwVar.bft() == 0) {
            if (z || bwVar.bfM() == 1 || StringUtils.isNull(bwVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> bgs = bwVar.bgs();
                if (!com.baidu.tbadk.core.util.y.isEmpty(bgs)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bgs.size(); i++) {
                        if (bgs.get(i) != null && !StringUtils.isNull(bgs.get(i).getText())) {
                            sb.append(bgs.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < bgs.size(); i3++) {
                        if (bgs.get(i3) != null && !StringUtils.isNull(bgs.get(i3).getText())) {
                            int length = bgs.get(i3).getText().length();
                            a(spannableString, bgs.get(i3), i2, length);
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
        public int abo;
        public int hqM;
        public String hqN;
        public int hqO;
        public int hqP;

        public a(int i, int i2, int i3) {
            this.hqM = -1;
            this.hqN = "";
            this.abo = R.color.cp_link_tip_c;
            this.hqO = R.drawable.pic_dot_title;
            this.hqP = 0;
            this.hqM = i;
            this.abo = i2;
            this.hqO = i3;
        }

        public a(int i) {
            this.hqM = -1;
            this.hqN = "";
            this.abo = R.color.cp_link_tip_c;
            this.hqO = R.drawable.pic_dot_title;
            this.hqP = 0;
            this.hqM = i;
        }

        public a(String str) {
            this.hqM = -1;
            this.hqN = "";
            this.abo = R.color.cp_link_tip_c;
            this.hqO = R.drawable.pic_dot_title;
            this.hqP = 0;
            this.hqN = str;
        }

        public a(String str, int i) {
            this.hqM = -1;
            this.hqN = "";
            this.abo = R.color.cp_link_tip_c;
            this.hqO = R.drawable.pic_dot_title;
            this.hqP = 0;
            this.hqN = str;
            this.hqO = i;
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
                if (aVar.hqM > 0) {
                    aVar.hqN = context.getString(aVar.hqM);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.hqN)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.hqN);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(aVar.abo)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ap.getBitmap(aVar.hqO);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.hqP != 0) {
                        iVar.setOffset(aVar.hqP);
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
        if ((StringUtils.isNull(bwVar.getTitle()) && (bwVar.bfw() == null || bwVar.bfw().size() == 0)) || bwVar.bfM() == 1) {
            bwVar.z(false, true);
            if (bwVar.bgi() == null || StringUtils.isNull(bwVar.bgi().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bwVar.bgi());
            return;
        }
        textView.setVisibility(0);
        bwVar.edW = 0;
        bwVar.z(false, true);
        SpannableStringBuilder bgi = bwVar.bgi();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(bgi));
        textView.setText(bgi);
        a(textView, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public static SpannableStringBuilder er(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
