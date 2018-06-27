package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    public static void kY(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.ub(str)) {
            readThreadHistory.tZ(str);
        }
    }

    public static boolean kZ(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.ua(str)) ? false : true;
    }

    public static String aiq() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String vk() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (kZ(str)) {
                am.h(textView, i2);
            } else {
                am.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int QH;
        public int cwu;
        public String cwv;
        public int cww;
        public int cwx;

        public a(int i, int i2, int i3) {
            this.cwu = -1;
            this.cwv = "";
            this.QH = d.C0142d.cp_link_tip_c;
            this.cww = d.f.pic_dot_title;
            this.cwx = 0;
            this.cwu = i;
            this.QH = i2;
            this.cww = i3;
        }

        public a(int i) {
            this.cwu = -1;
            this.cwv = "";
            this.QH = d.C0142d.cp_link_tip_c;
            this.cww = d.f.pic_dot_title;
            this.cwx = 0;
            this.cwu = i;
        }

        public a(String str) {
            this.cwu = -1;
            this.cwv = "";
            this.QH = d.C0142d.cp_link_tip_c;
            this.cww = d.f.pic_dot_title;
            this.cwx = 0;
            this.cwv = str;
        }

        public a(String str, int i) {
            this.cwu = -1;
            this.cwv = "";
            this.QH = d.C0142d.cp_link_tip_c;
            this.cww = d.f.pic_dot_title;
            this.cwx = 0;
            this.cwv = str;
            this.cww = i;
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
                if (aVar.cwu > 0) {
                    aVar.cwv = context.getString(aVar.cwu);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cwv)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cwv);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.QH)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cR = am.cR(aVar.cww);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                    if (cR != null) {
                        bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                    }
                    com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                    if (aVar.cwx != 0) {
                        jVar.setOffset(aVar.cwx);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(jVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bc bcVar, TextView textView) {
        if ((StringUtils.isNull(bcVar.getTitle()) && (bcVar.vu() == null || bcVar.vu().size() == 0)) || bcVar.vL() == 1) {
            bcVar.b(false, true, false);
            if (bcVar.vU() == null || StringUtils.isNull(bcVar.vU().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bcVar.vU());
            return;
        }
        textView.setVisibility(0);
        bcVar.ait = 0;
        bcVar.b(false, true, false);
        SpannableStringBuilder vU = bcVar.vU();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vU));
        textView.setText(vU);
        a(textView, bcVar.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
    }

    public static void b(bc bcVar, TextView textView) {
        if ((StringUtils.isNull(bcVar.getTitle()) && (bcVar.vu() == null || bcVar.vu().size() == 0)) || bcVar.vL() == 1) {
            bcVar.e(false, true);
            if (bcVar.vU() == null || StringUtils.isNull(bcVar.vU().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bcVar.vU());
            return;
        }
        textView.setVisibility(0);
        bcVar.ait = 0;
        bcVar.e(false, true);
        SpannableStringBuilder vU = bcVar.vU();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vU));
        textView.setText(vU);
        a(textView, bcVar.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
    }

    public static SpannableStringBuilder aO(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
