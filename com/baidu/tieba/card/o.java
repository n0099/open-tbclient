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
    public static void mG(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.vV(str)) {
            readThreadHistory.vT(str);
        }
    }

    public static boolean mH(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.vU(str)) ? false : true;
    }

    public static String aqj() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String zu() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (mH(str)) {
                al.h(textView, i2);
            } else {
                al.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Tx;
        public int cXJ;
        public String cXK;
        public int cXL;
        public int cXM;

        public a(int i, int i2, int i3) {
            this.cXJ = -1;
            this.cXK = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cXL = e.f.pic_dot_title;
            this.cXM = 0;
            this.cXJ = i;
            this.Tx = i2;
            this.cXL = i3;
        }

        public a(int i) {
            this.cXJ = -1;
            this.cXK = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cXL = e.f.pic_dot_title;
            this.cXM = 0;
            this.cXJ = i;
        }

        public a(String str) {
            this.cXJ = -1;
            this.cXK = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cXL = e.f.pic_dot_title;
            this.cXM = 0;
            this.cXK = str;
        }

        public a(String str, int i) {
            this.cXJ = -1;
            this.cXK = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cXL = e.f.pic_dot_title;
            this.cXM = 0;
            this.cXK = str;
            this.cXL = i;
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
                if (aVar.cXJ > 0) {
                    aVar.cXK = context.getString(aVar.cXJ);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cXK)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cXK);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Tx)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap dO = al.dO(aVar.cXL);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
                    if (dO != null) {
                        bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cXM != 0) {
                        mVar.setOffset(aVar.cXM);
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
