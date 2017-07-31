package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void jd(String str) {
        com.baidu.tieba.tbadkCore.util.f readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.sm(str)) {
            readThreadHistory.sk(str);
        }
    }

    public static boolean je(String str) {
        com.baidu.tieba.tbadkCore.util.f readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.sl(str)) ? false : true;
    }

    public static String Ws() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rw() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (je(str)) {
                ai.i(textView, i2);
            } else {
                ai.i(textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, ai.cS(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.e.cp_link_tip_a, d.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bHv;
        public String bHw;
        public int bHx;
        public int bHy;
        public int bHz;

        public a(int i, int i2, int i3) {
            this.bHv = -1;
            this.bHw = "";
            this.bHx = d.e.cp_link_tip_c;
            this.bHy = d.g.pic_dot_title;
            this.bHz = 0;
            this.bHv = i;
            this.bHx = i2;
            this.bHy = i3;
        }

        public a(int i) {
            this.bHv = -1;
            this.bHw = "";
            this.bHx = d.e.cp_link_tip_c;
            this.bHy = d.g.pic_dot_title;
            this.bHz = 0;
            this.bHv = i;
        }

        public a(String str) {
            this.bHv = -1;
            this.bHw = "";
            this.bHx = d.e.cp_link_tip_c;
            this.bHy = d.g.pic_dot_title;
            this.bHz = 0;
            this.bHw = str;
        }

        public a(String str, int i) {
            this.bHv = -1;
            this.bHw = "";
            this.bHx = d.e.cp_link_tip_c;
            this.bHy = d.g.pic_dot_title;
            this.bHz = 0;
            this.bHw = str;
            this.bHy = i;
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
                if (aVar.bHv > 0) {
                    aVar.bHw = context.getString(aVar.bHv);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bHw)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bHw);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(aVar.bHx)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cS = ai.cS(aVar.bHy);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cS);
                    if (cS != null) {
                        bitmapDrawable.setBounds(0, 0, cS.getWidth(), cS.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.bHz != 0) {
                        mVar.setOffset(aVar.bHz);
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

    public static void a(bl blVar, TextView textView) {
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rD() == null || blVar.rD().size() == 0)) || blVar.rU() == 1) {
            blVar.b(false, true, false);
            if (blVar.sf() == null || StringUtils.isNull(blVar.sf().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(blVar.sf());
            return;
        }
        textView.setVisibility(0);
        blVar.Zo = 0;
        blVar.b(false, true, false);
        SpannableStringBuilder sf = blVar.sf();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(sf));
        textView.setText(sf);
        a(textView, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void b(bl blVar, TextView textView) {
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rD() == null || blVar.rD().size() == 0)) || blVar.rU() == 1) {
            blVar.e(false, true);
            if (blVar.sf() == null || StringUtils.isNull(blVar.sf().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(blVar.sf());
            return;
        }
        textView.setVisibility(0);
        blVar.Zo = 0;
        blVar.e(false, true);
        SpannableStringBuilder sf = blVar.sf();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(sf));
        textView.setText(sf);
        a(textView, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void a(Context context, bl blVar, TextView textView) {
        String string;
        if (context != null && blVar != null) {
            if (StringUtils.isNull(blVar.rK())) {
                string = "吧";
            } else {
                string = context.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(blVar.rK(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            ai.i(textView, d.e.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aF(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
