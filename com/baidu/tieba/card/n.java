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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void tA(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.CO(str)) {
            readThreadHistory.CM(str);
        }
    }

    public static boolean tB(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.CN(str)) ? false : true;
    }

    public static String aQx() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String YE() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (tB(str)) {
                al.j(textView, i2);
            } else {
                al.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Wl;
        public int eih;
        public String eii;
        public int eij;
        public int eik;

        public a(int i, int i2, int i3) {
            this.eih = -1;
            this.eii = "";
            this.Wl = d.C0277d.cp_link_tip_c;
            this.eij = d.f.pic_dot_title;
            this.eik = 0;
            this.eih = i;
            this.Wl = i2;
            this.eij = i3;
        }

        public a(int i) {
            this.eih = -1;
            this.eii = "";
            this.Wl = d.C0277d.cp_link_tip_c;
            this.eij = d.f.pic_dot_title;
            this.eik = 0;
            this.eih = i;
        }

        public a(String str) {
            this.eih = -1;
            this.eii = "";
            this.Wl = d.C0277d.cp_link_tip_c;
            this.eij = d.f.pic_dot_title;
            this.eik = 0;
            this.eii = str;
        }

        public a(String str, int i) {
            this.eih = -1;
            this.eii = "";
            this.Wl = d.C0277d.cp_link_tip_c;
            this.eij = d.f.pic_dot_title;
            this.eik = 0;
            this.eii = str;
            this.eij = i;
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
                if (aVar.eih > 0) {
                    aVar.eii = context.getString(aVar.eih);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.eii)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.eii);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Wl)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap hq = al.hq(aVar.eij);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(hq);
                    if (hq != null) {
                        bitmapDrawable.setBounds(0, 0, hq.getWidth(), hq.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.eik != 0) {
                        kVar.setOffset(aVar.eik);
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
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.YP() == null || bgVar.YP().size() == 0)) || bgVar.Zg() == 1) {
            bgVar.b(false, true, false);
            if (bgVar.Zx() == null || StringUtils.isNull(bgVar.Zx().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bgVar.Zx());
            return;
        }
        textView.setVisibility(0);
        bgVar.bBu = 0;
        bgVar.b(false, true, false);
        SpannableStringBuilder Zx = bgVar.Zx();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
        textView.setText(Zx);
        a(textView, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
    }

    public static void b(bg bgVar, TextView textView) {
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.YP() == null || bgVar.YP().size() == 0)) || bgVar.Zg() == 1) {
            bgVar.k(false, true);
            if (bgVar.Zx() == null || StringUtils.isNull(bgVar.Zx().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bgVar.Zx());
            return;
        }
        textView.setVisibility(0);
        bgVar.bBu = 0;
        bgVar.k(false, true);
        SpannableStringBuilder Zx = bgVar.Zx();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
        textView.setText(Zx);
        a(textView, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
    }

    public static SpannableStringBuilder cs(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
