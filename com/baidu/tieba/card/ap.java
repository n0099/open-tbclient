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
public class ap {
    public static void hY(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.qj(str)) {
            readThreadHistory.qh(str);
        }
    }

    public static boolean hZ(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.qi(str)) ? false : true;
    }

    public static String Th() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rp() {
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
        public int bvA;
        public int bvB;
        public int bvx;
        public String bvy;
        public int bvz;

        public a(int i, int i2, int i3) {
            this.bvx = -1;
            this.bvy = "";
            this.bvz = w.e.cp_cont_b;
            this.bvA = w.g.pic_dot_black_title;
            this.bvB = 0;
            this.bvx = i;
            this.bvz = i2;
            this.bvA = i3;
        }

        public a(int i) {
            this.bvx = -1;
            this.bvy = "";
            this.bvz = w.e.cp_cont_b;
            this.bvA = w.g.pic_dot_black_title;
            this.bvB = 0;
            this.bvx = i;
        }

        public a(String str) {
            this.bvx = -1;
            this.bvy = "";
            this.bvz = w.e.cp_cont_b;
            this.bvA = w.g.pic_dot_black_title;
            this.bvB = 0;
            this.bvy = str;
        }

        public a(String str, int i) {
            this.bvx = -1;
            this.bvy = "";
            this.bvz = w.e.cp_cont_b;
            this.bvA = w.g.pic_dot_black_title;
            this.bvB = 0;
            this.bvy = str;
            this.bvA = i;
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
                if (aVar.bvx > 0) {
                    aVar.bvy = context.getString(aVar.bvx);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bvy)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bvy);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(aVar.bvz)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cL = com.baidu.tbadk.core.util.aq.cL(aVar.bvA);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cL);
                    if (cL != null) {
                        bitmapDrawable.setBounds(0, 0, cL.getWidth(), cL.getHeight());
                    }
                    com.baidu.tbadk.core.view.ar arVar = new com.baidu.tbadk.core.view.ar(bitmapDrawable);
                    if (aVar.bvB != 0) {
                        arVar.setOffset(aVar.bvB);
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

    public static void a(com.baidu.tbadk.core.data.bk bkVar, TextView textView) {
        if ((StringUtils.isNull(bkVar.getTitle()) && (bkVar.rx() == null || bkVar.rx().size() == 0)) || bkVar.rN() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        bkVar.XF = 0;
        bkVar.sg();
        SpannableStringBuilder rY = bkVar.rY();
        textView.setOnTouchListener(new com.baidu.tieba.view.aa(rY));
        textView.setText(rY);
        a(textView, bkVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
    }

    public static void a(Context context, com.baidu.tbadk.core.data.bk bkVar, TextView textView) {
        String string;
        if (context != null && bkVar != null) {
            if (StringUtils.isNull(bkVar.rD())) {
                string = "吧";
            } else {
                string = context.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bkVar.rD(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            com.baidu.tbadk.core.util.aq.i(textView, w.e.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }
}
