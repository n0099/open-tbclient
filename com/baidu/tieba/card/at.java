package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class at {
    public static void hY(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.qp(str)) {
            readThreadHistory.qn(str);
        }
    }

    public static boolean hZ(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.qo(str)) ? false : true;
    }

    public static String SN() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String sf() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hZ(str)) {
                com.baidu.tbadk.core.util.aq.i(textView, i2);
            } else {
                com.baidu.tbadk.core.util.aq.i(textView, i);
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
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.aq.cO(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, w.e.cp_link_tip_a, w.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int btf;
        public String btg;
        public int bth;
        public int bti;
        public int btj;

        public a(int i, int i2, int i3) {
            this.btf = -1;
            this.btg = "";
            this.bth = w.e.cp_link_tip_a;
            this.bti = w.g.pic_dot_title;
            this.btj = 0;
            this.btf = i;
            this.bth = i2;
            this.bti = i3;
        }

        public a(int i) {
            this.btf = -1;
            this.btg = "";
            this.bth = w.e.cp_link_tip_a;
            this.bti = w.g.pic_dot_title;
            this.btj = 0;
            this.btf = i;
        }

        public a(String str) {
            this.btf = -1;
            this.btg = "";
            this.bth = w.e.cp_link_tip_a;
            this.bti = w.g.pic_dot_title;
            this.btj = 0;
            this.btg = str;
        }

        public a(String str, int i) {
            this.btf = -1;
            this.btg = "";
            this.bth = w.e.cp_link_tip_a;
            this.bti = w.g.pic_dot_title;
            this.btj = 0;
            this.btg = str;
            this.bti = i;
        }

        public void gJ(int i) {
            this.btj = i;
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
                if (aVar.btf > 0) {
                    aVar.btg = context.getString(aVar.btf);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.btg)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.btg);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(aVar.bth)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cO = com.baidu.tbadk.core.util.aq.cO(aVar.bti);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                    if (cO != null) {
                        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                    }
                    com.baidu.tbadk.core.view.al alVar = new com.baidu.tbadk.core.view.al(bitmapDrawable);
                    if (aVar.btj != 0) {
                        alVar.setOffset(aVar.btj);
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

    public static void a(com.baidu.tbadk.core.data.bi biVar, TextView textView) {
        if ((StringUtils.isNull(biVar.getTitle()) && (biVar.sn() == null || biVar.sn().size() == 0)) || biVar.sD() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        biVar.Ym = 0;
        biVar.sW();
        SpannableStringBuilder sO = biVar.sO();
        textView.setOnTouchListener(new com.baidu.tieba.view.x(sO));
        textView.setText(sO);
        a(textView, biVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
    }
}
