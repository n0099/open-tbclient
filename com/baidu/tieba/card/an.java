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
    public static void hN(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.rv(str)) {
            readThreadHistory.rt(str);
        }
    }

    public static boolean hO(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.ru(str)) ? false : true;
    }

    public static String Oc() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String Od() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hO(str)) {
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
        return a(context, charSequence, i, r.d.cp_link_tip_a, r.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bae;
        public String baf;
        public int bag;
        public int bah;

        public a(int i, int i2, int i3) {
            this.bae = -1;
            this.baf = "";
            this.bag = r.d.cp_link_tip_a;
            this.bah = r.f.pic_dot_title;
            this.bae = i;
            this.bag = i2;
            this.bah = i3;
        }

        public a(int i) {
            this.bae = -1;
            this.baf = "";
            this.bag = r.d.cp_link_tip_a;
            this.bah = r.f.pic_dot_title;
            this.bae = i;
        }

        public a(String str) {
            this.bae = -1;
            this.baf = "";
            this.bag = r.d.cp_link_tip_a;
            this.bah = r.f.pic_dot_title;
            this.baf = str;
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
                if (aVar.bae > 0) {
                    aVar.baf = context.getString(aVar.bae);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.baf)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.baf);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(aVar.bag)), length, spannableStringBuilder.length(), 17);
                    Bitmap cN = com.baidu.tbadk.core.util.av.cN(aVar.bah);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                    if (cN != null) {
                        bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                    }
                    com.baidu.tbadk.core.view.ag agVar = new com.baidu.tbadk.core.view.ag(bitmapDrawable);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(agVar, length2, spannableStringBuilder.length(), 17);
                }
            }
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    public static void a(com.baidu.tbadk.core.data.bi biVar, TextView textView) {
        if ((StringUtils.isNull(biVar.getTitle()) && (biVar.rM() == null || biVar.rM().size() == 0)) || biVar.sb() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        biVar.TA = 0;
        biVar.su();
        SpannableStringBuilder sm = biVar.sm();
        textView.setOnTouchListener(new com.baidu.tieba.view.y(sm));
        textView.setText(sm);
        a(textView, biVar.getId(), r.d.cp_cont_b, r.d.cp_cont_c);
    }
}
