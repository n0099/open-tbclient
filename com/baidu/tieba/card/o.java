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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    public static void kY(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.ud(str)) {
            readThreadHistory.ub(str);
        }
    }

    public static boolean kZ(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.uc(str)) ? false : true;
    }

    public static String aiS() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String uX() {
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
        public int QE;
        public int cyU;
        public String cyV;
        public int cyW;
        public int cyX;

        public a(int i, int i2, int i3) {
            this.cyU = -1;
            this.cyV = "";
            this.QE = f.d.cp_link_tip_c;
            this.cyW = f.C0146f.pic_dot_title;
            this.cyX = 0;
            this.cyU = i;
            this.QE = i2;
            this.cyW = i3;
        }

        public a(int i) {
            this.cyU = -1;
            this.cyV = "";
            this.QE = f.d.cp_link_tip_c;
            this.cyW = f.C0146f.pic_dot_title;
            this.cyX = 0;
            this.cyU = i;
        }

        public a(String str) {
            this.cyU = -1;
            this.cyV = "";
            this.QE = f.d.cp_link_tip_c;
            this.cyW = f.C0146f.pic_dot_title;
            this.cyX = 0;
            this.cyV = str;
        }

        public a(String str, int i) {
            this.cyU = -1;
            this.cyV = "";
            this.QE = f.d.cp_link_tip_c;
            this.cyW = f.C0146f.pic_dot_title;
            this.cyX = 0;
            this.cyV = str;
            this.cyW = i;
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
                if (aVar.cyU > 0) {
                    aVar.cyV = context.getString(aVar.cyU);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cyV)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cyV);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.QE)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cT = am.cT(aVar.cyW);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                    if (cT != null) {
                        bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                    }
                    com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                    if (aVar.cyX != 0) {
                        jVar.setOffset(aVar.cyX);
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
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.vh() == null || bbVar.vh().size() == 0)) || bbVar.vz() == 1) {
            bbVar.b(false, true, false);
            if (bbVar.vI() == null || StringUtils.isNull(bbVar.vI().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.vI());
            return;
        }
        textView.setVisibility(0);
        bbVar.ahP = 0;
        bbVar.b(false, true, false);
        SpannableStringBuilder vI = bbVar.vI();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vI));
        textView.setText(vI);
        a(textView, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
    }

    public static void b(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.vh() == null || bbVar.vh().size() == 0)) || bbVar.vz() == 1) {
            bbVar.e(false, true);
            if (bbVar.vI() == null || StringUtils.isNull(bbVar.vI().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.vI());
            return;
        }
        textView.setVisibility(0);
        bbVar.ahP = 0;
        bbVar.e(false, true);
        SpannableStringBuilder vI = bbVar.vI();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vI));
        textView.setText(vI);
        a(textView, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
    }

    public static SpannableStringBuilder aM(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(f.d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
