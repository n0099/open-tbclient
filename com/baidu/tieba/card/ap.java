package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ap {
    public static void hL(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.qw(str)) {
            readThreadHistory.qu(str);
        }
    }

    public static boolean hM(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.qv(str)) ? false : true;
    }

    public static String OA() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String OB() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hM(str)) {
                com.baidu.tbadk.core.util.ar.j((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.ar.j((View) textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.ar.cQ(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, r.d.cp_link_tip_a, r.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bcE;
        public String bcF;
        public int bcG;
        public int bcH;
        public int bcI;

        public a(int i, int i2, int i3) {
            this.bcE = -1;
            this.bcF = "";
            this.bcG = r.d.cp_link_tip_a;
            this.bcH = r.f.pic_dot_title;
            this.bcI = 0;
            this.bcE = i;
            this.bcG = i2;
            this.bcH = i3;
        }

        public a(int i) {
            this.bcE = -1;
            this.bcF = "";
            this.bcG = r.d.cp_link_tip_a;
            this.bcH = r.f.pic_dot_title;
            this.bcI = 0;
            this.bcE = i;
        }

        public a(String str) {
            this.bcE = -1;
            this.bcF = "";
            this.bcG = r.d.cp_link_tip_a;
            this.bcH = r.f.pic_dot_title;
            this.bcI = 0;
            this.bcF = str;
        }

        public a(String str, int i) {
            this.bcE = -1;
            this.bcF = "";
            this.bcG = r.d.cp_link_tip_a;
            this.bcH = r.f.pic_dot_title;
            this.bcI = 0;
            this.bcF = str;
            this.bcH = i;
        }

        public void gh(int i) {
            this.bcI = i;
        }
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z) {
        return a(context, str, arrayList, z, true);
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z, boolean z2) {
        if (com.baidu.adp.lib.util.j.isEmpty(str) || context == null || arrayList == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i != arrayList.size(); i++) {
            a aVar = arrayList.get(i);
            if (aVar != null) {
                if (aVar.bcE > 0) {
                    aVar.bcF = context.getString(aVar.bcE);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bcF)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bcF);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(aVar.bcG)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cQ = com.baidu.tbadk.core.util.ar.cQ(aVar.bcH);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                    if (cQ != null) {
                        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                    }
                    com.baidu.tbadk.core.view.aj ajVar = new com.baidu.tbadk.core.view.aj(bitmapDrawable);
                    if (aVar.bcI != 0) {
                        ajVar.setOffset(aVar.bcI);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(ajVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(com.baidu.tbadk.core.data.bg bgVar, TextView textView) {
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.rD() == null || bgVar.rD().size() == 0)) || bgVar.rU() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        bgVar.Tx = 0;
        bgVar.sl();
        SpannableStringBuilder sd = bgVar.sd();
        textView.setOnTouchListener(new com.baidu.tieba.view.x(sd));
        textView.setText(sd);
        a(textView, bgVar.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
    }
}
