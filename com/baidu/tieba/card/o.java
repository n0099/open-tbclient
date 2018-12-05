package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    public static void mD(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.vS(str)) {
            readThreadHistory.vQ(str);
        }
    }

    public static boolean mE(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.vR(str)) ? false : true;
    }

    public static String apu() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String zu() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (mE(str)) {
                al.h(textView, i2);
            } else {
                al.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Tx;
        public int cUT;
        public String cUU;
        public int cUV;
        public int cUW;

        public a(int i, int i2, int i3) {
            this.cUT = -1;
            this.cUU = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cUV = e.f.pic_dot_title;
            this.cUW = 0;
            this.cUT = i;
            this.Tx = i2;
            this.cUV = i3;
        }

        public a(int i) {
            this.cUT = -1;
            this.cUU = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cUV = e.f.pic_dot_title;
            this.cUW = 0;
            this.cUT = i;
        }

        public a(String str) {
            this.cUT = -1;
            this.cUU = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cUV = e.f.pic_dot_title;
            this.cUW = 0;
            this.cUU = str;
        }

        public a(String str, int i) {
            this.cUT = -1;
            this.cUU = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cUV = e.f.pic_dot_title;
            this.cUW = 0;
            this.cUU = str;
            this.cUV = i;
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
                if (aVar.cUT > 0) {
                    aVar.cUU = context.getString(aVar.cUT);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cUU)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cUU);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Tx)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap dO = al.dO(aVar.cUV);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
                    if (dO != null) {
                        bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cUW != 0) {
                        mVar.setOffset(aVar.cUW);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(mVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.zE() == null || bbVar.zE().size() == 0)) || bbVar.zW() == 1) {
            bbVar.b(false, true, false);
            if (bbVar.Ag() == null || StringUtils.isNull(bbVar.Ag().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.Ag());
            return;
        }
        textView.setVisibility(0);
        bbVar.aty = 0;
        bbVar.b(false, true, false);
        SpannableStringBuilder Ag = bbVar.Ag();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Ag));
        textView.setText(Ag);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static void b(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.zE() == null || bbVar.zE().size() == 0)) || bbVar.zW() == 1) {
            bbVar.g(false, true);
            if (bbVar.Ag() == null || StringUtils.isNull(bbVar.Ag().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.Ag());
            return;
        }
        textView.setVisibility(0);
        bbVar.aty = 0;
        bbVar.g(false, true);
        SpannableStringBuilder Ag = bbVar.Ag();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Ag));
        textView.setText(Ag);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static SpannableStringBuilder bm(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
