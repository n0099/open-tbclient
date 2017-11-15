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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void jL(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.sN(str)) {
            readThreadHistory.sL(str);
        }
    }

    public static boolean jM(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.sM(str)) ? false : true;
    }

    public static String ZY() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rj() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (jM(str)) {
                aj.i(textView, i2);
            } else {
                aj.i(textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, aj.cQ(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.C0080d.cp_link_tip_a, d.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bSR;
        public String bSS;
        public int bST;
        public int bSU;
        public int bSV;

        public a(int i, int i2, int i3) {
            this.bSR = -1;
            this.bSS = "";
            this.bST = d.C0080d.cp_link_tip_c;
            this.bSU = d.f.pic_dot_title;
            this.bSV = 0;
            this.bSR = i;
            this.bST = i2;
            this.bSU = i3;
        }

        public a(int i) {
            this.bSR = -1;
            this.bSS = "";
            this.bST = d.C0080d.cp_link_tip_c;
            this.bSU = d.f.pic_dot_title;
            this.bSV = 0;
            this.bSR = i;
        }

        public a(String str) {
            this.bSR = -1;
            this.bSS = "";
            this.bST = d.C0080d.cp_link_tip_c;
            this.bSU = d.f.pic_dot_title;
            this.bSV = 0;
            this.bSS = str;
        }

        public a(String str, int i) {
            this.bSR = -1;
            this.bSS = "";
            this.bST = d.C0080d.cp_link_tip_c;
            this.bSU = d.f.pic_dot_title;
            this.bSV = 0;
            this.bSS = str;
            this.bSU = i;
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
                if (aVar.bSR > 0) {
                    aVar.bSS = context.getString(aVar.bSR);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.bSS)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bSS);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(aVar.bST)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cQ = aj.cQ(aVar.bSU);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                    if (cQ != null) {
                        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.bSV != 0) {
                        iVar.setOffset(aVar.bSV);
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

    public static void a(bh bhVar, TextView textView) {
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rr() == null || bhVar.rr().size() == 0)) || bhVar.rJ() == 1) {
            bhVar.b(false, true, false);
            if (bhVar.rU() == null || StringUtils.isNull(bhVar.rU().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.rU());
            return;
        }
        textView.setVisibility(0);
        bhVar.YC = 0;
        bhVar.b(false, true, false);
        SpannableStringBuilder rU = bhVar.rU();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(rU));
        textView.setText(rU);
        a(textView, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
    }

    public static void b(bh bhVar, TextView textView) {
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rr() == null || bhVar.rr().size() == 0)) || bhVar.rJ() == 1) {
            bhVar.e(false, true);
            if (bhVar.rU() == null || StringUtils.isNull(bhVar.rU().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.rU());
            return;
        }
        textView.setVisibility(0);
        bhVar.YC = 0;
        bhVar.e(false, true);
        SpannableStringBuilder rU = bhVar.rU();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(rU));
        textView.setText(rU);
        a(textView, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
    }

    public static void a(Context context, bh bhVar, TextView textView) {
        String string;
        if (context != null && bhVar != null) {
            if (StringUtils.isNull(bhVar.rz())) {
                string = "吧";
            } else {
                string = context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(bhVar.rz(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            aj.i(textView, d.C0080d.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aG(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
