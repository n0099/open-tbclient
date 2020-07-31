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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void Ez(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Oa(str)) {
            readThreadHistory.NY(str);
        }
    }

    public static boolean EA(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.NZ(str)) ? false : true;
    }

    public static String bRC() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aVX() {
        return "personalize_page";
    }

    public static String bRD() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (EA(str) && !com.baidu.tbadk.a.d.aRM()) {
                ao.setViewTextColor(textView, i2);
            } else {
                ao.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bv bvVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !as.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bvVar != null && bvVar.aWg() == 0) {
            if (z || bvVar.aWz() == 1 || StringUtils.isNull(bvVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aXf = bvVar.aXf();
                if (!com.baidu.tbadk.core.util.x.isEmpty(aXf)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aXf.size(); i++) {
                        if (aXf.get(i) != null && !StringUtils.isNull(aXf.get(i).getText())) {
                            sb.append(aXf.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aXf.size(); i3++) {
                        if (aXf.get(i3) != null && !StringUtils.isNull(aXf.get(i3).getText())) {
                            int length = aXf.get(i3).getText().length();
                            a(spannableString, aXf.get(i3), i2, length);
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
        public int aao;
        public int gWM;
        public String gWN;
        public int gWO;
        public int gWP;

        public a(int i, int i2, int i3) {
            this.gWM = -1;
            this.gWN = "";
            this.aao = R.color.cp_link_tip_c;
            this.gWO = R.drawable.pic_dot_title;
            this.gWP = 0;
            this.gWM = i;
            this.aao = i2;
            this.gWO = i3;
        }

        public a(int i) {
            this.gWM = -1;
            this.gWN = "";
            this.aao = R.color.cp_link_tip_c;
            this.gWO = R.drawable.pic_dot_title;
            this.gWP = 0;
            this.gWM = i;
        }

        public a(String str) {
            this.gWM = -1;
            this.gWN = "";
            this.aao = R.color.cp_link_tip_c;
            this.gWO = R.drawable.pic_dot_title;
            this.gWP = 0;
            this.gWN = str;
        }

        public a(String str, int i) {
            this.gWM = -1;
            this.gWN = "";
            this.aao = R.color.cp_link_tip_c;
            this.gWO = R.drawable.pic_dot_title;
            this.gWP = 0;
            this.gWN = str;
            this.gWO = i;
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
                if (aVar.gWM > 0) {
                    aVar.gWN = context.getString(aVar.gWM);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.gWN)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.gWN);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(aVar.aao)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ao.getBitmap(aVar.gWO);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.gWP != 0) {
                        iVar.setOffset(aVar.gWP);
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

    public static void a(bv bvVar, TextView textView) {
        if ((StringUtils.isNull(bvVar.getTitle()) && (bvVar.aWj() == null || bvVar.aWj().size() == 0)) || bvVar.aWz() == 1) {
            bvVar.w(false, true);
            if (bvVar.aWV() == null || StringUtils.isNull(bvVar.aWV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bvVar.aWV());
            return;
        }
        textView.setVisibility(0);
        bvVar.dSm = 0;
        bvVar.w(false, true);
        SpannableStringBuilder aWV = bvVar.aWV();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(aWV));
        textView.setText(aWV);
        a(textView, bvVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public static SpannableStringBuilder dV(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
