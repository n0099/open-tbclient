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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class at {
    public static void hU(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.pY(str)) {
            readThreadHistory.pW(str);
        }
    }

    public static boolean hV(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.pX(str)) ? false : true;
    }

    public static String Sp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rH() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hV(str)) {
                com.baidu.tbadk.core.util.aq.i((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.aq.i((View) textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.aq.cL(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, w.e.cp_link_tip_a, w.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bto;
        public String btp;
        public int btq;
        public int btr;
        public int bts;

        public a(int i, int i2, int i3) {
            this.bto = -1;
            this.btp = "";
            this.btq = w.e.cp_link_tip_a;
            this.btr = w.g.pic_dot_title;
            this.bts = 0;
            this.bto = i;
            this.btq = i2;
            this.btr = i3;
        }

        public a(int i) {
            this.bto = -1;
            this.btp = "";
            this.btq = w.e.cp_link_tip_a;
            this.btr = w.g.pic_dot_title;
            this.bts = 0;
            this.bto = i;
        }

        public a(String str) {
            this.bto = -1;
            this.btp = "";
            this.btq = w.e.cp_link_tip_a;
            this.btr = w.g.pic_dot_title;
            this.bts = 0;
            this.btp = str;
        }

        public a(String str, int i) {
            this.bto = -1;
            this.btp = "";
            this.btq = w.e.cp_link_tip_a;
            this.btr = w.g.pic_dot_title;
            this.bts = 0;
            this.btp = str;
            this.btr = i;
        }

        public void gG(int i) {
            this.bts = i;
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
                if (aVar.bto > 0) {
                    aVar.btp = context.getString(aVar.bto);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.btp)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.btp);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(aVar.btq)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cL = com.baidu.tbadk.core.util.aq.cL(aVar.btr);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cL);
                    if (cL != null) {
                        bitmapDrawable.setBounds(0, 0, cL.getWidth(), cL.getHeight());
                    }
                    com.baidu.tbadk.core.view.al alVar = new com.baidu.tbadk.core.view.al(bitmapDrawable);
                    if (aVar.bts != 0) {
                        alVar.setOffset(aVar.bts);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(alVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(com.baidu.tbadk.core.data.bj bjVar, TextView textView) {
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.rP() == null || bjVar.rP().size() == 0)) || bjVar.sf() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        bjVar.XW = 0;
        bjVar.sy();
        SpannableStringBuilder sq = bjVar.sq();
        textView.setOnTouchListener(new com.baidu.tieba.view.x(sq));
        textView.setText(sq);
        a(textView, bjVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
    }
}
