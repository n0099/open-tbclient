package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void vw(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.EY(str)) {
            readThreadHistory.EW(str);
        }
    }

    public static boolean vx(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.EX(str)) ? false : true;
    }

    public static String aZE() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aek() {
        return "personalize_page";
    }

    public static String aZF() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (vx(str)) {
                am.j(textView, i2);
            } else {
                am.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Us;
        public int eCG;
        public String eCH;
        public int eCI;
        public int eCJ;

        public a(int i, int i2, int i3) {
            this.eCG = -1;
            this.eCH = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCI = R.drawable.pic_dot_title;
            this.eCJ = 0;
            this.eCG = i;
            this.Us = i2;
            this.eCI = i3;
        }

        public a(int i) {
            this.eCG = -1;
            this.eCH = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCI = R.drawable.pic_dot_title;
            this.eCJ = 0;
            this.eCG = i;
        }

        public a(String str) {
            this.eCG = -1;
            this.eCH = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCI = R.drawable.pic_dot_title;
            this.eCJ = 0;
            this.eCH = str;
        }

        public a(String str, int i) {
            this.eCG = -1;
            this.eCH = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCI = R.drawable.pic_dot_title;
            this.eCJ = 0;
            this.eCH = str;
            this.eCI = i;
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
                if (aVar.eCG > 0) {
                    aVar.eCH = context.getString(aVar.eCG);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.eCH)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.eCH);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Us)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap ij = am.ij(aVar.eCI);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
                    if (ij != null) {
                        bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.eCJ != 0) {
                        kVar.setOffset(aVar.eCJ);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(kVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bg bgVar, TextView textView) {
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.aev() == null || bgVar.aev().size() == 0)) || bgVar.aeM() == 1) {
            bgVar.m(false, true);
            if (bgVar.afd() == null || StringUtils.isNull(bgVar.afd().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bgVar.afd());
            return;
        }
        textView.setVisibility(0);
        bgVar.bJP = 0;
        bgVar.m(false, true);
        SpannableStringBuilder afd = bgVar.afd();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(afd));
        textView.setText(afd);
        a(textView, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder cG(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
