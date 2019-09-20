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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void vW(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Fz(str)) {
            readThreadHistory.Fx(str);
        }
    }

    public static boolean vX(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Fy(str)) ? false : true;
    }

    public static String bak() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aep() {
        return "personalize_page";
    }

    public static String bal() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (vX(str)) {
                am.j(textView, i2);
            } else {
                am.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Ur;
        public int eEw;
        public String eEx;
        public int eEy;
        public int eEz;

        public a(int i, int i2, int i3) {
            this.eEw = -1;
            this.eEx = "";
            this.Ur = R.color.cp_link_tip_c;
            this.eEy = R.drawable.pic_dot_title;
            this.eEz = 0;
            this.eEw = i;
            this.Ur = i2;
            this.eEy = i3;
        }

        public a(int i) {
            this.eEw = -1;
            this.eEx = "";
            this.Ur = R.color.cp_link_tip_c;
            this.eEy = R.drawable.pic_dot_title;
            this.eEz = 0;
            this.eEw = i;
        }

        public a(String str) {
            this.eEw = -1;
            this.eEx = "";
            this.Ur = R.color.cp_link_tip_c;
            this.eEy = R.drawable.pic_dot_title;
            this.eEz = 0;
            this.eEx = str;
        }

        public a(String str, int i) {
            this.eEw = -1;
            this.eEx = "";
            this.Ur = R.color.cp_link_tip_c;
            this.eEy = R.drawable.pic_dot_title;
            this.eEz = 0;
            this.eEx = str;
            this.eEy = i;
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
                if (aVar.eEw > 0) {
                    aVar.eEx = context.getString(aVar.eEw);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.eEx)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.eEx);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Ur)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap ij = am.ij(aVar.eEy);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
                    if (ij != null) {
                        bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.eEz != 0) {
                        kVar.setOffset(aVar.eEz);
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

    public static void a(bh bhVar, TextView textView) {
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.aeA() == null || bhVar.aeA().size() == 0)) || bhVar.aeR() == 1) {
            bhVar.m(false, true);
            if (bhVar.afi() == null || StringUtils.isNull(bhVar.afi().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.afi());
            return;
        }
        textView.setVisibility(0);
        bhVar.bKs = 0;
        bhVar.m(false, true);
        SpannableStringBuilder afi = bhVar.afi();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(afi));
        textView.setText(afi);
        a(textView, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder cH(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
