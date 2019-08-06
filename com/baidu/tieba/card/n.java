package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void vx(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.EZ(str)) {
            readThreadHistory.EX(str);
        }
    }

    public static boolean vy(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.EY(str)) ? false : true;
    }

    public static String aZG() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String ael() {
        return "personalize_page";
    }

    public static String aZH() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (vy(str)) {
                am.j(textView, i2);
            } else {
                am.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Us;
        public int eCN;
        public String eCO;
        public int eCP;
        public int eCQ;

        public a(int i, int i2, int i3) {
            this.eCN = -1;
            this.eCO = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCP = R.drawable.pic_dot_title;
            this.eCQ = 0;
            this.eCN = i;
            this.Us = i2;
            this.eCP = i3;
        }

        public a(int i) {
            this.eCN = -1;
            this.eCO = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCP = R.drawable.pic_dot_title;
            this.eCQ = 0;
            this.eCN = i;
        }

        public a(String str) {
            this.eCN = -1;
            this.eCO = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCP = R.drawable.pic_dot_title;
            this.eCQ = 0;
            this.eCO = str;
        }

        public a(String str, int i) {
            this.eCN = -1;
            this.eCO = "";
            this.Us = R.color.cp_link_tip_c;
            this.eCP = R.drawable.pic_dot_title;
            this.eCQ = 0;
            this.eCO = str;
            this.eCP = i;
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
                if (aVar.eCN > 0) {
                    aVar.eCO = context.getString(aVar.eCN);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.eCO)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.eCO);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Us)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap ij = am.ij(aVar.eCP);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
                    if (ij != null) {
                        bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.eCQ != 0) {
                        kVar.setOffset(aVar.eCQ);
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

    public static void a(bh bhVar, TextView textView) {
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.aew() == null || bhVar.aew().size() == 0)) || bhVar.aeN() == 1) {
            bhVar.m(false, true);
            if (bhVar.afe() == null || StringUtils.isNull(bhVar.afe().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.afe());
            return;
        }
        textView.setVisibility(0);
        bhVar.bJU = 0;
        bhVar.m(false, true);
        SpannableStringBuilder afe = bhVar.afe();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(afe));
        textView.setText(afe);
        a(textView, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder cG(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
