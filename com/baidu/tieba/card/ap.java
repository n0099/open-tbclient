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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ap {
    public static void hG(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.rg(str)) {
            readThreadHistory.re(str);
        }
    }

    public static boolean hH(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.rf(str)) ? false : true;
    }

    public static String NC() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String ND() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hH(str)) {
                com.baidu.tbadk.core.util.av.j((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.av.j((View) textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.av.cN(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, t.d.cp_link_tip_a, t.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aZN;
        public String aZO;
        public int aZP;
        public int aZQ;

        public a(int i, int i2, int i3) {
            this.aZN = -1;
            this.aZO = "";
            this.aZP = t.d.cp_link_tip_a;
            this.aZQ = t.f.pic_dot_title;
            this.aZN = i;
            this.aZP = i2;
            this.aZQ = i3;
        }

        public a(int i) {
            this.aZN = -1;
            this.aZO = "";
            this.aZP = t.d.cp_link_tip_a;
            this.aZQ = t.f.pic_dot_title;
            this.aZN = i;
        }

        public a(String str) {
            this.aZN = -1;
            this.aZO = "";
            this.aZP = t.d.cp_link_tip_a;
            this.aZQ = t.f.pic_dot_title;
            this.aZO = str;
        }
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z) {
        if (com.baidu.adp.lib.util.j.isEmpty(str) || context == null || arrayList == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i != arrayList.size(); i++) {
            a aVar = arrayList.get(i);
            if (aVar != null) {
                if (aVar.aZN > 0) {
                    aVar.aZO = context.getString(aVar.aZN);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.aZO)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.aZO);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(aVar.aZP)), length, spannableStringBuilder.length(), 17);
                    Bitmap cN = com.baidu.tbadk.core.util.av.cN(aVar.aZQ);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                    if (cN != null) {
                        bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                    }
                    com.baidu.tbadk.core.view.ai aiVar = new com.baidu.tbadk.core.view.ai(bitmapDrawable);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(aiVar, length2, spannableStringBuilder.length(), 17);
                }
            }
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }
}
