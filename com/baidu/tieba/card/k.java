package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    public static void kc(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.sI(str)) {
            readThreadHistory.sG(str);
        }
    }

    public static boolean kd(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.sH(str)) ? false : true;
    }

    public static String aks() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String yI() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (kd(str)) {
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
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, aj.fO(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.C0107d.cp_link_tip_a, d.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ayl;
        public int cTU;
        public String cTV;
        public int cTW;
        public int cTX;

        public a(int i, int i2, int i3) {
            this.cTU = -1;
            this.cTV = "";
            this.ayl = d.C0107d.cp_link_tip_c;
            this.cTW = d.f.pic_dot_title;
            this.cTX = 0;
            this.cTU = i;
            this.ayl = i2;
            this.cTW = i3;
        }

        public a(int i) {
            this.cTU = -1;
            this.cTV = "";
            this.ayl = d.C0107d.cp_link_tip_c;
            this.cTW = d.f.pic_dot_title;
            this.cTX = 0;
            this.cTU = i;
        }

        public a(String str) {
            this.cTU = -1;
            this.cTV = "";
            this.ayl = d.C0107d.cp_link_tip_c;
            this.cTW = d.f.pic_dot_title;
            this.cTX = 0;
            this.cTV = str;
        }

        public a(String str, int i) {
            this.cTU = -1;
            this.cTV = "";
            this.ayl = d.C0107d.cp_link_tip_c;
            this.cTW = d.f.pic_dot_title;
            this.cTX = 0;
            this.cTV = str;
            this.cTW = i;
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
                if (aVar.cTU > 0) {
                    aVar.cTV = context.getString(aVar.cTU);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cTV)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cTV);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(aVar.ayl)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap fO = aj.fO(aVar.cTW);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                    if (fO != null) {
                        bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cTX != 0) {
                        mVar.setOffset(aVar.cTX);
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

    public static void a(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yQ() == null || bdVar.yQ().size() == 0)) || bdVar.zi() == 1) {
            bdVar.c(false, true, false);
            if (bdVar.zs() == null || StringUtils.isNull(bdVar.zs().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.zs());
            return;
        }
        textView.setVisibility(0);
        bdVar.aNn = 0;
        bdVar.c(false, true, false);
        SpannableStringBuilder zs = bdVar.zs();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(zs));
        textView.setText(zs);
        a(textView, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
    }

    public static void b(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yQ() == null || bdVar.yQ().size() == 0)) || bdVar.zi() == 1) {
            bdVar.h(false, true);
            if (bdVar.zs() == null || StringUtils.isNull(bdVar.zs().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.zs());
            return;
        }
        textView.setVisibility(0);
        bdVar.aNn = 0;
        bdVar.h(false, true);
        SpannableStringBuilder zs = bdVar.zs();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(zs));
        textView.setText(zs);
        a(textView, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
    }

    public static void a(Context context, bd bdVar, TextView textView) {
        String string;
        if (context != null && bdVar != null) {
            if (StringUtils.isNull(bdVar.yY())) {
                string = "吧";
            } else {
                string = context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(bdVar.yY(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            aj.r(textView, d.C0107d.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aG(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
