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
public class an {
    public static void hR(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.rQ(str)) {
            readThreadHistory.rO(str);
        }
    }

    public static boolean hS(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.rP(str)) ? false : true;
    }

    public static String Pe() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String Pf() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hS(str)) {
                com.baidu.tbadk.core.util.at.j((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.at.j((View) textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.at.cO(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, r.d.cp_link_tip_a, r.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bdm;
        public String bdn;
        public int bdo;
        public int bdp;
        public int bdq;

        public a(int i, int i2, int i3) {
            this.bdm = -1;
            this.bdn = "";
            this.bdo = r.d.cp_link_tip_a;
            this.bdp = r.f.pic_dot_title;
            this.bdq = 0;
            this.bdm = i;
            this.bdo = i2;
            this.bdp = i3;
        }

        public a(int i) {
            this.bdm = -1;
            this.bdn = "";
            this.bdo = r.d.cp_link_tip_a;
            this.bdp = r.f.pic_dot_title;
            this.bdq = 0;
            this.bdm = i;
        }

        public a(String str) {
            this.bdm = -1;
            this.bdn = "";
            this.bdo = r.d.cp_link_tip_a;
            this.bdp = r.f.pic_dot_title;
            this.bdq = 0;
            this.bdn = str;
        }

        public a(String str, int i) {
            this.bdm = -1;
            this.bdn = "";
            this.bdo = r.d.cp_link_tip_a;
            this.bdp = r.f.pic_dot_title;
            this.bdq = 0;
            this.bdn = str;
            this.bdp = i;
        }

        public void gi(int i) {
            this.bdq = i;
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
                if (aVar.bdm > 0) {
                    aVar.bdn = context.getString(aVar.bdm);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bdn)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bdn);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(aVar.bdo)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cO = com.baidu.tbadk.core.util.at.cO(aVar.bdp);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                    if (cO != null) {
                        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                    }
                    com.baidu.tbadk.core.view.ah ahVar = new com.baidu.tbadk.core.view.ah(bitmapDrawable);
                    if (aVar.bdq != 0) {
                        ahVar.setOffset(aVar.bdq);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(ahVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(com.baidu.tbadk.core.data.bk bkVar, TextView textView) {
        if ((StringUtils.isNull(bkVar.getTitle()) && (bkVar.rO() == null || bkVar.rO().size() == 0)) || bkVar.sd() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        bkVar.TX = 0;
        bkVar.sw();
        SpannableStringBuilder so = bkVar.so();
        textView.setOnTouchListener(new com.baidu.tieba.view.x(so));
        textView.setText(so);
        a(textView, bkVar.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
    }
}
