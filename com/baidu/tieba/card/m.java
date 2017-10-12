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
    public static void jm(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.sa(str)) {
            readThreadHistory.rY(str);
        }
    }

    public static boolean jn(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.rZ(str)) ? false : true;
    }

    public static String XG() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rm() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (jn(str)) {
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
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, aj.cR(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.e.cp_link_tip_a, d.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bLm;
        public String bLn;
        public int bLo;
        public int bLp;
        public int bLq;

        public a(int i, int i2, int i3) {
            this.bLm = -1;
            this.bLn = "";
            this.bLo = d.e.cp_link_tip_c;
            this.bLp = d.g.pic_dot_title;
            this.bLq = 0;
            this.bLm = i;
            this.bLo = i2;
            this.bLp = i3;
        }

        public a(int i) {
            this.bLm = -1;
            this.bLn = "";
            this.bLo = d.e.cp_link_tip_c;
            this.bLp = d.g.pic_dot_title;
            this.bLq = 0;
            this.bLm = i;
        }

        public a(String str) {
            this.bLm = -1;
            this.bLn = "";
            this.bLo = d.e.cp_link_tip_c;
            this.bLp = d.g.pic_dot_title;
            this.bLq = 0;
            this.bLn = str;
        }

        public a(String str, int i) {
            this.bLm = -1;
            this.bLn = "";
            this.bLo = d.e.cp_link_tip_c;
            this.bLp = d.g.pic_dot_title;
            this.bLq = 0;
            this.bLn = str;
            this.bLp = i;
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
                if (aVar.bLm > 0) {
                    aVar.bLn = context.getString(aVar.bLm);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.bLn)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bLn);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(aVar.bLo)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cR = aj.cR(aVar.bLp);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                    if (cR != null) {
                        bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.bLq != 0) {
                        iVar.setOffset(aVar.bLq);
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
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rt() == null || bhVar.rt().size() == 0)) || bhVar.rK() == 1) {
            bhVar.b(false, true, false);
            if (bhVar.rV() == null || StringUtils.isNull(bhVar.rV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.rV());
            return;
        }
        textView.setVisibility(0);
        bhVar.Yw = 0;
        bhVar.b(false, true, false);
        SpannableStringBuilder rV = bhVar.rV();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(rV));
        textView.setText(rV);
        a(textView, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void b(bh bhVar, TextView textView) {
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rt() == null || bhVar.rt().size() == 0)) || bhVar.rK() == 1) {
            bhVar.e(false, true);
            if (bhVar.rV() == null || StringUtils.isNull(bhVar.rV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.rV());
            return;
        }
        textView.setVisibility(0);
        bhVar.Yw = 0;
        bhVar.e(false, true);
        SpannableStringBuilder rV = bhVar.rV();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(rV));
        textView.setText(rV);
        a(textView, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void a(Context context, bh bhVar, TextView textView) {
        String string;
        if (context != null && bhVar != null) {
            if (StringUtils.isNull(bhVar.rA())) {
                string = "吧";
            } else {
                string = context.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bhVar.rA(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            aj.i(textView, d.e.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aK(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
