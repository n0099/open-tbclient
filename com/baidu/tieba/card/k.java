package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    public static void jT(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.to(str)) {
            readThreadHistory.tm(str);
        }
    }

    public static boolean jU(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.tn(str)) ? false : true;
    }

    public static String ajp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String yN() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (jU(str)) {
                aj.r(textView, i2);
            } else {
                aj.r(textView, i);
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
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, aj.fQ(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.C0108d.cp_link_tip_a, d.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aym;
        public int cPs;
        public String cPt;
        public int cPu;
        public int cPv;

        public a(int i, int i2, int i3) {
            this.cPs = -1;
            this.cPt = "";
            this.aym = d.C0108d.cp_link_tip_c;
            this.cPu = d.f.pic_dot_title;
            this.cPv = 0;
            this.cPs = i;
            this.aym = i2;
            this.cPu = i3;
        }

        public a(int i) {
            this.cPs = -1;
            this.cPt = "";
            this.aym = d.C0108d.cp_link_tip_c;
            this.cPu = d.f.pic_dot_title;
            this.cPv = 0;
            this.cPs = i;
        }

        public a(String str) {
            this.cPs = -1;
            this.cPt = "";
            this.aym = d.C0108d.cp_link_tip_c;
            this.cPu = d.f.pic_dot_title;
            this.cPv = 0;
            this.cPt = str;
        }

        public a(String str, int i) {
            this.cPs = -1;
            this.cPt = "";
            this.aym = d.C0108d.cp_link_tip_c;
            this.cPu = d.f.pic_dot_title;
            this.cPv = 0;
            this.cPt = str;
            this.cPu = i;
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
                if (aVar.cPs > 0) {
                    aVar.cPt = context.getString(aVar.cPs);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cPt)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cPt);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(aVar.aym)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap fQ = aj.fQ(aVar.cPu);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(fQ);
                    if (fQ != null) {
                        bitmapDrawable.setBounds(0, 0, fQ.getWidth(), fQ.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.cPv != 0) {
                        kVar.setOffset(aVar.cPv);
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

    public static void a(be beVar, TextView textView) {
        if ((StringUtils.isNull(beVar.getTitle()) && (beVar.yV() == null || beVar.yV().size() == 0)) || beVar.zn() == 1) {
            beVar.c(false, true, false);
            if (beVar.zx() == null || StringUtils.isNull(beVar.zx().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(beVar.zx());
            return;
        }
        textView.setVisibility(0);
        beVar.aNr = 0;
        beVar.c(false, true, false);
        SpannableStringBuilder zx = beVar.zx();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(zx));
        textView.setText(zx);
        a(textView, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
    }

    public static void b(be beVar, TextView textView) {
        if ((StringUtils.isNull(beVar.getTitle()) && (beVar.yV() == null || beVar.yV().size() == 0)) || beVar.zn() == 1) {
            beVar.h(false, true);
            if (beVar.zx() == null || StringUtils.isNull(beVar.zx().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(beVar.zx());
            return;
        }
        textView.setVisibility(0);
        beVar.aNr = 0;
        beVar.h(false, true);
        SpannableStringBuilder zx = beVar.zx();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(zx));
        textView.setText(zx);
        a(textView, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
    }

    public static void a(Context context, be beVar, TextView textView) {
        String string;
        if (context != null && beVar != null) {
            if (StringUtils.isNull(beVar.zd())) {
                string = "吧";
            } else {
                string = context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(beVar.zd(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            aj.r(textView, d.C0108d.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aG(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
