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
    public static void me(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.vr(str)) {
            readThreadHistory.vp(str);
        }
    }

    public static boolean mf(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.vq(str)) ? false : true;
    }

    public static String anH() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String yq() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (mf(str)) {
                al.h(textView, i2);
            } else {
                al.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Tx;
        public int cOm;
        public String cOn;
        public int cOo;
        public int cOp;

        public a(int i, int i2, int i3) {
            this.cOm = -1;
            this.cOn = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cOo = e.f.pic_dot_title;
            this.cOp = 0;
            this.cOm = i;
            this.Tx = i2;
            this.cOo = i3;
        }

        public a(int i) {
            this.cOm = -1;
            this.cOn = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cOo = e.f.pic_dot_title;
            this.cOp = 0;
            this.cOm = i;
        }

        public a(String str) {
            this.cOm = -1;
            this.cOn = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cOo = e.f.pic_dot_title;
            this.cOp = 0;
            this.cOn = str;
        }

        public a(String str, int i) {
            this.cOm = -1;
            this.cOn = "";
            this.Tx = e.d.cp_link_tip_c;
            this.cOo = e.f.pic_dot_title;
            this.cOp = 0;
            this.cOn = str;
            this.cOo = i;
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
                if (aVar.cOm > 0) {
                    aVar.cOn = context.getString(aVar.cOm);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cOn)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cOn);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Tx)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap dA = al.dA(aVar.cOo);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(dA);
                    if (dA != null) {
                        bitmapDrawable.setBounds(0, 0, dA.getWidth(), dA.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cOp != 0) {
                        mVar.setOffset(aVar.cOp);
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
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.yA() == null || bbVar.yA().size() == 0)) || bbVar.yS() == 1) {
            bbVar.b(false, true, false);
            if (bbVar.zc() == null || StringUtils.isNull(bbVar.zc().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.zc());
            return;
        }
        textView.setVisibility(0);
        bbVar.apY = 0;
        bbVar.b(false, true, false);
        SpannableStringBuilder zc = bbVar.zc();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(zc));
        textView.setText(zc);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static void b(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.yA() == null || bbVar.yA().size() == 0)) || bbVar.yS() == 1) {
            bbVar.g(false, true);
            if (bbVar.zc() == null || StringUtils.isNull(bbVar.zc().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.zc());
            return;
        }
        textView.setVisibility(0);
        bbVar.apY = 0;
        bbVar.g(false, true);
        SpannableStringBuilder zc = bbVar.zc();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(zc));
        textView.setText(zc);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static SpannableStringBuilder bh(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
