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
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void tC(String str) {
        d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.CQ(str)) {
            readThreadHistory.CO(str);
        }
    }

    public static boolean tD(String str) {
        d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.CP(str)) ? false : true;
    }

    public static String aQy() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String YE() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (tD(str)) {
                al.j(textView, i2);
            } else {
                al.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Wk;
        public int eil;
        public String eim;
        public int ein;
        public int eio;

        public a(int i, int i2, int i3) {
            this.eil = -1;
            this.eim = "";
            this.Wk = d.C0236d.cp_link_tip_c;
            this.ein = d.f.pic_dot_title;
            this.eio = 0;
            this.eil = i;
            this.Wk = i2;
            this.ein = i3;
        }

        public a(int i) {
            this.eil = -1;
            this.eim = "";
            this.Wk = d.C0236d.cp_link_tip_c;
            this.ein = d.f.pic_dot_title;
            this.eio = 0;
            this.eil = i;
        }

        public a(String str) {
            this.eil = -1;
            this.eim = "";
            this.Wk = d.C0236d.cp_link_tip_c;
            this.ein = d.f.pic_dot_title;
            this.eio = 0;
            this.eim = str;
        }

        public a(String str, int i) {
            this.eil = -1;
            this.eim = "";
            this.Wk = d.C0236d.cp_link_tip_c;
            this.ein = d.f.pic_dot_title;
            this.eio = 0;
            this.eim = str;
            this.ein = i;
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
                if (aVar.eil > 0) {
                    aVar.eim = context.getString(aVar.eil);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.eim)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.eim);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Wk)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap hq = al.hq(aVar.ein);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(hq);
                    if (hq != null) {
                        bitmapDrawable.setBounds(0, 0, hq.getWidth(), hq.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.eio != 0) {
                        kVar.setOffset(aVar.eio);
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
        bgVar.bBs = 0;
        bgVar.b(false, true, false);
        SpannableStringBuilder Zx = bgVar.Zx();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
        textView.setText(Zx);
        a(textView, bgVar.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
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
        bgVar.bBs = 0;
        bgVar.k(false, true);
        SpannableStringBuilder Zx = bgVar.Zx();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
        textView.setText(Zx);
        a(textView, bgVar.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
    }

    public static SpannableStringBuilder cs(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0236d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0236d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
