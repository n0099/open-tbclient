package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class at {
    public static void ib(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.qx(str)) {
            readThreadHistory.qv(str);
        }
    }

    public static boolean ic(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.qw(str)) ? false : true;
    }

    public static String Up() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rl() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (ic(str)) {
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
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.aq.cM(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, w.e.cp_link_tip_a, w.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bBl;
        public String bBm;
        public int bBn;
        public int bBo;
        public int bBp;

        public a(int i, int i2, int i3) {
            this.bBl = -1;
            this.bBm = "";
            this.bBn = w.e.cp_link_tip_c;
            this.bBo = w.g.pic_dot_title;
            this.bBp = 0;
            this.bBl = i;
            this.bBn = i2;
            this.bBo = i3;
        }

        public a(int i) {
            this.bBl = -1;
            this.bBm = "";
            this.bBn = w.e.cp_link_tip_c;
            this.bBo = w.g.pic_dot_title;
            this.bBp = 0;
            this.bBl = i;
        }

        public a(String str) {
            this.bBl = -1;
            this.bBm = "";
            this.bBn = w.e.cp_link_tip_c;
            this.bBo = w.g.pic_dot_title;
            this.bBp = 0;
            this.bBm = str;
        }

        public a(String str, int i) {
            this.bBl = -1;
            this.bBm = "";
            this.bBn = w.e.cp_link_tip_c;
            this.bBo = w.g.pic_dot_title;
            this.bBp = 0;
            this.bBm = str;
            this.bBo = i;
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
                if (aVar.bBl > 0) {
                    aVar.bBm = context.getString(aVar.bBl);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bBm)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bBm);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(aVar.bBn)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cM = com.baidu.tbadk.core.util.aq.cM(aVar.bBo);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cM);
                    if (cM != null) {
                        bitmapDrawable.setBounds(0, 0, cM.getWidth(), cM.getHeight());
                    }
                    com.baidu.tbadk.core.view.ar arVar = new com.baidu.tbadk.core.view.ar(bitmapDrawable);
                    if (aVar.bBp != 0) {
                        arVar.setOffset(aVar.bBp);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(arVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(com.baidu.tbadk.core.data.bl blVar, TextView textView) {
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rt() == null || blVar.rt().size() == 0)) || blVar.rJ() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        blVar.XB = 0;
        blVar.sc();
        SpannableStringBuilder rU = blVar.rU();
        textView.setOnTouchListener(new com.baidu.tieba.view.aa(rU));
        textView.setText(rU);
        a(textView, blVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
    }

    public static void a(Context context, com.baidu.tbadk.core.data.bl blVar, TextView textView) {
        String string;
        if (context != null && blVar != null) {
            if (StringUtils.isNull(blVar.rz())) {
                string = "吧";
            } else {
                string = context.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(blVar.rz(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            com.baidu.tbadk.core.util.aq.i(textView, w.e.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }
}
