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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    public static void kW(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.tZ(str)) {
            readThreadHistory.tX(str);
        }
    }

    public static boolean kX(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.tY(str)) ? false : true;
    }

    public static String aiP() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String uY() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (kX(str)) {
                am.h(textView, i2);
            } else {
                am.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int QE;
        public int cyX;
        public String cyY;
        public int cyZ;
        public int cza;

        public a(int i, int i2, int i3) {
            this.cyX = -1;
            this.cyY = "";
            this.QE = d.C0140d.cp_link_tip_c;
            this.cyZ = d.f.pic_dot_title;
            this.cza = 0;
            this.cyX = i;
            this.QE = i2;
            this.cyZ = i3;
        }

        public a(int i) {
            this.cyX = -1;
            this.cyY = "";
            this.QE = d.C0140d.cp_link_tip_c;
            this.cyZ = d.f.pic_dot_title;
            this.cza = 0;
            this.cyX = i;
        }

        public a(String str) {
            this.cyX = -1;
            this.cyY = "";
            this.QE = d.C0140d.cp_link_tip_c;
            this.cyZ = d.f.pic_dot_title;
            this.cza = 0;
            this.cyY = str;
        }

        public a(String str, int i) {
            this.cyX = -1;
            this.cyY = "";
            this.QE = d.C0140d.cp_link_tip_c;
            this.cyZ = d.f.pic_dot_title;
            this.cza = 0;
            this.cyY = str;
            this.cyZ = i;
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
                if (aVar.cyX > 0) {
                    aVar.cyY = context.getString(aVar.cyX);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cyY)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cyY);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.QE)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cT = am.cT(aVar.cyZ);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                    if (cT != null) {
                        bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                    }
                    com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                    if (aVar.cza != 0) {
                        jVar.setOffset(aVar.cza);
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

    public static void a(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.vi() == null || bbVar.vi().size() == 0)) || bbVar.vA() == 1) {
            bbVar.b(false, true, false);
            if (bbVar.vJ() == null || StringUtils.isNull(bbVar.vJ().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.vJ());
            return;
        }
        textView.setVisibility(0);
        bbVar.ahP = 0;
        bbVar.b(false, true, false);
        SpannableStringBuilder vJ = bbVar.vJ();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vJ));
        textView.setText(vJ);
        a(textView, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
    }

    public static void b(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.vi() == null || bbVar.vi().size() == 0)) || bbVar.vA() == 1) {
            bbVar.e(false, true);
            if (bbVar.vJ() == null || StringUtils.isNull(bbVar.vJ().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.vJ());
            return;
        }
        textView.setVisibility(0);
        bbVar.ahP = 0;
        bbVar.e(false, true);
        SpannableStringBuilder vJ = bbVar.vJ();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vJ));
        textView.setText(vJ);
        a(textView, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
    }

    public static SpannableStringBuilder aM(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
